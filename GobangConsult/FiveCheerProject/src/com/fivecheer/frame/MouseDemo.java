package com.fivecheer.frame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*���Ǽ̳�WindowAdapter�����ಢʵ��MouseListener interface,
 *������Ǳ����MouseListener�е�5��������ʵ�֣��������ʵ��
 *���������ڲ���ķ�����д�������
 */
public class MouseDemo extends WindowAdapter implements MouseListener{
    JFrame f=null;
    JButton b1=null;
    JLabel label=null;
    
    @SuppressWarnings("deprecation")
	public MouseDemo(){
       f=new JFrame("MouseDemo1");
       Container contentPane=f.getContentPane();
       contentPane.setLayout(new GridLayout(2,1));
       b1=new JButton("��ť");
       label=new JLabel("��ʼ״̬����û������¼�",JLabel.CENTER);
       b1.addMouseListener(this);
       contentPane.add(label);
       contentPane.add(b1);
       f.pack();
       f.show();
       f.addWindowListener(this);
    }
    public void mousePressed(MouseEvent e){
        label.setText("���Ѿ�ѹ����갴ť");
    }
    public void mouseReleased(MouseEvent e){
        label.setText("���Ѿ��ſ���갴ť");
    }
    public void mouseEntered(MouseEvent e){
        label.setText("�������밴ť");
    }
    public void mouseExited(MouseEvent e){
        label.setText("������뿪��ť");
    }
    public void mouseClicked(MouseEvent e){
        label.setText("���Ѿ����°�ť");
    }
    public void windowClosing(WindowEvent e){
        System.exit(0);
    }
    public static void main(String[] args){
       new MouseDemo();	
    }
}

