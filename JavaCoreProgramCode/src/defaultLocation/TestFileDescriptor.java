package defaultLocation;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


/**
 * 
 * @author Superhero
 * @version 2018年12月15日下午9:04:51
 */
public class TestFileDescriptor {
	
	public static void main(String [] args)
	{
		OutputStream os = null;
		InputStream is = null;
		byte[] buffer = new byte[20];
		try
		{
			
			 os = new FileOutputStream(FileDescriptor.out);
			 is = new FileInputStream(FileDescriptor.in);
			int a=is.read(buffer, 0, 20);
			os.write(buffer,0,20);
			os.close();
			is.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
}
