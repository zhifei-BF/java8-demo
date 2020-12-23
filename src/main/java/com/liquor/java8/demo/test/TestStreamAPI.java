package com.liquor.java8.demo.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
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
}
