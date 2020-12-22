package com.liquor.java8.demo.exer;

/**
 * @Description:
 * @Reference:
 * @Author: Liquor
 * @CreateDate:2020-12-22 22:29
 * @Modify:
 **/
@FunctionalInterface
public interface MyFunction2<T, R> {
    R getValue(T t1, T t2);
}
