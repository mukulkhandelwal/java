import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import java.util.*;
import java.lang.*;



class SampleDialog extends Dialog implements ActionListener {
String signal;
Notepad note;
 SampleDialog(Notepad note, String title) {
 super(note, title, false); 
setLayout(new FlowLayout()); 
setSize(300, 200);
this.note=note;
add(new Label("Press this button:")); 
Button b1,b2,b3; 
add(b1=new Button("Save"));
add(b2=new Button("Don't Save"));
add(b3=new Button("Cancel"));
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
}
public void actionPerformed(ActionEvent ae)
{
	signal=ae.getActionCommand();
	
	if(signal.equals("Save"))
	{
	
		try{
		FileDialog fd = new FileDialog(note, " Save File ",FileDialog.SAVE);
		fd.setVisible(true);
		String text = note.txt.getText();
		String dir = fd.getDirectory();
		String fname = fd.getFile();
		FileOutputStream fos = new FileOutputStream(dir+fname);
		DataOutputStream dos = new DataOutputStream(fos);
		dos.writeBytes(text);
		dos.close();
		
		}catch(Exception e){}
		setVisible(false);
	}	
	else
	if(signal.equals("Don't Save"))
	{	
		note.txt.setText("");	
		setVisible(false);
	}
	
	else
		{
			setVisible(false);
			
		}
}
}
public class Notepad extends Frame
{
int i;
TextField t1,t2;
String text="", f="" ,r="";

TextArea txt;
String msg="";
MenuBar mbar;
int x,y;
Menu File,Edit,Format,View,Help;
MenuItem item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16,item17,item18,item19,item20,item21,item22,item23,item24;
CheckboxMenuItem WordWrap;

public Notepad(String title)
{
	super(title);
	mbar=new MenuBar();
	setMenuBar(mbar);
	
	File=new Menu("File");
	Edit=new Menu("Edit");
	Format=new Menu("Format");
	View=new Menu("View");
	Help=new Menu("Help");
		

	item1=new MenuItem("New");
	item2=new MenuItem("Open");
	item3=new MenuItem("Save");
	item4=new MenuItem("Save As");
	item5=new MenuItem("-");
	item6=new MenuItem("Page Setup");
	item7=new MenuItem("Print");
	item8=new MenuItem("-");
	item9=new MenuItem("Exit");
	
	File.add(item1);
	File.add(item2);
	File.add(item3);
	File.add(item4);
	File.add(item5);
	File.add(item6);
	File.add(item7);
	File.add(item8);
	File.add(item9);
	mbar.add(File);

	item10=new MenuItem("Undo");
	item11=new MenuItem("-");
	item12=new MenuItem("Cut");
	item13=new MenuItem("Copy");
	item14=new MenuItem("Paste");
	item15=new MenuItem("Delete");
	item16=new MenuItem("Find");
	item17=new MenuItem("Find Next");
	item18=new MenuItem("Replace");
	item19=new MenuItem("SelectAll");
	item20=new MenuItem("Time-Date");
	
	Edit.add(item10);
	Edit.add(item11);
	Edit.add(item12);
	Edit.add(item13);
	Edit.add(item14);
	Edit.add(item15);
	Edit.add(item16);
	Edit.add(item17);
	Edit.add(item18);
	Edit.add(item19);
	Edit.add(item20);
	mbar.add(Edit);

	
WordWrap=new CheckboxMenuItem("WordWrap");

	item21=new MenuItem("Font");
	Format.add(WordWrap);
	Format.add(item21);
	mbar.add(Format);

	item22=new MenuItem("StatusBar");
	View.add(item22);
	mbar.add(View);	

	item23=new MenuItem("View Help");
	item24=new MenuItem("About MukulPad");

	Help.add(item23);
	Help.add(item24);
	mbar.add(Help);

	txt=new TextArea(msg);
	add(txt);



MyMenuHandler handler=new MyMenuHandler(this);
item1.addActionListener(handler);
item2.addActionListener(handler);
item3.addActionListener(handler);
item4.addActionListener(handler);
item5.addActionListener(handler);
item6.addActionListener(handler);
item7.addActionListener(handler);
item8.addActionListener(handler);
item9.addActionListener(handler);
item10.addActionListener(handler);
item11.addActionListener(handler);
item12.addActionListener(handler);
item13.addActionListener(handler);
item14.addActionListener(handler);
item15.addActionListener(handler);
item16.addActionListener(handler);
item17.addActionListener(handler);
item18.addActionListener(handler);
item19.addActionListener(handler);
item20.addActionListener(handler);
item21.addActionListener(handler);
item22.addActionListener(handler);
item23.addActionListener(handler);
item24.addActionListener(handler);

WordWrap.addItemListener(handler);

MyWindowAdapter adapter=new MyWindowAdapter(this);
addWindowListener(adapter);
MyMouseHandler mousehandler=new MyMouseHandler(this);
	addMouseListener(mousehandler);
}

public void paint(Graphics g)
{msg="Hello";
g.drawString(msg,400,400);


}



public static void main(String args[])
{		
	
	Notepad note=new Notepad("Notepad");
	note.setSize(new Dimension(500,600));
	note.setTitle("Untited");   /*name of save file*/
	note.setVisible(true);
}
}

