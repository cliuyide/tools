package thread.threadtest1;

import java.util.concurrent.TimeUnit;

public class ThreadTestException {

	public synchronized void create() throws InterruptedException {
		Integer a = null;
		try {
			a++;
		} catch (Exception e) {
			e.printStackTrace();
		}

		TimeUnit.SECONDS.sleep(10);
		System.out.println("我能c嘛");
	}

	public synchronized void get() {
		System.out.println("我能获取");
	}

	public static void main(String[] args) {
		ThreadTestException t1 = new ThreadTestException();
		Thread th1 = new Thread(() -> {
			try {
				t1.create();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "create");
		Thread th2 = new Thread(() -> {
			t1.get();
		}, "get");
		th1.start();
		th2.start();
	}
}
