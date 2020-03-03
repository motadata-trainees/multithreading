package ThreadpoolExample;

import java.util.concurrent.Callable;

/**
 * Created by parth on 27/2/20.
 */
public class Addition implements Callable<String> {
    @Override
    public String call() {
        String s="";
        try {
            int value = GlobalConfigure.generateRandomNumber();
            int updatevalue = value + 10;
            s=Thread.currentThread().getName()+" oldvalue: "+value+" + 10 "+"new value:"+updatevalue;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return s;

    }
}
