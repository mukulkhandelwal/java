import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*<applet code="MovingSmiley2" height=500 width=500>
</applet> */

public class MovingSmiley2 extends Applet implements MouseMotionListener

{int mx,my;
	public void init(){
	addMouseMotionListener(this);
}
	public void mouseMoved(MouseEvent me)
{	mx=me.getX();
	my=me.getY();
	repaint();
}
	public void mouseDragged(MouseEvent me)
{}
	public void paint(Graphics g)
	{
		Color c1=new Color(246,184,14);
		g.setColor(c1);
		g.fillOval(mx,my,100,100);
		
		g.setColor(Color.black);
		g.fillOval(mx+15,my+30,20,20);
		g.fillOval(mx+65,my+30,20,20);

		g.drawArc(mx+25,my+55,50,25,0,-180);
	}	
}