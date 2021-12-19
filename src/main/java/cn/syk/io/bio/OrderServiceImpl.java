package cn.syk.io.bio;
 
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
 
/**
 * class
 *
 * @author 知识快递
 * @date 2018年12月20日
 */
public class OrderServiceImpl implements IorderService {
 
    @Override
    public String getOrder(Integer orderId, String name) {
 
//      把参数依次装到一个List里面
        List<String> argList = new ArrayList();
        argList.add(orderId.toString());
        argList.add(name);
        return SocketUtil.getSocket(url, port, packageName, argList);
    }
 
    @Override
    public String getOrderName(String name) {
        return "订单名称:" + name;
    }

    public static void main(String[] args) throws IOException {
        Socket client = new Socket("127.0.0.1", 8081);
        int i = 0;
        while (i<100) {i++;
            client.getOutputStream().write("asddddddddd".getBytes());
        }
        client.shutdownOutput();
    }
}