import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.*;

public class ProgramManager {
	MainFrame main;
	InsertInfo insertInfo;
	InfoList infoList;
	
	ArrayList<StudentPanel> stList = new ArrayList<StudentPanel>();
	
	public ProgramManager(){
		
	}
	
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

		}catch(NullPointerException e) {
			return false;
		}
		
		// 남녀 선택했는가 
		String gender;
		if(insertInfo.getMale().isSelected()) {}
		else if(insertInfo.getFemale().isSelected()) {}
		else return false;
			
		
		// 시험 점수들이 0점 이상 100점 이하인가
		int temp = Integer.parseInt(insertInfo.getReportText().getText());
		System.out.println(temp);
		if( 0 > temp || temp > 100)
			return false;
			
		
		temp = Integer.parseInt(insertInfo.getMidtermText().getText());
		if( 0 > temp || temp > 100)
			return false;
		
		temp = Integer.parseInt(insertInfo.getFinalText().getText());
		if( 0 > temp || temp > 100)
			return false;
		
		temp = Integer.parseInt(insertInfo.getQuizJTextText().getText());
		if( 0 > temp || temp > 100)
			return false;
		
		temp = Integer.parseInt(insertInfo.getAnnouncementText().getText());
		if( 0 > temp || temp > 100)
			return false;
		
		temp = Integer.parseInt(insertInfo.getEtcText().getText());
		if( 0 > temp || temp > 100)
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
		for(int i =0 ; i < 16; i++)
			temp.attendance[i] = insertInfo.checkout[i];
		
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
		
		Student result = new Student();
		
		result.name = insertInfo.getNameText().getText();
		result.number = insertInfo.getNumberText().getText();
		result.major = insertInfo.getMajorText().getText();
		
		if(insertInfo.getMale().isSelected())
			result.gender = "남";
		else if(insertInfo.getFemale().isSelected())
			result.gender = "여";
		
		result.midtermExamScore = Integer.parseInt(insertInfo.getMidtermText().getText());
		result.finalExamScore = Integer.parseInt(insertInfo.getFinalText().getText());
		result.quizScore = Integer.parseInt(insertInfo.getQuizJTextText().getText());
		result.announcementScore = Integer.parseInt(insertInfo.getAnnouncementText().getText());
		result.reportScore = Integer.parseInt(insertInfo.getReportText().getText());
		result.etcScore = Integer.parseInt(insertInfo.getEtcText().getText());
		
		result.attendance = insertInfo.checkout;
		
		for(int i = 0; i< stList.size(); i++)
		{
			if(result.number.equals(stList.get(i).info.number)) {
				stList.get(i).info = result;
				stList.get(i).SettingButton();
				infoList.listPane.validate();
				System.out.println("이 목록을 수정합니다");
				break;
			}
		}
		this.EmptyInsertInfo();
	}
	
	public void ApplyBatchProcess(int week, int apply) {
		if( apply != 0 && week != 0)
			for(int i = 0; i < stList.size(); i++)
				stList.get(i).info.attendance[week - 1] = apply;
		
		System.out.print("성공");
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
		
		EmptyInsertInfo();
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
			JOptionPane.showMessageDialog(null, "숫자가 아닙니다", "오류", JOptionPane.WARNING_MESSAGE);
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
		
		for(int i =0 ; i < 16; i++)
			insertInfo.checkout[i] = p.info.attendance[i];
		
		for(int i =0 ; i < 16; i++)
			System.out.print(p.info.attendance[i] + " ");
		System.out.println("");
		
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
	
	public boolean EditGradeRatio(String apT, String a0T, String bpT, String b0T,  String cpT, String c0T, String dT, String fT) {
		if(!IsInteger(apT)) return false;
		if(!IsInteger(a0T)) return false;
		if(!IsInteger(bpT)) return false;
		if(!IsInteger(b0T)) return false;
		if(!IsInteger(cpT)) return false;
		if(!IsInteger(c0T)) return false;
		if(!IsInteger(dT)) return false;
		if(!IsInteger(fT)) return false;
		
		int ap = Integer.parseInt(apT);
		int a0 = Integer.parseInt(a0T);
		
		int bp = Integer.parseInt(bpT);
		int b0 = Integer.parseInt(b0T);
		
		int cp = Integer.parseInt(cpT);
		int c0 = Integer.parseInt(c0T);
		
		int d = Integer.parseInt(dT);
		int f = Integer.parseInt(fT);
		
		if( ap < 0 || a0 < 0 || bp < 0 || b0 < 0 || cp < 0 || c0 < 0 || d < 0 || f < 0) {
			JOptionPane.showMessageDialog(null, "음수가 있습니다.", "오류", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		if( (ap + a0 + bp + b0 + cp + c0 + d + f) > 100) {
			JOptionPane.showMessageDialog(null, "비율들의 도합이 100이 넘어갑니다", "오류", JOptionPane.WARNING_MESSAGE);
			return false;
		}
			
		
		GradeRatio.aP = ap;
		GradeRatio.aZ = a0;
		GradeRatio.bP = bp;
		GradeRatio.bZ = b0;
		GradeRatio.cP = cp;
		GradeRatio.cZ = c0;
		GradeRatio.d  = d;
		GradeRatio.f  = f;
		
		
		return true;
	}
	
	public boolean EditScoreRatio(String attendanceT, String midtermT, String finalsT, String quizT, String announceT, String reportT, String etcT) {
		if(!IsInteger(attendanceT)) return false;
		if(!IsInteger(midtermT)) return false;
		if(!IsInteger(finalsT)) return false;
		if(!IsInteger(quizT)) return false;
		if(!IsInteger(announceT)) return false;
		if(!IsInteger(reportT)) return false;
		if(!IsInteger(etcT)) return false;
		
		
		
		int checkout = Integer.parseInt(attendanceT);
		int midtermTest = Integer.parseInt(midtermT);
		int finalTest = Integer.parseInt(finalsT);
		int quiz = Integer.parseInt(quizT);
		int report = Integer.parseInt(announceT);
		int announce = Integer.parseInt(reportT);
		int etc = Integer.parseInt(etcT);
		
		if( checkout < 0 || midtermTest < 0 || finalTest < 0 || quiz < 0 || report < 0 || announce < 0 || etc < 0) {
			JOptionPane.showMessageDialog(null, "음수가 있습니다.", "오류", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		if( (checkout + midtermTest + finalTest + quiz + report + announce + etc) != 100) {
			JOptionPane.showMessageDialog(null, "비율들의 도합이 100이 아닙니다", "오류", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		ScoreRatio.checkout = checkout;
		ScoreRatio.midtermTest = midtermTest;
		ScoreRatio.finalTest = finalTest;
		ScoreRatio.quiz = quiz;
		ScoreRatio.report = report;
		ScoreRatio.announce = announce;
		ScoreRatio.etc = etc;
		
		return true;
	}
	
	public int CalculateAttendanceScore(int checkout[]) {
		int result = 100;
		
		for(int i = 0; i < 16; i++)
		{
			if(checkout[i] == 2)
				result-=5;
			else if(checkout[i] == 3)
				result -= 2;
		}
		
		return result;
	}
	
	public void CalculateTotalScore() {
		for(int i = 0; i < stList.size(); i++)
		{
			int total = 0;
			
			total += stList.get(i).info.midtermExamScore * ScoreRatio.midtermTest;
			total += stList.get(i).info.finalExamScore * ScoreRatio.finalTest;
			
			total += stList.get(i).info.quizScore * ScoreRatio.quiz;
			total += stList.get(i).info.announcementScore * ScoreRatio.announce;
			total += stList.get(i).info.etcScore * ScoreRatio.etc;
			total += stList.get(i).info.reportScore * ScoreRatio.report;
			
			total += CalculateAttendanceScore(stList.get(i).info.attendance) * ScoreRatio.report;
			
			stList.get(i).info.totalScore = total;
		}
		
		for(int i = 0; i < stList.size(); i++)
		{
			System.out.println(stList.get(i).info.totalScore);
		}
	}
	
	public void DrawGraph(JPanel graphPanel, int type) {
		
		graphPanel.add(new GraphPanel(), BorderLayout.CENTER);
		
		
	}
	
	// 등급 최대 비율
	static class GradeRatio{
		static int aP = 15;
		static int aZ = 15;
		static int bP = 30;
		static int bZ = 10;
		static int cP;
		static int cZ;
		static int d;
		static int f;
	}
	
	// 점수 비율
	static class ScoreRatio{
		static int checkout = 10;
		static int midtermTest = 30;
		static int finalTest = 30;
		static int quiz = 10;
		static int report = 10;
		static int announce = 5;
		static int etc = 5;
	}
	
}
