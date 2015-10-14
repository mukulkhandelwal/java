import java.awt.*;
import java.applet.*;

/*<applet code="MoveDrawing1" height=768 width=1366>
</applet>*/

public class MoveDrawing1 extends Applet implements Runnable 
{int mx1=800,mx2=600,my1=140,my2=170;
	Thread t=null;
	public void start()
{
	t=new Thread(this);
	t.start();
}

	public void run()
{while(true)
	{
	try
	{	if(mx2!=0)
			{mx1--;mx2--;
	repaint();
	Thread.sleep(5);}
		else
			{	 mx1=800;mx2=600;my1=140;my2=170;}
		
			}
		
			
	
	catch(InterruptedException e)
	{}
	}
}
	public void paint(Graphics g)
{
	g.drawLine(mx1,my1,mx2,my2);
	g.drawLine(mx1,my1+60,mx2,my2);
	g.drawRect(mx1,my1,70,60);
		
}}