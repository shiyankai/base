package cn.syk.controller;

import cn.syk.service.StudentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author syk
 * @date 2021/11/24 2:04
 **/
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/getById")
    public Map show(@Param("name") String name) {
        Map map = new HashMap<>();
        return map;
    }
}
