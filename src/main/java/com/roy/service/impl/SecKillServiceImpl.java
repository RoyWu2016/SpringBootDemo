package com.roy.service.impl;

import com.roy.entity.SecKill;
import com.roy.entity.Student;
import com.roy.enums.ResultEnum;
import com.roy.exception.MyException;
import com.roy.mapper.SecKillMapper;
import com.roy.service.SecKillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ldj on 2017/6/28.
 */
@Service
public class SecKillServiceImpl implements SecKillService {

    @Autowired
    private SecKillMapper secKillMapper;

    @Override
    public List<SecKill> getSecKillList() {

        return secKillMapper.queryAll(0,4);
    }

    @Override
    public int reduce(long id, Date time) {
        return secKillMapper.reduceNumber(id,time);
    }

    @Override
    public int insert(long id,long phone) {
        return secKillMapper.insertSuccessKilled(id,phone);
    }

    @Override
    @Transactional
    public int insertTwo() {

        int i = secKillMapper.insertSuccessKilled(Long.valueOf("1005"),Long.valueOf("15012464481"));

        int j = secKillMapper.insertSuccessKilled(Long.valueOf("1004"), Long.valueOf("150124644891501246448915012464489"));

        return i+j;
    }

    @Override
    public Student addStu(Student stu) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name",stu.getStuName());
        map.put("age",stu.getAge());
        if(secKillMapper.addStu(map)>=1) {
            return stu;
        }else {
            return null;
        }
    }

    @Override
    public void getAge(String name) throws Exception {
        Student stu = secKillMapper.getStuByName(name);
        if (stu.getAge()<25) {
            throw new MyException(ResultEnum.FAIL);
        }else if (stu.getAge()>45){
            throw new MyException(ResultEnum.FAIL);
        }
        //TODO
    }
}
