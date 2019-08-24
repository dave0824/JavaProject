package util;
/*
 * 图片的加载！
 * */

import java.io.IOException;

/**
 * 游戏开发常见的工具类
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
			  img=ImageIO.read(u);//返回 BufferedImage作为供给的解码结果
		  }catch(IOException e) {
			  e.printStackTrace();
		  }
		  return img;
	  }
}
