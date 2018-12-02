import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ProgramManager {
	MainFrame main;
	InsertInfo insertInfo;
	InfoList infoList;
	
	ArrayList<StudentPanel> stList = new ArrayList<StudentPanel>();
	
	public boolean IsOverLap() {
		// �ߺ��Ǵ� �̰� �ִ°�
			for(int i =0; i < stList.size(); i++)
				if(stList.get(i).getInfo().number.equals(insertInfo.getNumberText().getText()))
					return true;
			
			return false;	
	}
	
	public boolean IsInsertRight() {
		// �й��� �����ΰ�
		if(! IsInteger(insertInfo.getNumberText().getText())) return false;
		
		// ������������ �����ΰ� 
		
		if(! IsInteger(insertInfo.getReportText().getText())) return false;
		if(! IsInteger(insertInfo.getMidtermText().getText())) return false;
		if(! IsInteger(insertInfo.getFinalText().getText())) return false;
		if(! IsInteger(insertInfo.getQuizJTextText().getText())) return false;
		if(! IsInteger(insertInfo.getAnnouncementText().getText())) return false;
		if(! IsInteger(insertInfo.getEtcText().getText())) return false;
		
		// �⼮�� ��� �ԷµǾ��°�
		
		try {
			for(int i = 0; i< 16; i++)
				if(insertInfo.getCheckout()[i] == 0)
					return false;
				else
					return true;
			
		}catch(NullPointerException e) {
			return false;
		}
		
		// ���� �����ߴ°� 
		String gender;
		if(insertInfo.getMale().isSelected()) {}
		else if(insertInfo.getFemale().isSelected()) {}
		else return false;
			
		
		// ���� �������� 0�� �̻� 100�� �̸��ΰ�
		int temp = Integer.parseInt(insertInfo.getReportText().getText());
		if( 0 > temp && temp > 100)
			return false;
		
		temp = Integer.parseInt(insertInfo.getMidtermText().getText());
		if( 0 > temp && temp > 100)
			return false;
		
		temp = Integer.parseInt(insertInfo.getFinalText().getText());
		if( 0 > temp && temp > 100)
			return false;
		
		temp = Integer.parseInt(insertInfo.getQuizJTextText().getText());
		if( 0 > temp && temp > 100)
			return false;
		
		temp = Integer.parseInt(insertInfo.getAnnouncementText().getText());
		if( 0 > temp && temp > 100)
			return false;
		
		temp = Integer.parseInt(insertInfo.getEtcText().getText());
		if( 0 > temp && temp > 100)
			return false;
		
		
		
		return true;
	}

	public void InsertStudent() {
		String gender = "";
		if(insertInfo.getMale().isSelected())
			gender = "��";
		else if(insertInfo.getFemale().isSelected())
			gender = "��";
		
		Student temp = new Student(insertInfo.getNameText().getText(),
				insertInfo.getMajorText().getText(), 
				insertInfo.getNumberText().getText(),
				gender);
		
		
		temp.setMidtermExamScore(Integer.parseInt(insertInfo.getMidtermText().getText()));
		temp.setFinalExamScore(Integer.parseInt(insertInfo.getFinalText().getText()));
		temp.setAnnouncementScore(Integer.parseInt(insertInfo.getAnnouncementText().getText()));
		temp.setQuizScore(Integer.parseInt(insertInfo.getQuizJTextText().getText()));
		temp.setReportScore(Integer.parseInt(insertInfo.getReportText().getText()));
		temp.setEtcScore(Integer.parseInt(insertInfo.getEtcText().getText()));
		
		StudentPanel tempStudentPanel = new StudentPanel(temp);
		tempStudentPanel.manage = this;
		
		infoList.addStudentPanel(tempStudentPanel);
		EmptyInsertInfo();
		this.stList.add(tempStudentPanel);
		
	}
	
	public void AdjustStudent() {
		
	}
	
	public void DelStudent() {
		
		String delStNumber = insertInfo.getNumberText().getText();
		
		for(int i =0; i < stList.size(); i++)
			if(stList.get(i).getInfo().number.equals(insertInfo.getNumberText().getText()))
			{
				infoList.listPane.remove(stList.get(i));
				stList.remove(i);
				
				infoList.listPane.validate();
			}
		
	
		infoList.validate();
		infoList.updateUI();
	}
	
	public void EmptyInsertInfo() {
		insertInfo.getNameText().setText("");
		insertInfo.getNumberText().setText("");
		insertInfo.getMajorText().setText("");
		insertInfo.getMale().setSelected(false);
		insertInfo.getFemale().setSelected(false);
		
		insertInfo.checkout = new int[16];
		
		insertInfo.getMidtermText().setText("");
		insertInfo.getFinalText().setText("");
		insertInfo.getQuizJTextText().setText("");
		insertInfo.getAnnouncementText().setText("");
		insertInfo.getReportText().setText("");
		insertInfo.getEtcText().setText("");
	}
	
	boolean IsInteger(String s) {
		try {
			Integer.parseInt(s);
		}catch(NumberFormatException e) {
			System.out.println("���ڰ� �ƴմϴ�.");
			return false;
		}catch(NullPointerException e) {
			return false;
		}
		return true;
	}

	public void setMain(MainFrame main) {
		this.main = main;
	}

	public void CallInsertInfo(StudentPanel p) {
		insertInfo.getNameText().setText(p.getInfo().name);
		insertInfo.getMajorText().setText(p.getInfo().major);
		insertInfo.getNumberText().setText(p.getInfo().number);
		
		if(p.getInfo().gender.equals("��"))
			insertInfo.getMale().setSelected(true);
		else
			insertInfo.getFemale().setSelected(true);
		
		insertInfo.setCheckout(p.getInfo().attendance);
		
		insertInfo.getMidtermText().setText(String.valueOf(p.getInfo().midtermExamScore));
		insertInfo.getFinalText().setText(String.valueOf(p.getInfo().finalExamScore));
		insertInfo.getQuizJTextText().setText(String.valueOf(p.getInfo().quizScore));
		insertInfo.getAnnouncementText().setText(String.valueOf(p.getInfo().announcementScore));
		insertInfo.getReportText().setText(String.valueOf(p.getInfo().reportScore));
		insertInfo.getEtcText().setText(String.valueOf(p.getInfo().etcScore));
	}
	
	
	public void setInsertInfo(InsertInfo insertInfo) {
		this.insertInfo = insertInfo;
	}



	public void setInfoList(InfoList infoList) {
		this.infoList = infoList;
	}



	public MainFrame getMain() {
		return main;
	}



	public InsertInfo getInsertInfo() {
		return insertInfo;
	}



	public InfoList getInfoList() {
		return infoList;
	}
	
	
}
