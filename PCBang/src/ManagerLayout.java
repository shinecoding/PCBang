import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.util.List;

public class ManagerLayout extends JPanel {
	Color color = new Color(50,50,50);
	Color btnColor = new Color(70,70,70);
	Color seatColor = new Color(100,100,100);
	Font contentFnt = new Font("고딕", Font.PLAIN, 15);
	
	
	//데이터
	CustomerDAO cDao = new CustomerDAO();
	PrepayDAO pDao = new PrepayDAO();
	OrderDAO oDao = new OrderDAO();
	SnackDAO sDao = new SnackDAO();
	List<CustomerDAO> customerList = new ArrayList<CustomerDAO>();
	List<PrepayDAO> prepayList = new ArrayList<PrepayDAO>();
	List<OrderDAO> orderList = new ArrayList<OrderDAO>();
	List<SnackDAO> snackList = new ArrayList<SnackDAO>();
	
	
	
	JTabbedPane tabMenuPane = new JTabbedPane();
	
		JPanel seatTabPane = new JPanel(new BorderLayout());
		
		JLabel tab1Lbl = new JLabel("음식메뉴", JLabel.CENTER);
		JLabel tab2Lbl = new JLabel("좌석", JLabel.CENTER);
		JLabel tab3Lbl = new JLabel("회원관리", JLabel.CENTER);
		JLabel tab4Lbl = new JLabel("주문내역", JLabel.CENTER);
		JLabel tab5Lbl = new JLabel("결제", JLabel.CENTER);
		
	
		
		//좌석 페이지
		
	JPanel seatPane = new JPanel(new GridLayout(4,3));
		
	//여분용
		JPanel spp1 = new JPanel(new BorderLayout()); JPanel spp2 = new JPanel(new BorderLayout()); 
		JPanel spp3 = new JPanel(new BorderLayout()); JPanel spp4 = new JPanel(new BorderLayout()); 
		JPanel spp5 = new JPanel(new BorderLayout()); JPanel spp6 = new JPanel(new BorderLayout()); 
		JPanel spp7 = new JPanel(new BorderLayout()); JPanel spp8 = new JPanel(new BorderLayout()); 
		JPanel spp9 = new JPanel(new BorderLayout()); JPanel spp10 = new JPanel(new BorderLayout()); 
		JPanel spp11 = new JPanel(new BorderLayout()); JPanel spp12 = new JPanel(new BorderLayout()); 
	
	//선따기용
		JPanel sp1 = new JPanel(new BorderLayout()); JPanel sp2 = new JPanel(new BorderLayout()); 
		JPanel sp3 = new JPanel(new BorderLayout()); JPanel sp4 = new JPanel(new BorderLayout()); 
		JPanel sp5 = new JPanel(new BorderLayout()); JPanel sp6 = new JPanel(new BorderLayout()); 
		JPanel sp7 = new JPanel(new BorderLayout()); JPanel sp8 = new JPanel(new BorderLayout()); 
		JPanel sp9 = new JPanel(new BorderLayout()); JPanel sp10 = new JPanel(new BorderLayout()); 
		JPanel sp11 = new JPanel(new BorderLayout()); JPanel sp12 = new JPanel(new BorderLayout()); 
	
	//좌석 번호 매기기
		JLabel no1 = new JLabel("1"); JLabel no2 = new JLabel("2");
		JLabel no3 = new JLabel("3"); JLabel no4 = new JLabel("4");
		JLabel no5 = new JLabel("5"); JLabel no6 = new JLabel("6");
		JLabel no7 = new JLabel("7"); JLabel no8 = new JLabel("8");
		JLabel no9 = new JLabel("9"); JLabel no10 = new JLabel("10");
		JLabel no11 = new JLabel("11"); JLabel no12 = new JLabel("12");
		
	//좌석 내용	
		JLabel sl1 = new JLabel("1"); JLabel sl2 = new JLabel("1");
		JLabel sl3 = new JLabel("1"); JLabel sl4 = new JLabel("1");
		JLabel sl5 = new JLabel("1"); JLabel sl6 = new JLabel("1");
		JLabel sl7 = new JLabel("1"); JLabel sl8 = new JLabel("1");
		JLabel sl9 = new JLabel("1"); JLabel sl10 = new JLabel("1");
		JLabel sl11 = new JLabel("1"); JLabel sl12 = new JLabel("1");
		
