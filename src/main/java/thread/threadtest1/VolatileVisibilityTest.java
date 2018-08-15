package thread.threadtest1;

import java.util.concurrent.TimeUnit;

public class VolatileVisibilityTest {
	private boolean flag = true;

	void circle() {
		System.out.println("start");
		while (flag) {
			System.out.println("dsl");
		}
		System.out.println("end");
	}

	public static void main(String[] args) throws InterruptedException {
		VolatileVisibilityTest v = new VolatileVisibilityTest();
		Thread t1 = new Thread(v::circle, "circleThread");
		t1.start();
		TimeUnit.SECONDS.sleep(1);
		v.flag = false;
	}
}
