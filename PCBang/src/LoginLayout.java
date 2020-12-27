import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class LoginLayout extends JPanel implements ActionListener {
	Color color = new Color(50,50,50);
	Font tfFnt = new Font("���", Font.PLAIN, 15);
	
	String userId;
	static String loginId; //�α��ξ��̵�
	
	MenuLayout menuLayout;
	
	JPanel logoPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		ImageIcon logo = new ImageIcon("img/logo2.png");
		JLabel logoLbl= new JLabel(logo);
		
		
	CustomerDAO cDao = new CustomerDAO();
	List<CustomerVO> customerList = new ArrayList<CustomerVO>();
		
			
	JPanel centerPane = new JPanel(new BorderLayout());
		JPanel buttonPane = new JPanel(new FlowLayout());
			JPanel cp1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel loginBorderPane = new JPanel(new BorderLayout());
			JPanel loginPane = new JPanel(new BorderLayout());
			JPanel loginPane2 = new JPanel(new BorderLayout());
				JPanel cp2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
					JPanel loginSpacePane = new JPanel(new BorderLayout());
						JPanel tfPane = new JPanel(new GridLayout(2,1,20,20));
							JTextField userIdTf = new JTextField(12);
							JTextField userPasswordTf = new JTextField(12);
						JPanel lgPane = new JPanel(new BorderLayout());
							JButton loginBtn = new JButton("�α���");
				JPanel cp3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
					JButton joinBtn = new JButton("ȸ������");
	String[] firstPayArr = {"����", "2,000��", "5,000��", "10,000��", "20,000��"};
	DefaultComboBoxModel<String> firstPayModel = new DefaultComboBoxModel<String>(firstPayArr);
	JComboBox<String> firstPayBox = new JComboBox<String>(firstPayModel);
	JToggleButton afterPayBtn = new JToggleButton("  �ĺ�   ");
	
	public LoginLayout() {
		setLayout(new BorderLayout());
		
		add(logoPane, "North");
			logoPane.add(logoLbl);
		add(centerPane, "Center");
		centerPane.add(buttonPane, "North");
			buttonPane.add(cp1);
				cp1.add(firstPayBox);
				cp1.add(afterPayBtn);
		centerPane.add(loginBorderPane, "Center");
				loginBorderPane.add(cp2);
					cp2.add(loginPane2); //loginPane ��� ����
					loginPane2.add(loginPane);	
					loginPane.add(loginSpacePane, "Center"); //loginPane�� �׸��� �ֱ�
							loginSpacePane.add(tfPane, "Center");
								tfPane.add(userIdTf); tfPane.add(userPasswordTf);
							loginSpacePane.add(lgPane, "East");
								lgPane.add(loginBtn);
						loginPane.add(cp3, "South");
						cp3.add(joinBtn);

	//design
	
	logoPane.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));	
	lgPane.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));	
	loginPane.setBorder(BorderFactory.createEmptyBorder(60, 30, 30, 30));			
	buttonPane.setBorder(BorderFactory.createEmptyBorder(35, 0, 5, 0));	
	cp3.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
	loginPane2.setBorder(BorderFactory.createLineBorder(Color.WHITE));
	
	userIdTf.setFont(tfFnt);
	userPasswordTf.setFont(tfFnt);
	
	loginPane.setBackground(color);
	lgPane.setBackground(color);
	logoPane.setBackground(color);
	buttonPane.setBackground(color);
	centerPane.setBackground(color);
	cp1.setBackground(color);
	tfPane.setBackground(color);
	cp2.setBackground(color);
	cp3.setBackground(color);
	afterPayBtn.setBackground(new Color(70,70,70));
	afterPayBtn.setForeground(Color.WHITE);
	firstPayBox.setBackground(new Color(70,70,70));
	firstPayBox.setForeground(Color.WHITE);
	loginBtn.setBackground(new Color(70,70,70));
	loginBtn.setForeground(Color.WHITE);
	joinBtn.setBackground(new Color(70,70,70));
	joinBtn.setForeground(Color.WHITE);
	
	
	

		loginBtn.addActionListener(this);
		joinBtn.addActionListener(this);
		
	}
	
	
	
	public void actionPerformed(ActionEvent ae) {
		//�α���
		if(loginBtn == ae.getSource()) {
			
			userId = userIdTf.getText();
			String userPassword = userPasswordTf.getText();
			CustomerDAO cDao = new CustomerDAO();
			int result = cDao.loginCustomer(userId, userPassword);//customerDAO select �޼ҵ� ī��Ʈ ���� ����
			if(result==0) {
				JOptionPane.showMessageDialog(this, "�α��������� ���� �ʽ��ϴ�.");
			}else if(result==1) {
				//������ �α���
				if(userId.equals("admin") && userPassword.equals("1234")) {
					this.setVisible(false);
					this.removeAll();
					ManagerLayout managerLayout = new ManagerLayout(); //�������������� �̵�
					add(managerLayout);
					setVisible(true);
				}else { //�Ϲ�ȸ�� �α���
					
					if(firstPayBox.getSelectedItem().equals("2,000��") &&  !afterPayBtn.isSelected()){
						System.out.println("2,000��");
						PrepayDAO pDao = new PrepayDAO();
						PrepayVO pvo = new PrepayVO(userId, "T", 2);
						pDao.insertPrepay(pvo);
						loginSuccess();
					}else if(firstPayBox.getSelectedItem().equals("5,000��") &&  !afterPayBtn.isSelected()) {
						System.out.println("5,000��");
						PrepayDAO pDao = new PrepayDAO();
						PrepayVO pvo = new PrepayVO(userId, "T", 5);
						pDao.insertPrepay(pvo);
						loginSuccess();
					}else if(firstPayBox.getSelectedItem().equals("10,000��") &&  !afterPayBtn.isSelected()) {
						System.out.println("10,000��");
						PrepayDAO pDao = new PrepayDAO();
						PrepayVO pvo = new PrepayVO(userId, "T", 10);
						pDao.insertPrepay(pvo);
						loginSuccess();
					}else if(firstPayBox.getSelectedItem().equals("20,000��") &&  !afterPayBtn.isSelected()) {
						System.out.println("20,000��");
						PrepayDAO pDao = new PrepayDAO();
						PrepayVO pvo = new PrepayVO(userId, "T", 20);
						pDao.insertPrepay(pvo);
						loginSuccess();
					}else if(firstPayBox.getSelectedItem().equals("����") &&  afterPayBtn.isSelected()){
						System.out.println("�ĺ�");
						PrepayDAO pDao = new PrepayDAO();
						PrepayVO pvo = new PrepayVO(userId, "F", 0);
						pDao.insertPrepay(pvo);
						loginSuccess();
					}else {
						JOptionPane.showMessageDialog(this, "���ĺ� �ɼ��� ����� �������ּ���");
					}
				
				
				
				}
				
			}
			//ȸ������
		}else if(joinBtn == ae.getSource()) {
			
			this.setVisible(false);
			this.removeAll();
			JoinLayout joinLayout = new JoinLayout();
			add(joinLayout);
			this.setVisible(true);
			
		}
		
	}
	
	
	public void loginSuccess() {
		JOptionPane.showMessageDialog(this, "�α��ο� �����Ͽ����ϴ�");
		loginId = userId;
		this.setVisible(false);
		this.removeAll();
		
		if(menuLayout==null) {
			menuLayout = new MenuLayout();
		}else {
			menuLayout.dispose();
			menuLayout = new MenuLayout();
		}
		
		}
	
}
