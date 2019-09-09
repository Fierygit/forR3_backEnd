package com.Firefly.forR3.dao;

import com.Firefly.forR3.entity.Info;
import com.Firefly.forR3.entity.InfoExample;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;



@Component
@Mapper
public interface InfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Info record);

    int insertSelective(Info record);

    List<Info> selectByExample(InfoExample example);

    Info selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Info record);

    int updateByPrimaryKey(Info record);
}