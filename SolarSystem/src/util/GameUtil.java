package util;
/*
 * ͼƬ�ļ��أ�
 * */

import java.io.IOException;

/**
 * ��Ϸ���������Ĺ�����
 * 
 * 
 * */
import java.awt.*;
import java.net.URL;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class GameUtil {
	
	private GameUtil() {}
    
	  public static Image getImage(String path) {
		  URL u=GameUtil.class.getClassLoader().getResource(path);
		  BufferedImage img=null;
		  try {
			  img=ImageIO.read(u);//���� BufferedImage��Ϊ�����Ľ�����
		  }catch(IOException e) {
			  e.printStackTrace();
		  }
		  return img;
	  }
}
