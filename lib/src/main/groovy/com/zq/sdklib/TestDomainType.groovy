package com.zq.sdklib

public class TestDomainType {
    //必须定义一个 name 属性，并且这个属性值初始化以后不要修改
    String name

    String msg

    //构造函数必须有一个 name 参数
    public TestDomainType(String name) {
        this.name = name
    }

    void msg(String msg) {
        this.msg = msg
    }

    String toString() {
        return "name = ${name}, msg = ${msg}"
    }
}
