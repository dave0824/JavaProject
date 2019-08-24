import java.io.*;
public class TextWriter {

	public static void main (String[] args)throws IOException {
		
		FileWriter fw = null;
		fw = new FileWriter("G:\\20180910\\javawork\\ReadFile\\2.txt");
		fw.write(52);//写入int形数字转化为unicode码对应的字符
		fw.write("中国真棒！！！");//写入字符串
		fw.flush();
		fw.close();
		System.out.println("ok");
		
	}
}
