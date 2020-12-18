package com.liquor.java8.demo.test;

import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author Liquor.Huang
 * @Date 2020/12/18 18:08
 * To change this template use File | Settings | File Templates.
 */

/*
 * 一、Lambda 表达式的基础语法：Java8中引入了一个新的操作符 "->" 该操作符称为箭头操作符或 Lambda 操作符
 * 						    箭头操作符将 Lambda 表达式拆分成两部分：
 *
 * 左侧：Lambda 表达式的参数列表
 * 右侧：Lambda 表达式中所需执行的功能， 即 Lambda 体
 *
 * 语法格式一：无参数，无返回值
 * 		() -> System.out.println("Hello Lambda!");
 *
 * 语法格式二：有一个参数，并且无返回值
 * 		(x) -> System.out.println(x)
 *
 * 语法格式三：若只有一个参数，小括号可以省略不写
 * 		x -> System.out.println(x)
 *
 * 语法格式四：有两个以上的参数，有返回值，并且 Lambda 体中有多条语句
 *		Comparator<Integer> com = (x, y) -> {
 *			System.out.println("函数式接口");
 *			return Integer.compare(x, y);
 *		};
 *
 * 语法格式五：若 Lambda 体中只有一条语句， return 和 大括号都可以省略不写
 * 		Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
 *
 * 语法格式六：Lambda 表达式的参数列表的数据类型可以省略不写，因为JVM编译器通过上下文推断出，数据类型，即“类型推断”
 * 		(Integer x, Integer y) -> Integer.compare(x, y);
 *
 * 上联：左右遇一括号省
 * 下联：左侧推断类型省
 * 横批：能省则省
 *
 * 二、Lambda 表达式需要“函数式接口”的支持
 * 函数式接口：接口中只有一个抽象方法的接口，称为函数式接口。 可以使用注解 @FunctionalInterface 修饰
 * 			 可以检查是否是函数式接口
 */
public class TestLambda2 {

    @Test
    public void test1() {
        int num = 0;    //java7及以前，需要加final,并且值不可变。

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world " + num);
            }
        };
        runnable.run();
        System.out.println("----------------------------");
        Runnable runnable1 = () -> System.out.println("hello lambda " + num);

        runnable1.run();
    }

    @Test
    public void test2() {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("厉害了" + s);
            }
        };
        consumer.accept("张三");
        System.out.println("-----------------------------");
        Consumer<String> consumer1 = x -> System.out.println("不厉害啊" + x);
        consumer1.accept("李四");
    }

    @Test
    public void test3() {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return o1.length();
                }
                return o2.length();
            }
        };
        System.out.println(comparator.compare("he", "hell"));
        System.out.println("------------------------------");

        Comparator<String> comparator1 = (x, y) -> {
            if (x.length() > y.length()) {
                return x.length();
            }
            return y.length();
        };
        System.out.println(comparator1.compare("haaa", "hsdlsd"));
    }

    @Test
    public void test4() {
        String[] str = {"a", "b"};
//        str = {"hh","22"};
        List<String> list;
        list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
    }

    //类型推断
    @Test
    public void test5() {
        show(new HashMap<>());
    }

    public void show(Map<String, Integer> map) {
    }

    //需求：对一个数进行运算
    @Test
    public void test6() {
        Integer num = operation(3, num1 -> num1);
        System.out.println(num);
        System.out.println(operation(3, x -> x + 500));
    }

    public Integer operation(Integer num, MyFun myFun) {
        return myFun.getValue(num);
    }

}
