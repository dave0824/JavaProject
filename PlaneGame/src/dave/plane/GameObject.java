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
	
	//做飞机子弹的矩形，用于检测碰撞
	public Rectangle getRect() {
		Rectangle r= new Rectangle((int)x,(int)y,width,height);
		return r;
	}

}
