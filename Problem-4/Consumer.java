public class Consumer extends Thread{
    public Consumer(String name)
    {
        super(name);
    }
    public void run(){
        try{
            while(!GlobalConfiguration.getState())
            {
                GlobalConfiguration.consume();
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
