package com.threadpool.java;

import java.util.List;
import java.util.concurrent.Callable;

public class Addition implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int num = Config.Addition();
        System.out.print(Thread.currentThread().getName() + " : " + "Addition : " );
        return num;

        }
    }
