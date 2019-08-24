import java.util.Scanner;//Scanner这个类在util这个包中。所以要把这个类导入过来。
import java.util.InputMismatchException;
public class TextExcep
{
	public static void main(String[] args)
	{
		int i;
		//scanf("%d",&i);//java里面没有scanf。
		Scanner sc=new Scanner(System.in);//System.in表示从键盘流中获取。
		try
		{
			i=sc.nextInt();
			System.out.printf("i=%d",i);//输出放这就ok.
		}
		//i=sc.nextInt();
		catch (InputMismatchException e)
		{
			e.printStackTrace();
			System.out.printf("输入错误！！！\n");
		}
		//System.out.printf("i=%d",i);将输出放这就会出现错误：可能尚未初始化变量i；因为
														//系统默认try内的语句可能执行也可能不执行。
	}
}