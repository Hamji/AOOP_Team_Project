import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class ResultPanel extends BasePanel {
	public ResultPanel(Student st){
		this.setLayout(new GridLayout(1,3));
		this.setBackground(Color.LIGHT_GRAY);
		this.setPreferredSize(new Dimension(580,50));
		
		add(new JLabel(st.name));
		add(new JLabel(String.valueOf(st.totalScore)));
		add(st.gradeCombo);
	}
}
