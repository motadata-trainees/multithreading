public class Scheduler  implements Runnable {
    public void run() {
        while (GlobalConfigManger.getState()) {
            try {
                for (int i = 0; i < 100; i++) {
                    GlobalConfigManger.queueAdd();
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