package com.roy.service;

import com.roy.entity.SecKill;
import com.roy.entity.Student;

import java.util.Date;
import java.util.List;

/**
 * Created by ldj on 2017/6/28.
 */
public interface SecKillService {

    List<SecKill> getSecKillList();

    int reduce(long id, Date time);

    int insert(long id,long phone);

    int insertTwo();

    Student addStu(Student stu);

    void getAge(String name) throws Exception;
}
