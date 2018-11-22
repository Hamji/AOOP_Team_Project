import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	
	// ����, ����, ��� �޴�
	JMenu fileMenu;
	JMenu manageMenu;
	JMenu resultMenu;
	
	JMenuItem fileMenuList[];
	JMenuItem manageMenuList[];
	JMenuItem resultMenuList[];
	
	public MainFrame() {
		///////////���� ������ ������//////////// 
		
		this.setTitle("���� ó�� ���α׷�");
		
		// ũ�� 1600 900
		this.setSize(1600, 900);
		
		// MainFrame resize ���� �Ұ��� �ϵ���
		this.setResizable(false);
		
		////////////////////////////////
		
		
		/////////////�޴� �� ����////////////////
		JMenuBar mainBar = new JMenuBar();
		mainBar.setSize(1600, 30);
		
		this.SetMenuList();
		
		mainBar.add(fileMenu);
		mainBar.add(manageMenu);
		mainBar.add(resultMenu);
		
		
		this.add(mainBar);
		this.add(new JPanel());
	
		////////////////////
		
		
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
		
		for(int i = 0; i < fileMenuList.length;i++)
			fileMenu.add(fileMenuList[i]);
		
		
		// ���� �޴�
		manageMenu = new JMenu("����");
		manageMenuList = new JMenuItem[3];
	
		manageMenuList[0] = new JMenuItem("�⼮ �ϰ� ó��");
		manageMenuList[1] = new JMenuItem("�����ݿ� ���� ����");
		manageMenuList[2] = new JMenuItem("��� ���� ����");
		
		for(int i = 0; i < manageMenuList.length;i++)
			manageMenu.add(manageMenuList[i]);
		
		// ��� �޴�
		resultMenu = new JMenu("���");
		resultMenuList = new JMenuItem[2];
		
		resultMenuList[0] = new JMenuItem("��� ����");
		resultMenuList[1] = new JMenuItem("�׷��� ����");
		
		for(int i = 0; i < resultMenuList.length;i++)
			resultMenu.add(resultMenuList[i]);
	}
}
