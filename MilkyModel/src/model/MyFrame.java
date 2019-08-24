package model;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import model.ModelFrame03.PaintThread;

public class MyFrame extends Frame {


	/**
	 *���ش��� 
	 * 
	 *
	 */
	
	public void launchFrame() {
		setSize(Constant.GAME_HIGH,Constant.GAME_WIDTH);
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

