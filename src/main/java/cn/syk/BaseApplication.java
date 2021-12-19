package cn.syk;

import cn.syk.dataDeal.DealExcel;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.ws.Endpoint;

@MapperScan("cn.syk.mapper")
@SpringBootApplication(scanBasePackages = "cn.syk") //默认当前包以及其子包,如需指定则添加属性(scanBasePackages = "cn.syk")
public class BaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class, args);
        Endpoint.publish("http://127.0.0.1:80/readAndWrite", new DealExcel());
    }

}
