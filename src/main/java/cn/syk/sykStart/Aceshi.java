package cn.syk.sykStart;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;
import com.github.sarxos.webcam.WebcamUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author syk
 * @date 2021/12/6 17:31
 **/
public class Aceshi {
    public static void main(String[] args) throws IOException {
      /*  File file = new File("C:\\Users\\Administrator\\Desktop\\prop.txt");
        Properties pp = new Properties();
        InputStream fis = new FileInputStream(file);
        InputStream fiss = new FileInputStream("C:\\Users\\Administrator\\Desktop\\prop.txt");
        pp.load(fiss);
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("请输入一系列文字，可包括空格：");
        String text=bufferedReader.readLine();
        System.out.println("请输入文字："+text);
        FileReader fr = new FileReader(new File(""));*/
        System.out.println("sadadasd".replace("{name}", "name=asas"));

    }

    //    调用摄像头拍照
    public static String takePictures() {
        Webcam webcam = Webcam.getDefault();
        if (webcam == null) {
            return "没有找到摄像设备！";
        }
        String downloadPath = "C:\\Users\\Administrator\\Desktop";
        String filePath = downloadPath + "/picture/" + new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        File path = new File(filePath);
        if (!path.exists()) {//如果文件不存在，则创建该目录
            path.mkdirs();
        }
        String time = new SimpleDateFormat("yyyMMdd_HHmmss").format(new Date());
        File file = new File(filePath + "/" + time + ".jpg");
        webcam.setViewSize(WebcamResolution.VGA.getSize());
        WebcamUtils.capture(webcam, file);
        return "拍照成功！";
    }
}
