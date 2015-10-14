import java.awt.*;
import java.awt.event.*;




public class Calculator extends Frame
{

	String msg;
	TextField t1;
	Button bList[]=new Button[15];

Calculator(String str)
{	super(str);
        setLayout(new GridLayout(4,4));
	setFont(new Font("SansSerif",Font.BOLD,24));

	t1=new TextField(18);
	
	add(t1);
	

	
	Button one=new Button("1");
	Button two=new Button("2");
	Button three=new Button("3");
	Button four=new Button("4");
	Button five=new Button("5");
	Button six=new Button("6");
Button seven=new Button("7");
Button eight=new Button("8");
Button nine=new Button("9");
Button zero=new Button("0");
Button mult=new Button("*");
Button div=new Button("/");
Button add=new Button("+");
Button sub=new Button("-");
Button equal=new Button("=");

bList[0]=(Button)add(one);
bList[1]=(Button)add(two);
bList[2]=(Button)add(three);
bList[3]=(Button)add(four);
bList[4]=(Button)add(five);
bList[5]=(Button)add(six);
bList[6]=(Button)add(seven);
bList[7]=(Button)add(eight);
bList[8]=(Button)add(nine);
bList[9]=(Button)add(zero);
bList[10]=(Button)add(mult);
bList[11]=(Button)add(div);
bList[12]=(Button)add(sub);
bList[13]=(Button)add(add);
bList[14]=(Button)add(equal);		

MyCalculatorHandler handler=new MyCalculatorHandler(this);
for(int i=0;i<15;i++)
{
	bList[i].addActionListener(handler);
}
t1.addActionListener(handler);


MyWindowAdapter adapter=new MyWindowAdapter(this);
addWindowListener(adapter);
}

public void paint(Graphics g)
{
	t1.setText(msg);
}


public static void main(String args[])
{	
	Calculator cal=new Calculator("Calculator");
	cal.setSize(new Dimension(500,600));
	cal.setTitle("Calculator");
	cal.setVisible(true);

}
}

class MyCalculatorHandler implements ActionListener
{Calculator cal;
	public MyCalculatorHandler(Calculator cal)

	{this.cal=cal;
	}
String msg="";
String x="";



public void actionPerformed(ActionEvent ae)
{
		
	msg+=ae.getActionCommand();
	cal.t1.setText(msg);
}

}

class MyWindowAdapter extends WindowAdapter
{

	Calculator cal;
public MyWindowAdapter(Calculator cal)
{ this.cal=cal;
}
public void windowClosing(WindowEvent we)
{
	cal.setVisible(false);
	System.exit(0);
}
}
