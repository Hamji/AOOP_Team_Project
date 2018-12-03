
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GradeRatioFrame extends BaseFrame {
	JPanel panel = new JPanel();
	JPanel panel2 = new JPanel();
	JButton button = new JButton("OK");
	JLabel l1 = new JLabel("A+");
	JTextField aPText = new JTextField(3);
	JLabel l2 = new JLabel("A");
	JTextField aZText = new JTextField(3);
	JLabel l3 = new JLabel("B+");
	JTextField bPText = new JTextField(3);
	JLabel l4 = new JLabel("B");
	JTextField bZText = new JTextField(3);
	JLabel l5 = new JLabel("C+");
	JTextField cPText = new JTextField(3);
	JLabel l6 = new JLabel("C");
	JTextField cZText = new JTextField(3);
	JLabel l7 = new JLabel("D");
	JTextField dZText = new JTextField(3);
	JLabel l8 = new JLabel("F");
	JTextField fText = new JTextField(3);
	
	public GradeRatioFrame(){
		setTitle("µî±Þ ºñÀ² ¼³Á¤");
		
		panel.setLayout(new FlowLayout(FlowLayout.CENTER,15,15));
		setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		
		panel.add(l1);
		panel.add(aPText);
		panel.add(l2);
		panel.add(aZText);
		panel.add(l3);
		panel.add(bPText);
		panel.add(l4);
		panel.add(bZText);
		panel.add(l5);
		panel.add(cPText);
		panel.add(l6);
		panel.add(cZText);
		panel.add(l7);
		panel.add(dZText);
		panel.add(l8);
		panel.add(fText);
		panel2.add(button);
		
		panel.setBackground(Color.white);
		panel2.setBackground(new Color(67, 117, 219));
		button.setBackground(new Color(169, 169, 169));
		this.getContentPane().setBackground(new Color(67, 117, 219));
		setLocation(400, 400);
		
		button.addActionListener(new GradeActionListener());
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(670,150);
		setResizable(false);
		setVisible(true);
		
		this.addWindowListener(new ClosingEventHandler());
		
		add(panel,BorderLayout.CENTER);
		add(panel2,BorderLayout.SOUTH);
	}
	
	class GradeActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("¤·");
			
			if( manage.EditGradeRatio(aPText.getText(),
					aZText.getText(),
					bPText.getText(),
					bZText.getText(),
					cPText.getText(),
					cZText.getText(),
					dZText.getText(),
					fText.getText())) {
				
				GradeRatioFrame.this.mainFrame.setEnabled(true);
				dispose();
			}
	
		}
	}
	
	class ClosingEventHandler extends WindowAdapter{
		public void windowClosing(WindowEvent e) {
			//System.out.println("´ÝÈû");
			GradeRatioFrame.this.mainFrame.setEnabled(true);
		}
	}
}
