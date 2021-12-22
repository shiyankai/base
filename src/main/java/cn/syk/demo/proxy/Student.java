package cn.syk.demo.proxy;

/**
 * @Author syk
 * @date 2021/12/22 8:02
 **/
public class Student implements IPeople {
    @Override
    public String getName(String userId) {
        return "studentName";
    }
    @Override
    public String getAge(String userId) {
        System.out.println("studentAge");
        return "studentAge";
    }
}