	//좌석 주문 표시
		JLabel al1 = new JLabel(" "); JLabel al2 = new JLabel(" ");
		JLabel al3 = new JLabel(" "); JLabel al4 = new JLabel(" ");
		JLabel al5 = new JLabel(" "); JLabel al6 = new JLabel(" ");
		JLabel al7 = new JLabel(" "); JLabel al8 = new JLabel(" ");
		JLabel al9 = new JLabel(" "); JLabel al10 = new JLabel(" ");
		JLabel al11 = new JLabel(" "); JLabel al12 = new JLabel(" ");
		
	//왼쪽 인포보드 창
	JPanel infoBoardPane = new JPanel(new BorderLayout());
		JPanel topBoardPane = new JPanel(new BorderLayout());
			JLabel timeLbl = new JLabel("시작 시간:07:07", JLabel.CENTER);
		JPanel bottomBoardPane = new JPanel(new GridLayout(3,1));
			JLabel ttlLbl1 = new JLabel("현재 고객수: 5명", JLabel.CENTER);
			JLabel ttlLbl2 = new JLabel("총 고객수: 30명", JLabel.CENTER);
			JLabel ttlLbl3 = new JLabel("총 수익: 100,000원", JLabel.CENTER);
		
			MyAdapter ma = new MyAdapter();
			
