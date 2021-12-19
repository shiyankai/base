package cn.syk.io.bio;
 

/**
 * class
 *
 * @author 知识快递
 * @date 2018年12月20日
 */
public class OrderService implements ISocketServer {
 
    @Override
    public String getOrder(int orderId, String name) {
 
        return "订单号:"+orderId+",订单名称:"+name;
    }
 
    @Override
    public String getOrderName(String name) {
        return "订单名称:"+name;
    }
}