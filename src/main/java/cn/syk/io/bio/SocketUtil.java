package cn.syk.io.bio;
 
import java.io.IOException;
import java.net.Socket;
import java.util.List;
 
/**
 * class
 *
 * @author 知识快递
 * @date 2018年12月20日
 */
public class SocketUtil {
 
    public static String getSocket(String url, int port, String packageName, List<String> argList) {
 
        String reponseData = "";
 
        try {
            Socket client = new Socket(url, port);
//            获取服务端的 类 方法 和参数类型
            String className = "OrderServiceImpl/r/n";
            String method = "getOrderName/r/n";
//            依次写入这四个参数
            client.getOutputStream().write(packageName.getBytes());
            client.getOutputStream().write(className.getBytes());
            client.getOutputStream().write(method.getBytes());
//            遍历方法的参数
            for ( String argList1 : argList){
 
                client.getOutputStream().write(argList1.getBytes());
            }
 
            client.shutdownOutput();
//            获取服务器返回来的值
            byte[] b = new byte[1];
            while (client.getInputStream().read(b) != -1) {
                reponseData = reponseData + new String(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reponseData;
    }
}