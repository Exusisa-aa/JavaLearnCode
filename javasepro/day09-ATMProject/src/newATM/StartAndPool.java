package newATM;

import java.io.IOException;
import java.util.concurrent.*;

public class StartAndPool {
    public static void main(String[] args) {
        ExecutorService es = new ThreadPoolExecutor(40,50
                                                    ,10, TimeUnit.SECONDS,
                                                    new ArrayBlockingQueue<>(20),
                                                    Executors.defaultThreadFactory(),
                                                    new ThreadPoolExecutor.AbortPolicy());

        es.execute(new MyRunnable());


        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            es.shutdownNow();
            if (ATM.oos != null){
                try {
                    ATM.oos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (ATM.ois != null){
                try {
                    ATM.ois.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }));
    }
}
