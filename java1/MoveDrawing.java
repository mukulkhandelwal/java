import java.awt.*;
import java.applet.*;

/*<applet code="MoveDrawing" height=500 width=500>
</applet>*/

public class MoveDrawing extends Applet implements Runnable 
{int mx1=350,mx2=200,my1=140,my2=170;
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
	{	if(mx1!=0){mx1--;mx2--;
	repaint();
	Thread.sleep(5);}
		else
			mx1=350;mx2=200;my1=140;my2=170;
	}
	catch(InterruptedException e)
	{}
	}
}
	public void paint(Graphics g)
{if(mx1!=0){
	g.drawLine(mx1,my1,mx2,my2);
	g.drawLine(mx1,my1+60,mx2,my2);
	g.drawRect(mx1,my1,70,60);
	}
else	
	if(mx2==0){mx1++;mx2++;
		g.drawLine(mx1,my1,mx2,my2);
	g.drawLine(mx1,my1+60,mx2,my2);
	g.drawRect(mx1,my1,70,60);}
			
}	
}