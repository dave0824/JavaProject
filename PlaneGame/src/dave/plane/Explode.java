package dave.plane;

import java.awt.Graphics;
import java.awt.Image;

import dave.util.GameUtil;

/*
 * ��ը��
 * */
public class Explode {
   double x,y;
   static Image[] imgs=new Image[16];//���豬ըͼƬ����16��ͼƬ���
   static {
	   
	   for(int i=0;i<16;i++) {
		   imgs[i] = GameUtil.getImage("Images/bomb_"+i+1+".pmp");//���豬ըͼƬ��bomb_1��bomb_16
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
