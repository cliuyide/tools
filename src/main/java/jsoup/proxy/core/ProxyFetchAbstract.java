package jsoup.proxy.core;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import jsoup.proxy.core.entity.ProxyVO;
import jsoup.proxy.utils.SocketUtils;

public abstract class ProxyFetchAbstract {
	protected ThreadPoolExecutor threadpool=new ThreadPoolExecutor(5, 20,0L,TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(7000)); 
	protected ConcurrentLinkedQueue<ProxyVO> proxys=new ConcurrentLinkedQueue<>();
	/**
	 * 抓取代理的抽象方法
	 */
	protected abstract void fetchProxy();
	/**
	 * 获取原始的url链接
	 */
	protected abstract String getNativeUrl();
	
	protected void activityChecked(){
		threadpool.execute(()->{
			proxys.stream().forEach(item->{
				if(!SocketUtils.checked(item.getIp(), item.getPort()))
					proxys.remove(item);
			});
		});
	}
	
}
