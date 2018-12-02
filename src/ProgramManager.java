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
		// 중복되는 이가 있는가
			for(int i =0; i < stList.size(); i++)
				if(stList.get(i).getInfo().number.equals(insertInfo.getNumberText().getText()))
					return true;
			
			return false;	
	}
	
	public boolean IsInsertRight() {
		// 학번이 숫자인가
		if(! IsInteger(insertInfo.getNumberText().getText())) return false;
		
		// 시험점수들이 숫자인가 
		
		if(! IsInteger(insertInfo.getReportText().getText())) return false;
		if(! IsInteger(insertInfo.getMidtermText().getText())) return false;
		if(! IsInteger(insertInfo.getFinalText().getText())) return false;
		if(! IsInteger(insertInfo.getQuizJTextText().getText())) return false;
		if(! IsInteger(insertInfo.getAnnouncementText().getText())) return false;
		if(! IsInteger(insertInfo.getEtcText().getText())) return false;
		
		// 출석이 모두 입력되었는가
		
		try {
			for(int i = 0; i< 16; i++)
				if(insertInfo.getCheckout()[i] == 0)
					return false;
				else
					return true;
			
		}catch(NullPointerException e) {
			return false;
		}
		
		// 남녀 선택했는가 
		String gender;
		if(insertInfo.getMale().isSelected()) {}
		else if(insertInfo.getFemale().isSelected()) {}
		else return false;
			
		
		// 시험 점수들이 0점 이상 100점 미만인가
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
			gender = "남";
		else if(insertInfo.getFemale().isSelected())
			gender = "여";
		
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
			System.out.println("숫자가 아닙니다.");
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
		
		if(p.getInfo().gender.equals("남"))
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
