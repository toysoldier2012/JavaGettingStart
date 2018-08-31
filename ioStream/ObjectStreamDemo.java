package ioStream;
import java.io.*;

class WriteObj {
	public static void writeObj(String fileName, Object obj) throws IOException {
		File f = new File(fileName);
		if(!f.exists())
			f.createNewFile();
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(obj);
		oos.close();
	}
}

class ReadObj {
	public static void readObj(String fileName, Object obj) throws IOException, ClassNotFoundException {
		File f = new File(fileName);
		FileInputStream fis = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Person p = new Person();
		p = (Person)ois.readObject();
		
		System.out.println(p.name +"-----"+ p.age);
		ois.close();
	}
}

public class ObjectStreamDemo {

	public static void main(String[] args) {
		Person p = new Person("Lixiaoyu", 29);
		try {
			WriteObj.writeObj("ObjectStreamDemo.txt", p);
			ReadObj.readObj("ObjectStreamDemo.txt", p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
