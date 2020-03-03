import java.util.concurrent.Callable;

public class Substraction implements Callable<Integer> {

    public Integer call() throws Exception {
        int callonreturn=0;
        try {
            System.out.println(Thread.currentThread().getName());
            callonreturn=98;
        }catch(Exception e){e.printStackTrace();}
    return callonreturn;
    }
}