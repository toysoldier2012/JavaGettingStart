package ioStream.transcript;
import java.util.TreeSet;

public class TranscriptDemo {

	public static void main(String[] args) {
		TreeSet<Student> trans = new TreeSet<Student>();
	
		trans = Tools.enterInfo();
		Tools.OpenTranscript(trans);
		Tools.saveTranscriptAsFile(trans, "TranscriptDemo.Object");
		Tools.OpenTranscriptFromFile(trans, "TranscriptDemo.Object");
		Tools.outputTranscriptInFile(trans, "TranscriptDemo.txt");
	}

}
