import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;


public class MainFrame extends BaseFrame{
	
	// ����, ����, ��� �޴�
	JMenu fileMenu;
	JMenu manageMenu;
	JMenu resultMenu;
	
	JMenuItem fileMenuList[];
	JMenuItem manageMenuList[];
	JMenuItem resultMenuList[];
	
	InsertInfo insertInfo;
	InfoList infoList;
	
	FileMenuActionListener fileListen;
	ManageMenuActionListener manageListen;
	
	ProgramManager manage = new ProgramManager();
	
	public MainFrame() {
		///////////���� ������ ������//////////// 
		
		this.setTitle("���� ó�� ���α׷�");
		
		// ũ�� 1600 900
		this.setSize(1600, 900);
		// Layout : BorderLayout
		this.setLayout(new BorderLayout());
		// MainFrame resize ���� �Ұ��� �ϵ���
		this.setResizable(false);
		// MainFrame �� ������ Gray
		this.setBackground(Color.GRAY);
		////////////////////////////////
		
		
		/////////////�޴� �� ����////////////////
		JMenuBar mainBar = new JMenuBar();
		mainBar.setSize(1600, 30);
		mainBar.setBorder(new EtchedBorder());
		
		this.SetMenuList();
		
		mainBar.add(fileMenu);
		mainBar.add(manageMenu);
		mainBar.add(resultMenu);
		/////////////////////////////////////
		
		// ���ι� �߰�
		this.add(mainBar,BorderLayout.NORTH);
		
		// �г� ��ġ
		insertInfo = new InsertInfo();
		insertInfo.mainFrame = this;
		insertInfo.manage = manage;
		
		infoList = new InfoList();
		infoList.mainFrame = this;
		infoList.manage = manage;
		
		this.add(insertInfo,BorderLayout.EAST);
		this.add(infoList,BorderLayout.WEST);
		////////////////////
		
		manage.setInfoList(infoList);
		manage.setInsertInfo(insertInfo);
		manage.setMain(this);
		
		//X â ����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ���̵��� set visible
		this.setVisible(true);
	}
	
	// �޴� ����Ʈ ����
	void SetMenuList() {
		// ���ϸ޴�
		fileMenu = new JMenu("����");
		fileMenuList = new JMenuItem[3];
		
		fileMenuList[0] = new JMenuItem("���� �����");
		fileMenuList[1] = new JMenuItem("����");
		fileMenuList[2] = new JMenuItem("����");
		
		fileListen = new FileMenuActionListener();
		manageListen = new ManageMenuActionListener();
		
		for(int i = 0; i < fileMenuList.length;i++) {
			fileMenu.add(fileMenuList[i]);
		}
		
		fileMenuList[0].addActionListener(fileListen);
		fileMenuList[1].addActionListener(fileListen);
		fileMenuList[2].addActionListener(fileListen);
		
		// ���� �޴�
		manageMenu = new JMenu("����");
		manageMenuList = new JMenuItem[3];
	
		manageMenuList[0] = new JMenuItem("�⼮ �ϰ� ó��");
		manageMenuList[1] = new JMenuItem("�����ݿ� ���� ����");
		manageMenuList[2] = new JMenuItem("��� ���� ����");
		
		for(int i = 0; i < manageMenuList.length;i++)
			manageMenu.add(manageMenuList[i]);
		
		manageMenuList[0].addActionListener(manageListen);
		manageMenuList[1].addActionListener(manageListen);
		manageMenuList[2].addActionListener(manageListen);
		
		// ��� �޴�
		resultMenu = new JMenu("���");
		resultMenuList = new JMenuItem[2];
		
		resultMenuList[0] = new JMenuItem("��� ����");
		resultMenuList[1] = new JMenuItem("�׷��� ����");
		
		for(int i = 0; i < resultMenuList.length;i++)
			resultMenu.add(resultMenuList[i]);
	}
	

	public void ResetFrame() {
///////////���� ������ ������//////////// 
		
		this.setTitle("���� ó�� ���α׷�");
		
		// ũ�� 1600 900
		this.setSize(1600, 900);
		// Layout : BorderLayout
		this.setLayout(new BorderLayout());
		// MainFrame resize ���� �Ұ��� �ϵ���
		this.setResizable(false);
		// MainFrame �� ������ Gray
		this.setBackground(Color.GRAY);
		////////////////////////////////
		
		
		/////////////�޴� �� ����////////////////
		JMenuBar mainBar = new JMenuBar();
		mainBar.setSize(1600, 30);
		mainBar.setBorder(new EtchedBorder());
		
		this.SetMenuList();
		
		mainBar.add(fileMenu);
		mainBar.add(manageMenu);
		mainBar.add(resultMenu);
		/////////////////////////////////////
		
		// ���ι� �߰�
		this.add(mainBar,BorderLayout.NORTH);
		
		// �г� ��ġ
		insertInfo = new InsertInfo();
		infoList = new InfoList();
		
		
		this.add(insertInfo,BorderLayout.EAST);
		this.add(infoList,BorderLayout.WEST);
		////////////////////
		
		
		
		//X â ����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ���̵��� set visible
		this.setVisible(true);
	}
	
	class FileMenuActionListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == fileMenuList[0]) {
				// ���θ����
				System.out.print("���� �����");
				new MainFrame();
				MainFrame.this.dispose();
			}else if(e.getSource() == fileMenuList[1]) {
				// ����
				
			}else if(e.getSource() == fileMenuList[2]) {
				// ����
			}
		}
	}

	class ManageMenuActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == manageMenuList[0]) {
				System.out.println("�⼮ �ϰ�ó��");
				BaseFrame temp = new BatchProcessFrame();
				temp.mainFrame = MainFrame.this;
				MainFrame.this.setEnabled(false);
				
			}else if(e.getSource() == manageMenuList[1]) {
				System.out.println("���� �ݿ����� ����");
				ScoreRatioFrame temp = new ScoreRatioFrame();
				temp.mainFrame = MainFrame.this;
				MainFrame.this.setEnabled(false);
				
			}else if(e.getSource() == manageMenuList[2]) {
				System.out.println("��� ���� ����");
				GradeRatioFrame temp = new GradeRatioFrame();
				temp.mainFrame = MainFrame.this;
				MainFrame.this.setEnabled(false);
				
			}
		}
	}
}
