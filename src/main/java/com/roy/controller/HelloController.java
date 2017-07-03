package com.roy.controller;

import com.roy.entity.Result;
import com.roy.entity.SecKill;
import com.roy.entity.Student;
import com.roy.entity.User;
import com.roy.service.SecKillService;
import com.roy.utils.ResultUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by ldj on 2017/6/27.
 */
@RestController
@Api("用户服务")
public class HelloController {

    @Value("${testParamter}")
    private String testParamter;

    @Autowired
    private User user1;

    @Autowired
    private SecKillService secKillService;

//    @RequestMapping(value="/hello",method = RequestMethod.GET)
    @GetMapping(value = "/getAll")
    public List<SecKill> say() {
        List<SecKill> list = secKillService.getSecKillList();
        return list;
    }

    @PostMapping(value = "/insert")
    public int insert(@RequestParam("id") String id,
                      @RequestParam("phone") String phone) {
        return secKillService.insert(Long.valueOf(id),Long.valueOf(phone));
    }

    @PostMapping(value = "/insertTwo")
    public int insertTwo() {
        return secKillService.insertTwo();
    }

    @PostMapping(value = "/addStudent")
    public Result addStudent(@Valid@RequestBody Student student, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
//            return  null;
        }
        return ResultUtil.success(secKillService.addStu(student));
    }

    @GetMapping(value = "/getAge/{name}")
    public Result getAge(@PathVariable("name") String name) throws Exception {
        secKillService.getAge(name);
//        Cookie cookie
        return null;
    }
}