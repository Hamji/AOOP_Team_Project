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
	
	// 파일, 관리, 결과 메뉴
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
		///////////메인 프레임 설정들//////////// 
		
		this.setTitle("성적 처리 프로그램");
		
		// 크기 1600 900
		this.setSize(1600, 900);
		// Layout : BorderLayout
		this.setLayout(new BorderLayout());
		// MainFrame resize 설정 불가능 하도록
		this.setResizable(false);
		// MainFrame 의 배경색은 Gray
		this.setBackground(Color.GRAY);
		////////////////////////////////
		
		
		/////////////메뉴 바 설정////////////////
		JMenuBar mainBar = new JMenuBar();
		mainBar.setSize(1600, 30);
		mainBar.setBorder(new EtchedBorder());
		
		this.SetMenuList();
		
		mainBar.add(fileMenu);
		mainBar.add(manageMenu);
		mainBar.add(resultMenu);
		/////////////////////////////////////
		
		// 메인바 추가
		this.add(mainBar,BorderLayout.NORTH);
		
		// 패널 설치
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
		
		//X 창 종료
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 보이도록 set visible
		this.setVisible(true);
	}
	
	// 메뉴 리스트 구현
	void SetMenuList() {
		// 파일메뉴
		fileMenu = new JMenu("파일");
		fileMenuList = new JMenuItem[3];
		
		fileMenuList[0] = new JMenuItem("새로 만들기");
		fileMenuList[1] = new JMenuItem("열기");
		fileMenuList[2] = new JMenuItem("저장");
		
		fileListen = new FileMenuActionListener();
		manageListen = new ManageMenuActionListener();
		
		for(int i = 0; i < fileMenuList.length;i++) {
			fileMenu.add(fileMenuList[i]);
		}
		
		fileMenuList[0].addActionListener(fileListen);
		fileMenuList[1].addActionListener(fileListen);
		fileMenuList[2].addActionListener(fileListen);
		
		// 관리 메뉴
		manageMenu = new JMenu("관리");
		manageMenuList = new JMenuItem[3];
	
		manageMenuList[0] = new JMenuItem("출석 일괄 처리");
		manageMenuList[1] = new JMenuItem("성적반영 비율 설정");
		manageMenuList[2] = new JMenuItem("등급 비율 설정");
		
		for(int i = 0; i < manageMenuList.length;i++)
			manageMenu.add(manageMenuList[i]);
		
		manageMenuList[0].addActionListener(manageListen);
		manageMenuList[1].addActionListener(manageListen);
		manageMenuList[2].addActionListener(manageListen);
		
		// 결과 메뉴
		resultMenu = new JMenu("결과");
		resultMenuList = new JMenuItem[2];
		
		resultMenuList[0] = new JMenuItem("결과 보기");
		resultMenuList[1] = new JMenuItem("그래프 보기");
		
		for(int i = 0; i < resultMenuList.length;i++)
			resultMenu.add(resultMenuList[i]);
	}
	

	public void ResetFrame() {
///////////메인 프레임 설정들//////////// 
		
		this.setTitle("성적 처리 프로그램");
		
		// 크기 1600 900
		this.setSize(1600, 900);
		// Layout : BorderLayout
		this.setLayout(new BorderLayout());
		// MainFrame resize 설정 불가능 하도록
		this.setResizable(false);
		// MainFrame 의 배경색은 Gray
		this.setBackground(Color.GRAY);
		////////////////////////////////
		
		
		/////////////메뉴 바 설정////////////////
		JMenuBar mainBar = new JMenuBar();
		mainBar.setSize(1600, 30);
		mainBar.setBorder(new EtchedBorder());
		
		this.SetMenuList();
		
		mainBar.add(fileMenu);
		mainBar.add(manageMenu);
		mainBar.add(resultMenu);
		/////////////////////////////////////
		
		// 메인바 추가
		this.add(mainBar,BorderLayout.NORTH);
		
		// 패널 설치
		insertInfo = new InsertInfo();
		infoList = new InfoList();
		
		
		this.add(insertInfo,BorderLayout.EAST);
		this.add(infoList,BorderLayout.WEST);
		////////////////////
		
		
		
		//X 창 종료
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 보이도록 set visible
		this.setVisible(true);
	}
	
	class FileMenuActionListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == fileMenuList[0]) {
				// 새로만들기
				System.out.print("새로 만들기");
				new MainFrame();
				MainFrame.this.dispose();
			}else if(e.getSource() == fileMenuList[1]) {
				// 열기
				
			}else if(e.getSource() == fileMenuList[2]) {
				// 저장
			}
		}
	}

	class ManageMenuActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == manageMenuList[0]) {
				System.out.println("출석 일괄처리");
				BaseFrame temp = new BatchProcessFrame();
				temp.mainFrame = MainFrame.this;
				MainFrame.this.setEnabled(false);
				
			}else if(e.getSource() == manageMenuList[1]) {
				System.out.println("성적 반영비율 설정");
				ScoreRatioFrame temp = new ScoreRatioFrame();
				temp.mainFrame = MainFrame.this;
				MainFrame.this.setEnabled(false);
				
			}else if(e.getSource() == manageMenuList[2]) {
				System.out.println("등급 비율 설정");
				GradeRatioFrame temp = new GradeRatioFrame();
				temp.mainFrame = MainFrame.this;
				MainFrame.this.setEnabled(false);
				
			}
		}
	}
}
