package jsoup.proxy.core.entity;

public class ProxyVO {
	private String ip;
	private int port;
	private int useCount;
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	public int getUseCount() {
		return useCount;
	}
	public void setUseCount(int useCount) {
		this.useCount = useCount;
	}
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof ProxyVO)){
			throw new ClassCastException("An Error In ProxyVO Equals");
		}
		ProxyVO proxy=(ProxyVO)obj;
		return ip.equals(proxy.getIp())&&port==proxy.getPort();
	}
	
}
