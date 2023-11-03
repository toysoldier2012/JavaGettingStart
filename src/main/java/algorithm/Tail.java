package algorithm;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Tail {

	public String readFileLastLines(String fileName, int numLines) {
		Queue<String> queueLines = new LinkedList<>();

		File file = new File(fileName);
		BufferedReader bf = null;
		try {
			bf = new BufferedReader(new FileReader(file));
			String line = "";
			while ((line = bf.readLine()) != null){
				queueLines.add(line);
				if(queueLines.size() > numLines) {
					queueLines.poll();
				}
			}
			bf.readLine();
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		} finally {
			if (bf != null) {
				try {
					bf.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}

		StringBuffer sb = new StringBuffer();
		queueLines.forEach(sb::append);
		return sb.toString();
	}
}
