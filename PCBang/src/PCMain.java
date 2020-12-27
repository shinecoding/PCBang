import java.awt.*;
import javax.swing.*;

public class PCMain extends JFrame {
	Color color = new Color(50,50,50);
	LoginLayout loginLayout;
	
	
	public PCMain() {
		//로그인페이지
		loginLayout = new LoginLayout();
		add(loginLayout);
		loginLayout.setBackground(color);
		
		setSize(600,600);
		setVisible(true);
		//setResizable(false);
		
	}

	public static void main(String[] args) {
		new PCMain();
		
	}

}
