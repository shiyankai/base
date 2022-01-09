package cn.syk.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author syk
 * @date 2021/12/22 7:51
 **/

/**
 * 动态代理实现继承InvocationHandler
 */
public class MyDynamicProxyHandler implements InvocationHandler {
    private Object proxied;

    public MyDynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    public Object getProxy(Object obj) {
        this.proxied = obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doBefore();
        Object result = method.invoke(proxied, args);//自动调用代理目标(RealObject)的方法(利用方法的反射)
        doAfter();
        return result;
    }

    private void doBefore() {
        System.out.println("[Proxy]一些前置处理");
    }

    private void doAfter() {
        System.out.println("[Proxy]一些后置处理");
    }

    public static void main(String[] args) {
        IPeople people = new Student();
        IPeople proxy = (IPeople) Proxy.newProxyInstance(IPeople.class.getClassLoader(),
                new Class[]{IPeople.class}, new MyDynamicProxyHandler(people));
        proxy.getAge("");

    }
}
