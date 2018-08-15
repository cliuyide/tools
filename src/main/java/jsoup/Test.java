package jsoup;


import com.alibaba.fastjson.JSON;

import jsoup.proxy.pool.ProxyPool;
import jsoup.proxy.pool.imp.XiCIProxyPool;

public class Test {
	public static void main(String[] args) {
		ProxyPool pool=new XiCIProxyPool();
		for(;;){
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(JSON.toJSON(pool.getAll()));
		}
		
	}
}
