package ThreadpoolExample;

import java.util.concurrent.Callable;

/**
 * Created by parth on 27/2/20.
 */
public class Multiplication implements Callable<String> {
    @Override
    public String call(){
        String s="";
        try {
            int value = GlobalConfigure.generateRandomNumber();
            int updatevalue = value * 2;
            s=Thread.currentThread().getName() + " oldvalue: " + value + " * 2 " + "new value:" + updatevalue;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return s;
    }
}
