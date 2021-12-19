package cn.syk.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @Author syk
 * @date 2021/11/27 7:26
 **/
public class MyHttpSessionListener implements HttpSessionListener {
    public MyHttpSessionListener(){
        System.out.println("我的初始化初始化："+MyHttpSessionListener.class);
    }
    public static int online =0;
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("创建session");
        online++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("销毁session");
        online--;
    }

}
