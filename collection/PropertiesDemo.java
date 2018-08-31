package collection;
import java.io.*;
import java.util.*;

class ProgramRunCounter {


	public static void counter() throws IOException{		
		Properties prop = new Properties();
		File f = new File("ProgramRunCounter.ini");
		BufferedReader br;
		BufferedWriter bw;

		String key = "times";
		String value;
		int counter;

		if (!f.exists()) {
			f.createNewFile();
			System.out.println("File created");
		}
		
		//Should close the Reader, then begin the Writer
		br = new BufferedReader(new FileReader(f));
		prop.load(br);
		br.close();
		
		value = prop.getProperty(key);		
		bw = new BufferedWriter(new FileWriter(f));
		if (value != null) {
			counter = Integer.parseInt(value);
			System.out.println("This program has run " + counter + " times");
			counter++;
			value = String.valueOf(counter);
			prop.setProperty(key, value);
			prop.store(bw, "One more time run!");
		} else {
			prop.setProperty(key, "1");
			prop.store(bw, "First time run!");
		}
		
		bw.close();
	}
}

public class PropertiesDemo {

	public static void main(String[] args) {
		try {
			ProgramRunCounter.counter();
		} catch (IOException e) {
			throw new RuntimeException(e.toString());
		}
	}

}
