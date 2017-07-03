package com.roy.mapper;

import com.roy.entity.SecKill;
import com.roy.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by ldj on 2017/6/28.
 */
@Mapper
public interface SecKillMapper {

    List<SecKill> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    int reduceNumber(@Param("secKillId") long secKillId,@Param("killTime") Date killTime);

    int insertSuccessKilled(@Param("secKillId") long secKillId,@Param("userPhone") long userPhone);

    int addStu(Map map);

    Student getStuByName(String name);
}
