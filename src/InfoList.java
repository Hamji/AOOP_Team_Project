import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;

public class InfoList extends JScrollPane {
	public InfoList() {
		
		// ��� �� �Ͼ��
		this.setBackground(Color.white);
		
		// size ���� 1100 X 870
		this.setPreferredSize(new Dimension(1100,870));
		
		//this.setLayout(new GridLayout(1,40));
		
		
	}
}
