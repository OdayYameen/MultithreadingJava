package latches;

/** <p>
 * 	Using the excellent CountDownLatch Java class to synchronize your threads' activities..
 * </p>
 * 
 * <p>
 * The full tutorial and the majority of the code is available at
 * https://www.udemy.com/java-multithreading/?dtcode=KmfAU1g20Sjj#/
 * </p>
 * 
 * <p>
 * @author kanastasov L1087591@live.tees.ac.uk December-2014
 * </p>
 */
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) {
        
        CountDownLatch latch = new CountDownLatch(3);
        
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        for(int i=0; i < 3; i++) {
            executor.submit(new Processor(i, latch));
        }
        executor.shutdown();
        System.out.println("All tasks submitted.");
        try {
            latch.await();
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("All tasks completed.");
    }

}