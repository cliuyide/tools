package array;

public class Test {
	public static void main(String[] args) {
		Long start1=System.currentTimeMillis();
		int j = 100000;
		for(int i=0;i<j;i++){
			double a=i*1.0;
		}
		System.out.println("*1.0耗时"+(System.currentTimeMillis()-start1));
		Long start2=System.currentTimeMillis();
		for(int i=0;i<j;i++){
			double a=(double)i;
		}
		System.out.println("*(double)耗时"+(System.currentTimeMillis()-start2));
		Long start3=System.currentTimeMillis();
		for(int i=0;i<j;i++){
			double a=Double.valueOf(i);
		}
		System.out.println("*Double.valueOf()耗时"+(System.currentTimeMillis()-start3));
	}
}
