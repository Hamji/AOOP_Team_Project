import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProgramManager {
	MainFrame main;
	InsertInfo insertInfo;
	InfoList infoList;
	
	ArrayList<StudentPanel> stList = new ArrayList<StudentPanel>();
	
	public void SaveFile() {
		JFileChooser jfc = new JFileChooser();
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
		jfc.setFileFilter(filter);
		
		int returnVal = jfc.showSaveDialog(null);
		if(returnVal == 0) {
			File file = jfc.getSelectedFile();
			
			String str = ArrangeList();
			System.out.print("저장할게요오옷");
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(file));
				bw.write(str);
				bw.flush();
				bw.close();
			}catch(Exception e) { 
				e.printStackTrace();
			}
		}
		
	}
	
	public void OpenFile() throws IOException {
		JFileChooser jfc = new JFileChooser();
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
		jfc.setFileFilter(filter);
		
		String contents = "";
		
		int returnVal = jfc.showSaveDialog(null);
		if(returnVal == 0) {
			File file = jfc.getSelectedFile();
			contents = readFile(file.getPath(), Charset.defaultCharset());
			//System.out.println(contents);
		}
		
		String name, major, number, gender;
		int start, index = 0;
		start = 0;
		
		while( contents.length() - 2 > index)
		{
			index = contents.indexOf(", ",start);
			name = contents.substring(start, index);
			start = index + 2;
			
			index = contents.indexOf(", ", start);
			major = contents.substring(start,  index);
			start = index + 2;
			
			index = contents.indexOf(", ", start);
			number = contents.substring(start,  index);
			start = index + 2;
			
			index = contents.indexOf(", ", start);
			gender = contents.substring(start,  index);
			start = index + 2;
			
			Student stTemp = new Student(name, major, number, gender);
			
			index = contents.indexOf(", ", start);
			stTemp.midtermExamScore = Integer.parseInt(contents.substring(start,  index));
			start = index + 2;
			
			index = contents.indexOf(", ", start);
			stTemp.finalExamScore = Integer.parseInt(contents.substring(start,  index));
			start = index + 2;
			
			index = contents.indexOf(", ", start);
			stTemp.quizScore = Integer.parseInt(contents.substring(start,  index));
			start = index + 2;
			
			index = contents.indexOf(", ", start);
			stTemp.reportScore = Integer.parseInt(contents.substring(start,  index));
			start = index + 2;
			
			index = contents.indexOf(", ", start);
			stTemp.etcScore = Integer.parseInt(contents.substring(start,  index));
			start = index + 2;
			
			index = contents.indexOf(", ", start);
			stTemp.announcementScore = Integer.parseInt(contents.substring(start,  index));
			start = index + 2;
			
			index = contents.indexOf(", ", start);
			String attend = contents.substring(start,  index);
			for(int i = 0; i < 16; i++)
				if(attend.substring(i, i+1).equals("a"))
					stTemp.attendance[i] = 1;
				else if(attend.substring(i, i+1).equals("b"))
					stTemp.attendance[i] = 2;
				else if(attend.substring(i, i+1).equals("c"))
					stTemp.attendance[i] = 3;
			start = index + 2;
			
			index = contents.indexOf(", ", start);
			stTemp.totalScore = Integer.parseInt(contents.substring(start,  index));
			start = index + 2;
			
			index = contents.indexOf("\r\n", start);
			stTemp.grade = contents.substring(start,  index);
			start = index + 2;
			//System.out.println(stTemp.toString());
			
			StudentPanel tempStudentPanel = new StudentPanel(stTemp);
			tempStudentPanel.manage = this;
			
			infoList.addStudentPanel(tempStudentPanel);
			this.stList.add(tempStudentPanel);
			
		}
		
		
	}

	public void OpenBySql() throws SQLException {
		DBCaller temp = new DBCaller();
		
		String sql = "SELECT * FROM student";
		PreparedStatement pstmt = temp.con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Student stTemp = new Student(rs.getString(1),rs.getString("major"), rs.getString("number"), rs.getString("gender"));
			
			stTemp.totalScore = rs.getInt("totalScore");
			stTemp.midtermExamScore = rs.getInt("midtermScore");
			stTemp.finalExamScore = rs.getInt("finalScore");
			stTemp.quizScore = rs.getInt("quizScore");
			stTemp.etcScore = rs.getInt("etcScore");
			stTemp.reportScore = rs.getInt("reportScore");
			stTemp.announcementScore = rs.getInt("announceScore");
			
			String checkout = rs.getString("checkOut");
			
			for(int i = 0; i < 16; i++)
				if(checkout.charAt(i) == 'a') {
					stTemp.attendance[i] = 1;
				}else if(checkout.charAt(i) == 'b') {
					stTemp.attendance[i] = 2;
				}else if(checkout.charAt(i) == 'c') {
					stTemp.attendance[i] = 3;
				}
			
			stTemp.grade = rs.getString("grade");
			stTemp.manage = this;
			//System.out.println(stTemp.toString());
			
			StudentPanel tempStudentPanel = new StudentPanel(stTemp);
			tempStudentPanel.manage = this;
			
			infoList.addStudentPanel(tempStudentPanel);
			this.stList.add(tempStudentPanel);
			
			
			//System.out.print("name: " + rs.getString(1) + ", ");
			//System.out.println("number: " + rs.getString("number"));
		}
		
		temp.con.close();
		temp.stmt.close();
	}
	
	public void SaveBySql() throws SQLException {
		DBCaller temp = new DBCaller();
		
		
		String sql = "INSERT INTO student (name, major, number, gender, totalScore, midtermScore, finalScore, quizScore, etcScore, announceScore, reportScore, checkOut, grade)" ;
		sql += "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement pstmt;
		
		pstmt = temp.con.prepareStatement("TRUNCATE TABLE student");
		
		pstmt.executeUpdate();
		pstmt.close();
		
		
		for(int i = 0; i < stList.size(); i++) {
			pstmt = temp.con.prepareStatement(sql);
			
			pstmt.setString(1, stList.get(i).info.name);
			pstmt.setString(2, stList.get(i).info.major);
			pstmt.setString(3, stList.get(i).info.number);
			pstmt.setString(4, stList.get(i).info.gender);
			
			pstmt.setInt(5, stList.get(i).info.totalScore);
			pstmt.setInt(6, stList.get(i).info.midtermExamScore);
			pstmt.setInt(7, stList.get(i).info.finalExamScore);
			pstmt.setInt(8, stList.get(i).info.quizScore);
			pstmt.setInt(9, stList.get(i).info.etcScore);
			pstmt.setInt(10, stList.get(i).info.announcementScore);
			pstmt.setInt(11, stList.get(i).info.reportScore);
			
			pstmt.setString(12, stList.get(i).info.CheckoutToString());
			pstmt.setString(13, stList.get(i).info.grade);
			
			pstmt.execute();
			pstmt.close();
		}
		
		//sql.append("INSERT INTO student (name, major, number, gender, totalScore, midtermScore, finalScore, quizScore, etcScore, announceScore, reportScore, checkOut, grade)");
		//sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?");
		
		
		temp.con.close();
		temp.stmt.close();
	}
	private String readFile(String path, Charset encoding) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		  return new String(encoded, encoding);
	}

	public String ArrangeList() {
		this.CalculateTotalScore();
		
		String result = "";
		
		for(int i = 0; i < stList.size(); i++)
		{
			result += stList.get(i).info.name + ", ";
			result += stList.get(i).info.number + ", ";
			result += stList.get(i).info.major + ", ";
			result += stList.get(i).info.gender + ", ";
			
			result += stList.get(i).info.midtermExamScore + ", ";
			result += stList.get(i).info.finalExamScore + ", ";
			result += stList.get(i).info.quizScore + ", ";
			result += stList.get(i).info.reportScore + ", ";
			result += stList.get(i).info.etcScore + ", ";
			result += stList.get(i).info.announcementScore + ", ";
			
			for(int j = 0; j < 16; j++){
				if(stList.get(i).info.attendance[j] == 1) {
					result += 'a';
				}else if (stList.get(i).info.attendance[j] == 2) {
					result += 'b';
				}else if( stList.get(i).info.attendance[j] == 3) {
					result += 'c';
				}
			}
			result += ", ";
			
			result += stList.get(i).info.totalScore + ", ";
			result += stList.get(i).info.grade;
			
			result += "\r\n";
		}

		return result;
	}
	
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
		temp.manage = this;
		
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
				//System.out.println("이 목록을 수정합니다");
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
		
		if( (ap + a0 + bp + b0 + cp + c0 + d + f) != 100) {
			JOptionPane.showMessageDialog(null, "비율들의 도합이 100되지 않습니다.", "오류", JOptionPane.WARNING_MESSAGE);
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
		
		this.CalculateTotalScore();
		
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
	}
	
	public void DrawGraph(JPanel graphPanel, int type) {

		class GraphPanel extends BasePanel {
			protected void paintComponent (Graphics g) {
				int[] data = {0, 0, 0, 0, 0};
				int[] ratio = {0, 0, 0, 0, 0};
		
				
				super.paintComponent(g);
				
				final int centerX = 100;
				final int centerY = 80;
				
				g.setColor(new Color(0,200,250));
				g.drawLine(0, 0,0, 400);
				
				data = ProgramManager.this.GetGraphData(type);
				ratio = CalcurateRatio(data);
				
				//System.out.println(ratio.toString());
				
				//g.setColor(Color.RED);
				//g.fillArc(centerX, centerY, 250, 250, 0, 30 );
				
				
				g.setColor(Color.RED);
				g.fillArc(centerX, centerY, 250, 250, 0, ratio[0] );
				
				g.setColor(Color.blue);
				g.fillArc(centerX, centerY, 250, 250, ratio[0]+1, ratio[1]);
				
				g.setColor(Color.yellow);
				g.fillArc(centerX, centerY, 250, 250, ratio[0]+ratio[1]+1, ratio[2]);
				
				g.setColor(Color.magenta);
				g.fillArc(centerX, centerY, 250, 250, ratio[0]+ratio[1]+ratio[2]+1, ratio[3]);
				
				g.setColor(Color.green);
				g.fillArc(centerX, centerY, 250, 250, ratio[0]+ratio[1]+ratio[2]+ratio[3]+1, ratio[4]);
		
				
			}
		}
		GraphPanel graph = new GraphPanel();
		
		graphPanel.add(graph, BorderLayout.CENTER);
		
	}
	
	public int[] GetGraphData(int type) {
		this.CalculateTotalScore();
		int[] data = {0, 0, 0, 0, 0};
		for(int i = 0; i < stList.size(); i++) {
			switch(type) {
			case 1:
				if(stList.get(i).info.totalScore > 8000 )
					data[4]++;
				else if(stList.get(i).info.totalScore > 6000) 
					data[3]++;
				else if(stList.get(i).info.totalScore > 4000) 
					data[2]++;
				else if(stList.get(i).info.totalScore > 2000) 
					data[1]++;
				else 
					data[0]++;
				break;
			case 2:
				if(stList.get(i).info.midtermExamScore > 80 )
					data[4]++;
				else if(stList.get(i).info.midtermExamScore > 60) 
					data[3]++;
				else if(stList.get(i).info.midtermExamScore > 40) 
					data[2]++;
				else if(stList.get(i).info.midtermExamScore > 20) 
					data[1]++;
				else 
					data[0]++;
				
				break;
			case 3:
				if(stList.get(i).info.finalExamScore > 80 )
					data[4]++;
				else if(stList.get(i).info.finalExamScore > 60) 
					data[3]++;
				else if(stList.get(i).info.finalExamScore > 40) 
					data[2]++;
				else if(stList.get(i).info.finalExamScore > 20) 
					data[1]++;
				else 
					data[0]++;
				break;
			case 4:
				if(stList.get(i).info.quizScore > 80 )
					data[4]++;
				else if(stList.get(i).info.quizScore > 60) 
					data[3]++;
				else if(stList.get(i).info.quizScore > 40) 
					data[2]++;
				else if(stList.get(i).info.quizScore > 20) 
					data[1]++;
				else 
					data[0]++;
				break;
			case 5:
				if(stList.get(i).info.reportScore > 80 )
					data[4]++;
				else if(stList.get(i).info.reportScore > 60) 
					data[3]++;
				else if(stList.get(i).info.reportScore > 40) 
					data[2]++;
				else if(stList.get(i).info.reportScore > 20) 
					data[1]++;
				else 
					data[0]++;
				break;
			case 6:
				if(this.CalculateAttendanceScore(stList.get(i).info.attendance) > 80 )
					data[4]++;
				else if(this.CalculateAttendanceScore(stList.get(i).info.attendance) > 60) 
					data[3]++;
				else if(this.CalculateAttendanceScore(stList.get(i).info.attendance) > 40) 
					data[2]++;
				else if(this.CalculateAttendanceScore(stList.get(i).info.attendance) > 20) 
					data[1]++;
				else 
					data[0]++;				
				break;
			case 7:
				if(stList.get(i).info.etcScore > 80 )
					data[4]++;
				else if(stList.get(i).info.etcScore > 60) 
					data[3]++;
				else if(stList.get(i).info.etcScore > 40) 
					data[2]++;
				else if(stList.get(i).info.etcScore > 20) 
					data[1]++;
				else 
					data[0]++;
				break;
			}
		}
		
		return data;
	}
	public int[] CalcurateRatio(int[] data) {
		int[] ratio = {0, 0, 0, 0, 0};
		int total = 0;
		
		for(int i =0 ; i< 5; i++)
			total += data[i];
		
		for(int j = 0; j < 5; j++) {
			ratio[j] = (int)( data[j] / (double)total * 360);
		}
		
		return ratio;
	}
	
	public double CalculateAver() {
		double result = 0;
		
		for(int i = 0; i < stList.size(); i++)
			result += stList.get(i).info.totalScore;
		
		return result / stList.size();
	}
	
	public int GetMany() {
		return stList.size();
	}
	
	public double GetVar() {
		double result = 0;
		
		int[] data = new int[stList.size()];
		for(int i = 0; i < data.length; i++)
			data[i] = stList.get(i).info.totalScore;
		
		for(int j = 0; j < data.length; j++)
			result += (data[j] - CalculateAver()) *(data[j] - CalculateAver());
		
		if(stList.size() != 0)
			result /= (stList.size());
		
		return result;
	}
	
	public double GetStdev() {
		return (Math.sqrt(GetVar()));
	}
	
	public void SetResultPanel(JPanel pane) {
		for(int i = 0; i < stList.size(); i++) {
			pane.add(new ResultPanel(stList.get(i).info));
		}
		pane.setPreferredSize(new Dimension(560, 60 * stList.size()));
	}
	
	public boolean IsValidGrade(int sel) {
		int[] data = {0, 0, 0, 0, 0, 0, 0, 0};
		int[] ratio = {0, 0, 0, 0, 0, 0, 0, 0};
		int ratioSum = 0;
		double dataSum = 0.0f;
		
		ratio[0] = GradeRatio.aP;
		ratio[1] = GradeRatio.aZ;
		
		ratio[2] = GradeRatio.bP;
		ratio[3] = GradeRatio.bZ;
		
		ratio[4] = GradeRatio.cP;
		ratio[5] = GradeRatio.cZ;
		
		ratio[6] = GradeRatio.d;
		ratio[7] = GradeRatio.f;
		
		for(int i = 0; i < stList.size(); i++) {
			if(stList.get(i).info.gradeCombo.getSelectedIndex() != 0) {
				data[stList.get(i).info.gradeCombo.getSelectedIndex() - 1]++;
			}
		}
		/*
		for(int i = 0; i < data.length; i++){
			System.out.print(data[i] + " ");
		}
		System.out.println("");
		*/
		
		for(int j = 0; j < sel; j++)
			ratioSum += ratio[j];
		
		for(int k = 0; k < sel; k++)
			dataSum += data[k];
		
		dataSum = dataSum / stList.size() * 100;
		
		if( (int)dataSum > ratioSum)
			return false;
		
		return true;
	}
	
	// 등급 최대 비율
	static class GradeRatio{
		static int aP = 15;
		static int aZ = 15;
		static int bP = 30;
		static int bZ = 10;
		static int cP = 10;
		static int cZ = 20;;
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
