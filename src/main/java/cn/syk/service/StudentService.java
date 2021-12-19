package cn.syk.service;

import cn.syk.entity.Student;
import cn.syk.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author syk
 * @date 2021/11/24 2:01
 **/
@Service
public class StudentService {
    @Autowired
    StudentMapper studentMapper;

    @Transactional
    public Student selectByPrimaryKey(int id) {
        return null;
    }
}
