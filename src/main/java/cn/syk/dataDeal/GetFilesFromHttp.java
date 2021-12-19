package cn.syk.dataDeal;

import cn.syk.entity.GpHangQ;
import cn.syk.mapper.GpHangQMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author syk
 * @date 2021/12/14 9:07
 **/
@Component
public class GetFilesFromHttp {
    @Autowired
    GpHangQMapper gpHangQMapper;

    StringBuilder builder = new StringBuilder();//保存读取的数据

    public  void getDatefromUrl(String str) {
        builder.delete(0, builder.length());
        try {
            URL url = new URL(str);
            URLConnection connection = url.openConnection();
            InputStream is = connection.getInputStream();  // 获取输入流

            InputStreamReader isr = new InputStreamReader(is, "GBK");//在InputStreamReader中指定编码，手动指定为UTF-8
            BufferedReader br = new BufferedReader(isr);//实例化一个BufferedReader对象用来存放转换后的字符
            String line;
            while ((line = br.readLine()) != null) {  // 读取数据
                builder.append(line + "\n");
            }
            //System.out.println(builder.toString());
            br.close();//关闭流
            isr.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     public void writeToDataBase() throws ParseException {
        if (builder.length() > 0) {
            String[] str = builder.toString().split("\n");
            String[] date = null;
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            List<GpHangQ> list = new ArrayList<GpHangQ>();
            for (int i = 1; i < str.length; i++) {
                date = str[i].split(",");
                GpHangQ gpHangQ = new GpHangQ();
                gpHangQ.setCode(date[1].substring(1,date[1].length()));
                gpHangQ.setDate(formatter.parse(date[0]));
                gpHangQ.setName(date[2]);
                Float val = "None".equals(date[3])? (float) 0 :Float.parseFloat(date[3]);
                gpHangQ.setRate(val);
                gpHangQ.setTotal(Double.parseDouble(date[4]));
                list.add(gpHangQ);
                //gpHangQMapper.insert(gpHangQ);
                if(i%4000==0 || i==str.length-1){
                    gpHangQMapper.insertList(list);
                }
            }
        }
    }
}
