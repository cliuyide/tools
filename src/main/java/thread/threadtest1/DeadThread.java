package thread.threadtest1;

public class DeadThread {
	private Object o1=new Object();
	private Object o2=new Object();
	public static void main(String[] args) {
		DeadThread a=new DeadThread();
		new Thread(()->{
			synchronized (a.o1) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (a.o2) {
					System.out.println("o1o2");
				}
			}
		}).start();
		new Thread(()->{
			synchronized (a.o2) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (a.o1) {
					System.out.println("o2o1");
				}
			}
		}).start();
	}
}
