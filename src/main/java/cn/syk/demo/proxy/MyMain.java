package cn.syk.demo.proxy;

import java.lang.reflect.Proxy;

/**
 * @Author syk
 * @date 2021/12/22 8:05
 **/
public class MyMain {
    public static void main(String[] args) {
        Student student = new Student();
        IPeople proxy = (IPeople) Proxy.newProxyInstance(IPeople.class.getClassLoader(),
                new Class[]{IPeople.class},new MyDynamicProxyHandler(student));
        proxy.getAge("");

    }
}
