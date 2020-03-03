public class BootManager {
    public static void main(String[] args){
        try {
            GlobalConfiguration.store();
            TaskCreator t1 = new TaskCreator();
            TaskExecutor t2 = new TaskExecutor();
            t1.start();
            t2.start();
        } catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
