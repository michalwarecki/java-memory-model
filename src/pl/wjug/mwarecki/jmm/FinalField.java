package pl.wjug.mwarecki.jmm;

public class FinalField {
	
	public static void main(String[] args) {
		for(int i = 0; i < 100000; i++) {
			FinalFieldExample.writer();
			FinalFieldExample.reader();
		}
	}

}

class FinalFieldExample {
	final int x;
	int y;
	static FinalFieldExample f;

	public FinalFieldExample() {
		x = 3;
		y = 4;
	}

	static void writer() {
		f = new FinalFieldExample();
	}

	static void reader() {
		if (f != null) {
			int i = f.x;
			int j = f.y;
		}
	}
}
