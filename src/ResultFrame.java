import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class ResultFrame extends BaseFrame {
	
	JPanel upside = new JPanel(new GridLayout(1,6));
	JPanel midside = new JPanel();
	JScrollPane scroll = new JScrollPane(midside);
	
	public ResultFrame(MainFrame main) {
		this.setTitle("결과 보기");
		
		this.setBounds(100, 100, 600, 400);
		
		this.setResizable(false);
		this.setBackground(Color.white);
		this.setLayout(new BorderLayout());
		
		this.mainFrame = main;
		this.manage = main.manage;
		
		manage.CalculateTotalScore();
		Collections.sort(manage.stList);
		
		upside.setPreferredSize(new Dimension(600,50));
		upside.setBackground(Color.LIGHT_GRAY);
		
		upside.add(new JLabel("평균:",SwingConstants.CENTER));
		upside.add(new JLabel(String.valueOf(manage.CalculateAver())));
		
		upside.add(new JLabel("표준편차:",SwingConstants.CENTER));
		upside.add(new JLabel(String.valueOf(manage.GetStdev())));
		
		upside.add(new JLabel("수강인원:",SwingConstants.CENTER));
		upside.add(new JLabel(String.valueOf(manage.GetMany())));
		
		
		midside.setPreferredSize(new Dimension(570,310));
		midside.setLayout(new FlowLayout(FlowLayout.CENTER));
		midside.setBackground(Color.pink);
		JPanel temp = new JPanel(new GridLayout(1,3));
		temp.setPreferredSize(new Dimension(600,20));
		
		temp.add(new JLabel("이름", SwingConstants.CENTER));
		temp.add(new JLabel("총점", SwingConstants.CENTER));
		temp.add(new JLabel("성적", SwingConstants.CENTER));
		midside.add(temp);
		
		manage.SetResultPanel(midside);
		
		
		
		this.add(upside,BorderLayout.NORTH);
		this.add(scroll,BorderLayout.CENTER);
		
		this.addWindowListener(new ClosingEventHandler());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	
	class ClosingEventHandler extends WindowAdapter{
		public void windowClosing(WindowEvent e) {
			//System.out.println("닫힘");
			mainFrame.setEnabled(true);
		}
	}
}
