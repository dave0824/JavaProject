package solar;


/*
 * ������̫�����е����ԡ�ͼƬ�����ꡣ
 * */
import java.awt.Graphics;
import java.awt.Image;

import util.GameUtil;

public class Star {
	Image img;
	double x,y;
	int width,height;
	
	public void draw(Graphics g) {
		g.drawImage(img, (int)x, (int)y, null);//���Ƶ�ǰ���õ�ָ��ͼ��Ĵ�С�� ��ͼ������ͼ�������ĵ�����ռ��е����Ͻǣ� x �� y �������ơ� ͼ���е�͸�����ز���Ӱ���Ѿ����ڵ��κ����ء�����Ŀձ�ʾת�������ͼ��ʱҪ֪ͨ�Ķ��� 
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
		this(GameUtil.getImage(imgpath),x,y);//����this��һ���÷���
	}
}
