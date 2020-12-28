package com.liquor.java8.demo.test2;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author Liquor.Huang
 * @Date 2020/12/28 16:10
 * To change this template use File | Settings | File Templates.
 */
public class Godness {
    private String name;

    @Override
    public String toString() {
        return "Godness{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Godness(String name) {
        this.name = name;
    }

    public Godness() {
    }
}
