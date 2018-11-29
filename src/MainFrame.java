import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;

public class MainFrame extends JFrame {
	
	// 파일, 관리, 결과 메뉴
	JMenu fileMenu;
	JMenu manageMenu;
	JMenu resultMenu;
	
	JMenuItem fileMenuList[];
	JMenuItem manageMenuList[];
	JMenuItem resultMenuList[];
	
	JPanel insertInfo;
	JScrollPane infoList;
	
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
		infoList = new InfoList();
		
		this.add(insertInfo,BorderLayout.EAST);
		this.add(infoList,BorderLayout.WEST);
		
		////////////////////
		
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
		
		for(int i = 0; i < fileMenuList.length;i++)
			fileMenu.add(fileMenuList[i]);
		
		
		// 관리 메뉴
		manageMenu = new JMenu("관리");
		manageMenuList = new JMenuItem[3];
	
		manageMenuList[0] = new JMenuItem("출석 일괄 처리");
		manageMenuList[1] = new JMenuItem("성적반영 비율 설정");
		manageMenuList[2] = new JMenuItem("등급 비율 설정");
		
		for(int i = 0; i < manageMenuList.length;i++)
			manageMenu.add(manageMenuList[i]);
		
		// 결과 메뉴
		resultMenu = new JMenu("결과");
		resultMenuList = new JMenuItem[2];
		
		resultMenuList[0] = new JMenuItem("결과 보기");
		resultMenuList[1] = new JMenuItem("그래프 보기");
		
		for(int i = 0; i < resultMenuList.length;i++)
			resultMenu.add(resultMenuList[i]);
	}
}
