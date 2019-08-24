/*
 *  测试 FileReader 读取文件
 * */

import java.io.*;

public class TextReader {
	
	public static void main(String [] args)throws IOException {
	FileReader fr = null;
	fr = new FileReader("G:\\20180910\\javawork\\ReadFile\\可爱的中国.txt");
	int cnt;
	int k;
	k=fr.read();//返回一个字符的整数形式，即返回字符再unicode表上对应的值。
	char [] c = new char[1024];
	cnt=fr.read(c);//将字符存到数组里，返回字符的个数。
	System.out.printf("%c\n",k);//将整数以字符的形式输出
	System.out.println(cnt);
	System.out.println(c);
	fr.close();
	
	}
}
