package thread.threadtest1;

public class VolatileInstructionReordering {
	private int a;
	private boolean flag;

	void change() {
		a = 1;
		flag = true;
	}

	void get() {
		if (flag) {
			int i = a * a;
			if (i == 0) {
				System.out.println(i);
			}
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100000; i++) {
			VolatileInstructionReordering v = new VolatileInstructionReordering();
			Thread t1 = new Thread(v::change, "change");
			Thread t2 = new Thread(v::get, "get");
			t1.start();
			t2.start();
		}
	}
}