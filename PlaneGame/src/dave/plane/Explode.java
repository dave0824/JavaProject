package dave.plane;

import java.awt.Graphics;
import java.awt.Image;

import dave.util.GameUtil;

/*
 * 爆炸类
 * */
public class Explode {
   double x,y;
   static Image[] imgs=new Image[16];//假设爆炸图片是由16张图片组成
   static {
	   
	   for(int i=0;i<16;i++) {
		   imgs[i] = GameUtil.getImage("Images/bomb_"+i+1+".pmp");//假设爆炸图片是bomb_1到bomb_16
		   imgs[i].getWidth(null);
	   }
   }
   int count;
   
   public void draw(Graphics g) {
	   if(count<16) {
		   g.drawImage(imgs[count], (int)x,(int) y, null);
		   count++;
	   }
   }
   
   public Explode() {
	   
   }
   public Explode(double x,double y) {
	   this.x=x;
	   this.y=y;
   }
}
