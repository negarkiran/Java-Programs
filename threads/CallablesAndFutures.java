package threads;

import java.util.concurrent.*;

public class CallablesAndFutures {
    public static void main(String[] args) {
        Callable<Integer> task = ()->{
            TimeUnit.SECONDS.sleep(1);
            return 123;
        };
        try {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Integer> future = executorService.submit(task);

        System.out.println("Future Done?:"+future.isDone());

        Integer result = future.get();
        System.out.println("Future Done?:"+future.isDone());
        System.out.println("Result:"+result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
