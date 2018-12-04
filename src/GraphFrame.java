import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GraphFrame extends BaseFrame {
	JButton totalButton = new JButton("����");
	JButton midtermButton = new JButton("�߰�");
	JButton finalButton = new JButton("�⸻");
	JButton quizButton = new JButton("����");
	JButton reportButton = new JButton("����");
	JButton attendanceButton = new JButton("�⼮");
	JButton etcButton = new JButton("��Ÿ");
	
	
	
	JPanel graphPanel;
	
	JLabel graphName;
	
	
	
	GraphActionListener listen = new GraphActionListener();
	
	public GraphFrame() {
		
		setTitle("�׷���");
		
		this.setBounds(100, 100, 600, 500);
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
		this.totalButton.addActionListener(listen);
		this.midtermButton.addActionListener(listen);
		this.finalButton.addActionListener(listen);
		this.quizButton.addActionListener(listen);
		this.reportButton.addActionListener(listen);
		this.attendanceButton.addActionListener(listen);
		this.etcButton.addActionListener(listen);
		
		//////
		JPanel buttonPanel = new JPanel(new GridLayout(7,1));
		buttonPanel.setPreferredSize(new Dimension(100,300));
		
		buttonPanel.add(totalButton);
		buttonPanel.add(midtermButton);
		buttonPanel.add(finalButton);
		buttonPanel.add(quizButton);
		buttonPanel.add(reportButton);
		buttonPanel.add(attendanceButton);
		buttonPanel.add(etcButton);
		////////
		
		////////
		graphPanel = new JPanel(new BorderLayout());
		graphPanel.setBackground(Color.white);
		graphPanel.setPreferredSize(new Dimension(620,30));
		
		
		graphName = new JLabel("���� �׷����� ���� ���ּ���!");
		graphName.setPreferredSize(new Dimension(620,30));
		graphName.setHorizontalAlignment(SwingConstants.CENTER);
		
		graphPanel.add(graphName, BorderLayout.NORTH);
		////////
		
		this.add(buttonPanel, BorderLayout.WEST);
		this.add(graphPanel,BorderLayout.CENTER);
		this.addWindowListener(new ClosingEventHandler());
		
		this.setVisible(true);
		
	}

	class GraphActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
		
			if(e.getSource() == totalButton) {
				graphName.setText(totalButton.getText() + " (2000�� ����)");
				manage.DrawGraph(graphPanel, 1);
			}else if(e.getSource() == midtermButton) {
				graphName.setText(midtermButton.getText() + " (20�� ����)");
				manage.DrawGraph(graphPanel,2);
			}else if(e.getSource() == finalButton) {
				graphName.setText(finalButton.getText() + " (20�� ����)");
				manage.DrawGraph(graphPanel,3);
			}else if(e.getSource() == quizButton) {
				graphName.setText(quizButton.getText() + " (20�� ����)");
				manage.DrawGraph(graphPanel,4);
			}else if(e.getSource() == reportButton) {
				graphName.setText(reportButton.getText() + " (20�� ����)");
				manage.DrawGraph(graphPanel,5);
			}else if(e.getSource() == attendanceButton) {
				graphName.setText(attendanceButton.getText() + " (20�� ����)");
				manage.DrawGraph(graphPanel,6);
			}else if(e.getSource() == etcButton) {
				graphName.setText(etcButton.getText() + " (20�� ����)");
				manage.DrawGraph(graphPanel,7);
			}
			
			
			graphName.validate();
		}
	}
	
	class ClosingEventHandler extends WindowAdapter{
		public void windowClosing(WindowEvent e) {
			//System.out.println("����");
			GraphFrame.this.mainFrame.setEnabled(true);
		}
	}
}
