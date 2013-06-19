package pl.wjug.mwarecki.jmm;

public class LoopJitUnrolling {
	
	private volatile int volatileCounter = 0;
	private int counter = 0;
	
	private volatile int volatileTemp = 0;
	private int counterTemp = 0;
	
	void volatileLoop() {
		for(int i = 0; i < 3; i++) {
			volatileCounter++;
			volatileTemp = volatileCounter;
		}
	}
	
	void loop() {
		for(int i = 0; i < 3; i++) {
			counter++;
			counterTemp = counter;
		}
	}
	
	public static void main(String[] args) {
		LoopJitUnrolling loopUnrolling = new LoopJitUnrolling();
		for(int i = 0; i < 15000; i++) {
			loopUnrolling.loop();
			loopUnrolling.volatileLoop();
		}
	}

}
