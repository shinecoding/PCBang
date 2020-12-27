import java.awt.*;

import javax.swing.*;

public class SplitPane extends JPanel {
	
	MenuLayout menuLayout = new MenuLayout();
	CustomerLayout customerLayout = new CustomerLayout();
	JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, menuLayout, customerLayout);
	public SplitPane() {
		setLayout(new BorderLayout());
		add(split);
		split.setOneTouchExpandable(true); 
		
		setSize(1200,600);
		setVisible(true);
		
	}
	
	
}
