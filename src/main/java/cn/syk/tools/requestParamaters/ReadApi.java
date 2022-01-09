package cn.syk.tools.requestParamaters;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.support.ExcelTypeEnum;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

/**
 * @Author syk
 * @date 2022/1/6 15:20
 **/
@Component
public class ReadApi {
    public void read() {
        try (InputStream inputStream = new FileInputStream("C:\\Users\\Administrator\\Desktop\\新建 XLS 工作表.xls");) {
            ExcelReader excelReader = new ExcelReader(inputStream, ExcelTypeEnum.XLSX, null, new AnalysisEventListener<List<String>>() {
                @Override
                public void invoke(List<String> object, AnalysisContext context) {
                    System.out.println("当前sheet:" + context.getCurrentSheet().getSheetNo() + ",当前行:" +
                            context.getCurrentRowNum());
                }

                @Override
                public void doAfterAllAnalysed(AnalysisContext context) {

                }
            });
            excelReader.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
