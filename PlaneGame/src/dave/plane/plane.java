package dave.plane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Date;

import dave.util.Constant;
import dave.util.GameUtil;

public class plane extends GameObject {

	private boolean left,up,right,down;
	private boolean live=true;
	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}
	
/*	//�ӷɻ��ձ�ը���ֵ�һ�ַ�������ͼƬ
	private String imgpath;
   public void getboomimgpath(String imgpath) {
	   this.imgpath=imgpath;
   }*/

    //���ɻ�
	public void draw(Graphics g) {
		if(live) {
			g.drawImage(img, (int)x, (int)y, null);
			move();
		}
/*		else {
 * 			//�ɻ���ը���ֵ�һ�ַ�����
			g.drawImage(GameUtil.getImage(imgpath),(int)x,(int)y,null);
		}*/
	}
	
	/*
	 * ��ӡ�ɻ�������Ϣ
	 * 
	 * */
	public void printInfo(Graphics g,String str,int size,int x,int y,Color color) {
		Color c=g.getColor();
		Font f=new Font("����",Font.BOLD,size);
		g.setFont(f);
		g.setColor(color);
		g.drawString(str, x,y);
		g.setColor(c);
	}
	
	
	//֧�ְ˸�����
	public void move() {
		if(left) {
			if((int)x>=speed) {
				x-=speed;
			}
		}
		if(up) {
			if((int)y>=20+speed) {
				y-=speed;
			}
		}
		if(right) {
			if((int)x<=Constant.GAME_WIDTH-width-speed) {
				x+=speed;
			}
		}
		if(down) {
			if((int)y<=Constant.GAME_HIGH-height) {
				y+=speed;
			}
		}
		
		
	}
	
	public void addDirecation(KeyEvent e) {
		switch(e.getKeyCode()) {
		
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_UP:
			up = true;
			break;
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		case KeyEvent.VK_DOWN:
			down = true;
			break;
		default:
			break;
		}
	}
	public void minusDirecation(KeyEvent e) {
		switch(e.getKeyCode()) {
		
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_DOWN:
			down = false;
			break;
		default:
			break;
		}
	}
	
	//ֻ֧���ĸ�����
/*	public void move(KeyEvent e) {
		

		switch (e.getKeyCode()) {
		case 37:
			if((int)x>20) {
				x-=speed;
			}
			break;
		case 38:
			if((int)y>50) {
				y-=speed;
			}
			break;
		case 39:
			if((int)x<280) {
				x+=speed;
			}
			break;
		case 40:
			if((int)y<500) {
				y+=speed;
			}
			break;
		}
	}*/
	public plane(String imgpath ,double x,double y,int speed) {
		super(x,y,speed);
		this.img = GameUtil.getImage(imgpath);
		super.width = img.getWidth(null);
		super.height = img.getHeight(null);
	}
	public plane() {
		
	}
}
