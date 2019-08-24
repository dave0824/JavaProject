/*
	2018骞�8鏈�14鏃�17:30:07
	姝ょ▼搴忓姛鑳戒负缁熻寤虹珛浜嗗灏戜釜瀵硅薄锛屼篃鏄static鐨勪竴涓疄闄呯殑搴旂敤銆�
*/
class AS_1
{
	public int i;
	private static int cnt=0;
	public AS_1()
	{
		cnt++;
	}
	public AS_1(int i)
	{
		this.i=i;
		cnt++;
	}
	public static int getcnt()
	{
		return cnt;
	}
	public void out()
	{
		System.out.printf("%d\n",i);
	}
}
public class static_1
{
	public static void main(String[] args)
	{
		AS_1 aa1=new AS_1();
		System.out.printf("寤虹珛浜�%d涓璞n",AS_1.getcnt());
		AS_1 aa2=new AS_1(66);
	    aa2.out();
		System.out.printf("寤虹珛浜�%d涓璞n",AS_1.getcnt());
		AS_1 aa3=new AS_1();
		aa3.i=88;
		aa3.out();
		System.out.printf("寤虹珛浜�%d涓璞n",AS_1.getcnt());
	}
}