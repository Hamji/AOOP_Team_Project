import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
// 출석 수정 창 클래스
public class CheckOutEditFrame extends BaseFrame {
	
	CheckOutEditPanel mainPanel;
	
	JComboBox checkoutList[];
	
	String idle[] = {"선택", "출석", "결석", "지각"};
	
	class CheckOutEditPanel extends BasePanel{
		
		public CheckOutEditPanel() {
			this.setPreferredSize(new Dimension(900,40));
			this.setBackground(Color.white);
			this.setLayout(new GridLayout(2,16));
			
			checkoutList = new JComboBox[16];
			
			for(int i = 0; i < 16; i++)
				checkoutList[i] = new JComboBox(idle);
			
			
			
			for(int i = 1; i <= 16; i++)
				this.add(new JLabel(String.valueOf(i)));
			for(int i = 0; i < 16; i++)
				this.add(checkoutList[i]);
			
			
			
		}
	}
	public CheckOutEditFrame(MainFrame mainFrame){
		this.setPreferredSize(new Dimension(2000,40));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setBackground(Color.GRAY);
		this.setBounds(200, 200, 1500, 100);
		this.addWindowListener(new EventHandler());
		this.mainFrame = mainFrame;
		this.manage = mainFrame.manage;
		
		this.setTitle("출석 수정");
		
		mainPanel = new CheckOutEditPanel();
		
		this.add(mainPanel);
	}
	class EventHandler extends WindowAdapter{
		@Override
		public void windowOpened(WindowEvent e) {
			//System.out.println("창열림");
			System.out.println(manage.stList.size());
			for(int i = 0; i < manage.stList.size(); i++)
			{
				if(manage.stList.get(i).info.number.equals(manage.insertInfo.getNumberText().getText())) {
					//System.out.println("심상치 않은데?");
					for(int j = 0; j < 16; j++) {
						checkoutList[j].setSelectedIndex(manage.stList.get(i).info.attendance[j]);
						checkoutList[j].validate();
						//System.out.print(manage.stList.get(i).info.attendance[j] + " ");
					}
					//System.out.println("");
					return;
				}	
			}
		}

		public void windowClosing(WindowEvent e) {
			System.out.println("닫힘");
			CheckOutEditFrame.this.mainFrame.setEnabled(true);
			
			int temp[] = new int[16];
			
			for(int i = 0; i < 16; i++)
			{
				temp[i] = CheckOutEditFrame.this.checkoutList[i].getSelectedIndex();
			}
			
			manage.insertInfo.setCheckout(temp);
			//for(int i = 0; i < 16; i++)
				//System.out.println(temp[i]);
		}
	}
}


