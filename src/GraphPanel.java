import java.awt.Color;
import java.awt.Graphics;

public class GraphPanel extends BasePanel{
	
	int[] percent = {20,20,20,20,20};
	int[] ratio = {0,0,0,0,0};
	
	public GraphPanel() {
		this.setBackground(Color.white);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(new Color(0,200,250));
		g.drawLine(0, 0,0, 400);
		
		
		//g.setColor(Color.RED);
		//g.fillArc(100, 10, 250, 250, 0,60 );
		//g.setColor(Color.blue);
		//g.fillArc(100, 10, 250, 250, 60, 60);
		//g.setColor(Color.yellow);
		//g.fillArc(100, 10, 250, 250, 120, 60);
		//g.setColor(Color.green);
		//g.fillArc(100, 10, 250, 250, 180, 60);
		//g.setColor(Color.gray);
		//g.fillArc(100, 10, 250, 250, 240, 60);
		//g.setColor(Color.pink);
		//g.fillArc(100, 10, 250, 250, 300, 30);
		//g.setColor(Color.black);
		//g.fillArc(100, 10, 250, 250, 330, 30);
		
		
		g.setColor(Color.RED);
		g.fillArc(100, 80, 250, 250, 0,PercentToRatio(percent[0]));
		g.setColor(Color.BLUE);
		g.fillArc(100, 80, 250, 250, PercentToRatio(percent[0])+1, PercentToRatio(percent[1]));
		g.setColor(Color.YELLOW);
		g.fillArc(100, 80, 250, 250, PercentToRatio(percent[0])+PercentToRatio(percent[1])+1, PercentToRatio(percent[2]));
		g.setColor(Color.GREEN);
		g.fillArc(100, 80, 250, 250, PercentToRatio(percent[0])+PercentToRatio(percent[1])+PercentToRatio(percent[2])+1, PercentToRatio(percent[3]));
		g.setColor(Color.CYAN);
		g.fillArc(100, 80, 250, 250,PercentToRatio(percent[0])+PercentToRatio(percent[1])+PercentToRatio(percent[2])+PercentToRatio(percent[3])+1, PercentToRatio(percent[4]));
		
		
		
	}
	
	public int PercentToRatio(int percent) {
		int angle = 360 * percent / 100;
		
		return angle;
	}
}
