package ioStream;
import java.io.*;

class MyBufferedInputStream {
	private InputStream is = null;
	
	MyBufferedInputStream(InputStream is) {
		this.is = is;
	}
	
	public int read() throws IOException {
		byte b;
		byte[] bbuf = new byte[1024];
		int length = 0;
		int pointer = 0;
		
		if(length == 0) {
			length = is.read(bbuf);
			pointer = 0;
			
			if(length == -1)
				return -1;
			
			b = bbuf[pointer];
			pointer++;
			length--;
			return b&255;
			
		} else if(length > 0) {
			b = bbuf[pointer];
			pointer++;
			length--;
			return b&255;
		}
		return -1;
	}
	
	public void close() throws IOException {
		is.close();
	}
}

public class MyBufferedInputStreamDemo {

	public static void main(String[] args) {
		int b = 0;
		FileInputStream fis = null;
		FileOutputStream fos = null;
		MyBufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		
		try {
			fis = new FileInputStream("123.jpg");
			bis = new MyBufferedInputStream(fis);
			fos = new FileOutputStream("copy.jpg");
			bos = new BufferedOutputStream(fos);
			while((b = bis.read()) != -1)
				bos.write(b);
			
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e.toString());
		} catch (IOException e) {
			throw new RuntimeException(e.toString());
		} finally {
			if(bis != null)
				try {
					bis.close();
				} catch (IOException e) {
					throw new RuntimeException(e.toString());
				}
			if(bos != null)
				try {
					bos.close();
				} catch (IOException e) {
					throw new RuntimeException(e.toString());
				}
		}
	}

}
