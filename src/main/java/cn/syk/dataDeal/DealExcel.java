package cn.syk.dataDeal;

/**
 * @Author syk
 * @date 2021/12/14 11:03
 **/

import javax.jws.WebService;

@WebService
public class DealExcel implements IDealExcel{
    @Override
    public String readAndWrite(String FilePath){
        return "测试使用";
    }
}
