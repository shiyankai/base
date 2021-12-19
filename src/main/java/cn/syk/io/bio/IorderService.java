package cn.syk.io.bio;
 
/**
 * class
 *
 * @author 知识快递
 * @date 2018年12月20日
 */
public interface IorderService {
 
/**
 * 服务端地址
  */
    String url = "127.0.0.1";
 
    /**
     * 远程端口
     */
    int port = 8080;
 
    /**
     * 远程的包名 /r/n是分割协议
     */
    String packageName = "com.yunhe.server.service.impl/r/n";
 
    String getOrder(Integer orderId, String name);
 
    String getOrderName(String name);
}