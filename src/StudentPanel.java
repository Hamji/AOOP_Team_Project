import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class StudentPanel extends BasePanel implements Comparable<StudentPanel> {
	Student info;
	
	JButton studentButton;
	
	
	
	public Student getInfo() {
		return info;
	}

	public StudentPanel(Student info) {
		this.info = info;
		this.setSize(1030, 5);
		
		this.setPreferredSize(new Dimension(1050, 50));
		
		this.studentButton = new JButton();
		
		this.setLayout(new BorderLayout());
		SettingButton();
		
		this.add(studentButton,BorderLayout.CENTER);
		studentButton.addActionListener(new PanelActionListener());
	}
	
	void SettingButton() {
		String result = "";
		result += "이름: " + info.getName() + "  ";
		result += "학번: " + info.getNumber() + "  ";
		result += "전공: " + info.getMajor() + "  ";
		result += "성별: "; 
		if(info.getGender().equals("남"))
			result += "남자";
		else if(info.getGender().equals("여"))
			result += "여자";
		
		this.studentButton.setText(result);
	}
	
	class PanelActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			StudentPanel.this.manage.CallInsertInfo(StudentPanel.this);
		}
		
	}

	@Override
	public int compareTo(StudentPanel s) {
		// TODO Auto-generated method stub
		
		if( this.info.totalScore > s.info.totalScore)
			return -1;
		else if( this.info.totalScore < s.info.totalScore)
			return 1;
		else
			return 0;
	}
}
