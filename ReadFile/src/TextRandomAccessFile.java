import java.io.*;


public class TextRandomAccessFile {
	
	public static void main(String[] args) {
		
		RandomAccessFile ra = null;
		try {
			ra = new RandomAccessFile("G:\\20180910\\javawork\\ReadFile\\3.txt","rw");
			//byte ch;
			//ra.write(101);
			//ra.writeInt(103);
			ra.seek(1);
			ra.write(56);
			ra.writeChar(56);
			ra.writeChars("hahahah");
			ra.close();
			System.out.println("hahaha");
			//ra.seek(1);
			//ch=ra.readByte();
			
		}catch(IOException e) {
			
			e.printStackTrace();
		}
	
	}


}
