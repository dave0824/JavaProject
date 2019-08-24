package model;

import java.awt.Font;
import java.awt.*;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
/*
 * 基本知识测试类！！
 * 模型窗口
 */
public class ModelFrame extends Frame{
	
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
	
	@Override
	public void paint(Graphics g) {
		//System.out.println("重画了！！！");
		g.drawLine(100, 100, 200, 200);//划线，两点确定一条直线。
		g.drawRect(100, 100, 200, 200);//滑矩形
		g.drawOval(100, 100, 200, 200);//画圆
		
		Font f=new Font("宋体",Font.BOLD,100);
		g.setFont(f);
		g.drawString("哈哈哈哈", 200, 200);
		
		g.fillRect(100, 100, 20, 20);
		
		Color c = g.getColor();
		g.setColor(Color.BLUE);
		g.fillOval(300, 300, 20, 20);
		g.setColor(c);
		
		g.drawImage(img, (int)x, (int)y, null);
		x+=3;
		y+=3;
	}




	public static void main(String[] arg) {
		
		ModelFrame mf=new ModelFrame();
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
