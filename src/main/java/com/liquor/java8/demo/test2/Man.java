package com.liquor.java8.demo.test2;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author Liquor.Huang
 * @Date 2020/12/28 16:11
 * To change this template use File | Settings | File Templates.
 */
public class Man {
    private Godness god;

    @Override
    public String toString() {
        return "Man{" +
                "god=" + god +
                '}';
    }

    public Godness getGod() {
        return god;
    }

    public void setGod(Godness god) {
        this.god = god;
    }

    public Man(Godness god) {
        this.god = god;
    }

    public Man() {
    }
}
