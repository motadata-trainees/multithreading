public class Consumer1 implements Runnable {
    public void run() {
        while (GlobalConfigManger.getState()) {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName());
                    GlobalConfigManger.queuetake();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (GlobalConfigManger.getState()) {
                    run();

                }
            }
        }
    }
}