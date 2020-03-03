package com.multiplethreads.java;

public class BootManager {
    public static void main(String args[]) {
       Config.fetch();
       Schedular schedular = new Schedular();
       schedular.start();
       Addition addition =new Addition();
       Multiplication multiplication =new Multiplication();
       Subtraction subtraction = new Subtraction();
       Division division = new Division();
       Result result = new Result();

        addition.start();
        multiplication.start();
        subtraction.start();
        division.start();
        result.start();

    }
}
