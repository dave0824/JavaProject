package com.fivecheer.frame;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;
public class FrameMain extends JFrame implements MouseListener,Runnable {

	int arr[][]=new int[19][19];
	boolean isBlack=true; 
	
	String message="黑方先走";
	
	boolean isCuntiueGame=false;//默认刚进入时，不能开始游戏
	
	int x=0;
	int y=0;
	
	int nextTime=10;
	int blackTime=nextTime;
	int whiteTime=nextTime;
	
	String blackMessage="无限制";
	String whiteMessage="无限制";
	
	Thread countTh=new Thread(this);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FrameMain()
	{
		int factWidth=500;
		int factHeight=500;
		this.setTitle("五子棋游戏");
		this.setSize(factWidth, factHeight);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation((width-factWidth)/2, (height-factHeight)/2);
		this.setVisible(true);
		this.addMouseListener(this);
		this.setResizable(false);
		countTh.start();//开始执行计数
		countTh.suspend();//默认刚进入时，不能开始游戏(也不能倒计时)
		
		
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stubtl
		
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	private void BtnClick()
	{
		
		int yJian=55;
		//当鼠标点击了这个范围，说明点中了开始游戏
		if(x>=400&&x<=480&&y>=105&&y<=120)
		{
			int result=JOptionPane.showConfirmDialog(this, "是否确认开始游戏");
			if(result==0)
			{
				RestartCheer();
			}
		}
		//游戏设置
		else if(x>=400&&x<=480&&y>=120+55&&y<=120+55+15)
		{
			String setMessage=JOptionPane.showInputDialog(this, "请输入倒计时的时间(秒)");
			try
			{
				if(setMessage!=null&&setMessage!="")
				{
					nextTime=Integer.parseInt(setMessage);
				}
			}
			catch(NumberFormatException ex)
			{
				JOptionPane.showMessageDialog(this, "请输入数字");
			}
			
		}
		//游戏说明
		else if(x>=400&&x<=480&&y>=120+55*2+15&&y<=120+55*2+30)
		{
			JOptionPane.showMessageDialog(this, "游戏说明");
		}
		//关于我们
		else if(x>=400&&x<=480&&y>=120+55*3+30&&y<=120+55*3+45)
		{
			JOptionPane.showMessageDialog(this, "关于我们");
		}
		//退出游戏
		else if(x>=400&&x<=480&&y>=120+55*4+45&&y<=120+55*4+60)
		{
			int result=JOptionPane.showConfirmDialog(this, "是否确认退出游戏?");
			if(result==0)
			{
				System.exit(0);
			}
		}
	}
	
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("x="+e.getX()+" y="+e.getY());
		x=e.getX();
		y=e.getY();
		BtnClick();
		
		if(isCuntiueGame)
		{
			//JOptionPane.showMessageDialog(this, "你点击了我");
			
			if(x>=10&&x<=370&&y>=70&&y<=430)
			{
				x=(x-10)/20;
				y=(y-70)/20;
				if(arr[x][y]==0)
				{
					if(isBlack)
					{
						arr[x][y]=1;//表示这个地方应该下黑棋
						isBlack=false;//下完黑棋后，将标记设为false,表示接下来要下白棋了
						message="等待白方下棋";
						
						
					}
					else
					{
						arr[x][y]=2;
						isBlack=true;
						message="等待黑方下棋";
					}
					//每走一步，都将双方的倒计时时间设为初始值，重新开始倒计时
					blackTime=nextTime;
					whiteTime=nextTime;
					ShowWin();//判断是否已经获胜
					repaint();
					
				}
				else
				{
					JOptionPane.showMessageDialog(this, "该位置已经有棋子了");
				}
			}
		}
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		//JOptionPane.showMessageDialog(this, "鼠标释放");
		//System.out.println("release");
	}
	public void paint(Graphics g){

	
		//使用双缓冲技术，解决下棋时的屏幕闪烁问题(先在内存中生成一个图片，再在图片上画图，最后将图片显示出来)

		BufferedImage memoryImage=new BufferedImage(500,500,BufferedImage.TYPE_INT_BGR);
		Graphics g2=memoryImage.createGraphics();
	    paintCheer(g2);
	    g.drawImage(memoryImage, 0, 0, this);

	      
	}
	
