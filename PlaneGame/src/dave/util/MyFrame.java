package dave.util;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MyFrame extends Frame {


	/**
	 *加载窗口 
	 * 
	 *
	 */
	
	public void launchFrame() {
		setSize(Constant.GAME_WIDTH,Constant.GAME_HIGH);
		setLocation(400,50);
		setVisible(true);
		
		new PaintThread().start();//启动线程
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
    //添加双缓冲区：
	private	Image ImageBuffer = null;
	private	Graphics GraImage = null;
		public void update(Graphics g){
			ImageBuffer = createImage(this.getWidth(),this.getHeight());
		    GraImage = ImageBuffer.getGraphics();       //获取图形缓冲区的图形上下文  
		    paint(GraImage);        //用paint方法中编写的绘图过程对图形缓冲区绘图  
		    GraImage.dispose();     //释放图形上下文资源  
		    g.drawImage(ImageBuffer, 0, 0, this);   //将图形缓冲区绘制到屏幕上  
		}
	
	/**

	 * @author Bruce Yang

	 * 面板绘制线程~

	 */

	class PaintThread extends Thread {

		
		public static final int PAINT_INTERVAL = 40;
		//int i=0;
		boolean cc=true;
		
		@Override

		public void run() {

			while (cc) {
					repaint();//图片重画

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


