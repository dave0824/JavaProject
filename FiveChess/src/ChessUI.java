//���̽����ࣺ


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.AncestorListener;

public class ChessUI extends JPanel{
	
	public static void main(String args[])
	{
		ChessUI ch = new ChessUI();
		ch.Chessinit();
	}
	private int Chess[][] = new int[Config.ROWS][Config.COLUMS];
	public void Chessinit()
	{
		JFrame frame = new JFrame("������");
		
		frame.setSize(800, 700);	
		frame.setLayout(new BorderLayout());
		
		JPanel eastPane = new JPanel();
		/*���һϵ�а�ť���������ǵ�����*/
		
		eastPane.setPreferredSize(new Dimension(150,0));
		JButton JBstart = new JButton("��ʼ����Ϸ");
		JBstart.setPreferredSize(new Dimension(100,100));
		eastPane.add(JBstart);
		JButton JBback = new JButton("����");
		JBback.setPreferredSize(new Dimension(100,100));
		eastPane.add(JBback);
		JButton JBgiveup = new JButton("����");
		JBgiveup.setPreferredSize(new Dimension(100,100));
		eastPane.add(JBgiveup);
		String []type ={"���˶�ս","�˻���ս"};
		JComboBox<String>cItem  = new JComboBox<>(type);
		cItem.setPreferredSize(new Dimension(100,50));
		eastPane.add(cItem);
		eastPane.setBackground(Color.orange);
		/*���̵ļ���*/

		ChessListener L = new ChessListener(this,Chess);//����һ���������ɡ�
		JBstart.addActionListener(L);
		JBback.addActionListener(L);
		JBgiveup.addActionListener(L);
		cItem.addActionListener(L);
		
		
		
		frame.add(eastPane, BorderLayout.EAST);//������
		frame.setBackground(Color.orange);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(3);
		frame.setResizable(false);
		
		frame.add(this);
		frame.setVisible(true);
		
		this.addMouseListener(L);
	}
	/*�ػ�����*/
	
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D G = (Graphics2D)g;//g�������һ�������ˡ�
		G.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
			RenderingHints.VALUE_ANTIALIAS_ON);
		
		for(int i=0;i<Config.ROWS;i++)
		{
			g.drawLine(Config.X0, Config.Y0+Config.SIZE*i, Config.X0+(Config.COLUMS-1)*Config.SIZE, Config.Y0+Config.SIZE*i);
		}
		for(int j=0;j<Config.COLUMS;j++)
		{
			g.drawLine(Config.X0+Config.SIZE*j, Config.Y0, Config.X0+Config.SIZE*j, Config.Y0+(Config.ROWS-1)*Config.SIZE);
			
		}
		/*�����ػ�*/
		
		for(int i=0;i<Chess.length;i++)
		{
			for(int j=0;j<Chess.length;j++)
			{
				int x = Config.X0 + Config.SIZE*i;
				int y = Config.Y0 + Config.SIZE*j;
				
				if(Chess[i][j]==1)
				{
					
						g.setColor(Color.black);//������һ�λ����ӵ���ɫ
						
						Chess[i][j]=1;
						g.fillOval(x-Config.CHESS_SIZE/2,y-Config.CHESS_SIZE/2,Config.CHESS_SIZE,Config.CHESS_SIZE);
				}
				else if(Chess[i][j]==-1)
					{
						g.setColor(Color.white);
						
						Chess[i][j]=-1;
						g.fillOval(x-Config.CHESS_SIZE/2,y-Config.CHESS_SIZE/2,Config.CHESS_SIZE,Config.CHESS_SIZE);
					}
				
			}
		}
	}
  }

