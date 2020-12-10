package com.liquor.java8.demo.test;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author Liquor.Huang
 * @Date 2020/12/10 15:01
 * To change this template use File | Settings | File Templates.
 */
public class FilterEmployeeForAge implements MyPredicate<Employee> {

    @Override
    public boolean test(Employee employee) {
        return employee.getAge() <= 35;
    }
}
