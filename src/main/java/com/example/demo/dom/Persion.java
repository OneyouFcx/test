package com.example.demo.dom;

import lombok.Data;
import lombok.ToString;
//exclude--不显示那个一个字段
@ToString(includeFieldNames = true,callSuper = true)
@Data
public class Persion {
    private String name;
    private String like;
    private int age;
    private int money;
}
