package com.liquor.java8.demo.test2;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author Liquor.Huang
 * @Date 2020/12/28 16:18
 * To change this template use File | Settings | File Templates.
 */
public class SubClass extends MyClass implements MyFun, MyInterface {
    @Override
    public String getName() {
        return MyInterface.super.getName();
    }
}
