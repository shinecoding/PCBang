import java.awt.*;

import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;

public class JoinLayout extends JPanel implements ActionListener {
	Font titleFnt = new Font("���", Font.BOLD, 32);
	Font contentFnt = new Font("���", Font.PLAIN, 15);
	Font tfFnt = new Font("���", Font.PLAIN, 15);
	
	CustomerDAO cDao = new CustomerDAO();
	List<CustomerVO> customerList = new ArrayList<CustomerVO>();
	
	//���̺�
	JPanel topPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel joinLbl = new JLabel("ȸ������");
	JPanel centerPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel threePane = new JPanel(new GridLayout(1,3));
		JPanel lblPane = new JPanel(new GridLayout(6,1));
			JPanel f1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
			JPanel f2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
			JPanel f3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
			JPanel f4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
			JPanel f5 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
			JPanel f6 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
				JLabel l1 = new JLabel("���̵�");
				JLabel l2 = new JLabel("��й�ȣ");
				JLabel l3 = new JLabel("�Ǹ�");
				JLabel l4 = new JLabel("��ȭ��ȣ");
				JLabel l5 = new JLabel("�̸���");
				JLabel l6 = new JLabel("�� �ּ�");
				
		//�ؽ�Ʈ�ʵ�
			String[] tfArr = {"useridTf", "passwordTf", "usernameTf", "telTf", "emailTf", "addrTf"};
		JPanel tfPane = new JPanel(new GridLayout(6,1));
			JPanel t1 = new JPanel();
			JPanel t2 = new JPanel();
			JPanel t3 = new JPanel();
			JPanel t4 = new JPanel();
			JPanel t5 = new JPanel();
			JPanel t6 = new JPanel();
				JTextField userIdTf = new JTextField(10); 
				JTextField passwordTf = new JTextField(10); 
				JTextField usernameTf = new JTextField(10); 
				JTextField telTf = new JTextField(10); 
				JTextField emailTf = new JTextField(10); 
				JTextField addrTf = new JTextField(10); 
		JPanel btnPane = new JPanel(new GridLayout(6,1));
			JPanel b1 = new JPanel();
				JButton idCheckBtn = new JButton("�ߺ�Ȯ��");  
		
	JPanel bottomPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton joinBtn = new JButton("���");
		JButton cancelBtn = new JButton("���");
		
