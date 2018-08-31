package ioStream;
import java.io.*;

class PipedWrite implements Runnable{
	PipedOutputStream pos;
	
	PipedWrite(PipedOutputStream pos){
		this.pos = pos;
	}
	
	public void run() {
		String s = "I am Lixiaoyu";
		byte[] b = s.getBytes();
		try {
			pos.write(b);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class PipedRead implements Runnable{
	PipedInputStream pis;
	
	PipedRead(PipedInputStream pis){
		this.pis = pis;
	}
	
	public void run() {
		byte[] b = new byte[1024];
		try {
			Thread.sleep(6000);
			int len = pis.read(b);
			String s = new String(b, 0, len);
			System.out.println(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}


public class PipedStreamExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PipedOutputStream pos = new PipedOutputStream();
		PipedInputStream pis = new PipedInputStream();
		PipedWrite pw = new PipedWrite(pos);
		PipedRead pr = new PipedRead(pis);
		
		try {
			pis.connect(pos);
			
			Thread t1 = new Thread(pw);
			Thread t2 = new Thread(pr);
			
			t1.start();
			t2.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
