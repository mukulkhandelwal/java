class Box
{ 	private int h,w,d;
	Box()
	{
		h=d=w=0;
	}
	
	Box(int a,int b,int c)
	{
		h=a;
		w=b;
		d=c;
	}
	public String toString()
	{
		return("height="+h+"depth="+d+"width="+w);
	}
	
}
class toStringDemo
{
	public static void main(String args[])
{
	Box b1=new Box(2,5,8);
	System.out.println(b1);
}
}
