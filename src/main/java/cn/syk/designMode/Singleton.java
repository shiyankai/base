package cn.syk.designMode;

/**
 * @Author syk
 * @date 2021/12/1 21:21
 * 饿汉模式
 **/
public class Singleton {
    private Singleton() {
    }
    private static Singleton instance = new Singleton();
    public static Singleton getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        Singleton.getInstance();
    }
}
