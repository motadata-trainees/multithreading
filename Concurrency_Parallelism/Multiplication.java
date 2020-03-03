import java.util.HashMap;

public class Multiplication implements Runnable {
    public void run() {

            try {
                while (!ConfigurationManager.GetState()) {

                        int mul = 3;
                        mul = ConfigurationManager.MulQueueTake() * mul;
                        ConfigurationManager.MulQueue(mul);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                if(!ConfigurationManager.GetState()){
                    run();
                }
            }
        }
    }
