
import java.util.concurrent.*;

public class MainDisplay {
    public static void main(String args[])
    {
        GlobalConfiguration.initializeConfiguration();
        TaskCreator taskCreator = new TaskCreator();
        taskCreator.start();
        GlobalConfiguration.executeTask();
    }

}

