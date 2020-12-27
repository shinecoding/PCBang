import java.awt.*;
import java.util.List;
import java.awt.event.*;
import java.util.*;
import java.util.Calendar;

import javax.swing.*;

public class CustomerLayout extends JPanel implements ActionListener {
		Color color = new Color(50,50,50);
		Color btnColor = new Color(70,70,70); 
		Font timer1 = new Font("���", Font.PLAIN, 18);
		Font timer2 = new Font("���", Font.BOLD, 36);
		Font timer3 = new Font("���", Font.BOLD, 50);
		Font price1 = new Font("���", Font.PLAIN, 18);

		
		List<CustomerVO> customerList = new ArrayList<CustomerVO>();
		
		//Ÿ�̸� ����
		Timer timer = new Timer();
		PrepayDAO pDao = new PrepayDAO();
		List<PrepayVO> prepayList = new ArrayList<PrepayVO>();
		PCMain pcmain;
		MenuLayout menuLayout;
		
		JPanel timePane = new JPanel(new BorderLayout());
		JPanel infoPane = new JPanel(new GridLayout(1,2));
			JPanel foodListPane = new JPanel(new BorderLayout());
			JPanel priceListPane = new JPanel(new BorderLayout());
			JLabel priceLbl = new JLabel("");
				JButton foodMenuBtn = new JButton("\n���� �޴�\n");
				JButton logoutBtn = new JButton("�α׾ƿ�");
		
		
		JPanel flp = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel foodListTitleLbl = new JLabel("������ ����");
			JList<String> foodList = new JList<String>();
			
			
		JPanel plp = new JPanel(new GridLayout(4,2));
			
			JLabel plLbl1 = new JLabel("���ұݾ�: ", JLabel.CENTER);
			JLabel plLbl11 = new JLabel("0��", JLabel.CENTER);
			JLabel plLbl2 = new JLabel("�߰��ݾ�: ", JLabel.CENTER);
			JLabel plLbl22 = new JLabel("0��", JLabel.CENTER);
		
			JLabel plLbl3 = new JLabel("�ΰ��ݾ�: ", JLabel.CENTER);
			JLabel plLbl33 = new JLabel("0��", JLabel.CENTER);
			JLabel plLbl4 = new JLabel("�� �ݾ�: ", JLabel.CENTER);
			JLabel plLbl44 = new JLabel("0��", JLabel.CENTER);
		
			
	public CustomerLayout() {
		setLayout(new GridLayout(2,1));
			add(timePane);
			timePane.add(timer);
			
			
			add(infoPane);
			infoPane.add(foodListPane); infoPane.add(priceListPane);
			foodListPane.add(flp, "North"); flp.add(foodListTitleLbl);
			foodListPane.add(foodMenuBtn, "South");
			foodListPane.add(foodList, "Center");
				
			priceListPane.add(logoutBtn, "South");
			priceListPane.add(plp);
			plp.add(plLbl1); plp.add(plLbl11); 
			plp.add(plLbl2); plp.add(plLbl22); 
			plp.add(plLbl3); plp.add(plLbl33); 
			plp.add(plLbl4); plp.add(plLbl44); 
			
			//design
			foodListPane.setBorder(BorderFactory.createLineBorder(Color.WHITE));
			priceListPane.setBorder(BorderFactory.createLineBorder(Color.WHITE));
			foodMenuBtn.setBackground(btnColor); foodMenuBtn.setForeground(Color.WHITE); 
			logoutBtn.setBackground(btnColor); logoutBtn.setForeground(Color.WHITE);
			plp.setBackground(color);
			plLbl1.setFont(price1);plLbl2.setFont(price1);plLbl3.setFont(price1);plLbl4.setFont(price1);
			plLbl1.setForeground(Color.WHITE);plLbl2.setForeground(Color.WHITE);plLbl3.setForeground(Color.WHITE);plLbl4.setForeground(Color.WHITE);
			plLbl11.setForeground(Color.WHITE);plLbl22.setForeground(Color.WHITE);plLbl33.setForeground(Color.WHITE);plLbl44.setForeground(Color.WHITE);
			
			flp.setBackground(color);
			foodListTitleLbl.setFont(price1);
			foodListTitleLbl.setForeground(Color.WHITE);
			foodList.setBackground(color);
			
		//Ÿ�̸� ������
		Thread th1 = new Thread(timer);
		th1.start();
		
		//���ұݾ�
		int pHour = pDao.selectPrepayHour();
		String pMoney = String.valueOf(pHour*1000 + "��");
		plLbl11.setText(pMoney);
		
		//�߰��ݾ�
		plLbl22.setText(String.valueOf(Timer.extMoney) + "��" );
		
		
		//�� �ݾ�
		int tMoney = pHour*1000 + Timer.extMoney;
		plLbl44.setText(String.valueOf(tMoney)+ "��");
		
		logoutBtn.addActionListener(this);
		
		foodMenuBtn.addActionListener(this);
		
		
		//pcmain = new PCMain();
		//menuLayout = new MenuLayout();
		
		
	}

	public void actionPerformed(ActionEvent ae) {
		if(logoutBtn == ae.getSource()) {
			Calendar logoutTime = Calendar.getInstance();
			CustomerVO cvo = new CustomerVO();
			cvo.setLogoutTime(logoutTime.toString());
			customerList.add(cvo);
		}
		
		if(foodMenuBtn == ae.getSource()) {
			
			
			menuLayout.setVisible(true);
			
		}
	}
	
	

}
