package com.fivecheer.frame;

import javax.swing.JOptionPane;

public class JudgeIsWon {

	protected int[][] arr;
	protected int x;
	protected int y;
	
	
	//��ȡһ�����������ĵ�(һ��������������)
	private int GetOneLineCount(int xRightChange,int yRightChange,int xLeftChange,int yLeftChane,int currentColor)
	{
		
		int oneFang=GetOneFangCount(xRightChange,yRightChange,currentColor);
		int twoFang=GetOneFangCount(xLeftChange,yLeftChane,currentColor);
		return oneFang+twoFang;
	}
	
	//��ȡһ�����������������ӵĸ���
	private int GetOneFangCount(int xChange,int yChange,int currentColor)
	{
		int count=0;
		while((x+xChange)>-1&&(x+xChange)<19
				&&
				(y+yChange)>-1&&(y+yChange)<19&&
				currentColor==arr[x+xChange][y+yChange])
		{
			count++;
			if(xChange!=0)
			{
				if(xChange>0)
				{
					xChange++;
				}
				else
				{
					xChange--;//Ϊ����ʱ������-3, --��Ϊ-4
				}
			}
			if(yChange!=0)
			{
				if(yChange>0)
				{
					yChange++;
				}
				else
				{
					yChange--;//Ϊ����ʱ������-3, --��Ϊ-4
				}
			}
		}
		return count;
	}
	
	
	protected boolean IsWin_ʹ���Լ���ͨ�÷���()
	{
		boolean flag=false;
		int currentColor=arr[x][y];
		if(GetOneLineCount(1,0,-1,0,currentColor)>=4)
		{
			flag=true;
		}
		else if(GetOneLineCount(0,1,0,-1,currentColor)>=4)
		{
			flag=true;
		}
		else if(GetOneLineCount(1,1,-1,-1,currentColor)>=4)
		{
			flag=true;
		}
		else if(GetOneLineCount(1,-1,-1,1,currentColor)>=4)
		{
			flag=true;
		}
		return flag;
	}
	
	private boolean IsWin_����Ƶ��ѧ���ķ���()
	{
		boolean flag=false;
		int currentColor=arr[x][y];
		if(GetOneLineCountFrom��Ƶ(1,0,currentColor)>=4)
		{
			flag=true;
		}
		else if(GetOneLineCountFrom��Ƶ(0,1,currentColor)>=4)
		{
			flag=true;
		}
		else if(GetOneLineCountFrom��Ƶ(1,1,currentColor)>=4)
		{
			flag=true;
		}
		else if(GetOneLineCountFrom��Ƶ(1,-1,currentColor)>=4)
		{
			flag=true;
		}
		return flag;
	}
	private int GetOneLineCountFrom��Ƶ(int xChange,int yChange,int currentColor)
	{
		int tempX=xChange;
		int tempY=yChange;
		int count=0;
		while(currentColor==arr[x+xChange][y+yChange])
		{
			count++;
			if(xChange!=0)
			{
				xChange++;
			}
			if(yChange!=0)
			{
				if(yChange>0)
				{
					yChange++;
				}
				else
				{
					yChange--;
				}
			}
		}
		
		xChange=tempX;
		yChange=tempY;
		while(currentColor==arr[x-xChange][y-yChange])
		{
			count++;
			if(xChange!=0)
			{
				xChange++;
			}
			if(yChange!=0)
			{
				if(yChange>0)
				{
					yChange++;
				}
				else
				{
					yChange--;
				}
			}
		}
		return count;
	}
	/**
	 * �жϵ�ǰ�����巽���Ƿ��ʤ
	 * @param x
	 * @param y
	 * @return
	 */
	private boolean IsWin_û����ͨ�÷���()
	{
		boolean flag=false;
		int i=1;
		
		int count=0;//������
		int currentColor=arr[x][y];
		//�жϺ����Ƿ��Ѿ�������5��
		// x���Ҳ��Ƿ���4������������
		while(i<5&(x+i)<19&&currentColor==arr[x+i][y])
		{
			count++;
			i++;
		}
		// x������Ƿ���4������������
		i=1;
		while(i<5&&(x-i)>-1&&currentColor==arr[x-i][y])
		{
			count++;
			i++;
		}
		if(count>=4)
		{
			flag=true;
		}
		
		//�������û������5�������ж������Ƿ�������5��
		if(!flag)
		{
			i=1;
			count=0;
			while(i<5&&(y+i)<19&&currentColor==arr[x][y+i])
			{
				count++;
				i++;
			}
			// x������Ƿ���4������������
			i=1;
			while(i<5&&(y-i)>-1&&currentColor==arr[x][y-i])
			{
				count++;
				i++;
			}
			if(count>=4)
			{
				flag=true;
			}
		}
		
		//������������û������5�������ж��󽻲��Ƿ�������5��
		if(!flag)
		{
			i=1;
			count=0;
			while(i<5&&(x+i)<19&&(y-i)>-1&&currentColor==arr[x+i][y-i])
			{
				count++;
				i++;
			}
			// x������Ƿ���4������������
			i=1;
			while(i<5&&(x-i)>-1&&(y+i)<19&&currentColor==arr[x-i][y+i])
			{
				count++;
				i++;
			}
			if(count>=4)
			{
				flag=true;
			}
		}
		//�������,����,�󽻲涼û������5�������ж��ҽ����Ƿ�������5��
		if(!flag)
		{
			i=1;
			count=0;
			while(i<5&&(x+i)<19&&(y+i)<19&&currentColor==arr[x+i][y+i])
			{
				count++;
				i++;
			}
			// x������Ƿ���4������������
			i=1;
			while(i<5&&(x-i)>-1&&(y-i)>-1&&currentColor==arr[x-i][y-i])
			{
				count++;
				i++;
			}
			if(count>=4)
			{
				flag=true;
			}
		}
		
		return flag;
		
	}
}
