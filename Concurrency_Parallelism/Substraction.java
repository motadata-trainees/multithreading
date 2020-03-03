public class Substraction  implements Runnable {
    public void run() {
        try {
            while (!ConfigurationManager.GetState()) {
                    int sub = 20;
                    sub = ConfigurationManager.SubQueueTake() - sub;
                    ConfigurationManager.SubQueue(sub);
            }
        }
        catch(Exception e){
                e.printStackTrace();
            }
        finally {
            if(!ConfigurationManager.GetState()){
                run();
            }
        }
        }
    }
