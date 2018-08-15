package thread.produceandconsumer;

import java.util.ArrayList;
import java.util.List;

/**
 * 生产者消费者单线程
 * 
 * @author liuyi
 *
 */
public class ProducerAndConsumerSingleTest {
	private static Integer i = 0;

	public static void main(String[] args) {
		List<Integer> product = new ArrayList<Integer>();
		Thread produce = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (product) {
					System.out.println("开始生产");
					while (true) {
						if (product.size() == 100) {
							System.out.println("生产结束");
							try {
								product.notifyAll();
								product.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							System.out.println("开始生产");
							System.out.println(product.size());
						}
						product.add(i++);
					}
				}

			}
		});
		produce.setName("我是生产者");
		Thread consumer = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (product) {
					while (true) {
						if (product.size() == 0) {
							try {
								System.out.println("消费结束");
								product.notify();
								product.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							System.out.println("消费开始");
							System.out.println(product.size());
						}
						Integer val = product.remove(product.size() - 1);
					}
				}
			}
		});
		consumer.setName("我是消费者");
		produce.start();
		consumer.start();
	}

}
