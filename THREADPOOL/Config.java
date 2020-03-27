package com.threadpool.java;


import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.lang.System.*;

public class Config {
     private static ExecutorService executor = Executors.newFixedThreadPool(3);
     private static Random ran = new Random();
     private static String request = null;

     //public static String request=null;

     public static String getRequest(){
          int number = ran.nextInt(3);
          String[] request = new String[]{"Addition", "Subtraction", "Division"};
          String req = request[number];
          return req;

     }
     public static int Addition(){
          int number = ran.nextInt(100);
          System.out.println("number for addition : " +number);
          return (number + 10);

     }
     public static int Subtraction(){
          int number = ran.nextInt(100);
          System.out.println("number for subtraction : " +number);
          return (number - 10);

     }
     public static int Division(){
          int number = ran.nextInt(100);
          System.out.println("number for division : " +number);
          return (number / 2);

     }
     public static void execute()  {
          Future<Integer> future;
          try {

               for (int i = 0; i < 1000; i++) {
                    request = Config.getRequest();
                    switch (request) {
                         case "Addition":
                              future = executor.submit(new Addition());
                              System.out.println(future.get());
                              break;

                         case "Subtraction":
                              future = executor.submit(new Subtraction());
                              System.out.println(future.get());
                              break;


                         case "Division":
                              future = executor.submit(new Division());
                              System.out.println(future.get());
                              break;
                    }
               }
          }catch(Exception e){
               e.printStackTrace();
          }
     }

}
