import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public class InfoList extends BasePanel {
	
	JScrollPane scroll;
	JPanel listPane;
	
	float extraHeight;
	int manyPanel;
	
	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}

	public InfoList() {
		extraHeight = 0;
		manyPanel = 0;
		
		this.setLayout(null);
		// ¹è°æ »ö ÇÏ¾á»ö
		this.setBackground(Color.white);
		
		this.setBorder(new EtchedBorder());
		// size ¼³Á¤ °¡·Î 1100 
		this.setPreferredSize(new Dimension(1100,800));
		
		// ·¹ÀÌ¾Æ¿ô ¼³Á¤
		this.setLayout(new FlowLayout(10,15,3));
		
		listPane = new JPanel();
		listPane.setLayout(new FlowLayout(FlowLayout.CENTER));
		listPane.setPreferredSize(new Dimension(1050,800));
		listPane.setBackground(new Color(230,230,230));
		
		//listPane.add(new StudentPanel(new Student("±è°ÇÈñ", "ÄÄ°ø", 60152154, 1)));
		
		scroll = new JScrollPane(listPane);
		scroll.setPreferredSize(new Dimension(1073,825));
		
		
		this.add(scroll);
	
	
	}
	
	public void addStudentPanel(JPanel pane) {
		
		if(manyPanel > 15)
		{
			extraHeight+= 60;
			listPane.setPreferredSize(new Dimension(1040,700 + (int)extraHeight));
		}
		
		
		
		listPane.add(pane);
		manyPanel++;
		
		listPane.updateUI();
		listPane.validate();
	}
}
