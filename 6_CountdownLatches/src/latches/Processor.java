package latches;

/** <p>
 *	Using the excellent CountDownLatch Java class to synchronize your threads' activities..
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

class Processor implements Runnable {
    private int id;
    private CountDownLatch latch;
    
    public Processor(int id, CountDownLatch latch) {
        this.id = id;
        this.latch = latch;
    }
    
    public void run() {
        System.out.println("Starting: " + id);
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        latch.countDown();
        System.out.println("Completed: " + id);
    }
}