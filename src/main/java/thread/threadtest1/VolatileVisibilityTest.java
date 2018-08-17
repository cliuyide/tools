package thread.threadtest1;

public class VolatileVisibilityTest {
	private boolean flag = true;

	void circle() {
		System.out.println("start");
		while (flag) {

		}
		System.out.println("end");
	}

	public static void main(String[] args) throws InterruptedException {
		VolatileVisibilityTest v = new VolatileVisibilityTest();
		Thread t1 = new Thread(v::circle, "circleThread");
		t1.start();
		Thread currentThread = Thread.currentThread();
		System.out.println(currentThread.getState());
		while (true) {
			Thread.yield();
			System.out.println(currentThread.getState());
			if (currentThread.getState().equals(Thread.State.RUNNABLE)) {
				break;
			}
		}
		// TimeUnit.SECONDS.sleep(1);
		// v.flag = false;
	}
}
