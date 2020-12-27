import java.io.*;
import java.net.*;

public class ServerSocket extends Thread {

	public ServerSocket() {
		this.start();
		
	}
	public void run() {
		try {
			//접속을 대기한 후, 접속하면 Socket객체를 얻을 수 있다.
			ServerSocket ss = new ServerSocket(20000);
			
			while(true) {
				//접속대기 : 접속자의 ip가 소켓안에 들어있음
				System.out.println("접속대기중...");
				Socket socket = ss.accept();
				//한명생성
				OneClient oc = new OneClient(socket);
				//중복 아이피 검사하기
				setConnectionCheck(oc);
				//접속자 관리하는 컬렉션에 추가
				connList.add(oc);
				//관리자 화면에 표시
				
				//관리자에게 음식 주문 알리기
				oc.setAllMessage();
				
				//스레드 구현
				oc.start(); //개인접속자
				
			}
					
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	class OneCustomer extends Thread{
		Socket socket;
		BufferedReader br;
		PrintWriter pw;
		String username;
		InetAddress ia;
		
	OneCustomer(Socket socket){
		this.socket = socket;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			ia = socket.getInetAddress();
			username = ia.getHostAddress();
			
		}catch(Exception e) {
			
		}
	}
	
	}

}
