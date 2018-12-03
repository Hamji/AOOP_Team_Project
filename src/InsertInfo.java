import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public class InsertInfo extends BasePanel {
	
	// 추가 수정 제거 버튼
	JButton addButton;
	JButton editButton;
	JButton delButton;
	
	// 출석 수정 버튼
	JButton attendanceEdit;
	
	public JTextField getNameText() {
		return nameText;
	}


	public void setNameText(JTextField nameText) {
		this.nameText = nameText;
	}


	public JTextField getNumberText() {
		return numberText;
	}


	public void setNumberText(JTextField numberText) {
		this.numberText = numberText;
	}


	public JTextField getMajorText() {
		return majorText;
	}


	public void setMajorText(JTextField majorText) {
		this.majorText = majorText;
	}


	public JTextField getMidtermText() {
		return midtermText;
	}


	public void setMidtermText(JTextField midtermText) {
		this.midtermText = midtermText;
	}


	public JTextField getFinalText() {
		return finalText;
	}


	public void setFinalText(JTextField finalText) {
		this.finalText = finalText;
	}


	public JTextField getQuizJTextText() {
		return quizJTextText;
	}


	public void setQuizJTextText(JTextField quizJTextText) {
		this.quizJTextText = quizJTextText;
	}


	public JTextField getAnnouncementText() {
		return announcementText;
	}


	public void setAnnouncementText(JTextField announcementText) {
		this.announcementText = announcementText;
	}


	public JTextField getReportText() {
		return reportText;
	}


	public void setReportText(JTextField reportText) {
		this.reportText = reportText;
	}


	public JTextField getEtcText() {
		return etcText;
	}


	public void setEtcText(JTextField etcText) {
		this.etcText = etcText;
	}


	public JRadioButton getMale() {
		return male;
	}


	public void setMale(JRadioButton male) {
		this.male = male;
	}


	public JRadioButton getFemale() {
		return female;
	}


	public void setFemale(JRadioButton female) {
		this.female = female;
	}

	public int[] getCheckout() {
		return checkout;
	}


	public void setCheckout(int[] checkout) {
		this.checkout = checkout;
	}

	public ButtonGroup getGender() {
		return gender;
	}


	public void setGender(ButtonGroup gender) {
		this.gender = gender;
	}

	// 이름, 학번, 학과 text area
	JTextField nameText;
	JTextField numberText;
	JTextField majorText;
	
	// 출석
	int[] checkout = new int[16];
	
	// 중간 기말 퀴즈 발표 보고서 기타 text area
	JTextField midtermText;
	JTextField finalText;
	JTextField quizJTextText;
	JTextField announcementText;
	JTextField reportText;
	JTextField etcText;
	
	// 남녀 라디오  그룹
	JRadioButton male;
	JRadioButton female;
	ButtonGroup gender;
	
	// 컴포넌트들을 보기좋게 배치하기 위한 패널
	JPanel upside;
	JPanel midside;
	JPanel downside;
	
	// 컴포넌트 폰트
	Font componentFont;
	
	// 이벤트 처리
	InsertInfoActionListener listener;
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
		componentFont = new Font("Serif",Font.BOLD,15);
		
		listener = new InsertInfoActionListener();
		
		this.addButton = new JButton("추가");
		this.editButton = new JButton("수정");
		this.delButton = new JButton("삭제");
		
		addButton.addActionListener(listener);
		editButton.addActionListener(listener);
		delButton.addActionListener(listener);
		
		this.attendanceEdit = new JButton("출석 수정");
		attendanceEdit.addActionListener(listener);
		
		this.nameText = new JTextField(10); 
		this.numberText = new JTextField(10);
		this.majorText = new JTextField(10);
		
		this.midtermText = new JTextField(10);
		this.finalText = new JTextField(10);
		this.quizJTextText = new JTextField(10);
		this.announcementText = new JTextField(10);
		this.reportText = new JTextField(10);
		this.etcText = new JTextField(10);
		
		male = new JRadioButton("남");
		female = new JRadioButton("여");
		
		male.setFont(componentFont);
		male.setFont(componentFont);
		
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
	
	// upside 패널의 컴포넌트 배치  grid 레이아웃 섞어서 사용하자
	void ComponentAtUpside() {
		upside.setLayout(new GridLayout(2,1));
		
		Font labelFontSetting = new Font("Serif",Font.BOLD, 20);
		
		JLabel nameLabel = new JLabel("이름");
		JLabel numLabel = new JLabel("학번");
		JLabel majorLabel = new JLabel("학과");
		JLabel genderLabel = new JLabel("성별");
		
		nameLabel.setFont(labelFontSetting);
		numLabel.setFont(labelFontSetting);
		majorLabel.setFont(labelFontSetting);
		genderLabel.setFont(labelFontSetting);
		
		JPanel northPane = new JPanel();
		JPanel southPane = new JPanel();
		
		northPane.setLayout(new FlowLayout(40,20,40));
		southPane.setLayout(new FlowLayout(40,20,40));
		
		northPane.add(nameLabel);
		northPane.add(nameText);
		northPane.add(numLabel);
		northPane.add(numberText);
		
		southPane.add(majorLabel);
		southPane.add(majorText);
		southPane.add(genderLabel);
		southPane.add(male);
		southPane.add(female);
		
		
		upside.add(northPane);
		upside.add(southPane);
		
	}
	
	// midside 패널 컴포넌트 배치 grid 레이아웃 사용
	void ComponentAtMidside() {
		this.midside.setLayout(new BorderLayout());
		
		JPanel leftPane = new JPanel();
		JPanel rightPane = new JPanel();
		
		leftPane.setLayout(new GridLayout(7,1));
		rightPane.setLayout(new GridLayout(7,1,20,10));
		
		leftPane.setPreferredSize(new Dimension(120,300));
		rightPane.setPreferredSize(new Dimension(350,300));
		
		leftPane.add(new JLabel("출석",SwingConstants.CENTER));
		leftPane.add(new JLabel("중간고사",SwingConstants.CENTER));
		leftPane.add(new JLabel("기말고사",SwingConstants.CENTER));
		leftPane.add(new JLabel("퀴즈 점수",SwingConstants.CENTER));
		leftPane.add(new JLabel("발표 점수",SwingConstants.CENTER));
		leftPane.add(new JLabel("보고서 점수",SwingConstants.CENTER));
		leftPane.add(new JLabel("기타 점수",SwingConstants.CENTER));
		
		rightPane.add(attendanceEdit);
		rightPane.add(midtermText);
		rightPane.add(finalText);
		rightPane.add(quizJTextText);
		rightPane.add(announcementText);
		rightPane.add(reportText);
		rightPane.add(etcText);
		
		JPanel northBlankPane = new JPanel();
		northBlankPane.setPreferredSize(new Dimension(570,100));
		JPanel southBlankPane = new JPanel();
		southBlankPane.setPreferredSize(new Dimension(570,100));
		
		this.midside.add(leftPane, BorderLayout.WEST);
		this.midside.add(rightPane, BorderLayout.CENTER);
		
		this.midside.add(northBlankPane, BorderLayout.NORTH);
		this.midside.add(southBlankPane, BorderLayout.SOUTH);
		
		
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
	
	class InsertInfoActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			if(arg0.getSource() == addButton) {
				System.out.println("추가");
				
				if( !InsertInfo.this.manage.IsInsertRight()) {
					JOptionPane.showMessageDialog(null, "잘못된 입력", "오류", JOptionPane.WARNING_MESSAGE);
				}else {
					if(InsertInfo.this.manage.IsOverLap()) {
						JOptionPane.showMessageDialog(null, "중복", "오류", JOptionPane.WARNING_MESSAGE);
						return;
					}
					manage.InsertStudent();
				}
			}else if(arg0.getSource() == editButton) {
				System.out.println("수정");
				if( InsertInfo.this.manage.IsInsertRight())
					manage.AdjustStudent();
				else 
					JOptionPane.showMessageDialog(null, "잘못된 입력", "오류", JOptionPane.WARNING_MESSAGE);
				
			}else if(arg0.getSource() == delButton) {
				System.out.println("제거");
				manage.DelStudent();
				
			}else if(arg0.getSource() == attendanceEdit) {
				System.out.println("출석수정");
				CheckOutEditFrame temp = new CheckOutEditFrame(mainFrame);
				mainFrame.setEnabled(false);
				
			}
		}	
	}
	
}
