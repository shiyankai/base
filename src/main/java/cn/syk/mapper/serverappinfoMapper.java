package cn.syk.mapper;

import cn.syk.entity.serverappinfo;

public interface serverappinfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(serverappinfo record);

    int insertSelective(serverappinfo record);

    serverappinfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(serverappinfo record);

    int updateByPrimaryKey(serverappinfo record);
}