class MyWindowAdapter extends WindowAdapter
{

Notepad note;

public MyWindowAdapter(Notepad note)
{
	this.note=note;
}
public void windowClosing(WindowEvent we)
{
	
	SampleDialog sam=new SampleDialog(note,"New Dialog Box");
	
	sam.setVisible(true);
	note.setVisible(false);
	System.exit(0); 
}
}

class MyMenuHandler implements ActionListener,ItemListener
{
Notepad note;
String text,text1;

int i;
	public MyMenuHandler(Notepad note)
{
	this.note=note;
	
}

public void actionPerformed(ActionEvent ae)
{
	String msg=ae.getActionCommand();
	note.repaint();

	if(msg.equals("New"))
{	SampleDialog sam=new SampleDialog(note,"New Dialog Box");
	
	sam.setVisible(true);

}
	else
	
	if(msg.equals("Open"))
{try{
		FileDialog fd = new FileDialog(note,"Open File",FileDialog.LOAD);
		fd.setVisible(true);
		String dir = fd.getDirectory();
		String fname = fd.getFile();
		FileInputStream fis = new FileInputStream(dir+fname);
		DataInputStream dis = new DataInputStream(fis);
		String str = "" , mesg = "";
		while((str = dis.readLine())!=null)
		{
			mesg = mesg+str;
			mesg +="\n"; 
		}
		note.txt.setText(mesg);
		dis.close();
	}catch(Exception e){}


}
	else
	
	if(msg.equals("Save"))
{
}
	else
	
	if(msg.equals("Save As"))
{FileDialog fd = new FileDialog(note, "File Dialog");
fd.setVisible(true);
}
	else
	
	if(msg.equals("Page Setup"))
{note.msg="Hello World";
}
	else
	
	if(msg.equals("Print"))
{note.msg="Hello World";
}
	else
	
	if(msg.equals("Exit"))
{note.setVisible(false);
	System.exit(0);
}
	else
	
	if(msg.equals("Undo"))
{note.msg="Hello World";
}
	else
	
	if(msg.equals("Cut"))
{ 	text=note.txt.getText();

	text1=note.txt.getSelectedText();
	
	i=text.indexOf(text1);
	text=text.substring(0,i)+text.substring(i+text1.length());
	note.txt.setText(text);

}
	else
	
	if(msg.equals("Copy"))
{	text1=note.txt.getSelectedText();
}
	else
	
	if(msg.equals("Paste"))
{	text=text.substring(0,note.x)+text1+text.substring(note.x);
	note.txt.setText(text);
    
}
	else
	
	if(msg.equals("Delete"))
{note.msg="Hello World";
}
	else
	
	if(msg.equals("Find"))
{		
		note.i = text.indexOf(note.f);
		note.txt.select(note.i-1,note.i+note.f.length()-1);
}
	else
	
	if(msg.equals("Find Next"))
{int c=1;
	note.f = note.t1.getText();
		note.i = note.text.indexOf(note.f,c);
		note.txt.select(note.i-1,note.i+note.f.length()-1);
		c++;
}
	else
	
	if(msg.equals("Replace"))
{FindDialog fid=new FindDialog(note,"Replace");
	fid.setVisible(true);
}
	else
	
	if(msg.equals("SelectAll"))
{note.txt.select(0,text.length());
}
	else
	
	if(msg.equals("Time-Date"))
{Date date = new Date();
    text = note.txt.getText();
    text1 = date.toString();
    note.txt.setText(text + text1);
}
	else
	
	if(msg.equals("Font"))
{
	Frame f = new Fontframe("Font");
	f.setVisible(true);
	f.setSize(200,150);
}
	else
	
	if(msg.equals("StatusBar"))
{note.msg="Hello World";
}
	else
	
	if(msg.equals("View Help"))
{	
}
	else
	
	if(msg.equals("About MukulPad"))
{Frame f = new Aboutframe("About Notepad");
	f.setVisible(true);
	f.setSize(300,200);
}
	else
	
	if(msg.equals("WordWrap"))
{
}
}
public void itemStateChanged(ItemEvent ie)
{
/*fill after*/

note.msg="java";
note.repaint();
}

}

