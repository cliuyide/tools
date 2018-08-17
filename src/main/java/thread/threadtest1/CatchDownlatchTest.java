package thread.threadtest1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 门栓,按照初始化设置的值解锁,解锁完成后可继续向下执行
 *  优点不需要同步 操作简单好理解
 * 
 * @author liuyi
 *
 */
public class CatchDownlatchTest {
	private CountDownLatch latch = new CountDownLatch(1);
	private List<Object> list = new ArrayList<>();

	Integer add() {
		list.add(new Object());
		return list.size();
	}

	Integer get() {
		return list.size();
	}

	public static void main(String[] args) {
		CatchDownlatchTest ca = new CatchDownlatchTest();
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				if (ca.add() == 5) {
					ca.latch.countDown();
				}
				System.out.println(ca.get());
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, "add");

		Thread t2 = new Thread(() -> {
			try {
				ca.latch.await();
				System.out.println("t2结束了");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "get");
		t2.start();
		t1.start();
	}
}
