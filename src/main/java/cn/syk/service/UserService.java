package cn.syk.service;

import cn.syk.entity.User;
import cn.syk.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    @Transactional
    public User selectByPrimaryKey(int id) {
        return userMapper.selectByPrimaryKey(id);
    }
}