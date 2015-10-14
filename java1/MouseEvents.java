import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*<applet code="MouseEvents" width=500 height=500>
</applet>*/

public class MouseEvents extends Applet implements MouseListener,MouseMotionListener
{	
	String msg=" ";
	int mouseX=0,mouseY=0;
	public void init()
	{
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	public void mouseClicked(MouseEvent me)
	{
		mouseX=0;
		mouseY=10;
		msg="mouse  clicked";
	repaint();
	}

	public void mousePressed(MouseEvent me)
	{
		mouseX=me.getX();
		mouseY=me.getY();
		msg="mouse pressed";
		repaint();
	}

	public void mouseEntered(MouseEvent me)
	{
		mouseX=0;
		mouseY=10;
		msg="mouse entered";
		repaint();
	}

	public void mouseExited(MouseEvent me)
	{
		mouseX=0;
		mouseY=10;
		msg="mouse Exited";
		repaint();
	}

	public void mouseReleased(MouseEvent me)
	{
		mouseX=me.getX();
		mouseY=me.getY();
		msg="mouse Released";
		repaint();	
	}
			
	public void mouseMoved(MouseEvent me)
	{
		showStatus("mouse moving at "+me.getX()+", "+me.getY());
	}

	public void mouseDragged(MouseEvent me)
	{
		mouseX=me.getX();
		mouseY=me.getY();
		showStatus("mouse Dragged: "+mouseX+","+mouseY);
	}

	public void paint(Graphics g)
	{
		g.drawString(msg,mouseX,mouseY);
	}
}		