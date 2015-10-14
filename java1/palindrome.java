import java.util.*;
class palindrome
{
	public static void main (String args[])
{
	Scanner s = new Scanner(System.in);
	int p,n,m,sum=0;
	System.out.println("enter the number");
	n=s.nextInt();
	p=n;
	while(n>0)
		{
			m=n%10;
			sum=sum*10+m;
			n=n/10;
		}
	if(p==sum)
		
		System.out.println("palindrome");
	else
		System.out.println("not palindrome");
}
}