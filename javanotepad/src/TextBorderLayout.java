import java.awt.*;
public class TextBorderLayout
{
	public static void main(String[] args)
	{
		Frame f=new Frame();
		Button bn1=new Button("bn1");
		Button bn2=new Button("bn2");
		Button bn3=new Button("bn3");
		Button bn4=new Button("bn4");
		Button bn5=new Button("bn5");
		
		//一种写法，推荐使用。
		f.add(bn1, BorderLayout.NORTH);
		f.add(bn2, BorderLayout.SOUTH);
  		f.add(bn3, BorderLayout.WEST);
		f.add(bn4, BorderLayout.EAST);
		f.add(bn5, BorderLayout.CENTER);
		
		//另一种写法，不推荐使用。
/* 		f.add(bn1, "North");  
		f.add(bn2, "South");
		f.add(bn3, "West");
		f.add(bn4, "East");
		f.add(bn5, "Center"); */
		
		f.setSize(400,400);
		f.setBackground(Color.RED);//这里不会显示颜色，因为被按钮覆盖了。
		f.setVisible(true);
	}
}