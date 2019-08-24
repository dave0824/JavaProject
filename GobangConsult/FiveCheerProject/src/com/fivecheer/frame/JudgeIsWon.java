package com.fivecheer.frame;

import javax.swing.JOptionPane;

public class JudgeIsWon {

	protected int[][] arr;
	protected int x;
	protected int y;
	
	
	//获取一条线上连续的点(一条线有两个方向)
	private int GetOneLineCount(int xRightChange,int yRightChange,int xLeftChange,int yLeftChane,int currentColor)
	{
		
		int oneFang=GetOneFangCount(xRightChange,yRightChange,currentColor);
		int twoFang=GetOneFangCount(xLeftChange,yLeftChane,currentColor);
		return oneFang+twoFang;
	}
	
	//获取一个方向上连续的棋子的个数
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
					xChange--;//为复数时，例子-3, --后为-4
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
					yChange--;//为复数时，例子-3, --后为-4
				}
			}
		}
		return count;
	}
	
	
	protected boolean IsWin_使用自己的通用方法()
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
	
	private boolean IsWin_从视频中学到的方法()
	{
		boolean flag=false;
		int currentColor=arr[x][y];
		if(GetOneLineCountFrom视频(1,0,currentColor)>=4)
		{
			flag=true;
		}
		else if(GetOneLineCountFrom视频(0,1,currentColor)>=4)
		{
			flag=true;
		}
		else if(GetOneLineCountFrom视频(1,1,currentColor)>=4)
		{
			flag=true;
		}
		else if(GetOneLineCountFrom视频(1,-1,currentColor)>=4)
		{
			flag=true;
		}
		return flag;
	}
	private int GetOneLineCountFrom视频(int xChange,int yChange,int currentColor)
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
	 * 判断当前的下棋方，是否获胜
	 * @param x
	 * @param y
	 * @return
	 */
	private boolean IsWin_没有用通用方法()
	{
		boolean flag=false;
		int i=1;
		
		int count=0;//计数器
		int currentColor=arr[x][y];
		//判断横向是否已经连成了5个
		// x轴右侧是否有4个连续的棋子
		while(i<5&(x+i)<19&&currentColor==arr[x+i][y])
		{
			count++;
			i++;
		}
		// x轴左侧是否有4个连续的棋子
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
		
		//如果横向没有练成5个，再判断纵向是否连成了5个
		if(!flag)
		{
			i=1;
			count=0;
			while(i<5&&(y+i)<19&&currentColor==arr[x][y+i])
			{
				count++;
				i++;
			}
			// x轴左侧是否有4个连续的棋子
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
		
		//如果横向和纵向都没有练成5个，再判断左交叉是否连成了5个
		if(!flag)
		{
			i=1;
			count=0;
			while(i<5&&(x+i)<19&&(y-i)>-1&&currentColor==arr[x+i][y-i])
			{
				count++;
				i++;
			}
			// x轴左侧是否有4个连续的棋子
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
		//如果横向,纵向,左交叉都没有练成5个，再判断右交叉是否连成了5个
		if(!flag)
		{
			i=1;
			count=0;
			while(i<5&&(x+i)<19&&(y+i)<19&&currentColor==arr[x+i][y+i])
			{
				count++;
				i++;
			}
			// x轴左侧是否有4个连续的棋子
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
