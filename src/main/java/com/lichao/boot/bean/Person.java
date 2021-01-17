package com.lichao.boot.bean;

import lombok.Data;

@Data
public class Person {

    private String userName;
    private Integer age;
    private String birth;

    private Pet pet;


}
