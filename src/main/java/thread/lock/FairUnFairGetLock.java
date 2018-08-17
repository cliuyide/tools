package thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairUnFairGetLock implements Runnable {
	private Lock lock = new ReentrantLock(true);
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			try {
				lock.lock();
				System.out.println(Thread.currentThread().getName());
			} finally {
				lock.unlock();
			}
		}
	}

	public static void main(String[] args) {
		FairUnFairGetLock run = new FairUnFairGetLock();
		new Thread(run, "t1").start();
		new Thread(run, "t2").start();
	}

}
