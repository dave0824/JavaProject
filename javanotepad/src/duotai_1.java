/*
	2018骞�8鏈�15鏃�20:39:49
*/
class A_1
{
	public void f()
	{
		System.out.printf("hahah\n");
	}
}
class B_1 extends A_1
{
	public void f()
	{
		System.out.printf("lalala\n");
	}
	public void g()
	{
		
	}
}
public class duotai_1
{
	public static void main(String[] args)
	{
		A_1 aa=new A_1();
		A_1 aa2=new A_1();
		B_1 bb=new B_1();
		//bb=aa;//error
		/* bb=(B)aa;//缂栬瘧鍙互閫氳繃锛屼絾鏄繍琛屼笉鑳介�氳繃銆傚洜涓鸿繖鏉¤鍙ヨ娉曚笂鏄纭殑锛屽彲浠ュ皢aa寮哄埗杞崲鎴怋绫伙紝浣嗘槸閫昏緫涓婃槸涓嶅厑璁哥殑銆�
		aa.f(); */
		
		aa=bb;
		bb=(B_1)aa;//ok,杩愯缁撴灉锛歭alala  鍙互鍙戠幇鍦ㄥ墠闈㈠姞涓奱a=bb鍐嶈繍琛岃繖鏉¤鍙ュ氨鍙互琛岀殑閫氫簡銆�
		aa.f();//杩欐槸鍥犱负aa=bb;杩欐潯璇彞宸茬粡鎶夾绫荤殑aa瀵硅薄鎸囧悜浜咮绫荤殑bb瀵硅薄浜嗭紝鎵�浠ュ啀杩涜寮哄埗杞崲鍦ㄩ�昏緫涓婂氨鑳借寰楅�氫簡銆�
		//aa.g();// 閿欒: 鎵句笉鍒扮鍙�
		bb.g();
		
		 
	/* 	 aa=bb;
		 bb=aa;//閿欒锛氳櫧鐒跺墠闈㈠凡缁廇绫荤殑aa瀵硅薄鎸囧悜浜咮绫荤殑bb瀵硅薄浜嗭紝鐒惰�岀紪璇戝櫒杩樻槸涓嶅厑璁竍b=aa杩欐潯璇彞鐨勫嚭鐜�,蹇呴』寰楀湪鍓嶉潰鍔犱竴涓己鍒惰浆鍖栵紝
		       //杩欎篃鏄痵un鍏徃鐨勭‖鎬ц璁★紝闃叉鐢ㄦ埛鍑虹幇璇В銆� */
	}          
}