	private void paintCheer(Graphics g)
	{
		
		BufferedImage image=null;
		try {
			image = ImageIO.read(new File("F:\\照片.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(image,1,20,this);//窗体大小是包含标题栏的

		g.setColor(Color.BLACK);
        g.setFont(new Font("黑体",Font.BOLD,20));

        
        
        g.drawString("游戏信息："+message,120,60);

        g.setFont(new Font("宋体",0,14));

        g.drawString("黑方时间(秒)："+blackTime,30,470);

        g.drawString("白方时间(秒)："+whiteTime,240,470);

        
        //绘制按钮
        g.setFont(new Font("楷体",Font.BOLD,19));
        
        int jiange=70;
        g.drawString("开始游戏", 400, 120);
        g.drawString("游戏设置", 400, 120+jiange);
        g.drawString("游戏说明", 400, 120+jiange*2);
        g.drawString("关于我们", 400, 120+jiange*3);
        g.drawString("退出游戏", 400, 120+jiange*4);
        //绘制棋盘

        for(int i=0;i<19;i++){

            g.drawLine(10,70+20*i,370,70+20*i);//20是每个格子的像素

            g.drawLine(10+20*i,70,10+20*i,430);

        }
		
		for(int i=0;i<19;i++)
		{
			for(int j=0;j<19;j++)
			{
				if(arr[i][j]==1)
				{
					x=20*i+10;
					y=20*j+70;
					
					g.fillOval(x-7, y-7, 14, 14);
				}
				if(arr[i][j]==2)
				{
					x=20*i+10;
					y=20*j+70;
					g.setColor(Color.white);
					g.fillOval(x-7, y-7, 14, 14);
					g.setColor(Color.BLACK);
					g.drawOval(x-7, y-7, 14, 14);
				}
			}
		}
	}
	
	/**
	 * 游戏重新开始的方法
	 */
	private void RestartCheer()
	{
		message="黑方先下";
		arr=new int[19][19];
		isBlack=true;
		this.isCuntiueGame=true;
		blackTime=nextTime;
		whiteTime=nextTime;
		
		countTh.resume();
		repaint();
		
	}
	
	private void ShowWin()
	{
		JudgeIsWon wonClass=new JudgeIsWon();
		wonClass.arr=arr;
		wonClass.x=x;
		wonClass.y=y;
		boolean isWin=wonClass.IsWin_使用自己的通用方法();
		if(isWin)
		{
			countTh.suspend();//一方胜利后，将线程挂起
			int result=JOptionPane.showConfirmDialog(this, (arr[x][y]==1?"黑方":"白方")+"胜利了!!\n是否重新开始?");
			//JOptionPane.showMessageDialog(this, (arr[x][y]==1?"黑方":"白方")+"胜利了!!");
			if(result==0)
			{
				RestartCheer();
				
				
			}
			else
			{
				isCuntiueGame=false;
			}
		}
	}

	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			if(nextTime>0)
			{
				if(isBlack)
				{
					blackTime--;
					if(blackTime<=0)
					{
						int result=JOptionPane.showConfirmDialog(this, "黑方超时，是否重新开始");
						//countTh.suspend();//超时后，把线程挂起
						if(result==0)
						{
							
							RestartCheer();
						}
						else
						{
							this.isCuntiueGame=false;//否则屏蔽掉棋盘的点击操作
							countTh.suspend();//超时后，把线程挂起
						}
					}
				}
				else
				{
					whiteTime--;
					if(whiteTime<=0)
					{
						int result=JOptionPane.showConfirmDialog(this, "白方超时，是否重新开始");
						//countTh.suspend();//超时后，把线程挂起
						if(result==0)
						{
							
							RestartCheer();
						}
						else
						{
							this.isCuntiueGame=false;//否则屏蔽掉棋盘的点击操作
							countTh.suspend();//超时后，把线程挂起
						}
					}
				}
				this.repaint();
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		}
	}


}
