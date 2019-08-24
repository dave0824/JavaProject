package solar;

import java.awt.Graphics;
import java.awt.Image;

import util.Constant;
import util.GameUtil;
import util.MyFrame;

/**
 * 太阳系的主窗口
 */
public class SolarFrame extends MyFrame{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1729879437029143206L;
	private double speed=0.11;
     Image bg=GameUtil.getImage("Images/beijing.jpg");
     Star a=new Star("Images/a.jpg",Constant.GAME_WIDTH/2,Constant.GAME_HIGH/2);
     Planet b=new Planet(a,"Images/b.jpg",100,50,speed);
     Planet c=new Planet(a,"Images/c.jpg",150,80,speed-0.02);
     
     Planet earth=new Planet(a,"Images/d.jpg",200,110,speed-0.03);
     Planet moon=new Planet(earth,"Images/moon.jpg",20,15,0.3,true);
     
     Planet e=new Planet(a,"Images/e.jpg",250,140,speed-0.04);
     Planet f=new Planet(a,"Images/f.jpg",300,180,speed-0.05);
     Planet h=new Planet(a,"Images/h.jpg",360,220,speed-0.06);
     Planet y=new Planet(a,"Images/y.jpg",400,250,speed-0.07);
     Planet j=new Planet(a,"Images/j.jpg",450,290,speed-0.1);
  
     
		public void paint(Graphics g) {
		
		 //g.drawLine(0, 0, 100, 100);
    	 g.drawImage(bg, 0, 0, null);
    	 a.draw(g);
    	 b.draw(g);
    	 c.draw(g);
    	 earth.draw(g);
    	 moon.draw(g);
    	 e.draw(g);
    	 f.draw(g);
    	 h.draw(g);
    	 y.draw(g);
    	 j.draw(g);
     }
     
     public static void main(String[] arg) {
    	 new SolarFrame().launchFrame();
     }
}
