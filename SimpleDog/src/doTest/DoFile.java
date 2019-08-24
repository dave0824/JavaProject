package doTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;



public class DoFile {
	public static void main(String [] args) {
		DoTest dt=new DoTest();
		dt.fileTest();
		
	}
}

class DoTest{
	public DoTest(){
		
	}
	public void fileTest() {
		
		//FileInputStream fis=null;
		InputStream fis=null;
		OutputStream out=null;
		byte[] b=new byte[2048];
		int i=0;
		int len=200;
		
		try {
			//File file=new File("F:/java/3.mp3");
			fis =new FileInputStream("F:/java/3.mp3");	
			out=new FileOutputStream("F:/java/6.mp3");
			while((i=fis.read())!=-1) {
				
				out.write(i);
				System.out.println((char)i);
				fis.read(b, 0, len);
				out.write(b, 0, len);
				//out.write(i);
			}
		}
		
		catch(Exception e){
			e.getStackTrace();
		}finally {
			try {
				fis.close();
				out.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
}
