package ioStream;
import java.io.Serializable;

public class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String name;
	int age;
	
	Person(){
		
	}
	Person(String name, int age){
		this.name = name;
		this.age = age;
	}

}
