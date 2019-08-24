package dave.plane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

import dave.util.GameUtil;
import dave.util.MyFrame;

public class PlaneGameFrame extends MyFrame {
	
	Image bg = GameUtil.getImage("Images/background.png");
	plane p = new plane("Images/airplane.png",150,500,15);

	ArrayList<Bullet> bulletList = new ArrayList<Bullet>();
	
	Date starTime;
	Date endTime;
	
	//Explode baozha;//3用数组实现一组爆炸！
	public void paint(Graphics g) {
		
		g.drawImage(bg, 0, 0, null); 
		//g.drawImage(hero1, 150, 500, null);
		p.draw(g);
		
		//画一堆子弹
		for(int i=0;i<bulletList.size();i++) {
			Bullet b = (Bullet) bulletList.get(i);
			b.draw(g);
			
			//检测和飞机是否碰撞。
			boolean peng = b.getRect().intersects(p.getRect());
			if(peng) {
				//System.out.println("aaaaaaaaaaaaaaaaaa");
				p.setLive(false);
	/*			if(baozha==null) {
					baozha = new Explode();//3用数组实现一组爆炸！
				}*/
				if(endTime==null) {
					
					endTime = new Date();
				}
				//endTime = new Date();//放这会重复记时
				//p.getboomimgpath("Images/bomb_1.bmp");//飞机爆炸部分第一种方法
				//g.drawImage(GameUtil.getImage("Images/bomb_1.bmp"),(int)p.x,(int)p.y,null);//飞机爆炸第二种方法；
			
			}
			if(!p.isLive()) {
				p.printInfo(g, "GAME OVER", 50,80,300,Color.YELLOW);
				int period = (int)((endTime.getTime()-starTime.getTime())/1000);
				p.printInfo(g, "时间："+period+"秒", 20, 140, 360, Color.RED);
				
				switch (period/10) {
				case 0:
					p.printInfo(g, "三秒真男人！！", 30, 100, 420, Color.BLUE);
					break;
				case 1:
					p.printInfo(g, "菜鸡！！", 30, 130, 420, Color.BLUE);
					break;
				case 2:
					p.printInfo(g, "just so so！！", 30, 100, 420, Color.BLUE);
					break;
				case 3:
					p.printInfo(g, "还行吧！！！", 30, 100, 420, Color.BLUE);
					break;
				default:
					p.printInfo(g, "单生就是不一样！！", 30, 70, 420, Color.BLUE);
					break;
				
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		new PlaneGameFrame().launchFrame();
	}
	
	public void launchFrame() {
		
		super.launchFrame();
		//增加键盘监听
		addKeyListener(new KeyMonitor());
		
		//生成一堆子弹
		for(int i=0;i<20;i++) {
			Bullet b = new Bullet(10,10,3);
			bulletList.add(b);
		}
		
		starTime=new Date();
	}
	
	
	//定义内部类
	class KeyMonitor extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			//System.out.println("按下："+ e.getKeyCode());
			
			p.addDirecation(e);
			
			//p.move(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
		//System.out.println("弹起："+ e.getKeyCode());
		
		p.minusDirecation(e);
	  }
		
	}
}
