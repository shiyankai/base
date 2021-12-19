package cn.syk.io.bio;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * @Author syk
 * @date 2021/12/3 20:09
 **/
public class MainRun {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8081);

        String requestdata = "";
        while (true) {
            Socket socketServer = serverSocket.accept();
            byte[] b = new byte[1];
            while (socketServer.getInputStream().read(b) != -1) {
                requestdata = requestdata + new String(b);
            }
            System.out.println("从客户端接收的数据:" + requestdata);
//            以"/r/n"为约定分割
            String[] split = requestdata.split("/r/n");
//            将数组的内容解码
            String packageName = split[0];
            String className = split[1];
            String method = split[2];
            String argVal = split[3];

            Class<?> classObj = null;
            try {
//                获取的包和类名找到本地的利用反射实例化
                classObj = Class.forName(packageName + "." + className);
                Method returnMethod = classObj.getMethod(method, String.class);
                String result = (String) returnMethod.invoke(classObj.newInstance(), argVal);
                System.out.println("返回给客户端的结果:" + result);
                socketServer.getOutputStream().write(result.getBytes(Charset.forName("UTF-8")));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
