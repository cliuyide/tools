package thread.threadtest1;

public class TwoThreadCount {
	private volatile int a;
	volatile boolean flag = true;
	void add() {
		a++;
	}

	int get() {
		return a;
	}

	public static void main(String[] args) throws InterruptedException {
		TwoThreadCount ttc = new TwoThreadCount();
		Thread t1 = new Thread(() -> {
			int i = 0;
			while (ttc.flag && i < 10) {
				ttc.add();
				i++;
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "add");
		Thread t2 = new Thread(() -> {
			while (true) {
				if (ttc.get() == 5) {
					ttc.flag = false;
					break;
				}
			}
		}, "get");
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(ttc.get() + "" + ttc.flag);
	}
}
