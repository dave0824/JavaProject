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
	
	String message="�ڷ�����";
	
	boolean isCuntiueGame=false;//Ĭ�ϸս���ʱ�����ܿ�ʼ��Ϸ
	
	int x=0;
	int y=0;
	
	int nextTime=10;
	int blackTime=nextTime;
	int whiteTime=nextTime;
	
	String blackMessage="������";
	String whiteMessage="������";
	
	Thread countTh=new Thread(this);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FrameMain()
	{
		int factWidth=500;
		int factHeight=500;
		this.setTitle("��������Ϸ");
		this.setSize(factWidth, factHeight);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation((width-factWidth)/2, (height-factHeight)/2);
		this.setVisible(true);
		this.addMouseListener(this);
		this.setResizable(false);
		countTh.start();//��ʼִ�м���
		countTh.suspend();//Ĭ�ϸս���ʱ�����ܿ�ʼ��Ϸ(Ҳ���ܵ���ʱ)
		
		
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
		//��������������Χ��˵�������˿�ʼ��Ϸ
		if(x>=400&&x<=480&&y>=105&&y<=120)
		{
			int result=JOptionPane.showConfirmDialog(this, "�Ƿ�ȷ�Ͽ�ʼ��Ϸ");
			if(result==0)
			{
				RestartCheer();
			}
		}
		//��Ϸ����
		else if(x>=400&&x<=480&&y>=120+55&&y<=120+55+15)
		{
			String setMessage=JOptionPane.showInputDialog(this, "�����뵹��ʱ��ʱ��(��)");
			try
			{
				if(setMessage!=null&&setMessage!="")
				{
					nextTime=Integer.parseInt(setMessage);
				}
			}
			catch(NumberFormatException ex)
			{
				JOptionPane.showMessageDialog(this, "����������");
			}
			
		}
		//��Ϸ˵��
		else if(x>=400&&x<=480&&y>=120+55*2+15&&y<=120+55*2+30)
		{
			JOptionPane.showMessageDialog(this, "��Ϸ˵��");
		}
		//��������
		else if(x>=400&&x<=480&&y>=120+55*3+30&&y<=120+55*3+45)
		{
			JOptionPane.showMessageDialog(this, "��������");
		}
		//�˳���Ϸ
		else if(x>=400&&x<=480&&y>=120+55*4+45&&y<=120+55*4+60)
		{
			int result=JOptionPane.showConfirmDialog(this, "�Ƿ�ȷ���˳���Ϸ?");
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
			//JOptionPane.showMessageDialog(this, "��������");
			
			if(x>=10&&x<=370&&y>=70&&y<=430)
			{
				x=(x-10)/20;
				y=(y-70)/20;
				if(arr[x][y]==0)
				{
					if(isBlack)
					{
						arr[x][y]=1;//��ʾ����ط�Ӧ���º���
						isBlack=false;//�������󣬽������Ϊfalse,��ʾ������Ҫ�°�����
						message="�ȴ��׷�����";
						
						
					}
					else
					{
						arr[x][y]=2;
						isBlack=true;
						message="�ȴ��ڷ�����";
					}
					//ÿ��һ��������˫���ĵ���ʱʱ����Ϊ��ʼֵ�����¿�ʼ����ʱ
					blackTime=nextTime;
					whiteTime=nextTime;
					ShowWin();//�ж��Ƿ��Ѿ���ʤ
					repaint();
					
				}
				else
				{
					JOptionPane.showMessageDialog(this, "��λ���Ѿ���������");
				}
			}
		}
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		//JOptionPane.showMessageDialog(this, "����ͷ�");
		//System.out.println("release");
	}
	public void paint(Graphics g){

	
		//ʹ��˫���弼�����������ʱ����Ļ��˸����(�����ڴ�������һ��ͼƬ������ͼƬ�ϻ�ͼ�����ͼƬ��ʾ����)

		BufferedImage memoryImage=new BufferedImage(500,500,BufferedImage.TYPE_INT_BGR);
		Graphics g2=memoryImage.createGraphics();
	    paintCheer(g2);
	    g.drawImage(memoryImage, 0, 0, this);

	      
	}
	
	private void paintCheer(Graphics g)
	{
		
		BufferedImage image=null;
		try {
			image = ImageIO.read(new File("F:\\��Ƭ.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(image,1,20,this);//�����С�ǰ�����������

		g.setColor(Color.BLACK);
        g.setFont(new Font("����",Font.BOLD,20));

        
        
        g.drawString("��Ϸ��Ϣ��"+message,120,60);

        g.setFont(new Font("����",0,14));

        g.drawString("�ڷ�ʱ��(��)��"+blackTime,30,470);

        g.drawString("�׷�ʱ��(��)��"+whiteTime,240,470);

        
        //���ư�ť
        g.setFont(new Font("����",Font.BOLD,19));
        
        int jiange=70;
        g.drawString("��ʼ��Ϸ", 400, 120);
        g.drawString("��Ϸ����", 400, 120+jiange);
        g.drawString("��Ϸ˵��", 400, 120+jiange*2);
        g.drawString("��������", 400, 120+jiange*3);
        g.drawString("�˳���Ϸ", 400, 120+jiange*4);
        //��������

        for(int i=0;i<19;i++){

            g.drawLine(10,70+20*i,370,70+20*i);//20��ÿ�����ӵ�����

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
	 * ��Ϸ���¿�ʼ�ķ���
	 */
	private void RestartCheer()
	{
		message="�ڷ�����";
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
		boolean isWin=wonClass.IsWin_ʹ���Լ���ͨ�÷���();
		if(isWin)
		{
			countTh.suspend();//һ��ʤ���󣬽��̹߳���
			int result=JOptionPane.showConfirmDialog(this, (arr[x][y]==1?"�ڷ�":"�׷�")+"ʤ����!!\n�Ƿ����¿�ʼ?");
			//JOptionPane.showMessageDialog(this, (arr[x][y]==1?"�ڷ�":"�׷�")+"ʤ����!!");
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
						int result=JOptionPane.showConfirmDialog(this, "�ڷ���ʱ���Ƿ����¿�ʼ");
						//countTh.suspend();//��ʱ�󣬰��̹߳���
						if(result==0)
						{
							
							RestartCheer();
						}
						else
						{
							this.isCuntiueGame=false;//�������ε����̵ĵ������
							countTh.suspend();//��ʱ�󣬰��̹߳���
						}
					}
				}
				else
				{
					whiteTime--;
					if(whiteTime<=0)
					{
						int result=JOptionPane.showConfirmDialog(this, "�׷���ʱ���Ƿ����¿�ʼ");
						//countTh.suspend();//��ʱ�󣬰��̹߳���
						if(result==0)
						{
							
							RestartCheer();
						}
						else
						{
							this.isCuntiueGame=false;//�������ε����̵ĵ������
							countTh.suspend();//��ʱ�󣬰��̹߳���
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
