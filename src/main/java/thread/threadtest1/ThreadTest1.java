package thread.threadtest1;

import java.util.HashMap;
import java.util.Map;

public class ThreadTest1 {
	public static void main(String[] args) {
		Map<String,Thread> map=new HashMap<>();
		Thread thread1=new Thread(()->{
			try {
				for(int i=0;i<100;i++){
					
				}
				Thread.sleep(10);
				for(int i=0;i<100;i++){
					
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		for(;;){
			System.out.println(thread1.getState());
			if(thread1.getState().equals(Thread.State.NEW)){
				thread1.start();
			}
			if(thread1.getState().equals(Thread.State.TERMINATED)){
				System.out.println(thread1.getState());
				break;
			}
		}
	}
}
