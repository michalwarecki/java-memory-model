package pl.wjug.mwarecki.jmm;
import java.util.concurrent.atomic.AtomicBoolean;

public class LoopFlagLazy {
	
	private AtomicBoolean running = new AtomicBoolean(true);

	  public void test() {
		  new Thread(new Runnable() {
	  	      public void run() {
	  	        int counter = 0;
	  	        while (running.get()) {
	  	          counter++;
	  	        }
	  	        System.out.println("Thread 1 finished. Counted up to " + counter);
	  	      }
	  	    }).start();
	  	    new Thread(new Runnable() {
	  	      public void run() {
	  	        // Sleep for a bit so that thread 1 has a chance to start
	  	        try {
	  	          Thread.sleep(100);
	  	        } catch (InterruptedException ignored) { }
	  	        System.out.println("Thread 2 finishing");
	  	        running.lazySet(false);
	  	      }
	  	    }).start();
	  }
	
    public static void main(final String[] args) {
        LoopFlagLazy main = new LoopFlagLazy();
        main.test();
    }

    
}