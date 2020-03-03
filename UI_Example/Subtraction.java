package ThreadpoolExample;

import java.util.concurrent.Callable;

/**
 * Created by parth on 27/2/20.
 */
public class Subtraction implements Callable<String> {

    @Override
    public String call(){
        String s="";
        try {
            int value = GlobalConfigure.generateRandomNumber();
            int updatevalue = value - 5;
            s=Thread.currentThread().getName() + " oldvalue: " + value + " - 5 " + "new value:" + updatevalue;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return s;
    }
}
