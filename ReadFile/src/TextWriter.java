import java.io.*;
public class TextWriter {

	public static void main (String[] args)throws IOException {
		
		FileWriter fw = null;
		fw = new FileWriter("G:\\20180910\\javawork\\ReadFile\\2.txt");
		fw.write(52);//д��int������ת��Ϊunicode���Ӧ���ַ�
		fw.write("�й����������");//д���ַ���
		fw.flush();
		fw.close();
		System.out.println("ok");
		
	}
}
