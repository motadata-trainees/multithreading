import java.util.Scanner;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class ConfigurationManager {
    private static ExecutorService service = Executors.newFixedThreadPool(10);

    private static LinkedBlockingQueue<String> Unirequest = new LinkedBlockingQueue<>();
    private static AtomicBoolean isNotReady = new AtomicBoolean(false);
//    private static ArrayList<Future> listAdd=new ArrayList<>();
//    private static  ArrayList<Future> listSub=new ArrayList<>();

    public static void requestInput() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the number of Requests");
            int requestnumber = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter the requests in the format /request-name");
            for (int i = 0; i < requestnumber; i++) {
                String request = sc.nextLine();
//                sc.nextLine();
                Unirequest.put(request);
            }
            System.out.println(Unirequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String inorderRequest(){

        String InputRequest = null;
        try {
            InputRequest = Unirequest.take();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return InputRequest;

    }

//    public static void  additionToList(Future future){
//        listAdd.add(future);
//    }
//    public static void substractionToList(Future future){
//        listSub.add(future);
//    }
////    for printing futures
//    public static void addlistprint(){
//        try {
//            for (int i = 0; i < listAdd.size(); i++) {
//                Future<Integer> future = listAdd.get(i);
//                try {
//                    Integer result = future.get();
//                    System.out.println("Result of Addition class"+i+" "+result);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }catch(Exception e){e.printStackTrace();}
//
//    }
//    public static void sublistprint(){
//        try{
//        for(int i=0;i<listSub.size();i++){
//            Future<Integer> future=listSub.get(i);
//            try{
//                Integer result=future.get(); // blocking
//                System.out.println("Result of Substraction class"+i+" "+result);
//            }catch(Exception e){e.printStackTrace();}
//        }
//
//    }catch(Exception e){e.printStackTrace();}
//    }

    public static boolean getState() {
        return isNotReady.get();
    }

    public static void setState(boolean state) {
        isNotReady.set(state);
    }

    public static Integer queueSize() {
        return Unirequest.size();
    }

    public static Future serviceSubmitAdd(Callable<Integer> callable) throws Exception
    {
        return service.submit(callable);
    }

    public static Future submitTask(Callable<Integer> callable) {
        return service.submit(callable);

    }
}