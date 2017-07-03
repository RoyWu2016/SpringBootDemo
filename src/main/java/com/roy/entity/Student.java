package com.roy.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by ldj on 2017/6/29.
 */
public class Student {

    @NotNull(message = "不能为空")
    @NotBlank(message = "不能为空")
    private String stuName;

    @Min(value = 18,message = "未满18岁")
    private int age;

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
