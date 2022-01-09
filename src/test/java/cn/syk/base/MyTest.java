package cn.syk.base;

import cn.syk.bean.MyBean;
import cn.syk.dataDeal.GetFilesFromHttp;
import cn.syk.tools.requestParamaters.ReadApi;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.ParseException;


@SpringBootTest
public class MyTest {
    @Autowired
    GetFilesFromHttp getDatefromUrl;
    @Autowired
    DataSource dataSource;
    @Autowired
    JedisPool jedisPool;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Resource
    private MyBean myBean;
    @Autowired
    ReadApi readApi;

    public void get() throws ParseException, SQLException {
       /* RowMapper rowMap = null;
        System.out.println("2222222222222222222222222222");
        System.out.println(studentMapper.selectByPrimaryKey("1"));
        System.out.println(jdbcTemplate.query("select * from user where id = 1 ",new BeanPropertyRowMapper(User.class)));
        JSONObject json = new JSONObject();
        json.put("name", 12);*/
//        for (int i = 0; i < 999; i++) {
//            String str = "http://quotes.money.163.com/service/chddata.html?code=0600"+String.format("%03d",i)+"&start=19991110&end=20220418&fields=CHG;TCAP";
//            Long start = System.currentTimeMillis();
//            getDatefromUrl.getDatefromUrl(str);
//            getDatefromUrl.writeToDataBase();
//            Long use = System.currentTimeMillis() - start;
//            DecimalFormat df = new DecimalFormat("0.0000");
//            System.out.println("代码：600"+String.format("%03d",i)+"@"+df.format((double)use/1000));
//        }
//        //获取一个连接
//        Connection connection = druidDataSource.getConnection();
//        //Statement接口
//        Statement statement = connection.createStatement();
//        ResultSet aaa = statement.executeQuery("select * from GpHangQM a order by total desc limit 0,10;");
//
//        while (aaa.next()){
//            System.out.print(aaa.getString("date"));
//            System.out.print(aaa.getString(2));
//            System.out.print(aaa.getString(3));
//            System.out.print(aaa.getString(4));
//            System.out.println(aaa.getBigDecimal(5));
//        }
    }

    @Test
    void test() throws NoSuchAlgorithmException {
        readApi.read();
        /*Map map = new HashMap<>();
        JSONObject jsonObject = new JSONObject(map);
        try {
            jsonObject.put("name","王林");
            jsonObject.put("age",18);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println(jsonObject.toString());
        try {
            JSON.parse("{\"name\":\"王林\",\"age\":18}");
            new JSONObject().toString();
        } catch (com.alibaba.dubbo.common.json.ParseException e) {
            e.printStackTrace();
        }*/
    }
}
