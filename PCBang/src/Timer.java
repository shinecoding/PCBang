import java.awt.*;
import java.text.*;
import java.util.*;
import java.util.List;

import javax.swing.*;

public class Timer extends JPanel implements Runnable {
	Font timerFnt1 = new Font("고딕", Font.PLAIN, 18);
	Font timerFnt2 = new Font("고딕", Font.BOLD, 36);
	Font timerFnt3 = new Font("고딕", Font.BOLD, 50);
	Color color = new Color(50,50,50);
	PrepayDAO pDao = new PrepayDAO();
	static int extMoney;
	
	String userId;
	int pHour;
	
	JPanel threeTimePane = new JPanel(new GridLayout(3,1));
	//JPanel twoTimePane = new JPanel(new GridLayout(2,1));
		JPanel t1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel t2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel t3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
			JLabel startTimeLbl = new JLabel("시작 시간:");
			JLabel startTime = new JLabel("16:05:23");
			
			JLabel remainingTimeLbl = new JLabel("남은 시간:");
			JLabel remainingTime = new JLabel("00:00:00");
			
			JLabel usedTimeLbl = new JLabel("사용 시간:");
			JLabel usedTime = new JLabel("00:00:00");
	
		//현재시간
		Calendar now = Calendar.getInstance();
				
		//문자열 포맷
		SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss");
			
		//지금 날짜에서 20시간 더함 - 로그인고정날짜뺌
			
	public Timer() {
		
		//레이아웃
		setLayout(new BorderLayout());		
		add(threeTimePane);
		threeTimePane.add(t1);threeTimePane.add(t2);threeTimePane.add(t3);
		t1.add(startTimeLbl);t1.add(startTime);
		t2.add(remainingTimeLbl);t2.add(remainingTime);
		t3.add(usedTimeLbl);t3.add(usedTime);
		startTimeLbl.setFont(timerFnt1);
		remainingTimeLbl.setFont(timerFnt1);
		usedTimeLbl.setFont(timerFnt1);
		startTime.setFont(timerFnt2); remainingTimeLbl.setForeground(Color.RED);
		remainingTime.setFont(timerFnt3); remainingTime.setForeground(Color.RED);
		usedTime.setFont(timerFnt2);
		
		
		//design
		t1.setBackground(color);t2.setBackground(color);t3.setBackground(color);
		startTimeLbl.setForeground(Color.WHITE);startTime.setForeground(Color.WHITE);
		usedTimeLbl.setForeground(Color.WHITE);usedTime.setForeground(Color.WHITE);
		threeTimePane.setBorder(BorderFactory.createLineBorder(Color.WHITE));
	
		

		//시작시간
		String nowStr = fmt.format(now.getTime());
		startTime.setText(nowStr);
		
		pDao.selectPrepay();
		pHour = pDao.selectPrepayHour();
		System.out.println(pHour);
		
	}
		public Timer(int prepayTime) {
				this();
				
		}
	
	public void run() {
		
		
		do {
			//현재시간
			Calendar now2 = Calendar.getInstance();
			
			//사용시간
			now2.add(Calendar.YEAR, -now.get(Calendar.YEAR));
			now2.add(Calendar.MONTH, -(now.get(Calendar.MONTH)+1));
			now2.add(Calendar.DATE, -now.get(Calendar.DATE));
			now2.add(Calendar.HOUR_OF_DAY, -now.get(Calendar.HOUR_OF_DAY ));
			now2.add(Calendar.MINUTE, -now.get(Calendar.MINUTE));
			now2.add(Calendar.SECOND, -now.get(Calendar.SECOND));
			String countStr = fmt.format(now2.getTime());
			
			
			usedTime.setText(countStr);
			
			extMoney = (Integer.parseInt(countStr.substring(0, 2)) + 1 - pHour)*1000;
			if (extMoney<=0) {
				extMoney = 0;
			}
			
			//남은 시간(선불제 구매시간)
			Calendar now3 = Calendar.getInstance();
			now3.set(0, 0, 0, pHour, 0, 0);
			
			
			
			now3.add(Calendar.YEAR, -now2.get(Calendar.YEAR));
			now3.add(Calendar.MONTH, -now2.get(Calendar.MONTH)+1);
			now3.add(Calendar.DATE, -now2.get(Calendar.DATE));
			now3.add(Calendar.HOUR, -now2.get(Calendar.HOUR_OF_DAY));
			now3.add(Calendar.MINUTE, -now2.get(Calendar.MINUTE));
			now3.add(Calendar.SECOND, -now2.get(Calendar.SECOND));
			
			String remainingStr = fmt.format(now3.getTime());
			if(remainingStr.equals("00:00:00")) {
				remainingStr = "00:00:00";
			}
			
			
			remainingTime.setText(remainingStr);
			
			//일시정지
			try {
				Thread.sleep(200);
			}catch(Exception e) {}
			
		}while(true);
		
	}
}
