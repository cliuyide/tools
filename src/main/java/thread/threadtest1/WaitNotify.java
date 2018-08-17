package thread.threadtest1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WaitNotify {
	private List<Object> a = new ArrayList<>();

	Integer add() {
		a.add(new Object());
		return a.size();
	}

	Integer get() {
		return a.size();
	}

	public static void main(String[] args) throws InterruptedException {
		WaitNotify wn = new WaitNotify();
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				synchronized (wn.a) {
					if (wn.add() == 5) {
						wn.a.notify();
						try {
							wn.a.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				System.out.println(wn.get());
			}
		}, "add");
		Thread t2 = new Thread(() -> {
			synchronized (wn.a) {
				try {
					wn.a.wait();
					wn.a.notify();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(wn.get() + "t2结束了");
			}


		}, "get");
		t2.start();
		TimeUnit.SECONDS.sleep(1);
		t1.start();

	}
}
