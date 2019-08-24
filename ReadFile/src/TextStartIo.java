

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
* ���߳���д�ļ�
* @author owen.huang
*
*/

/**
* ��Ҫд���ļ������ݴ��������
*/
class Creater implements Runnable{
private ConcurrentLinkedQueue<String> queue;
private String contents;
public Creater(){}
public Creater(ConcurrentLinkedQueue<String> queue, String contents){
this.queue = queue;
this.contents = contents;
}
public void run() {
try {
Thread.sleep(100);
} catch (InterruptedException e) {
e.printStackTrace();
}
queue.add(contents);
}
}

/**
* �������е�����д�뵽�ļ�
*/
class DealFile implements Runnable{
private FileOutputStream out;
private ConcurrentLinkedQueue<String> queue;
public DealFile(){}
public DealFile(FileOutputStream out,ConcurrentLinkedQueue<String> queue){
this.out = out;
this.queue = queue;
}
public void run() {
while(true){//ѭ������
if(!queue.isEmpty()){
try {
out.write(queue.poll().getBytes());
} catch (IOException e) {
e.printStackTrace();
}
}
try {
Thread.sleep(100);
} catch (InterruptedException e) {
e.printStackTrace();
}
}
}
}

/**
* ������
*/

public class TextStartIo {
public static void main(String[] args) throws FileNotFoundException{
FileOutputStream out = new FileOutputStream(new File("F:"+ File.separator +"test.txt"),true);
ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<String>();

for(int j=0;j<10;j++){
new Thread(new Creater(queue,j+"--")).start();//���߳���������д������
}
new Thread(new DealFile(out,queue)).start();//�����̣߳����ϴ�queue�ж�����д�뵽�ļ���
}
}
