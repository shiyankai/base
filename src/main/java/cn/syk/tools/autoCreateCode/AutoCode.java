package cn.syk.tools.autoCreateCode;

import cn.syk.tools.StringTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author syk
 * @date 2021/12/25 7:08
 **/
public class AutoCode {
    private  Logger logger = LoggerFactory.getLogger(AutoCode.class);
    String pjPath = System.getProperty("user.dir");
    String flagController = "Controller.java" ,flagService = "Service.java";

    public static void main(String[] args) {
        new AutoCode().getFilesPath("getMyName");
    }
    //构建文件框架
    void getFilesPath(String serviceName){
        serviceName = StringTools.getName(serviceName);
        List fileList = new ArrayList();
        String filePath = null ,fileModel = null;
        fileList.add(pjPath+"\\src\\main\\java\\cn\\syk\\controller/"+ serviceName +"Controller.java");
        fileList.add(pjPath+"\\src\\main\\java\\cn\\syk\\service/"+serviceName+"Service.java");
        Iterator fileListItrt = fileList.iterator();
        while(fileListItrt.hasNext()){
            filePath = (String) fileListItrt.next();
            createFile(filePath);
            if(filePath.indexOf(flagController)!=-1){
                fileModel = pjPath+"\\src\\main\\java\\cn\\syk\\tools\\autoCreateCode\\codeModel\\DemoController.java";
            }else if(filePath.indexOf(flagService)!=-1){
                fileModel = pjPath+"\\src\\main\\java\\cn\\syk\\tools\\autoCreateCode\\codeModel\\DemoService.java";
            }
            fileInput(serviceName,filePath,fileModel);
        }
    }
    //构建文件内容
    void fileInput(String serviceName ,String filePath,String fileModel){
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileModel));
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
            String line = br.readLine();
            while(line != null){
                if(filePath.indexOf(flagController)!=-1 && line.indexOf("package")!=-1){
                    bw.write("package cn.syk.controller;\n");
                }else if(filePath.indexOf(flagService)!=-1 && line.indexOf("package")!=-1){
                    bw.write("package cn.syk.service;\n");
                }else{
                    line = line.replace("Demo",serviceName);
                    bw.write(line+"\n");
                }
                line = br.readLine();
            }
            bw.flush();
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //构建文件对象
    void createFile(String filePath ){
        if (filePath.startsWith("/")){
            filePath = pjPath + filePath ;
        }
        File file = new File(filePath);
        if (file.exists()){
            return;
        }
        if (!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("创建空的文件："+filePath);
    }
}
