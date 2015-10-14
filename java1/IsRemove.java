import java.util.*;
class IsRemove
{
	public static void main(String args[])
{
	Scanner s=new Scanner(System.in);
	System.out.println("enter the string");
	String s1=new String();
	s1=s.nextLine();
	String s2=new String();
	int i=0,m;
	m=s1.length();
	
	do
	{
		i=s1.indexOf("is");
		if(i!=-1){
		s2=s1.substring(0,i);
		s1=s1.substring(i+2,m);
		s1=s2+s1;}
	}
		while(i!=-1);
	System.out.println(s1);
}
}

	