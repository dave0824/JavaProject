/*
	2018年8月21日19:53:02
	给按键添加一个内容（事物）
*/
import java.awt.*;
import java.awt.event.*;
public class TestButton
{
	public static void main(String[] args)
	{
		Frame f=new Frame();
		Button bn=new Button("确定打开？");
		f.add(bn);
		bn.addActionListener(new A());
		//f.addWindowListener(new B());
		f.pack();
		f.addWindowListener(new B());
		f.setVisible(true);
	}
}
class A implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		System.out.printf("啊哈，我就是这么的强大！\n");
	}
}
class B extends WindowAdapter //implements WindowListener //两者都可以，但是后面的出了下面那个方法还有好多抽象方法，如果要用第二个的话就要重写好多方法，很麻烦，所以就用第一种。
{
		public void windowClosing(WindowEvent e)
		{
			System.exit(-1);
		}
}