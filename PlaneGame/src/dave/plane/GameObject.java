package dave.plane;

import java.awt.Image;
import java.awt.Rectangle;

public class GameObject {
	
	Image img;
	public double x,y;
	int speed;
	int width,height;

	public  GameObject(double x,double y,int speed) {
		this.x=x;
		this.y=y;
		this.speed=speed;
	}
	public GameObject(int height,int width,int speed) {
		this.height=height;
		this.width=width;
		this.speed=speed;
	}
	public GameObject() {
		
	}
	
	//���ɻ��ӵ��ľ��Σ����ڼ����ײ
	public Rectangle getRect() {
		Rectangle r= new Rectangle((int)x,(int)y,width,height);
		return r;
	}

}
