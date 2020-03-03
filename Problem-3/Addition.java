import java.util.concurrent.Callable;

public class Addition implements Callable {
    @Override
    public Object call() {
            Integer add = 0;
            try {
                add=GlobalConfiguration.addition();
            } catch (Exception e) {
                System.out.println(e);
            }
            return add;
    }
}
