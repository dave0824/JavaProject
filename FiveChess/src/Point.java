//Point类


public class Point {
	
		private int x;//索引x
		private int y;
		private int count=0;//表示当前棋子的颜色
		public Point(int x,int y,int count)
		{
			this.x=x;
			this.y=y;
			this.count=count;
		}
		public int getx()
		{
			return x;
		}
		public int gety()
		{
			return y;
		}
}