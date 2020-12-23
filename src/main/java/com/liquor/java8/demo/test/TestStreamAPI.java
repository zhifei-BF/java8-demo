package com.liquor.java8.demo.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author Liquor.Huang
 * @Date 2020/12/23 17:50
 * To change this template use File | Settings | File Templates.
 */
/*
 * 一、Stream API 的操作步骤：
 *
 * 1. 创建 Stream
 *
 * 2. 中间操作
 *
 * 3. 终止操作(终端操作)
 */
public class TestStreamAPI {
    //创建Stream流
    @Test
    public void test1() {
        //1.Collection提供了两个方法 stream()与parallelStream();
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();//获取一个顺序流
        System.out.println("stream = " + stream);
        Stream<String> stringStream = list.parallelStream();//获取一个并行流
        System.out.println("stringStream = " + stringStream);

        //2.通过Arrays.stream()获取一个数组流
        Integer[] integers = new Integer[10];
        Stream<Integer> stream1 = Arrays.stream(integers);
        System.out.println("stream1 = " + stream1);

        //3.通过Stream类中的静态方法of()
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);
        System.out.println("integerStream = " + integerStream);

        //4.创建无限流
        //迭代
        Stream<Integer> limit = Stream.iterate(0, (x) -> x + 2).limit(10);
        limit.forEach(System.out::println);

        //生成
        Stream<Double> stream2 = Stream.generate(Math::random).limit(2);
        stream2.forEach(System.out::println);
    }

    //2. 中间操作
    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 59, 6666.66),
            new Employee(101, "张三", 18, 9999.99),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );

    /*
	  筛选与切片
		filter——接收 Lambda ， 从流中排除某些元素。
		limit——截断流，使其元素不超过给定数量。
		skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
		distinct——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
	 */

    //内部迭代：迭代操作Stream API内部完成
    @Test
    public void test2() {
        //所有的中间操作不会做任何处理
        Stream<Employee> stream = emps.stream()
                .filter((e) -> {
                    System.out.println("测试中间操作");
                    return e.getAge() <= 35;
                });
        //只有当做终止操作时，所有的中间操作会一次性的全部执行，称为“惰性求值”
        stream.forEach(System.out::println);
    }

    //外部迭代
    @Test
    public void test3() {
        Iterator<Employee> it = emps.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    @Test
    public void test4() {
        emps.stream()
                .filter((e) -> {
                    System.out.println("短路！");// && ||
                    return e.getSalary() >= 5000;
                })
                .limit(3)
                .forEach(System.out::println);
    }

    @Test
    public void test5() {
        emps.stream()
                .filter((e) -> e.getSalary() >= 5000)
                .skip(2)
                .forEach(System.out::println);
    }

    @Test
    public void test6() {
        emps.stream()
                .distinct()
                .forEach(System.out::println);
    }

}
