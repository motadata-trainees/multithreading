import java.io.FileNotFoundException;
public class BootManager {
    public static void main(String[] args) {
        try{

            GlobalConfig.store();
            Scheduler scheduler=new Scheduler();
            CollectorService service=new CollectorService();
            scheduler.start();
            service.start();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }
}