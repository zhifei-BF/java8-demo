package com.liquor.java8.demo.test;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author Liquor.Huang
 * @Date 2020/12/10 14:09
 * To change this template use File | Settings | File Templates.
 */
public class TestLambda1 {
    //原来的匿名内部类
    @Test
    public void test1() {
        Comparator<String> com = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        };
        TreeSet<String> ts = new TreeSet<>(com);

        TreeSet<String> ts2 = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
    }

    //现在的lambda表达式
    @Test
    public void test2() {
        Comparator<String> com = (x, y) -> Integer.compare(x.length(), y.length());
        TreeSet<String> ts = new TreeSet<>(com);
    }
}
