package dave.plane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import dave.util.Constant;

public class Bullet extends GameObject {
	double degree;
	public void draw(Graphics g) {
		Color c=g.getColor();
		g.setColor(Color.RED);
		g.fillOval((int)x, (int)y, width, height);
		
		x += speed*Math.cos(degree);
		y += speed*Math.sin(degree);
		if(y>Constant.GAME_HIGH-height||y<30) {
			degree=-degree;
		}
		if(x<0||x>Constant.GAME_WIDTH-width) {
			degree=Math.PI-degree;
		
		}
		g.setColor(c);
	}
	
	public Bullet(int height,int width,int speed) {
		super(height,width,speed);
		degree = Math.random()*Math.PI*2;
		x = Constant.GAME_WIDTH/2;
		y = Constant.GAME_HIGH/2;

	}
}