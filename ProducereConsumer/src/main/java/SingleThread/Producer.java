package SingleThread;

public class Producer extends Thread {
    static int count =1;

        public void run()
        {
            try
            {
                while (!GlobalConfiguration.isShutdownGet())
                {
                    GlobalConfiguration.produce("task "+Integer.toString(count));
                    System.out.println("Producer produced task "+Integer.toString(count));
                    count=count+1;
                    Thread.sleep(1000);
                }
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
            finally
            {
                if(!GlobalConfiguration.isShutdownGet())
                    run();
            }
        }
}
