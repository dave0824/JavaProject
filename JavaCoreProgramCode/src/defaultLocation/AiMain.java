package defaultLocation;

import java.util.Scanner;
/**
 * ��ֵһ���ڵ�AI���Ĵ���
 * @author Superhero
 * @version 2018��12��16������10:31:21
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
			str = str.replace("��", "");
			str = str.replace("��", "!");
			str = str.replace("�� ", "!");
			System.out.println(str);
			
		}
	}

}
