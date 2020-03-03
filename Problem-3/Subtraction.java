import java.util.concurrent.Callable;

public class Subtraction implements Callable {
    public Object call() {

            Integer sub = 0;
            try {
                sub=GlobalConfiguration.subtraction();
            } catch (Exception e) {
                System.out.println(e);
            }
            return sub;
    }
}
