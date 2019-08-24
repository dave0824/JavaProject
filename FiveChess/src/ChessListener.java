//监听类：


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

//import com.sun.org.apache.xpath.internal.operations.Bool;

public class ChessListener extends MouseAdapter implements ActionListener {

	private ChessUI gm;
	private Graphics2D g;
	private int count = 1;
	private int chess[][] = new int[Config.ROWS][Config.COLUMS];
	private int gameover = 1;
	private String fontName="人人对战";
	private static HashMap<String,Integer> map = new HashMap<String,Integer>();
	private int[][] weightArray = new int[Config.ROWS][Config.COLUMS];
	
	static{
		
		map.put("010",10);//活一连(黑）
		map.put("0-10", 10);//活一连（白）
		map.put("01010", 80);//活二连（黑）
		map.put("0110", 80);//活二连（黑）
		map.put("0-10-10", 80);//活二连（白）
		map.put("0-1-10", 80);//活二连（白）
		map.put("01110", 100);//活三连（黑）
		map.put("0-1-1-10", 100);//活三连（白）
		map.put("011110", 3000);//活四连（黑）
		map.put("0-1-1-1-10", 3000);//活四连（白）
		map.put("1-1", 1);//眠一连（黑）
		map.put("-11", 1);//眠一连（白）
		map.put("011-1", 50);//眠二连（黑）
		map.put("-1110", 50);//眠二连（黑）
		map.put("0-1-11", 50);//眠二连（白）
		map.put("1-1-10", 50);//眠二连（白）
		map.put("0111-1", 100);//眠三连（黑）
		map.put("-11110", 100);//眠三连（黑）
		map.put("0-1-1-11", 100);//眠三连（白）
		map.put("1-1-1-10", 100);//眠三连（白）
		map.put("01111-1", 250);//眠四连（黑）
		map.put("-111110", 250);//眠四连（黑）
		map.put("1-1-1-1-10", 2500);//眠四连（白）
		map.put("0-1-1-1-11", 2500);//眠四连（白）
		
		
	}
	//当前棋盘棋子的个数
	public ChessListener(ChessUI G, int[][] chess) {
		this.gm = G;
		this.chess = chess;
	}
	Point[] chessList=new Point[(Config.ROWS+1)*(Config.COLUMS+1)];//记录第几个棋子
    int chessCount=0;//当前棋子的个数
    int xIndex,yIndex;
	public void GoBack()
	{
		if(chessCount==0)
			return ;
		if(chessCount>0){
			xIndex=chessList[chessCount-1].getx();
			yIndex=chessList[chessCount-1].gety();
			chess[xIndex][yIndex]=0;
		}
		chessList[chessCount-1]=null;
		chessCount--;	
		gm.repaint();

	}
	public void Search()
	{
		for(int r=0;r<chess.length;r++)
		{
			for(int c=0;c<chess.length;c++)//遍历整个棋盘
			{
				if(chess[r][c]==0)//该位置没有棋子
				{
					int num=0;//空位出现的次数
					String code="0";//棋子相连的情况
					int chesscount=0;//记录当前出现的棋子
					for(int c1=c-1;c1>=0;c1--)//向左
					{
						if(chess[r][c1]==0)
						{
							if(c==c1+1) break;
							
							else if(num==0)
							{
								code+=chess[r][c1];
								num++;
							}
							else if(num==1)
							{
								if(chess[r][c1]==chess[r][c1+1]) break;
								code+=chess[r][c1];
								num++;
							}
							else if(num==3)
							{
								if(chess[r][c1]==chess[r][c1+1]) break;
							}
							
						}
						else//有棋子
						{
							if(chesscount==0)//第一次出现棋子
							{
								chesscount=chess[r][c1];
								code+=chess[r][c1];
							}
							else if(chess[r][c1]==chesscount)
							{
								code+=chess[r][c1];
							}
							else
							{
								code+=chess[r][c1];
								break;
							}
						}
						
					}
					Integer value = map.get(code);
					if(value!=null){//判断value是否不为null
					weightArray[r][c]+=value;//在对应空位累加权值
				}
				/*----------------------------------------------*/
				//向右
					for(int c1=c+1;c1<chess.length-1;c1++)
					{
						if(chess[r][c1]==0)
						{
							if(c==c1-1) break;
							
							else if(num==0)
							{
								code+=chess[r][c1];
								num++;
							}
							else if(num==1)
							{
								if(chess[r][c1]==chess[r][c1+1]) break;
								code+=chess[r][c1];
								num++;
							}
							else if(num==3)
							{
								if(chess[r][c1]==chess[r][c1+1]) break;
							}
							
						}
						else//有棋子
						{
							if(chesscount==0)//第一次出现棋子
							{
								chesscount=chess[r][c1];
								code+=chess[r][c1];
							}
							else if(chess[r][c1]==chesscount)
							{
								code+=chess[r][c1];
							}
							else
							{
								code+=chess[r][c1];
								break;
							}
						}
						
					}
					 value = map.get(code);
					if(value!=null){//判断value是否不为null
					weightArray[r][c]+=value;//在对应空位累加权值
				}
				/*----------------------------------------------*/
				//up
					
					for(int r1=r-1;r1>=0;r1--)
					{
						if(chess[r1][c]==0)
						{
							if(r==r1+1) break;
							
							else if(num==0)
							{
								code+=chess[r1][c];
								num++;
							}
							else if(num==1)
							{
								if(chess[r1][c]==chess[r1+1][c]) break;
								code+=chess[r1][c];
								num++;
							}
							else if(num==3)
							{
								if(chess[r1][c]==chess[r1+1][c]) break;
							}
							
						}
						else//有棋子
						{
							if(chesscount==0)//第一次出现棋子
							{
								chesscount=chess[r1][c];
								code+=chess[r1][c];
							}
							else if(chess[r1][c]==chesscount)
							{
								code+=chess[r1][c];
							}
							else
							{
								code+=chess[r1][c];
								break;
							}
						}
						
					}
					
					 value = map.get(code);
					if(value!=null){//判断value是否不为null
					weightArray[r][c]+=value;//在对应空位累加权值
				}
				/*----------------------------------------------*/
				//down

					for(int r1=r+1;r1<chess.length-1;r1++)
					{
						if(chess[r1][c]==0)
						{
							if(r==r1-1) break;
							
							else if(num==0)
							{
								code+=chess[r1][c];
								num++;
							}
							else if(num==1)
							{
								if(chess[r1][c]==chess[r1+1][c]) break;
								code+=chess[r1][c];
								num++;
							}
							else if(num==3)
							{
								if(chess[r1][c]==chess[r1+1][c]) break;
							}
							
						}
						else//有棋子
						{
							if(chesscount==0)//第一次出现棋子
							{
								chesscount=chess[r1][c];
								code+=chess[r1][c];
							}
							else if(chess[r1][c]==chesscount)
							{
								code+=chess[r1][c];
							}
							else
							{
								code+=chess[r1][c];
								break;
							}
						}
						
					}
					 value = map.get(code);
					if(value!=null){//判断value是否不为null
					weightArray[r][c]+=value;//在对应空位累加权值
				}
					
					/*------for (int i = xx + 1, j = yy - 1; j >= 0 && i < chess.length; i++, j--)// 右下----------------------------------------*/
					//右下
					for(int i=r+1,j=c-1;j>=0&&i<chess.length-1;i++,j--)
					{
						if(chess[i][j]==0)
						{
							if(r==i-1 && c==j+1) break;
							else if(num==0)
							{
								code+=chess[i][j];
								num++;
							}
							else if(num==1)
							{
								if(chess[i][j]==chess[i+1][j+1]) break;
								code+=chess[i][j];
								num++;
							}
							else if(num==3)
							{
								if(chess[i][j]==chess[i+1][j+1]) break;
							}
							
						}
						else//有棋子
						{
							if(chesscount==0)//第一次出现棋子
							{
								chesscount=chess[i][j];
								code+=chess[i][j];
							}
							else if(chess[i][j]==chesscount)
							{
								code+=chess[i][j];
							}
							else
							{
								code+=chess[i][j];
								break;
							}
						
						}
					}
					value = map.get(code);
					if(value!=null){//判断value是否不为null
					weightArray[r][c]+=value;//在对应空位累加权值
					}
					 /*------------------------------------*/
					/*左上*/
					for(int i=r-1,j=c+1;i>=0&&j<chess.length-1;j++,i--)
					{
						if(chess[i][j]==0)
						{
							if(r==i+1 && c==j-1) break;
							else if(num==0)
							{
								code+=chess[i][j];
								num++;
							}
							else if(num==1)
							{
								if(chess[i][j]==chess[i+1][j+1]) break;
								code+=chess[i][j];
								num++;
							}
							else if(num==3)
							{
								if(chess[i][j]==chess[i+1][j+1]) break;
							}
							
						}
						else//有棋子
						{
							if(chesscount==0)//第一次出现棋子
							{
								chesscount=chess[i][j];
								code+=chess[i][j];
							}
							else if(chess[i][j]==chesscount)
							{
								code+=chess[i][j];
							}
							else
							{
								code+=chess[i][j];
								break;
							}
						
						}
					}
					value = map.get(code);
					if(value!=null){//判断value是否不为null
					weightArray[r][c]+=value;//在对应空位累加权值
					}
					 /*------------------------------------*/
					/*右上*/
					for(int i=r+1,j=c+1;i<chess.length-1&&j<chess.length-1;j++,i++)
					{
						if(chess[i][j]==0)
						{
							if(r==i-1 && c==j-1) break;
							else if(num==0)
							{
								code+=chess[i][j];
								num++;
							}
							else if(num==1)
							{
								if(chess[i][j]==chess[i+1][j+1]) break;
								code+=chess[i][j];
								num++;
							}
							else if(num==3)
							{
								if(chess[i][j]==chess[i+1][j+1]) break;
							}
							
						}
						else//有棋子
						{
							if(chesscount==0)//第一次出现棋子
							{
								chesscount=chess[i][j];
								code+=chess[i][j];
							}
							else if(chess[i][j]==chesscount)
							{
								code+=chess[i][j];
							}
							else
							{
								code+=chess[i][j];
								break;
							}
						
						}
					}
					 value = map.get(code);
					if(value!=null){//判断value是否不为null
					weightArray[r][c]+=value;//在对应空位累加权值
				}
					 /*------------------------------------*/
					/*左下*/
					for(int i=r-1,j=c-1;i>=0&&j>=0;j--,i--)
					{
						if(chess[i][j]==0)
						{
							if(r==i+1 && c==j+1) break;
							else if(num==0)
							{
								code+=chess[i][j];
								num++;
							}
							else if(num==1)
							{
								if(chess[i][j]==chess[i+1][j+1]) break;
								code+=chess[i][j];
								num++;
							}
							else if(num==3)
							{
								if(chess[i][j]==chess[i+1][j+1]) break;
							}
							
						}
						else//有棋子
						{
							if(chesscount==0)//第一次出现棋子
							{
								chesscount=chess[i][j];
								code+=chess[i][j];
							}
							else if(chess[i][j]==chesscount)
							{
								code+=chess[i][j];
							}
							else
							{
								code+=chess[i][j];
								break;
							}
						
						}
					}	
					//计算weight
					value = map.get(code);
					if(value!=null){//判断value是否不为null
					weightArray[r][c]+=value;//在对应空位累加权值
					}
				}/*---if---*/		
			}/*第一个for*/
		}/*第二个for*/
	}
	public void pve_draw()
	{
		this.Search();
		int max=-1;
		int xIndex=0;
		int yIndex=0;
		for(int i=0;i<weightArray.length;i++)
		{
			for(int j=0;j<weightArray.length;j++)
			{	
				if(weightArray[i][j]>max)//找到第一个最大的
				{
					max=weightArray[i][j];
					xIndex=i;
					yIndex=j;
				}
			}
		}
		
		
		/*-------------TEST--------------*/
		for(int i=0;i<weightArray.length;i++)
		{
			for(int j=0;j<weightArray.length;j++)
			{	
				System.out.print(weightArray[i][j]+" ");
				
			}
			System.out.println();
			
		}
		System.out.println("所选最大权值位置为："+xIndex+" "+yIndex+"最大权值："+max);
		if(chess[xIndex][yIndex]==0)
		{

			g = (Graphics2D) gm.getGraphics();
			g.setColor(Color.white);
			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			g.fillOval(Config.X0+xIndex*Config.SIZE- Config.CHESS_SIZE / 2, Config.Y0+yIndex*Config.SIZE - Config.CHESS_SIZE / 2, Config.CHESS_SIZE,
					Config.CHESS_SIZE);
			Point ch = new Point(xIndex,yIndex,count);
			chessList[chessCount++]=ch;
			chess[xIndex][yIndex] = -1;
			weightArray[xIndex][yIndex]=0;//用了这个点清空
			
			if (Judge(xIndex, yIndex)) {
				
				String msg = String.format("恭喜，%s赢啦~", "白棋 win!");
				JOptionPane.showMessageDialog(gm, msg);
				gameover = 1;
		}
			
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JComboBox) {
			JComboBox<String> comboBox = (JComboBox) e.getSource();// 拿到对象
			fontName = comboBox.getSelectedItem().toString();// 拿到内容
			System.out.println("选择了这个面板的内容！" + fontName);
			

		}
		if (e.getActionCommand() == "开始新游戏") {
			for (int i = 0; i < chess.length; i++) {
				for (int j = 0; j < chess.length; j++) {
					chess[i][j] = 0;
				}
			}
			gameover = 0;
		//	System.out.println("okok  " + gameover);
			gm.repaint();
			count = 1;
		} else if (e.getActionCommand() == "悔棋") {
			
			this.GoBack();
			
			
		} else if (e.getActionCommand() == "认输") {
			if (count == 0) {
				String msg = String.format("恭喜，%s赢啦~", "黑棋 win!");
				JOptionPane.showMessageDialog(gm, msg);
			} else if (count == 1) {
				String msg = String.format("恭喜，%s赢啦~", "白棋 win!");
				JOptionPane.showMessageDialog(gm, msg);
				
			}
		}
	}

