import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/*<applet code="ListDemo" height=400 width=400>
</applet> */

public class ListDemo extends Applet implements ActionListener
{

	List os,browser;
	String msg;
	
public void init(){
	os=new List(4,true);
	browser=new List(4,false);
	os.add("Windows xp");
	os.add("Windows Vista");
	os.add("Mac Os");
	os.add("Solaris");
	browser.add("firefox");
	browser.add("opera");
	browser.add("Google Chrome");

add(os);
	add(browser);

os.addActionListener(this);
browser.addActionListener(this);
}

public void actionPerformed(ActionEvent ae)
{
repaint();
}

public void paint(Graphics g)
{
	int idx[];
	msg="Current OS:";
	idx=os.getSelectedIndexes();
	for(int i=0;i<idx.length;i++)
	msg+=os.getItem(idx[i])+" ";
	g.drawString(msg,10,120);

	msg="Current Browser: ";
	msg+=browser.getSelectedItem();
	g.drawString(msg,10,140);
}
}