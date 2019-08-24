/*
	2018年8月21日16:21:01
*/
import java.awt.*;
public class TextFlowLayout
{
	public static void main(String[] args)
	{
		Frame f=new Frame("hahha");//这“hahha”是窗口的名字。
		Button bn1=new Button("ok?");//里面是按钮的名字。
		Button bn2=new Button("haha?");
		Button bn3=new Button("heihei?");
		f.setLayout(new FlowLayout(FlowLayout.LEFT,50,50));//设置f是FlowLayout布局，并且是右对齐.如果50,50不设置就会默认5,5。这是两个按钮直接的距离。
		f.add(bn1);//将这个按钮添加到容积里面去。
		f.add(bn2);
		f.add(bn3);
		f.setLocation(500,300);//表示在屏幕上的位置。
		f.setBackground(Color.RED);//设置颜色。
		f.setSize(300,400);//300表像素。窗口的大小。
		f.setVisible(true);//表示可见的。	
	}
}
