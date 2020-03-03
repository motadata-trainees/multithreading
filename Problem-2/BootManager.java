import java.io.FileNotFoundException;
public class BootManager
{
    public static void main(String[] args) {
        try{
            GlobalConfiguration.store();
            GlobalConfiguration.loadConfiguration();
            IncrementTen incrementBy10=new IncrementTen();
            IncrementTwenty incrementBy20=new IncrementTwenty();
            IncrementThirty incrementBy30=new IncrementThirty();
            IncrementForty incrementBy40=new IncrementForty();
            FinalResult finalresult=new FinalResult();
            Scheduler scheduler=new Scheduler();

            scheduler.start();
            incrementBy10.start();
            incrementBy20.start();
            incrementBy30.start();
            incrementBy40.start();
            finalresult.start();
        } catch (Exception e){
            System.out.println(e);
        }
    }
}