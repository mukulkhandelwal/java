import java.util.*;
class Tbill
{
	public static void main(String args[])
{
 	Scanner s=new Scanner(System.in);
	System.out.println("enter no. of calls");
	int i;
	i=s.nextInt();
	double m;
	if(i>100)
		if(i>200)
			if(i>400)
		          m=(i-400)*0.80+200+100*1.20;
	                 else
		          m=(i-200)+100*1.20;
		else
			m=(i-100)*1.20;
	else
		m=0;

	  m=m+100;
	
	  m=m+0.1*m;
System.out.println("your bill is:"+m);

}}
				