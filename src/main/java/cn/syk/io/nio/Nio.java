package cn.syk.io.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author syk
 * @date 2021/12/8 16:24
 **/
public class Nio {
    public static void main(String[] args) throws IOException {

    }
    void a() throws IOException {
        FileInputStream fish = new FileInputStream("C:\\Users\\Administrator\\Desktop\\prop.txt");
        FileChannel channel = fish.getChannel();
        ByteBuffer bb = ByteBuffer.allocate(3);
        channel.read(bb);
        System.out.println();

        IntBuffer buf1 = IntBuffer.allocate(10);
        int[] arr = new int[]{1,2,5};
        buf1.put(arr);
        System.out.println(buf1);
        //一种复制方法
        IntBuffer buf3 = buf1.duplicate();
        System.out.println(buf3);
        buf1.flip();
        System.out.println(buf1);
        while(buf1.hasRemaining()){
            System.out.println(buf1.get());
        }
        System.out.println("可读数据为：" + buf1.remaining());
    }
}
