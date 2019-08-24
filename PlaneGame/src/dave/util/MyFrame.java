package dave.util;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MyFrame extends Frame {


	/**
	 *���ش��� 
	 * 
	 *
	 */
	
	public void launchFrame() {
		setSize(Constant.GAME_WIDTH,Constant.GAME_HIGH);
		setLocation(400,50);
		setVisible(true);
		
		new PaintThread().start();//�����߳�
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
    //���˫��������
	private	Image ImageBuffer = null;
	private	Graphics GraImage = null;
		public void update(Graphics g){
			ImageBuffer = createImage(this.getWidth(),this.getHeight());
		    GraImage = ImageBuffer.getGraphics();       //��ȡͼ�λ�������ͼ��������  
		    paint(GraImage);        //��paint�����б�д�Ļ�ͼ���̶�ͼ�λ�������ͼ  
		    GraImage.dispose();     //�ͷ�ͼ����������Դ  
		    g.drawImage(ImageBuffer, 0, 0, this);   //��ͼ�λ��������Ƶ���Ļ��  
		}
	
	/**

	 * @author Bruce Yang

	 * �������߳�~

	 */

	class PaintThread extends Thread {

		
		public static final int PAINT_INTERVAL = 40;
		//int i=0;
		boolean cc=true;
		
		@Override

		public void run() {

			while (cc) {
					repaint();//ͼƬ�ػ�

				try {

					Thread.sleep(PAINT_INTERVAL);
					/*i++;
					if(i>100)
					{
						cc=false;
					}*/

				} catch (InterruptedException e) {

					e.printStackTrace();

				}

			}

		}

	}
}


