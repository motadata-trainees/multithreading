import java.util.concurrent.*;

public class TaskExecutor extends Thread {
    public void run()
    {
        try{
            while(!(GlobalConfiguration.gettState()))
            {
                String key=GlobalConfiguration.receiveQueueOne();

                    if(key.equals("add")) {
                        Callable callable = new Addition();
                        FutureTask task = new FutureTask(callable);
                        GlobalConfiguration.execute(task);
                        System.out.println("Addition "+task.get());
                    }
                    else if(key.equals("sub"))
                    {
                        Callable callable = new Subtraction();
                        FutureTask task = new FutureTask(callable);
                        GlobalConfiguration.execute(task);
                        System.out.println("Subtraction "+task.get());

                    }
                    else if(key.equals("mul"))
                    {
                        Callable callable = new Multiplication();
                        FutureTask task = new FutureTask(callable);
                        GlobalConfiguration.execute(task);
                        System.out.println("Multiplication "+task.get());
                    }
                }

            }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally {
            if (!(GlobalConfiguration.gettState())) {
                run();
            }
        }
    }
}
