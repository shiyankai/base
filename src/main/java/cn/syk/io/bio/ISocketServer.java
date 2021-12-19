package cn.syk.io.bio;

/**
 * @Author syk
 * @date 2021/12/3 20:07
 **/
public interface ISocketServer {
    String getOrder(int orderId, String name);
    String getOrderName(String name);
}
