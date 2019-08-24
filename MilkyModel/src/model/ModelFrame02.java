package model;

import java.awt.Font;
import java.awt.*;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
/*
 * 实现球的运动
 * 模型窗口
 */
public class ModelFrame02 extends Frame{
	
	Image img=GameUtil.getImage("images/sun.png");
	/**
	 *加载窗口 
	 * 
	 *
	 */
	
	public void launchFrame() {
		setSize(500,500);
		setLocation(100,100);
		setVisible(true);
		
		new PaintThread().start();//启动线程
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	private double x=100,y=100;
	private boolean left;
	private boolean up;
	@Override
	public void paint(Graphics g) {
		
		g.drawImage(img, (int)x, (int)y, null);

		/*if(left) {
			x-=3;
		}else {
			x+=3;
		}
		if(x>500-80) {
			left=true;
		}
		if(x<0) {
			left=false;
		}*/
		if(up) {
			y-=8;
		}else {
			y+=8;
		}
		if(y>500-80) {
			up=true;
		}
		if(y<30) {
			up=false;
		}
	}




	public static void main(String[] arg) {
		
		ModelFrame02 mf=new ModelFrame02();
		mf.launchFrame();
	}
	/**

	 * @author Bruce Yang

	 * 面板绘制线程~

	 */

	class PaintThread extends Thread {

		


		public static final int PAINT_INTERVAL = 40;
		
		@Override

		public void run() {

			while (true) {
					repaint();

				try {

					Thread.sleep(PAINT_INTERVAL);

				} catch (InterruptedException e) {

					e.printStackTrace();

				}

			}

		}

	}

}
