import java.io.*;
import java.net.*;

public class ServerSocket extends Thread {

	public ServerSocket() {
		this.start();
		
	}
	public void run() {
		try {
			//������ ����� ��, �����ϸ� Socket��ü�� ���� �� �ִ�.
			ServerSocket ss = new ServerSocket(20000);
			
			while(true) {
				//���Ӵ�� : �������� ip�� ���Ͼȿ� �������
				System.out.println("���Ӵ����...");
				Socket socket = ss.accept();
				//�Ѹ����
				OneClient oc = new OneClient(socket);
				//�ߺ� ������ �˻��ϱ�
				setConnectionCheck(oc);
				//������ �����ϴ� �÷��ǿ� �߰�
				connList.add(oc);
				//������ ȭ�鿡 ǥ��
				
				//�����ڿ��� ���� �ֹ� �˸���
				oc.setAllMessage();
				
				//������ ����
				oc.start(); //����������
				
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
