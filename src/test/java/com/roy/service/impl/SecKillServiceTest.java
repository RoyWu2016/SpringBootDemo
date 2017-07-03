package com.roy.service.impl;

import com.roy.service.SecKillService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ldj on 2017/6/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SecKillServiceTest {

    @Autowired
    private SecKillService secKillService;

    @Test
    public void getSecKillList() throws Exception {
        List list = secKillService.getSecKillList();
        Assert.assertNotNull(list);
    }

}