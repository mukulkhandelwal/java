import java.util.*;
class Insertion
{
public static void main(String args[])
{	Scanner s=new Scanner(System.in);
	int r;
	System.out.println("enter how many values you want to enter");
	r=s.nextInt();
	int a[]=new int[r];
	System.out.println("enter the values");
	int i;
	for(i=0;i<a.length;i++)
		a[i]=s.nextInt();
	
	System.out.println("enter the value you want to enter and at what position");
	int x,y;
	x=s.nextInt();
	y=s.nextInt();
	y--;
	int b[]=new int[a.length+1];
	int j=0;
	for(i=0;i<b.length;i++)
	{	
		if(i!=y)
		{	b[i]=a[j];
			j++;
		}
		else
			b[i]=x;
	}
	a=b;
	b=null;
	

	for(i=0;i<a.length;i++)
	System.out.println("your values are"+a[i]);
}
}
				
	