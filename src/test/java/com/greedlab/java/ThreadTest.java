package com.greedlab.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadTest {
    /**
     * 使用 VisualVM 查看线程战胜资源得到，线程结束后就不再占用资源，FutureTask.get() 可以得到线程返回的结果。
     */
    @Test
    public void testFutureTask() {
        final int[] number = {0};

        Callable<Integer> callable = () -> {
            System.out.println("number: " + number[0]);
            Thread.sleep(10 * 1000);
            number[0]++;
            return number[0];
        };

        List<FutureTask<Integer>> futureTaskList = new ArrayList<>();
        for (int index = 0; index < 5; index++) {
            FutureTask<Integer> futureTask = new FutureTask<>(callable);
            futureTaskList.add(futureTask);
            Thread thread = new Thread(futureTask);
            thread.start();
        }

        for (FutureTask<Integer> futureTask : futureTaskList) {
            try {
                int result = futureTask.get();
                System.out.println("result: " + result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        for (FutureTask<Integer> futureTask : futureTaskList) {
            try {
                int result = futureTask.get();
                System.out.println("result: " + result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(10 * 60 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
