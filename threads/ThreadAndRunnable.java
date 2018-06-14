package threads;

import java.util.concurrent.TimeUnit;

public class ThreadAndRunnable {
    public static void main(String[] args) {
        Runnable task = ()->{
            try {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello:"+threadName);

            TimeUnit.SECONDS.sleep(1);
            System.out.println("Fooo");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        //task.run();

        Thread thread = new Thread(task);
        thread.start();

        System.out.println("Done!");
    }
}
