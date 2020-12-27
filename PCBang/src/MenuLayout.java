import java.awt.*;
import javax.swing.*;

public class MenuLayout extends JFrame {
	Color color = new Color(50,50,50);
	Color btnColor = new Color(70,70,70);
	Font contentFnt = new Font("°íµñ", Font.PLAIN, 15);
	
	JPanel halfPane = new JPanel(new GridLayout(1,2));
		JPanel foodMenuPane = new JPanel(new GridLayout(0,1));
		JScrollPane scrollPane = new JScrollPane(foodMenuPane);
			JPanel p1 = new JPanel(new BorderLayout());
			//ImageIcon hotdog = new ImageIcon("img/hotdog.png");
			JLabel f1 = new JLabel();
			JLabel f11 = new JLabel("ÇÖµµ±×",JLabel.CENTER);
		
		JPanel casherPane = new JPanel(new BorderLayout());
		
		JPanel tpl1 = new JPanel();
		JLabel totalPriceLbl = new JLabel("ÃÑ ±Ý¾×: 4000¿ø", JLabel.CENTER);
		
		JList<String> foodList = new JList<String>();
		
	JPanel btnPane = new JPanel(new GridLayout(2,1));	
	JPanel bp1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JPanel bp2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JButton basketBtn = new JButton("   ´ã±â   ");
	JButton buyBtn = new JButton("   ±¸¸Å   ");
	
	public MenuLayout() {
		
	int w = f1.getWidth();
	int h = f1.getWidth();
		setLayout(new BorderLayout());
		add(halfPane);
		halfPane.add(scrollPane);
		halfPane.add(casherPane);
	
		scrollPane.add(foodMenuPane);
		foodMenuPane.add(p1);
			p1.add(f1, "Center");
			p1.add(f11,"South");
			
			
		casherPane.add(tpl1, "North");
			tpl1.add(totalPriceLbl);
		casherPane.add(btnPane, "South");
		btnPane.add(bp1);
		bp1.add(basketBtn);
		btnPane.add(bp2);
		bp2.add(buyBtn);
		//design
		foodMenuPane.setBackground(color);
		f1.setBackground(Color.YELLOW);
		
		
		
		casherPane.setBackground(color);
		tpl1.setBackground(color);
		totalPriceLbl.setForeground(Color.WHITE);
		totalPriceLbl.setFont(contentFnt);
		btnPane.setBackground(color);
		bp1.setBackground(color);
		bp2.setBackground(color);
		basketBtn.setBackground(btnColor);
		buyBtn.setBackground(btnColor);
		basketBtn.setForeground(Color.WHITE);
		buyBtn.setForeground(Color.WHITE);
		
		tpl1.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));
		btnPane.setBorder(BorderFactory.createEmptyBorder(10, 0, 50, 0));
		
		setSize(600,600);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		new MenuLayout();

	}

}
