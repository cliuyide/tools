package jsoup.proxy.utils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketUtils {
	
	//验证ip是否可用
	public static boolean checked(String ip,Integer port){
		boolean result=false;
		Socket socket=null;
		try{
			socket=new Socket();
			socket.connect(new InetSocketAddress(ip, port),2000);
			if(socket.isConnected()){
				result=true;
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	};
	
	public static void main(String[] args) {
		System.out.println(checked("121.31.103.176",8123));
		System.out.println(1);
	}
}
