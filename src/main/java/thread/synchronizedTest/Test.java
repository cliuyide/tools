package thread.synchronizedTest;

public class Test {
	private Object object = new Object();
	public static void main(String[] args) {
		Test t = new Test();
		Thread t1=new Thread(new Runnable() {
			
			@Override
			public void run() {
					t.getObject();
			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				t.setObject(555);
			}
		});
		t1.start();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
	}

	public synchronized Object getObject() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return object;
	}

	public synchronized void setObject(Object object) {
		this.object = object;
		System.err.println("获取不到");
	}

}
