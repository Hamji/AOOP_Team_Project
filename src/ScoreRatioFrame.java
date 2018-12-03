import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ScoreRatioFrame extends BaseFrame {
	JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER,15,15));
	JPanel panel2 = new JPanel();

	JLabel l1 = new JLabel("�⼮");
	JLabel l2 = new JLabel("�߰�");
	JLabel l3 = new JLabel("�⸻");
	JLabel l4 = new JLabel("����");
	JLabel l5 = new JLabel("��ǥ");
	JLabel l6 = new JLabel("����");
	JLabel l7 = new JLabel("��Ÿ");
	JTextField attendance = new JTextField(5);
	JTextField midterm = new JTextField(5);
	JTextField finals = new JTextField(5);
	JTextField quiz = new JTextField(5);
	JTextField announcement = new JTextField(5);
	JTextField report = new JTextField(5);
	JTextField etc = new JTextField(5);
	JButton OkButton = new JButton("OK");
	
	public ScoreRatioFrame(){
		setTitle("���� �ݿ����� ����");
		this.setResizable(false);
		setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		
		panel.add(l1);
		panel.add(attendance);
		panel.add(l2);
		panel.add(midterm);
		panel.add(l3);
		panel.add(finals);
		panel.add(l4);
		panel.add(quiz);
		panel.add(l5);
		panel.add(announcement);
		panel.add(l6);
		panel.add(report);
		panel.add(l7);
		panel.add(etc);
		panel.add(OkButton);
		
		panel2.add(OkButton);
		
		panel.setBackground(Color.WHITE);
		panel2.setBackground(new Color(0,200,250));
		this.getContentPane().setBackground(new Color(0,200,250));
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//setSize(880,160);
		this.setBounds(200, 200, 880, 160);
		setVisible(true);
		
		add(panel,BorderLayout.CENTER);
		add(panel2,BorderLayout.SOUTH);
		
		this.addWindowListener(new ClosingEventHandler());
		this.OkButton.addActionListener(new ScoreActionListener());
	}
	
	class ScoreActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("��");
			if( manage.EditScoreRatio(attendance.getText(),
					midterm.getText(), 
					finals.getText(), 
					quiz.getText(), 
					announcement.getText(), 
					report.getText(), 
					etc.getText() ))
					{
						ScoreRatioFrame.this.mainFrame.setEnabled(true);
						dispose();
					}
						
		}
	}

	class ClosingEventHandler extends WindowAdapter{
		public void windowClosing(WindowEvent e) {
			System.out.println("����");
			ScoreRatioFrame.this.mainFrame.setEnabled(true);
		}
	}
}
