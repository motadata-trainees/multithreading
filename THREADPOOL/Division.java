package com.threadpool.java;

import java.util.concurrent.Callable;

public class Division implements Callable {
    @Override
    public Integer call() throws Exception {
        int num = Config.Division();
        System.out.print(Thread.currentThread().getName() + " : " + "Division : ");
        return num;
    }
    }

