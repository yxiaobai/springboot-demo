package com.spring.boot.springbootdemo.dto;

public enum EnumModelType {
    caidan("菜单",0),biaoqian("标签",2),keyong("可用",1);
    private String name;
    private int num;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    EnumModelType(String name, int num) {
        this.name = name;
        this.num = num;
    }

    @Override
    public String toString() {
        return "EnumModelType{" +
                "name='" + name + '\'' +
                ", num=" + num +
                '}';
    }
}
