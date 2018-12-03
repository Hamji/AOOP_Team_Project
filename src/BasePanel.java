import javax.swing.JPanel;

public class BasePanel extends JPanel{
	protected MainFrame mainFrame;
	protected ProgramManager manage;
	public ProgramManager getManage() {
		return manage;
	}
	public void setManage(ProgramManager manage) {
		this.manage = manage;
	}
}
