package com.threadpool.java;

import java.util.concurrent.Callable;

public class Subtraction implements Callable {
    @Override
        public Integer call() throws Exception {
        int num = Config.Subtraction();
        System.out.print(Thread.currentThread().getName() + " : " + "Subtraction : ");
        return num;
        }
    }

