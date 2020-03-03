package ThreadpoolExample;

import java.util.concurrent.*;

/**
 * Created by parth on 27/2/20.
 */
public class Bootmanager {
    public static void main(String[] args) {

        GlobalConfigure.getRequest();
        GlobalConfigure.getExecuterService();
        //GlobalConfigure.outputData();
    }
}
