import java.util.concurrent.Future;

public class Scheduler implements Runnable {
    public void run() {
        try {
        while (!ConfigurationManager.getState()) {

            ConfigurationManager.requestInput();
            int x = ConfigurationManager.queueSize();
            for (int i = 0; i < x; i++) {
                String req = ConfigurationManager.inorderRequest();

                switch (req) {
                    case "Addition":

                        Future futureAdd = ConfigurationManager.serviceSubmitAdd(new Addition());
//                    Future is a placeholder for the value that will arrive sometime in the future.
                        try{
                            Integer result= (Integer) futureAdd.get(); // blocking
                            System.out.println("Result of Addition class"+i+" "+result);
                        }catch(Exception e){e.printStackTrace();}
                        break;

                    case "Substraction":

                        Future futureSub = ConfigurationManager.submitTask(new Substraction());
                        try{
                            Integer result= (Integer) futureSub.get(); // blocking
                            System.out.println("Result of Substraction class"+i+" "+result);
                        }catch(Exception e){e.printStackTrace();}
                        break;

                    default:
                        System.out.println("Please recheck");
                }
            }
        }

            } catch (Exception e) {
                e.printStackTrace();
                ConfigurationManager.setState(true);
            }
            finally {
                if(!ConfigurationManager.getState()){
                    run();
                }
            }
    }
}
