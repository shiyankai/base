package cn.syk.tools.autoCreateCode;

import java.io.File;
import java.io.IOException;

/**
 * @Author syk
 * @date 2021/12/25 7:08
 **/
public class AutoCode {
    //构建文件
    static void createFile(String filePath ){
        if (filePath.startsWith("/")){
            filePath = System.getProperty("path") + filePath ;
        }
        File file = new File(filePath);
        if (!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //createFile("/asd.txt");
        String str = "/asd/asd";
        str+=System.getProperty("user.dir");
        System.out.println(str);
    }
}
