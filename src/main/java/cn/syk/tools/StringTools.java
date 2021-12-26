package cn.syk.tools;

/**
 * @Author syk
 * @date 2021/12/25 16:10
 **/
public  class StringTools {
    //首字母大写
    public static String getName(String name){
       return name.substring(0,1).toUpperCase()+name.substring(1).toLowerCase();
    }
}
