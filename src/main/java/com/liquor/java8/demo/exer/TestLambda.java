package com.liquor.java8.demo.exer;

import com.liquor.java8.demo.test.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * @Reference:
 * @Author: Liquor
 * @CreateDate:2020-12-22 22:12
 * @Modify:
 **/
public class TestLambda {
    List<Employee> emps = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );

    @Test
    public void test1() {
        Collections.sort(emps, (e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return Integer.compare(e1.getAge(), e2.getAge());
            }
        });

        for (Employee emp : emps) {
            System.out.println(emp);
        }
    }

    @Test
    public void test2() {
        String trimStr = strHandler("\t\t\t 死在江南烟雨中\t\t\t", (m) -> m.trim());
        System.out.println(trimStr);

        String upper = strHandler("abcdef", (m) -> m.toUpperCase());
        System.out.println(upper);

        String newStr = strHandler("改变生活从一张纸开始！", (m) -> m.substring(2, 5));
        System.out.println(newStr);
    }

    //需求：用于处理字符串
    public String strHandler(String str, MyFunction mf) {
        return mf.getValue(str);
    }

    @Test
    public void test3() {
        op(1l, 2l, (m, n) -> m + n);

        op(100l, 200l, (m, n) -> m * n);
    }

    //需求：对于两个Long型数据进行处理
    public void op(Long l1, Long l2, MyFunction2<Long, Long> myFunction) {
        System.out.println(myFunction.getValue(l1, l2));
    }
}
