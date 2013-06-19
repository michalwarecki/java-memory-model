package pl.wjug.mwarecki.jmm;
class Monitors {
	int a;
	volatile int v;

	void monitors() {
		int i;
		synchronized (this) {
			i = a;
			a = i;
		}
		
		//synchronized (this) {
		//	synchronized (this) {
		//	}
		//}

		i = v;
		synchronized (this) {
		}

		v = i;
		synchronized (this) {
		}
	}
	
	public static void main(final String[] args) {
		Monitors main = new Monitors();
		for(int i = 0; i < 1000000; i++)
			main.monitors();
	}
}
