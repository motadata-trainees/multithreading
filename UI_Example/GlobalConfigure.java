package ThreadpoolExample;

import jdk.internal.util.xml.impl.Input;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by parth on 27/2/20.
 */
public class GlobalConfigure {

   private static ArrayList<String> request= new ArrayList<>();

   //private static ArrayList<Future> futures=new ArrayList<>();

   private static ExecutorService executor = Executors.newCachedThreadPool();

   private static Random random=new Random();

   public static void getRequest()
   {
       request.add("addition");
       request.add("subtraction");
       request.add("multiplication");
   }

   public static String randomRequestGenerator()
   {
       int index=random.nextInt(3);
       return request.get(index);
   }

   public static void getExecuterService()
   {
       for (int i=0;i<100;i++)
       {
           String request=randomRequestGenerator();
           Future futurevalue = null;
           switch (request)
           {
               case "addition":
                   futurevalue=executor.submit(new Addition());
                   try {
                       System.out.println(futurevalue.get());
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   } catch (ExecutionException e) {
                       e.printStackTrace();
                   }
                   break;

               case "subtraction":
                   futurevalue=executor.submit(new Subtraction());
                   try {
                       System.out.println(futurevalue.get());
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   } catch (ExecutionException e) {
                       e.printStackTrace();
                   }
                   break;

               case "multiplication":
                   futurevalue=executor.submit(new Multiplication());
                   try {
                       System.out.println(futurevalue.get());
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   } catch (ExecutionException e) {
                       e.printStackTrace();
                   }
                   break;

               default:
                   System.out.println("no request");

           }
          // putDataFuture(futurevalue);
       }
   }

   /*public static void putDataFuture(Future value)
   {
       futures.add(value);
   }*/

   public static Integer generateRandomNumber()
   {
       int randomInt=random.nextInt(500)+1;
       return randomInt;
   }

   /*public static void outputData()
   {
       for (Future map:futures)
       {
           try {
               System.out.println(map.get());
           } catch (InterruptedException e) {
               e.printStackTrace();
           } catch (ExecutionException e) {
               e.printStackTrace();
           }
       }
   }*/

}
