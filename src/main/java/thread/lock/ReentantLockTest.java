package thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentantLockTest {
	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		Thread t1 = new Thread(() -> {
			try {
				lock.lock();
				System.out.println("t1拿到了锁");
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				System.out.println("t1interrupt");
			} finally {
				System.out.println(Thread.currentThread().isInterrupted());
				lock.unlock();
			}
		}, "lock");
		Thread t2 = new Thread(() -> {
			boolean locked = false;
			try {
				lock.lockInterruptibly();
				locked = true;
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				System.out.println("t2interrupt");
			} finally {
				if (locked) {
					lock.unlock();
				} else {
					System.out.println("我没有获取到锁");
				}

			}

		}, "lockInterruptibly");
		t2.start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t1.start();
		// t2.interrupt();
		t1.interrupt();
	}
}
