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
	
	// �߰� ���� ���� ��ư
	JButton addButton;
	JButton editButton;
	JButton delButton;
	
	// �⼮ ���� ��ư
	JButton attendanceEdit;
	
	// �̸�, �й�, �а� text area
	JTextArea nameText;
	JTextArea numberText;
	JTextArea majorText;
	
	// �߰� �⸻ ���� ��ǥ ���� ��Ÿ text area
	JTextArea midtermText;
	JTextArea finalText;
	JTextArea quizJTextText;
	JTextArea announcementText;
	JTextArea reportText;
	JTextArea etcText;
	
	// ���� ����  �׷�
	JRadioButton male;
	JRadioButton female;
	ButtonGroup gender;
	
	// ������Ʈ���� �������� ��ġ�ϱ� ���� �г�
	JPanel upside;
	JPanel midside;
	JPanel downside;
	
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
		this.addButton = new JButton("�߰�");
		this.editButton = new JButton("����");
		this.delButton = new JButton("����");

		this.attendanceEdit = new JButton("�⼮ ����");
		
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
	
	// upside �г��� ������Ʈ ��ġ flow borderlayout �� grid ���̾ƿ� ��� �������
	void ComponentAtUpside() {
		
	}
	
	// midside �г� ������Ʈ ��ġ grid ���̾ƿ� ���
	void ComponentAtMidside() {
		
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
}