	public ManagerLayout() {
		
		setLayout(new BorderLayout());
		add(tabMenuPane, "North");
		
		//탭 생성
		tabMenuPane.add("간식메뉴", new SnackMenuPane()); 
		tabMenuPane.add("좌석", seatTabPane); 
		tabMenuPane.add("회원관리", new CustomerPane()); 
		tabMenuPane.add("주문내역", new OrderPane()); 
		tabMenuPane.add("결제", new CasherPane()); 
		
		//탭 마진
		tab1Lbl.setPreferredSize(new Dimension(94,50));
		tabMenuPane.setTabComponentAt(0, tab1Lbl);
		tab2Lbl.setPreferredSize(new Dimension(94,50));
		tabMenuPane.setTabComponentAt(1, tab2Lbl);
		tab3Lbl.setPreferredSize(new Dimension(94,50));
		tabMenuPane.setTabComponentAt(2, tab3Lbl);
		tab4Lbl.setPreferredSize(new Dimension(94,50));
		tabMenuPane.setTabComponentAt(3, tab4Lbl);
		tab5Lbl.setPreferredSize(new Dimension(94,50));
		tabMenuPane.setTabComponentAt(4, tab5Lbl);
		
		//탭 색상
		for(int i=0; i<tabMenuPane.getTabCount(); i++) {
		tabMenuPane.setBackgroundAt(i, btnColor);
		}
		tab1Lbl.setForeground(Color.WHITE);
		tab2Lbl.setForeground(Color.WHITE);
		tab3Lbl.setForeground(Color.WHITE);
		tab4Lbl.setForeground(Color.WHITE);
		tab5Lbl.setForeground(Color.WHITE);
		
		
		//좌석페이지
		seatTabPane.add(seatPane, "Center");
		
		seatPane.add(spp1); seatPane.add(spp2); seatPane.add(spp3); 
		seatPane.add(spp4); seatPane.add(spp5); seatPane.add(spp6); 
		seatPane.add(spp7); seatPane.add(spp8); seatPane.add(spp9); 
		seatPane.add(spp10); seatPane.add(spp11); seatPane.add(spp12); 
		seatTabPane.setPreferredSize(new Dimension(600,500));
		
		
		//여분용 안에 선따기용
		spp1.add(sp1); spp2.add(sp2); spp3.add(sp3); 
		spp4.add(sp4); spp5.add(sp5); spp6.add(sp6); 
		spp7.add(sp7); spp8.add(sp8); spp9.add(sp9); 
		spp10.add(sp10); spp11.add(sp11); spp12.add(sp12); 

		
		
		//각 좌석 번호매기기
		sp1.add(no1, "North"); sp2.add(no2, "North"); sp3.add(no3, "North");
		sp4.add(no4, "North"); sp5.add(no5, "North"); sp6.add(no6, "North");
		sp7.add(no7, "North"); sp8.add(no8, "North"); sp9.add(no9, "North");
		sp10.add(no10, "North"); sp11.add(no11, "North"); sp12.add(no12, "North");
		
		//각 좌석 안에 레이블 넣기
		sp1.add(sl1, "Center"); sp2.add(sl2, "Center"); sp3.add(sl3, "Center");
		sp4.add(sl4, "Center"); sp5.add(sl5, "Center"); sp6.add(sl6, "Center");
		sp7.add(sl7, "Center"); sp8.add(sl8, "Center"); sp9.add(sl9, "Center");
		sp10.add(sl10, "Center"); sp11.add(sl11, "Center"); sp12.add(sl12, "Center");
		
		//각 좌석 하단에 주문표시
		sp1.add(al1, "South"); sp2.add(al2, "South"); sp3.add(al3, "South");
		sp4.add(al4, "South"); sp5.add(al5, "South"); sp6.add(al6, "South"); 
		sp7.add(al7, "South"); sp8.add(al8, "South"); sp9.add(al9, "South"); 
		sp10.add(al10, "South"); sp11.add(al11, "South"); sp12.add(al12, "South"); 
		
		//색 지정
		no1.setOpaque(true);no2.setOpaque(true);no3.setOpaque(true);
		no4.setOpaque(true);no5.setOpaque(true);no6.setOpaque(true);
		no7.setOpaque(true);no8.setOpaque(true);no9.setOpaque(true);
		no10.setOpaque(true);no11.setOpaque(true);no12.setOpaque(true);
		
		sl1.setOpaque(true);sl2.setOpaque(true);sl3.setOpaque(true);
		sl4.setOpaque(true);sl5.setOpaque(true);sl6.setOpaque(true);
		sl7.setOpaque(true);sl8.setOpaque(true);sl9.setOpaque(true);
		sl10.setOpaque(true);sl11.setOpaque(true);sl12.setOpaque(true);
		
		al1.setOpaque(true);al2.setOpaque(true);al3.setOpaque(true);
		al4.setOpaque(true);al5.setOpaque(true);al6.setOpaque(true);
		al7.setOpaque(true);al8.setOpaque(true);al9.setOpaque(true);
		al10.setOpaque(true);al11.setOpaque(true);al12.setOpaque(true);
		
		no1.setBackground(seatColor); no2.setBackground(seatColor);  no3.setBackground(seatColor);
		no4.setBackground(seatColor); no5.setBackground(seatColor); no6.setBackground(seatColor);
		no7.setBackground(seatColor); no8.setBackground(seatColor); no9.setBackground(seatColor);
		no10.setBackground(seatColor); no11.setBackground(seatColor); no12.setBackground(seatColor);
		
		sl1.setBackground(seatColor); sl2.setBackground(seatColor);  sl3.setBackground(seatColor);
		sl4.setBackground(seatColor); sl5.setBackground(seatColor); sl6.setBackground(seatColor);
		sl7.setBackground(seatColor); sl8.setBackground(seatColor); sl9.setBackground(seatColor);
		sl10.setBackground(seatColor); sl11.setBackground(seatColor); sl12.setBackground(seatColor);
		//좌석 주문시 색상 변경!
		al1.setBackground(seatColor); al2.setBackground(seatColor);  al3.setBackground(seatColor);
		al4.setBackground(seatColor); al5.setBackground(seatColor); al6.setBackground(seatColor);
		al7.setBackground(seatColor); al8.setBackground(seatColor); al9.setBackground(seatColor);
		al10.setBackground(seatColor); al11.setBackground(seatColor); al12.setBackground(seatColor);
		
		no1.setForeground(Color.WHITE);no2.setForeground(Color.WHITE);no3.setForeground(Color.WHITE);
		no4.setForeground(Color.WHITE);no5.setForeground(Color.WHITE);no6.setForeground(Color.WHITE);
		no7.setForeground(Color.WHITE);no8.setForeground(Color.WHITE);no9.setForeground(Color.WHITE);
		no10.setForeground(Color.WHITE);no11.setForeground(Color.WHITE);no12.setForeground(Color.WHITE);
		
		sl1.setForeground(Color.WHITE);sl2.setForeground(Color.WHITE);sl3.setForeground(Color.WHITE);
		sl4.setForeground(Color.WHITE);sl5.setForeground(Color.WHITE);sl6.setForeground(Color.WHITE);
		sl7.setForeground(Color.WHITE);sl8.setForeground(Color.WHITE);sl9.setForeground(Color.WHITE);
		sl10.setForeground(Color.WHITE);sl11.setForeground(Color.WHITE);sl12.setForeground(Color.WHITE);
		
		//좌석 사이 복도색
		spp1.setBackground(color); spp2.setBackground(color); spp3.setBackground(color);
		spp4.setBackground(color); spp5.setBackground(color); spp6.setBackground(color);
		spp7.setBackground(color); spp8.setBackground(color); spp9.setBackground(color);
		spp10.setBackground(color); spp11.setBackground(color); spp12.setBackground(color);
		
		//왼쪽상단
		topBoardPane.setBackground(color);
		timeLbl.setForeground(Color.WHITE);
		
		//왼쪽하단
		bottomBoardPane.setBackground(color);
		ttlLbl1.setForeground(Color.WHITE);
		ttlLbl2.setForeground(Color.WHITE);
		ttlLbl3.setForeground(Color.WHITE);
		
		//보더 지정
		sp1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1, true));
		spp1.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		sp2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1, true));
		spp2.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		sp3.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1, true));
		spp3.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		sp4.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1, true));
		spp4.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		sp5.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1, true));
		spp5.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		sp6.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1, true));
		spp6.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		sp7.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1, true));
		spp7.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		sp8.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1, true));
		spp8.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		sp9.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1, true));
		spp9.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		sp10.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1, true));
		spp10.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		sp11.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1, true));
		spp11.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		sp12.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1, true));
		spp12.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		bottomBoardPane.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		seatTabPane.add(infoBoardPane, "East");
		infoBoardPane.add(topBoardPane, "Center");
		topBoardPane.add(timeLbl, "Center");
		infoBoardPane.add(bottomBoardPane, "South");
		infoBoardPane.setPreferredSize(new Dimension(180,500));
		bottomBoardPane.add(ttlLbl1);
		bottomBoardPane.add(ttlLbl2);
		bottomBoardPane.add(ttlLbl3);
		
		
		
		//좌석 마우스 리스너
		sp1.addMouseListener(ma);
		sp2.addMouseListener(ma);
		sp3.addMouseListener(ma);
		sp4.addMouseListener(ma);
		sp5.addMouseListener(ma);
		sp6.addMouseListener(ma);
		sp7.addMouseListener(ma);
		sp8.addMouseListener(ma);
		sp9.addMouseListener(ma);
		sp10.addMouseListener(ma);
		sp11.addMouseListener(ma);
		sp12.addMouseListener(ma);
		
		
	}
	
	
	class MyAdapter extends MouseAdapter {
		public void mouseReleased(MouseEvent me) {
			int btn = me.getButton();
			if(btn==MouseEvent.BUTTON1) {
				if(sp1==me.getSource()) {
					timeLbl.setText("1");
				}else if(sp2==me.getSource()) {
					timeLbl.setText("2");
				}else if(sp3==me.getSource()) {
					timeLbl.setText("3");
				}else if(sp4==me.getSource()) {
					timeLbl.setText("4");
				}else if(sp5==me.getSource()) {
					timeLbl.setText("5");
				}else if(sp6==me.getSource()) {
					timeLbl.setText("6");
				}else if(sp7==me.getSource()) {
					timeLbl.setText("7");
				}else if(sp8==me.getSource()) {
					timeLbl.setText("8");
				}else if(sp9==me.getSource()) {
					timeLbl.setText("9");
				}else if(sp10==me.getSource()) {
					timeLbl.setText("10");
				}else if(sp11==me.getSource()) {
					timeLbl.setText("11");
				}else if(sp12==me.getSource()) {
					timeLbl.setText("12");
				}
			}
		}
	}
	
	
	class SnackMenuPane extends JPanel{
		String[] sTitle = {"간식코드", "간식이름", "가격", "입고일"};
		DefaultTableModel snackModel = new DefaultTableModel(sTitle,0);
		JTable snackTable = new JTable(snackModel);
		JScrollPane snackSp = new JScrollPane(snackTable);
		
		public SnackMenuPane() {
			this.setLayout(new BorderLayout());
			this.add(snackSp, "Center");
			this.showSnackTable();
		}
		
		
		public void showSnackTable() {
			SnackDAO snackDao = new SnackDAO();
			List<SnackVO> snackList = snackDao.selectSnack();
			
			for(int i=0; i<snackList.size(); i++) {
				SnackVO svo = snackList.get(i);
				Object[] record = {svo.getSnackCode(), svo.getSnackName(), svo.getSnackPrice(), svo.getSnackDate()};
				snackModel.addRow(record);
			}
		}
	}
	
	class CustomerPane extends JPanel{
		String[] customerTitle = {"아이디", "비밀번호", "실명", "전화번호", "이메일", "주소"};
		DefaultTableModel customerModel = new DefaultTableModel(customerTitle, 0);
		JTable customerTable = new JTable(customerModel);
		JScrollPane customerSp = new JScrollPane(customerTable);
		
		public CustomerPane() {
			this.setLayout(new BorderLayout());
			this.add(customerSp, "Center");
			this.showCustomerTable();
		}
		public void showCustomerTable() {
			CustomerDAO customerDao = new CustomerDAO();
			List<CustomerVO> customerList = customerDao.selectCustomer();
		
			for(int i=0; i<customerList.size(); i++) {
				CustomerVO cvo = customerList.get(i);
				Object[] record = {cvo.getUserId(), cvo.getUserPassword(), cvo.getUserName(), cvo.getTel(), cvo.getEmail(), cvo.getAddr()};
				customerModel.addRow(record);
			}	
		}
	}

	class OrderPane extends JPanel {
		String[] orderTitle = {"주문코드","아이디", "간식코드","수량","주문날짜", "주문상태"};
		DefaultTableModel orderModel = new DefaultTableModel(orderTitle, 0);
		JTable orderTable = new JTable(orderModel);
		JScrollPane orderSp = new JScrollPane(orderTable);
		
		public OrderPane() {
			this.setLayout(new BorderLayout());
			this.add(orderSp);
			this.showOrderTable();
			
		}
		
		public void showOrderTable() {
			OrderDAO oDao = new OrderDAO();
			List<OrderVO> orderList = oDao.selectOrder();
			
			for(int i=0; i<orderList.size(); i++) {
				OrderVO ovo = orderList.get(i);
				Object[] record = {ovo.getOrderCode(), ovo.getUserId(), ovo.getSnackCode(), ovo.getQuantity(), ovo.getOrderDate(), ovo.getOrderBool()};
				orderModel.addRow(record);
			}
		}
	}
	
	
	
	
	
	class CasherPane extends JPanel {
		//아이디, 로그인시간, 로그아웃시간, 아웃-인 시간, 선불여부, 선불시간, 간식총금액(수량*
		String[] casherTitle = {"아이디", "로그인시간", "로그아웃시간", "이용시간H", "선불여부", "선불시간", "이용금액", "간식금액", "총 금액"};
		DefaultTableModel casherModel = new DefaultTableModel(casherTitle, 0);
		JTable casherTable = new JTable(casherModel);
		JScrollPane casherSp = new JScrollPane(casherTable);
		
		public CasherPane() {
			this.setLayout(new BorderLayout());
			this.add(casherSp, "Center");
			this.showCasherTable();
		}
		
		public void showCasherTable() {
			
			
			
			
		}
		
	}
	

}
