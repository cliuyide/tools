package thread.volatile1;

public class VolatileTest1 {
	private volatile int a = 0;
	public static void main(String[] args) {
		VolatileTest1 a = new VolatileTest1();
		a.getA();
	}

	public int getA() {
		a++;
		return a += 1;
	}

	public void setA(int a) {
		this.a = a;
	}

}

