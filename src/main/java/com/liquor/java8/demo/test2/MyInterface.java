package com.liquor.java8.demo.test2;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author Liquor.Huang
 * @Date 2020/12/28 16:16
 * To change this template use File | Settings | File Templates.
 */
public interface MyInterface {
    default String getName() {
        return "呵呵呵";
    }

    public static void show() {
        System.out.println("接口中的静态方法");
    }
}
