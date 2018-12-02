import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BatchProcessFrame extends BaseFrame {
	
	JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER,15,15));
	
	String [] week = {"select","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16"};
	String [] attend = {"select","�⼮","�Ἦ"};
	JLabel l1 = new JLabel("����");
	JLabel l2 = new JLabel("��� ó��");
	JLabel l3 = new JLabel("����");
	
	JComboBox<String> cb1 = new JComboBox(week);
	JComboBox<String> cb2 = new JComboBox(attend);
	JTextField text = new JTextField(20);
	
	public BatchProcessFrame(){
		this.setTitle("�⼮ �ϰ� ó��");
		this.setBounds(100, 100, 600, 110);
		this.setResizable(false);
		setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		
		panel.add(l1);
		panel.add(cb1);
		panel.add(l2);
		panel.add(cb2);
		panel.add(l3);
		panel.add(text);

		panel.setBackground(Color.WHITE);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
		this.getContentPane().setBackground(new Color(0,200,250));
		this.addWindowListener(new ClosingEventHandler());
		
		add(panel);
	}
	class ClosingEventHandler extends WindowAdapter{
		public void windowClosing(WindowEvent e) {
			System.out.println("����");
			BatchProcessFrame.this.mainFrame.setEnabled(true);
		}
	}
}
