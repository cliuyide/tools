package jsoup.proxy.pool;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import jsoup.proxy.core.entity.ProxyVO;

public interface ProxyPool {
	 ProxyVO get();
	 ProxyVO getUnUsed(List<ProxyVO> proxys);
	 ConcurrentLinkedQueue<ProxyVO> getAll();
}
