package defaultLocation;

import java.util.Scanner;
/**
 * 价值一个亿的AI核心代码
 * @author Superhero
 * @version 2018年12月16日下午10:31:21
 */
public class AiMain 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String str;
		while(true)
		{
			str = sc.next();
			str = str.replace("吗", "");
			str = str.replace("？", "!");
			str = str.replace("？ ", "!");
			System.out.println(str);
			
		}
	}

}
