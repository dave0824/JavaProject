package model;

import java.awt.Font;
import java.awt.*;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
/*
 * ����֪ʶ�����࣡��
 * ģ�ʹ���
 */
public class ModelFrame extends Frame{
	
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
	
	@Override
	public void paint(Graphics g) {
		//System.out.println("�ػ��ˣ�����");
		g.drawLine(100, 100, 200, 200);//���ߣ�����ȷ��һ��ֱ�ߡ�
		g.drawRect(100, 100, 200, 200);//������
		g.drawOval(100, 100, 200, 200);//��Բ
		
		Font f=new Font("����",Font.BOLD,100);
		g.setFont(f);
		g.drawString("��������", 200, 200);
		
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
