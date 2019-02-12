package com.greedlab.java;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ForTest {
    @Test
    public void test1() {
        System.out.println("===== test1 =====");
        for (String item : getList()) {
            System.out.println(item);
        }
    }

    private List<String> getList() {
        System.out.println("get list");
        return Arrays.asList("a", "b", "c", "d");
    }

    @Test
    public void test2() {
        System.out.println("===== test2 =====");
        List<String > list = Arrays.asList("a", "b", "c", "d");
        for (int i = 0; i < getSize(list); i ++) {
            System.out.println(list.get(i));
        }
    }

    private int getSize(List list) {
        System.out.println("get size");
        return list.size();
    }

}
