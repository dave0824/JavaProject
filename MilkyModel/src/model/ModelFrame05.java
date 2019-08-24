package model;

import java.awt.Font;
import java.awt.*;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
/*
 * 小球沿任意角度运动，顺便实现桌球的弹射。
 * 模型窗口
 */
public class ModelFrame05 extends MyFrame{
	
	Image img=GameUtil.getImage("images/sun.png");
	
	private double x=100,y=100;
	private double degree=3.14/3;
	private double speed=10;//(0,2pi)
	@Override
	public void paint(Graphics g) {
		
		g.drawImage(img, (int)x, (int)y, null);
		if(speed>=0)
		{
			speed-=0.05;
		}else{
			speed=0;
		}
		x+=speed*Math.cos(degree);
		y+=speed*Math.sin(degree);
		if(y>500-80||y<30) {
			degree=-degree;
		}
		if(x<0||x>500-80) {
			degree=Math.PI-degree;
		}
	}




	public static void main(String[] arg) {
		
		ModelFrame05 mf=new ModelFrame05();
		mf.launchFrame();
	}
}

