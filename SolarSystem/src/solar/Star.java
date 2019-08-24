package solar;


/*
 * 行星与太阳共有的属性。图片，坐标。
 * */
import java.awt.Graphics;
import java.awt.Image;

import util.GameUtil;

public class Star {
	Image img;
	double x,y;
	int width,height;
	
	public void draw(Graphics g) {
		g.drawImage(img, (int)x, (int)y, null);//绘制当前可用的指定图像的大小。 该图像在其图形上下文的坐标空间中的左上角（ x ， y ）处绘制。 图像中的透明像素不会影响已经存在的任何像素。后面的空表示转换更多的图像时要通知的对象 
	}
	
	public Star() {
		
	}
	public Star(Image img) {
		this.img=img;	
		this.width=img.getWidth(null);
		this.height=img.getHeight(null);
	}
	
	public Star(Image img,double x,double y) {
		this(img);
		this.x=x;
		this.y=y;
		

    }
	
	public Star(String imgpath,double x,double y) {
		/*this.img=GameUtil.getImage(imgpath);
		this.x=x;
		this.y=y;
		
		this.width=img.getWidth(null);
		this.height=img.getHeight(null);*/
		this(GameUtil.getImage(imgpath),x,y);//这是this的一种用法。
	}
}
