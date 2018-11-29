import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

public class InsertInfo extends JPanel {
	
	// 추가 수정 제거 버튼
	JButton addButton;
	JButton editButton;
	JButton delButton;
	
	// 출석 수정 버튼
	JButton attendanceEdit;
	
	// 이름, 학번, 학과 text area
	JTextArea nameText;
	JTextArea numberText;
	JTextArea majorText;
	
	// 중간 기말 퀴즈 발표 보고서 기타 text area
	JTextArea midtermText;
	JTextArea finalText;
	JTextArea quizJTextText;
	JTextArea announcementText;
	JTextArea reportText;
	JTextArea etcText;
	
	// 남녀 라디오  그룹
	JRadioButton male;
	JRadioButton female;
	ButtonGroup gender;
	
	// 컴포넌트들을 보기좋게 배치하기 위한 패널
	JPanel upside;
	JPanel midside;
	JPanel downside;
	
	public InsertInfo() {
		
		// 배경색 밝은 회색
		this.setBackground(new Color(245,245,245));
		
		// 사이즈 설정 500 X 870
		this.setPreferredSize(new Dimension(500,870));
		
		// 레이아웃 설정
		this.setLayout(new BorderLayout());
		
		// border 설정
		this.setBorder(new EtchedBorder());
		
		InitComponent();
		InitPanel();
		
	}
	
	// 이 패널에 들어가는 컴포넌트들 생성하며 초기화해준다
	void InitComponent() {
		this.addButton = new JButton("추가");
		this.editButton = new JButton("수정");
		this.delButton = new JButton("삭제");

		this.attendanceEdit = new JButton("출석 수정");
		
		this.nameText = new JTextArea(); 
		this.numberText = new JTextArea();
		this.majorText = new JTextArea();
		
		this.midtermText = new JTextArea();
		this.finalText = new JTextArea();
		this.quizJTextText = new JTextArea();
		this.announcementText = new JTextArea();
		this.reportText = new JTextArea();;
		this.etcText = new JTextArea();
		
		male = new JRadioButton("male");
		female = new JRadioButton("female");
		gender = new ButtonGroup();
		gender.add(male);
		gender.add(female);
	}
	
	void InitPanel() {
		upside = new JPanel();
		midside = new JPanel();
		downside = new JPanel();
		
		upside.setPreferredSize(new Dimension(500,200));
		upside.setBackground(Color.white);
		upside.setBorder(new EtchedBorder());
		
		midside.setPreferredSize(new Dimension(500,570));
		midside.setBackground(Color.white);
		midside.setBorder(new EtchedBorder());
		
		downside.setPreferredSize(new Dimension(500,100));
		downside.setBackground(Color.white);
		downside.setBorder(new EtchedBorder());
		
		ComponentAtUpside();
		ComponentAtMidside();
		ComponentAtDownside();
		
		this.add(upside, BorderLayout.NORTH);
		this.add(midside, BorderLayout.CENTER);
		this.add(downside, BorderLayout.SOUTH);
	}
	
	// upside 패널의 컴포넌트 배치 flow borderlayout 과 grid 레이아웃 섞어서 사용하자
	void ComponentAtUpside() {
		
	}
	
	// midside 패널 컴포넌트 배치 grid 레이아웃 사용
	void ComponentAtMidside() {
		
	}
	
	// downside 패널의 컴포넌트 배치
	void ComponentAtDownside() {
		downside.setLayout(new FlowLayout(30,70,30));
		
		JPanel temp1 = new JPanel();
		temp1.setSize(163, 100);
		temp1.add(addButton);
		
		JPanel temp2 = new JPanel();
		temp2.setSize(163, 100);
		temp2.add(editButton);
		
		JPanel temp3 = new JPanel();
		temp3.setSize(163, 100);
		temp3.add(delButton);
		
		downside.add(temp1,FlowLayout.LEFT);
		downside.add(temp2,FlowLayout.CENTER);
		downside.add(temp3,FlowLayout.RIGHT);
	}
}
