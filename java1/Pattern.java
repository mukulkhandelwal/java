import java.util.*;
class Pattern
{
public static void main(String args[])
{	Scanner s =new Scanner(System.in);
	String s1=new String();
	System.out.println("enter the string");
	s1=s.nextLine();
	for(int i=1;i<=s1.length();i++)
		System.out.println(s1.substring(0,i));
}
}
		
	