	public JoinLayout() {
		setLayout(new BorderLayout());
		
		add(topPane, "North");
			topPane.add(joinLbl);
			
		add(centerPane, "Center");
			centerPane.add(threePane);
			threePane.add(lblPane);
			threePane.add(tfPane);
			threePane.add(btnPane);
			//���̺�
			lblPane.add(f1);lblPane.add(f2);lblPane.add(f3);
			lblPane.add(f4);lblPane.add(f5);lblPane.add(f6);
			f1.add(l1);
			f2.add(l2);
			f3.add(l3);
			f4.add(l4);
			f5.add(l5);
			f6.add(l6);
			//�ؽ�Ʈ�ʵ�		
			tfPane.add(t1);tfPane.add(t2);tfPane.add(t3);
			tfPane.add(t4);tfPane.add(t5);tfPane.add(t6);
			
			t1.add(userIdTf);t2.add(passwordTf);
			t3.add(usernameTf);t4.add(telTf);
			t5.add(emailTf);t6.add(addrTf);

			btnPane.add(b1);
			b1.add(idCheckBtn);
			
		add(bottomPane,"South");
			bottomPane.add(joinBtn); bottomPane.add(cancelBtn);
		
			
		//design
		topPane.setBorder(BorderFactory.createEmptyBorder(70, 0, 30, 0));
		bottomPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 80, 0));
		f1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
		f2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
		f3.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
		f4.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
		f5.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
		f6.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
		btnPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		t1.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		t2.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		t3.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		t4.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		t5.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		t6.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
	
		userIdTf.setFont(tfFnt);
		passwordTf.setFont(tfFnt);
		usernameTf.setFont(tfFnt);
		telTf.setFont(tfFnt);
		emailTf.setFont(tfFnt);
		addrTf.setFont(tfFnt);
		
		t1.setBackground(new Color(50,50,50));
		t2.setBackground(new Color(50,50,50));
		t3.setBackground(new Color(50,50,50));
		t4.setBackground(new Color(50,50,50));
		t5.setBackground(new Color(50,50,50));
		t6.setBackground(new Color(50,50,50));
		b1.setBackground(new Color(50,50,50));
		
		topPane.setBackground(new Color(50,50,50));
		centerPane.setBackground(new Color(50,50,50));
		bottomPane.setBackground(new Color(50,50,50));
		
		joinLbl.setForeground(Color.WHITE);
		joinLbl.setFont(titleFnt);
		idCheckBtn.setBackground(new Color(70,70,70));
		idCheckBtn.setForeground(Color.WHITE);
		f1.setBackground(new Color(50,50,50));
		l1.setForeground(Color.WHITE);
		l1.setFont(contentFnt);
		f2.setBackground(new Color(50,50,50));
		l2.setForeground(Color.WHITE);
		l2.setFont(contentFnt);
		f3.setBackground(new Color(50,50,50));
		l3.setForeground(Color.WHITE);
		l3.setFont(contentFnt);
		f4.setBackground(new Color(50,50,50));
		l4.setForeground(Color.WHITE);
		l4.setFont(contentFnt);
		f5.setBackground(new Color(50,50,50));
		l5.setForeground(Color.WHITE);
		l5.setFont(contentFnt);
		f6.setBackground(new Color(50,50,50));
		l6.setForeground(Color.WHITE);
		l6.setFont(contentFnt);
		tfPane.setBackground(new Color(50,50,50));
		btnPane.setBackground(new Color(50,50,50));
		joinBtn.setBackground(new Color(70,70,70));
		joinBtn.setForeground(Color.WHITE);
		
		cancelBtn.setBackground(new Color(70,70,70));
		cancelBtn.setForeground(Color.WHITE);
		
		
		
		idCheckBtn.addActionListener(this);
		joinBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
	}

	
	public void actionPerformed(ActionEvent ae) {
		if(idCheckBtn == ae.getSource()) { //�ߺ�üũ ��ư����
			String userId = userIdTf.getText(); //�Է��� ���̵� ������
			
			CustomerDAO cDao = new CustomerDAO(); //DAO�ҷ���
			int result = cDao.joinMatchCustomer(userId); //DAO���� �޼ҵ� �ҷ���
			if(userId.equals("") || userId == null) {
				JOptionPane.showMessageDialog(this, "���̵� �Է��ϼ���.");
			}else {
				if(result>0) {
					JOptionPane.showMessageDialog(this, "�ߺ� ���̵� �����մϴ�.");
					userIdTf.setText("");
				}else {
					JOptionPane.showMessageDialog(this, "��� ������ ���̵��Դϴ�.");
				}
			}
			
			
			
		}else if(joinBtn==ae.getSource()) {
			CustomerVO cvo = new CustomerVO(userIdTf.getText(), passwordTf.getText(), usernameTf.getText(), telTf.getText(), emailTf.getText(), addrTf.getText());
				
			if(cvo.getUserId().equals("") || cvo.getUserId() == null) {
					JOptionPane.showMessageDialog(this, "���̵� �Է��ϼ���");
				} else if(cvo.getUserPassword().equals("") || cvo.getUserId() == null) {
					JOptionPane.showMessageDialog(this, "��й�ȣ�� �Է��ϼ���");
				} else {
					CustomerDAO cDao = new CustomerDAO();
					int result = cDao.insertCustomer(cvo);
					if(result>0) {
				JOptionPane.showMessageDialog(this, "ȸ������ �Ǿ����ϴ�!");
				
				//ȭ��α��� ȭ������ ��ȯ
				this.setVisible(false);
				this.removeAll();
				LoginLayout loginLayout = new LoginLayout();
				add(loginLayout);
				this.setVisible(true);
				
					} else {
						JOptionPane.showMessageDialog(this, "ȸ�����Կ� �����߽��ϴ�");
			}}
		}else if(cancelBtn == ae.getSource()) {
			
			this.setVisible(false);
			this.removeAll();
			LoginLayout loginLayout = new LoginLayout();
			add(loginLayout);
			this.setVisible(true);
		}
		
		
	}
	
	

}
