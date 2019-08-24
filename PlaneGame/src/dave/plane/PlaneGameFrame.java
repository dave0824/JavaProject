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
	
	//Explode baozha;//3������ʵ��һ�鱬ը��
	public void paint(Graphics g) {
		
		g.drawImage(bg, 0, 0, null); 
		//g.drawImage(hero1, 150, 500, null);
		p.draw(g);
		
		//��һ���ӵ�
		for(int i=0;i<bulletList.size();i++) {
			Bullet b = (Bullet) bulletList.get(i);
			b.draw(g);
			
			//���ͷɻ��Ƿ���ײ��
			boolean peng = b.getRect().intersects(p.getRect());
			if(peng) {
				//System.out.println("aaaaaaaaaaaaaaaaaa");
				p.setLive(false);
	/*			if(baozha==null) {
					baozha = new Explode();//3������ʵ��һ�鱬ը��
				}*/
				if(endTime==null) {
					
					endTime = new Date();
				}
				//endTime = new Date();//������ظ���ʱ
				//p.getboomimgpath("Images/bomb_1.bmp");//�ɻ���ը���ֵ�һ�ַ���
				//g.drawImage(GameUtil.getImage("Images/bomb_1.bmp"),(int)p.x,(int)p.y,null);//�ɻ���ը�ڶ��ַ�����
			
			}
			if(!p.isLive()) {
				p.printInfo(g, "GAME OVER", 50,80,300,Color.YELLOW);
				int period = (int)((endTime.getTime()-starTime.getTime())/1000);
				p.printInfo(g, "ʱ�䣺"+period+"��", 20, 140, 360, Color.RED);
				
				switch (period/10) {
				case 0:
					p.printInfo(g, "���������ˣ���", 30, 100, 420, Color.BLUE);
					break;
				case 1:
					p.printInfo(g, "�˼�����", 30, 130, 420, Color.BLUE);
					break;
				case 2:
					p.printInfo(g, "just so so����", 30, 100, 420, Color.BLUE);
					break;
				case 3:
					p.printInfo(g, "���аɣ�����", 30, 100, 420, Color.BLUE);
					break;
				default:
					p.printInfo(g, "�������ǲ�һ������", 30, 70, 420, Color.BLUE);
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
		//���Ӽ��̼���
		addKeyListener(new KeyMonitor());
		
		//����һ���ӵ�
		for(int i=0;i<20;i++) {
			Bullet b = new Bullet(10,10,3);
			bulletList.add(b);
		}
		
		starTime=new Date();
	}
	
	
	//�����ڲ���
	class KeyMonitor extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			//System.out.println("���£�"+ e.getKeyCode());
			
			p.addDirecation(e);
			
			//p.move(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
		//System.out.println("����"+ e.getKeyCode());
		
		p.minusDirecation(e);
	  }
		
	}
}
