import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/*<applet code="StudentFact" height=500 width=500>
</applet>*/

public class StudentFact extends Applet implements ActionListener
{	
	Label name,result;
	TextField t1,t2;
	Button fact;
	double x;
	String h,f;
	public void init()
	{
		name=new Label("Name",Label.RIGHT);
		result=new Label("Result",Label.RIGHT);
		t1=new TextField(18);
		t2=new TextField(18);
		fact=new Button("Factorial");
		
		add(name);
	
	add(t1);
	add(result);
	add(t2);
	add(fact);
t1.addActionListener(this);
t2.addActionListener(this);
fact.addActionListener(this);
}
String factorial(double m)
	{double y=1;
		for(double i=m;i>1;i--)
		{
			
			y=y*i;
			
		}
	String h=String.valueOf(y);
		t2.setText(h);
	return h;
	}		

public void actionPerformed(ActionEvent ae)
	{	String str;
		str=ae.getActionCommand();
		if(str.equals("Factorial"))
		{
			x=Integer.parseInt(t1.getText());
			f=factorial(x);
		}
	repaint();
	}
public void paint(Graphics g)
{	String s=String.valueOf(f);
	g.drawString(s,50,100);
}
}