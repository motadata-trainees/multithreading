import java.util.concurrent.Callable;

public class Multiplication implements Callable {
    public Object call() {
            Integer mul = 1;
            try {
                mul=GlobalConfiguration.multiplication();
            } catch (Exception e) {
                System.out.println(e);
            }
            return mul;
    }
}
