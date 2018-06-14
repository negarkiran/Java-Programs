package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorsExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {

            executorService.submit(()->{
                String threadName = Thread.currentThread().getName();
                System.out.println("Hello:"+threadName);
             });

        executorService.shutdown();

        executorService.awaitTermination(5,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            if(!executorService.isTerminated()){
                System.out.println("Cancel not finished yet");
            }
            executorService.shutdownNow();
            System.out.println("Shutdown Finished");
        }
    }
}
