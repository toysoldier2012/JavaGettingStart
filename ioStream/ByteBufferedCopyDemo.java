package ioStream;
import java.io.*;

public class ByteBufferedCopyDemo {

	public static void main(String[] args) {
		byte[] data = new byte[1024];
		int n = 0;
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		
		try {
			fis = new FileInputStream("LR170806-03.jpg");
			bis = new BufferedInputStream(fis);
			fos = new FileOutputStream("pic_copy.jpg");
			bos = new BufferedOutputStream(fos);
			while((n = bis.read(data)) != -1)
				bos.write(data, 0, n);
			
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
