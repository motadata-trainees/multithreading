import java.util.concurrent.Callable;

public class Addition implements Callable<Integer> {

    public Integer call() {
        int callonreturn=0;
        try {
            System.out.println(Thread.currentThread().getName());
            callonreturn=78;
        }catch(Exception e){e.printStackTrace();}
    return callonreturn;
    }
}