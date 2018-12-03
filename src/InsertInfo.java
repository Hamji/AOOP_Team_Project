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
	
	// �߰� ���� ���� ��ư
	JButton addButton;
	JButton editButton;
	JButton delButton;
	
	// �⼮ ���� ��ư
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

	// �̸�, �й�, �а� text area
	JTextField nameText;
	JTextField numberText;
	JTextField majorText;
	
	// �⼮
	int[] checkout = new int[16];
	
	// �߰� �⸻ ���� ��ǥ ���� ��Ÿ text area
	JTextField midtermText;
	JTextField finalText;
	JTextField quizJTextText;
	JTextField announcementText;
	JTextField reportText;
	JTextField etcText;
	
	// ���� ����  �׷�
	JRadioButton male;
	JRadioButton female;
	ButtonGroup gender;
	
	// ������Ʈ���� �������� ��ġ�ϱ� ���� �г�
	JPanel upside;
	JPanel midside;
	JPanel downside;
	
	// ������Ʈ ��Ʈ
	Font componentFont;
	
	// �̺�Ʈ ó��
	InsertInfoActionListener listener;
	public InsertInfo() {
		
		// ���� ���� ȸ��
		this.setBackground(new Color(245,245,245));
		
		// ������ ���� 500 X 870
		this.setPreferredSize(new Dimension(500,870));
		
		// ���̾ƿ� ����
		this.setLayout(new BorderLayout());
		
		// border ����
		this.setBorder(new EtchedBorder());
		
		InitComponent();
		InitPanel();
		
	}
	

	// �� �гο� ���� ������Ʈ�� �����ϸ� �ʱ�ȭ���ش�
	void InitComponent() {
		componentFont = new Font("Serif",Font.BOLD,15);
		
		listener = new InsertInfoActionListener();
		
		this.addButton = new JButton("�߰�");
		this.editButton = new JButton("����");
		this.delButton = new JButton("����");
		
		addButton.addActionListener(listener);
		editButton.addActionListener(listener);
		delButton.addActionListener(listener);
		
		this.attendanceEdit = new JButton("�⼮ ����");
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
		
		male = new JRadioButton("��");
		female = new JRadioButton("��");
		
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
	
	// upside �г��� ������Ʈ ��ġ  grid ���̾ƿ� ��� �������
	void ComponentAtUpside() {
		upside.setLayout(new GridLayout(2,1));
		
		Font labelFontSetting = new Font("Serif",Font.BOLD, 20);
		
		JLabel nameLabel = new JLabel("�̸�");
		JLabel numLabel = new JLabel("�й�");
		JLabel majorLabel = new JLabel("�а�");
		JLabel genderLabel = new JLabel("����");
		
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
	
	// midside �г� ������Ʈ ��ġ grid ���̾ƿ� ���
	void ComponentAtMidside() {
		this.midside.setLayout(new BorderLayout());
		
		JPanel leftPane = new JPanel();
		JPanel rightPane = new JPanel();
		
		leftPane.setLayout(new GridLayout(7,1));
		rightPane.setLayout(new GridLayout(7,1,20,10));
		
		leftPane.setPreferredSize(new Dimension(120,300));
		rightPane.setPreferredSize(new Dimension(350,300));
		
		leftPane.add(new JLabel("�⼮",SwingConstants.CENTER));
		leftPane.add(new JLabel("�߰����",SwingConstants.CENTER));
		leftPane.add(new JLabel("�⸻���",SwingConstants.CENTER));
		leftPane.add(new JLabel("���� ����",SwingConstants.CENTER));
		leftPane.add(new JLabel("��ǥ ����",SwingConstants.CENTER));
		leftPane.add(new JLabel("���� ����",SwingConstants.CENTER));
		leftPane.add(new JLabel("��Ÿ ����",SwingConstants.CENTER));
		
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
	
	// downside �г��� ������Ʈ ��ġ
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
				System.out.println("�߰�");
				
				if( !InsertInfo.this.manage.IsInsertRight()) {
					JOptionPane.showMessageDialog(null, "�߸��� �Է�", "����", JOptionPane.WARNING_MESSAGE);
				}else {
					if(InsertInfo.this.manage.IsOverLap()) {
						JOptionPane.showMessageDialog(null, "�ߺ�", "����", JOptionPane.WARNING_MESSAGE);
						return;
					}
					manage.InsertStudent();
				}
			}else if(arg0.getSource() == editButton) {
				System.out.println("����");
				if( InsertInfo.this.manage.IsInsertRight())
					manage.AdjustStudent();
				else 
					JOptionPane.showMessageDialog(null, "�߸��� �Է�", "����", JOptionPane.WARNING_MESSAGE);
				
			}else if(arg0.getSource() == delButton) {
				System.out.println("����");
				manage.DelStudent();
				
			}else if(arg0.getSource() == attendanceEdit) {
				System.out.println("�⼮����");
				CheckOutEditFrame temp = new CheckOutEditFrame(mainFrame);
				mainFrame.setEnabled(false);
				
			}
		}	
	}
	
}
