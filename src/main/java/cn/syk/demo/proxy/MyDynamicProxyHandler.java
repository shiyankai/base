package cn.syk.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author syk
 * @date 2021/12/22 7:51
 **/
/**动态代理实现继承InvocationHandler*/
public class MyDynamicProxyHandler implements InvocationHandler {
    private Object proxied;
    public MyDynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("do someThing waysBefore");

        Object result = method.invoke(proxied, args);//自动调用代理目标(RealObject)的方法(利用方法的反射)

        System.out.println("do someThing waysAfter");

        return result;
    }
}
