package pl.wjug.mwarecki.jmm;
import java.util.concurrent.atomic.AtomicInteger;


public class AtomicIntegerOperations {
	
	private AtomicInteger integer = new AtomicInteger();
	
	public static void main(String[] args) {
		AtomicIntegerOperations atomIntTest = new AtomicIntegerOperations();
		for(int i = 0; i < 10000; i++) {
			atomIntTest.test();
		}
	}
	
	private void test() {
		integer.set(1);
		integer.set(1);
		integer.set(1);
		integer.set(1);
		integer.lazySet(2);
		integer.lazySet(2);
		integer.incrementAndGet();
		integer.incrementAndGet();
	}

}
