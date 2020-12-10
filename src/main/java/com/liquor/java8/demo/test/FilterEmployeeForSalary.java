package com.liquor.java8.demo.test;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author Liquor.Huang
 * @Date 2020/12/10 15:05
 * To change this template use File | Settings | File Templates.
 */
public class FilterEmployeeForSalary implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee employee) {
        return employee.getSalary() > 5000;
    }
}
