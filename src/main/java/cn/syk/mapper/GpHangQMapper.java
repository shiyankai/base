package cn.syk.mapper;

import cn.syk.entity.GpHangQ;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GpHangQMapper {
    int insert(GpHangQ record);

    int insertList(List<GpHangQ> list);

    int insertSelective(GpHangQ record);
}