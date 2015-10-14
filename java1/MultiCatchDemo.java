class MultiCatchDemo
{
	public static void main(String m[])
{
	int a=0,b=0,c=0,d=0;
	try
{
	a=Integer.parseInt(m[0]);
	b=Integer.parseInt(m[1]);
	c=a-b;
	d=a/c;
	System.out.println(d);
}
	catch(ArithmeticException e)
	{	System.out.println(e);
		System.out.println("both numbers are equal  please change one number");
	}
	catch(ArrayIndexOutOfBoundsException e)
	{
		System.out.println("argument missing   /n run this program by this syntax");
	System.out.println("MultiCatchDemo argument1 argument2");
	}
finally{
	 System.out.println("you are a good java programmer");
	}
	
}
}
	
		 