class Triangle
{
	private int a,b,c;//private是访问控制符私有行的，即加了它外部就不能直接对它进行修改，必须通过函数才能对它进行修改
	int zhouchang()
	{
		return a+b+c;
	}
	double ears()
	{
		double p=1.0*(a+b+c)/2;
		return Math.sqrt(p*(p-a)*(p-b)*(p-c));
	}
	void set(int i,int j,int k)
	{
		a=i;
		b=j;
		c=k;
	}
}
class texttriangle
{
	public static void main(String[] args)
	{
		Triangle t=new Triangle();
		/* t.a=3; 
		t.b=4;
		t.c=5; */
		t.set(3,4,5);
		System.out.printf("%d\n%f",t.zhouchang(),t.ears());
	}
}