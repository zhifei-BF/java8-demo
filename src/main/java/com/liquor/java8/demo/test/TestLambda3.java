package com.liquor.java8.demo.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Description:
 * @Reference:
 * @Author: Liquor
 * @CreateDate:2020-12-22 22:45
 * @Modify:
 **/
/*
 * Java8 内置的四大核心函数式接口
 *
 * Consumer<T> : 消费型接口
 * 		void accept(T t);
 *
 * Supplier<T> : 供给型接口
 * 		T get();
 *
 * Function<T, R> : 函数型接口
 * 		R apply(T t);
 *
 * Predicate<T> : 断言型接口
 * 		boolean test(T t);
 *
 */
public class TestLambda3 {
    //Consumer<T> 消费型接口 :
    @Test
    public void test1() {
        happy(1000, (m) -> System.out.println("我消费了" + m + "元！"));
    }

    public void happy(double money, Consumer<Double> con) {
        con.accept(money);
    }

    //Supplier<T> 供给型接口 :
    @Test
    public void test2() {
        List<Integer> numList = getNumList(2, () -> (int) (Math.random() * 100));
        for (Integer integer : numList) {
            System.out.println(integer);
        }
    }

    //需求：产生指定个数的整数，并放入到集合中
    public List<Integer> getNumList(int num, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            Integer n = sup.get();
            list.add(n);
        }
        return list;
    }

    //Function<T, R> 函数型接口：
    @Test
    public void test3() {
        String newStr = strHandler("\t\t\thello", (m) -> m.trim());
        System.out.println(newStr);

        String str = strHandler("我思安胜多负少", (m) -> m.substring(2, 5));
        System.out.println(str);
    }

    //需求：用于处理字符串
    public String strHandler(String str, Function<String, String> function) {
        return function.apply(str);
    }

    //Predicate<T> 断言型接口:
    @Test
    public void test4() {
        List<String> list = Arrays.asList("hello", "world", "name", "lambda", "consumer");

        List<String> strings = filterStr(list, (m) -> m.length() > 3);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    //需求：将满足条件的字符串，放入集合中
    public List<String> filterStr(List<String> list, Predicate<String> pre) {
        List<String> strList = new ArrayList<>();
        for (String str : list) {
            if (pre.test(str)) {
                strList.add(str);
            }
        }
        return strList;
    }
}
