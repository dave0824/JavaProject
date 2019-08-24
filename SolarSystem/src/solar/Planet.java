package solar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import util.GameUtil;

public class Planet extends Star {
     //除了图片，坐标，行星沿着某个椭圆运动，长轴，短轴，速度，角度，绕着某个Star(也就是相对恒星)飞。
	double longAxis;  //椭圆的长轴
	double shortAxis;  //椭圆的短轴
	double speed;  //飞行的速度
	double degree;//角度
	Star center;
	boolean satellite;//判断是否为卫星。
	
	/*public void draw(Graphics g) {
		g.drawImage(img, (int)x, (int)y, null);
		
		//沿椭圆飞
		x=(center.x+center.width/2)+longAxis*Math.cos(degree);
		y=(center.y+center.height/2)+shortAxis*Math.sin(degree);
		
		degree+=speed;
	}*/
	public void draw(Graphics g) {
		super.draw(g);
		if(!satellite) {
			drawTrace(g);
		}
		move();
		
	}
	public void drawTrace(Graphics g) {
		double _x,_y,_width,_height;
		
		_width=longAxis*2;
		_height=shortAxis*2;
		_x= (center.x+center.width/2)-longAxis;
		_y=(center.y+center.height/2)-shortAxis;
		
		Color c=g.getColor();
		g.setColor(Color.BLUE);
		g.drawOval((int)_x,(int)_y,(int)_width,(int)_height);
		g.setColor(c);
	}
	
	public void move() {
		//沿椭圆飞
		x=(center.x+center.width/2)+longAxis*Math.cos(degree);
		y=(center.y+center.height/2)+shortAxis*Math.sin(degree);
		
		degree+=speed;
		
	}
	
	
	public Planet(Star center,String imgpath, double longAxis, 
			double shortAxis, double speed) {
		
		super(GameUtil.getImage(imgpath));
		
		this.center = center;
		this.longAxis = longAxis;
		this.shortAxis = shortAxis;
		
		this.speed = speed;
		this.x=center.x+longAxis;
		this.y=center.y;
		//this.img=GameUtil.getImage(imgpath);
	}
	public Planet(Image img,double x,double y) {
		super(img,x,y);
	}
	public Planet(String imgpath,double x,double y) {
		super(imgpath,x,y);
	}
	public Planet(Star center,String imgpath, double longAxis, 
			double shortAxis, double speed,boolean satellite) {
    
		this(center,imgpath,longAxis,shortAxis,speed);
		
		this.satellite=satellite;
		//this.img=GameUtil.getImage(imgpath);
	}
}
