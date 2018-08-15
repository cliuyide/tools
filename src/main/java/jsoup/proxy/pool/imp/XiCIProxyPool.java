package jsoup.proxy.pool.imp;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import jsoup.proxy.core.ProxyFetchAbstract;
import jsoup.proxy.core.entity.ProxyVO;
import jsoup.proxy.pool.ProxyPool;
import jsoup.proxy.utils.SocketUtils;
/**
 * 西刺网高匿代理抓取
 * @author liuyi
 *
 */
public class XiCIProxyPool extends ProxyFetchAbstract implements ProxyPool {
	public XiCIProxyPool() {
		fetchProxy();
	}
	
	@Override
	public ProxyVO get() {
		return proxys.peek();
	}

	@Override
	public ProxyVO getUnUsed(List<ProxyVO> proxys) {
		return null;
	}
	
	@Override
	public ConcurrentLinkedQueue<ProxyVO> getAll() {
		return proxys;
	}

	@Override
	protected void fetchProxy() {
		for(int i=1;i<=3328;i++){
			int pageIndex=i;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			threadpool.execute(()->{
				try {
					Handler(getNativeUrl()+pageIndex);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		}
	}

	@Override
	protected String getNativeUrl() {
		return "http://www.xicidaili.com/nn/";
	}

	private void Handler(String url) throws IOException {
		Document document = Jsoup.connect(url).timeout(1000).get();
		if(document==null){
			return;
		}
		Elements trs = document.getElementsByClass("odd");
		if(trs==null){
			return;
		}
		for(Element item:trs){
			Elements tds = item.getElementsByTag("td");
			if(tds!=null&&tds.size()>0){
				String ip = tds.get(1).text().trim();
				int port = Integer.parseInt(tds.get(2).text().trim());
				if(SocketUtils.checked(ip, port)){
					ProxyVO proxy=new ProxyVO();
					proxy.setIp(ip);
					proxy.setPort(port);
					proxys.offer(proxy);
				}
				
			}
			
		}
	}

}
