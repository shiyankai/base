package cn.syk.bean;

import org.springframework.stereotype.Component;

/**
 * @Author syk
 * @date 2021/11/26 5:47
 **/
@Component
public class MyBean {
    public Object MyBean() {
        //return "asdddddddddddd";
        return new Object(); //一般使用这种方式把对象加入springioc控制
    }
}
