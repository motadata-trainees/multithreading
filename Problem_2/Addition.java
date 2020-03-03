package exmaple;

/**
 * Created by parth on 24/2/20.
 */
public class Addition extends Thread
{

    public void run()
    {
        try {

            while (!ConfigureManager.shutDown()) {


                String task = ConfigureManager.takeAdditionTask();

                if(task != null)
                {
                    float value = ConfigureManager.getData(task);

                    value = value + 50;

                    ConfigureManager.putData(task,value);

                    ConfigureManager.setValSub(task);

                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {

            if(!ConfigureManager.shutDown())
            {
                run();
            }
        }
    }
}