class MyMouseHandler extends MouseAdapter
{	Notepad aref;
	
	MyMouseHandler(Notepad aref)
	{this.aref=aref;
	}	

	public void mousePressed(MouseEvent me)
	{
		aref.x=me.getX();
		aref.y=me.getY();
	}
}

	

class FindDialog extends Dialog implements ActionListener {
String signal;

Notepad note;

 FindDialog(Notepad note, String title) {
 super(note, title, false); 
setLayout(new FlowLayout()); 
setSize(300, 200);
this.note=note;

add(new Label("Find (Enter the word)")); 
note.t1 = new TextField(10);
add(note.t1);
Button b1,b2,b3; 
add(new Label("Replace (Enter the word)")); 
note.t2 = new TextField(10);
add(note.t2);
add(b1=new Button("Find"));
add(b2=new Button("Replace"));
add(b3=new Button("Close"));
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
note.t1.addActionListener(this);
note.t2.addActionListener(this);
}
public void actionPerformed(ActionEvent ae)
{
	signal=ae.getActionCommand();
	note.text = note.txt.getText();
	if(signal.equals("Find"))
	{
		note.f = note.t1.getText();
		note.i = note.text.indexOf(note.f);
		note.txt.select(note.i-1,note.i+note.f.length()-1);
		setVisible(false);
	}	
	
	else
	if(signal.equals("Replace"))
	{
		note.r = note.t2.getText();
		note.txt.setText(note.text.replaceAll(note.f,note.r));
	}
	
	else
		{
			setVisible(false);
			
		}
}
}

	
class Aboutframe extends Frame{
	
	Aboutframe(String title){
		super(title);
		setLayout(new FlowLayout());
		Label l1 = new Label("This is a notepad made by Mukul Khandelwal.");
		Label l2 = new Label("It is made using Java language.");
		Label l3 = new Label("Copyright@Mukul");
		add(l1);
		add(l2);
		add(l3);
		addWindowListener(new WindowAdapter()
		{public void windowClosing(WindowEvent we){
			setVisible(false);
		}});
	}
}









class Fontframe extends Frame implements ItemListener{
	Notepad note;
	String m="",m1="";
	Choice font,size;
	Font myFont;
	Fontframe(String title){
		super(title);		
		setLayout(new FlowLayout());
		
		font = new Choice();
		size = new Choice();
		
		font.add("Arial");
		font.add("Serif");
		font.add("Courier");
		font.add("Tahoma");
		
		size.add("16");
		size.add("20");
		size.add("24");
		size.add("28");
		size.add("32");
		
		add(font);
		add(size);
		font.addItemListener(this);
		size.addItemListener(this);
		addWindowListener(new WindowAdapter()
		{public void windowClosing(WindowEvent we){
			setVisible(false);
		}});
	}
	public void itemStateChanged(ItemEvent ie)
	{
		m=font.getSelectedItem();
		m1=size.getSelectedItem();
		
		if(m.equals("Arial") && m1.equals("16"))
		{
			myFont = new Font("Arial", Font.BOLD, 16);
			note.txt.setFont(myFont);
			setVisible(false);
		}
		
		else if(m.equals("Serif")) //&& m1.equals("20"))
		{
			myFont = new Font("Serif", Font.BOLD, 20);
			note.txt.setFont(myFont);
			
			setVisible(false);
		}
		
		else if(m.equals("Tahoma") && m1.equals("24"))
		{
			myFont = new Font("Tahoma", Font.BOLD, 24);
			note.txt.setFont(myFont);
			setVisible(false);
		}
		
		else if(m.equals("Courier") && m1.equals("28"))
		{
			myFont = new Font("Arial", Font.BOLD, 28);
			note.txt.setFont(myFont);
			setVisible(false);
		}
		
		else if(m.equals("Arial") && m1.equals("32"))
		{
			myFont = new Font("Arial", Font.BOLD, 32);
			note.txt.setFont(myFont);
		}
	}
}
