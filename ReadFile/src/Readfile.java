/*
     ����FileInputStream
*/

import java.io.*;

/*class DoubleReadfile implements Runnable {
	
	public void run() {
		
		//try {
			 FileInputStream is = null;
				try {
					is = new FileInputStream("G:\\20180910\\javawork\\ReadFile\\�ɰ����й�.txt");
				} catch (FileNotFoundException e2) {
					// TODO �Զ����ɵ� catch ��
					e2.printStackTrace();
				}
		//}catch(IOException e) {
			
		//	e.printStackTrace();
		//}
		
		byte[] buffer = new byte[1024];
		int size;
		try {
		while((size = inputStream.read(buffer))>0)
		}catch(IOException e) {}
		
		try {
			while((size = is.read(buffer))>0)
			{
				try {
					is.read(buffer, 0, size);
					System.out.println(buffer);
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
		} catch (IOException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}
		
		try {
			is.close();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		//outputStream.close();
	}
}*/
/**
 * @author Administrator
 *
 */
public class Readfile {

	public static void main(String[] args) throws IOException {
		
		 FileInputStream fis = null;
			try {
				fis = new FileInputStream("G:\\20180910\\javawork\\ReadFile\\1.txt");
			} catch (FileNotFoundException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			byte[] b = new byte[1024];
			int size;
			size=fis.read(b,0,32);
			System.out.printf("%d\n",size);
			fis.close();
			for(int i=0;i<=32;i++)
			//System.out.println(b[i]);
				System.out.printf("%c", b[i]);
				//System.out.printf("%c",49);
	}
}
