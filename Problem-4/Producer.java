public class Producer extends Thread {
    public Producer(String name)
    {
        super(name);
    }

    public void run(){
        try{
            while(!GlobalConfiguration.getState())
            {
                GlobalConfiguration.produce();
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        finally {
            if (!GlobalConfiguration.getState()) {
                run();
            }
        }
    }
}
