package model;

import java.awt.Font;
import java.awt.*;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
/*
 * С��������Ƕ��˶���˳��ʵ������ĵ��䡣
 * ģ�ʹ���
 */
public class ModelFrame03 extends Frame{
	
	Image img=GameUtil.getImage("images/sun.png");
	/**
	 *���ش��� 
	 * 
	 *
	 */
	
	public void launchFrame() {
		setSize(500,500);
		setLocation(100,100);
		setVisible(true);
		
		new PaintThread().start();//�����߳�
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
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
		
		ModelFrame03 mf=new ModelFrame03();
		mf.launchFrame();
	}
	/**

	 * @author Bruce Yang

	 * �������߳�~

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

