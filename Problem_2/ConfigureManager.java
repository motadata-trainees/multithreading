package exmaple;

import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by parth on 24/2/20.
 */
public class ConfigureManager {

    private static Map<String,Float> data = new ConcurrentHashMap<>();

    private static BlockingDeque<String> valAdd = new LinkedBlockingDeque<>();

    private static BlockingDeque<String> valSub = new LinkedBlockingDeque<>();

    private static BlockingDeque<String> valMul = new LinkedBlockingDeque<>();

    private static BlockingDeque<String> valDiv = new LinkedBlockingDeque<>();

    private static BlockingDeque<String> valResult = new LinkedBlockingDeque<>();

    private static AtomicBoolean shutdown = new AtomicBoolean(false);

    public static void fetch() {

        data.put("parth", (float) 100);
        data.put("nilesh", (float) 150);
        data.put("satvik", (float) 200);

        System.out.println(data);
    }

    public static float getData(String name) {

        return data.get(name);
    }

    public static void putData(String name,float value) {

        data.replace(name,value);
    }

    public static Boolean shutDown() {

        return shutdown.get();
    }

    public static String takeAdditionTask() {


        try {

            return valAdd.take();
        }
        catch (InterruptedException e) {

            e.printStackTrace();
        }

        return null;

    }
    public static String takeSubtractionTask() {


        try {

            return valSub.take();
        }
        catch (InterruptedException e) {

            e.printStackTrace();
        }


        return null;
    }

    public static String takeMultiplicationTask() {


        try {

            return valMul.take();
        }
        catch (InterruptedException e) {

            e.printStackTrace();
        }

        return null;
    }

    public static String takeDivideTask() {

        try {

            return valDiv.take();
        }
        catch (InterruptedException e) {

            e.printStackTrace();
        }

        return null;
    }
    public static String takeResultTask() {

        try {

            return valResult.take();
        }
        catch (InterruptedException e) {

            e.printStackTrace();
        }
        return null;
    }

    public static void setValAdd(String key)
    {
        try {
            valAdd.put(key);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void setValSub(String key){

        try {
            valSub.put(key);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void setValMul(String key) {

        try {
            valMul.put(key);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void setValDiv(String key) {

        try {
            valDiv.put(key);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void setValResult(String key) {

        try {
            valResult.put(key);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void intialize(){
        try {
            for (Map.Entry<String, Float> map : data.entrySet()) {
                String key = map.getKey();
                ConfigureManager.setValAdd(key);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}