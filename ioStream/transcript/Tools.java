package ioStream.transcript;
import java.io.*;
import java.util.Iterator;
import java.util.TreeSet;

public class Tools {
	public static TreeSet<Student> enterInfo() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		TreeSet<Student> transcript = new TreeSet<Student>();
		
		System.out.println("Enter Student information");
		try {
			while((str = br.readLine()) != null) {
				if("over".equals(str))
					break;
				String[] info = str.split(",");
				Student s = new Student();
				s.setName(info[0]);
				s.setChinese(Integer.parseInt(info[1]));
				s.setMath(Integer.parseInt(info[2]));
				s.setEnglish(Integer.parseInt(info[3]));
				s.setSum();
				transcript.add(s);
			}
		} catch (IOException e) {
			throw new RuntimeException(e.toString());
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return transcript;
	}

	public static void OpenTranscript(TreeSet<Student> trans) {
		for(Iterator<Student> it = trans.iterator(); it.hasNext();)
			System.out.println(it.next().toString());
	}
	
	public static void saveTranscriptAsFile(TreeSet<Student> trans, String filename) {
		File f = new File(filename);
		
		if(!f.exists())
			try {
				f.createNewFile();
			} catch (IOException e) {
				throw new RuntimeException(e.toString());
			}
		
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(f);
			ObjectOutputStream oos;
			try {
				oos = new ObjectOutputStream(fos);
				oos.writeObject(trans);
				oos.close();
			} catch (IOException e) {
				throw new RuntimeException(e.toString());
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException("File creation failed! "+e.toString());
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void OpenTranscriptFromFile(TreeSet<Student> trans, String filename) {
		File f = new File(filename);
		
		try {
			FileInputStream fis = new FileInputStream(f);
			try {
				ObjectInputStream ois = new ObjectInputStream(fis);
				try {
					trans = (TreeSet<Student>)ois.readObject();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e.toString());
		}
	}
	
	
	public static void outputTranscriptInFile(TreeSet<Student> trans, String filename) {
		File f = new File(filename);
		if(!f.exists())
			try {
				f.createNewFile();
			} catch (IOException e) {
				throw new RuntimeException(e.toString());
			}
		
		try {
			System.setOut(new PrintStream(f));
			for(Iterator<Student> it = trans.iterator();it.hasNext();) {
				System.out.println(it.next().toString());
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e.toString());
		}
	
	}
}