	private boolean Judge(int xx, int yy) {
		int count = 1;
		for (int i = xx - 1; i >= 0; i--)// 横向向左找
		{
			if (chess[i][yy] == chess[xx][yy]) {
				count++;
				// System.out.println("(Left)Count:"+count);
			} else
				break;
		}

		for (int i = xx + 1; i < chess.length; i++)// 横向向右找
		{
			if (chess[i][yy] == chess[xx][yy]) {
				count++;
				// System.out.println("Count:"+count);
			} else
				break;
		}
		if (count >= 5) {
			return true;
		} else {
			count = 1;
		}
		for (int j = yy - 1; j >= 0; j--)// 纵向向上
		{
			if (chess[xx][j] == chess[xx][yy]) {
				count++;
				// System.out.println("(UP)Count:"+count);
			} else
				break;
		}
		for (int j = yy + 1; j < chess.length; j++)// 纵向向下
		{
			if (chess[xx][j] == chess[xx][yy]) {
				count++;

			} else
				break;
		}
		if (count >= 5) {
			return true;
		} else {
			count = 1;
		}
		for (int i = xx + 1, j = yy - 1; j >= 0 && i < chess.length; i++, j--)// 右下
		{
			if (chess[i][j] == chess[xx][yy]) {
				count++;
			} else
				break;
		}
		for (int i = xx - 1, j = yy + 1; i >= 0 && j < chess.length; i--, j++)// 左上
		{
			if (chess[i][j] == chess[xx][yy]) {
				count++;
			} else
				break;
		}
		if (count >= 5) {
			return true;
		} else {
			count = 1;
		}
		for (int i = xx + 1, j = yy + 1; j < chess.length && i < chess.length; i++, j++)// 右上
		{
			if (chess[i][j] == chess[xx][yy]) {
				count++;
			} else
				break;
		}
		for (int i = xx - 1, j = yy - 1; i >= 0 && j >= 0; i--, j--)// 左下
		{
			if (chess[i][j] == chess[xx][yy]) {
				count++;
			} else
				break;
		}
		if (count >= 5) {
			return true;
		} else {
			count = 1;
		}
		// System.out.println("Count:"+count);
		return false;

	}
	public void pvp(int x1,int y1)
	{
		for (int j = 0; j < Config.ROWS; j++) {
			for (int i = 0; i < Config.COLUMS; i++) {
				int x = Config.X0 + Config.SIZE * i;
				int y = Config.Y0 + Config.SIZE * j;
				if (x1 > x - Config.SIZE / 3 && x1 < x + Config.SIZE / 3 && y1 > y - Config.SIZE / 3
						&& y1 < y + Config.SIZE / 3) {
					if (chess[i][j] == 0) {

						if (count == 0) {
						

							g.setColor(Color.white);// 设置下一次画棋子的颜色
							g.fillOval(x - Config.CHESS_SIZE / 2, y - Config.CHESS_SIZE / 2, Config.CHESS_SIZE,
									Config.CHESS_SIZE);
							Point ch = new Point(i,j,count);
							chessList[chessCount++]=ch;
							count = 1;
							chess[i][j] = -1;
							
							if (Judge(i, j)) {
								// System.out.println("黑棋赢了！");
								String msg = String.format("恭喜，%s赢啦~", "白棋 win!");
								JOptionPane.showMessageDialog(gm, msg);
								gameover = 1;
							}
						} else if (count==1){
							

							g.setColor(Color.black);
							g.fillOval(x - Config.CHESS_SIZE / 2, y - Config.CHESS_SIZE / 2, Config.CHESS_SIZE,
									Config.CHESS_SIZE);
							Point ch = new Point(i,j,count);
							chessList[chessCount++]=ch;
							count = 0;
							chess[i][j] = 1;
							
							if (Judge(i, j)) {
								// System.out.println("白棋赢了！");
								String msg = String.format("恭喜，%s赢啦~", "黑棋 win!");
								JOptionPane.showMessageDialog(gm, msg);
								gameover = 1;

							}
						}

						return;
					}
				}
			}
		}
	}
	public void mousePressed(MouseEvent e) {
		if (g == null) {
			g = (Graphics2D) gm.getGraphics();
			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		}
		int x1 = e.getX();
		int y1 = e.getY();
		
		if (gameover == 1)
			return;
		int flag=0;
		if(fontName.equals("人机对战"))
		{
			if(flag==0)
			{
				for (int j = 0; j < Config.ROWS; j++) {
					for (int i = 0; i < Config.COLUMS; i++) {
						int x = Config.X0 + Config.SIZE * i;
						int y = Config.Y0 + Config.SIZE * j;
						if (x1 > x - Config.SIZE / 3 && x1 < x + Config.SIZE / 3 && y1 > y - Config.SIZE / 3
								&& y1 < y + Config.SIZE / 3) {
							if (chess[i][j] == 0) {

									g.setColor(Color.black);// 设置下一次画棋子的颜色
									g.fillOval(x - Config.CHESS_SIZE / 2, y - Config.CHESS_SIZE / 2, Config.CHESS_SIZE,
											Config.CHESS_SIZE);
									Point ch = new Point(i,j,count);
									chessList[chessCount++]=ch;
					
							     	chess[i][j] = 1;
									flag=1;
									if (Judge(i, j)) {
										// System.out.println("黑棋赢了！");
										String msg = String.format("恭喜，%s赢啦~", "黑棋 win!");
										JOptionPane.showMessageDialog(gm, msg);
										gameover = 1;
									}
							}
						}
					}
				}
			}
			if(flag==1)
			this.pve_draw();
			
		}
		
		if(fontName.equals("人人对战"))
		{
			this.pvp(x1, y1);
		}

	}

}
