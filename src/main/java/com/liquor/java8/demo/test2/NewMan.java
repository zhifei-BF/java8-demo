package com.liquor.java8.demo.test2;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author Liquor.Huang
 * @Date 2020/12/28 16:14
 * To change this template use File | Settings | File Templates.
 */
//注意：Optional 不能被序列化
public class NewMan {

    private Godness god;

    private Optional<Godness> godness =Optional.empty();

    public Optional<Godness> getGodness() {
        return godness;
    }

    public void setGodness(Optional<Godness> godness) {
        this.godness = godness;
    }

    @Override
    public String toString() {
        return "NewMan{" +
                "god=" + god +
                ", godness=" + godness +
                '}';
    }

    public NewMan(Optional<Godness> godness) {
        this.godness = godness;
    }

    public NewMan() {
    }
}
