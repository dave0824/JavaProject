/*
 *  ���� FileReader ��ȡ�ļ�
 * */

import java.io.*;

public class TextReader {
	
	public static void main(String [] args)throws IOException {
	FileReader fr = null;
	fr = new FileReader("G:\\20180910\\javawork\\ReadFile\\�ɰ����й�.txt");
	int cnt;
	int k;
	k=fr.read();//����һ���ַ���������ʽ���������ַ���unicode���϶�Ӧ��ֵ��
	char [] c = new char[1024];
	cnt=fr.read(c);//���ַ��浽����������ַ��ĸ�����
	System.out.printf("%c\n",k);//���������ַ�����ʽ���
	System.out.println(cnt);
	System.out.println(c);
	fr.close();
	
	}
}
