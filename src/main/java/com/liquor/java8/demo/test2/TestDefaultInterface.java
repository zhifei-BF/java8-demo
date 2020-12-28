package com.liquor.java8.demo.test2;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author Liquor.Huang
 * @Date 2020/12/28 16:50
 * To change this template use File | Settings | File Templates.
 */
public class TestDefaultInterface {
    public static void main(String[] args) {
        SubClass sc = new SubClass();
        System.out.println(sc.getName());

        MyInterface.show();
    }
}
