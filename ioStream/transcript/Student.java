package ioStream.transcript;
import java.io.Serializable;

public class Student implements Comparable<Student>, Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private int math;
	private int english;
	private int chinese;
	private int sum;
	
	Student(){
		
	}
	
	Student(String name, int chinese, int math, int english){
		this.name = name;
		this.chinese = chinese;
		this.math = math;
		this.english = english;
		sum = chinese + math + english;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getChinese() {
		return chinese;
	}

	public void setChinese(int chinese) {
		this.chinese = chinese;
	}

	public int getSum() {
		sum = chinese + math + english;
		return sum;
	}

	public void setSum() {
		sum = chinese + math + english;
	}
	
	public String toString() {
		return name + ", chinese: "+ chinese +", math: "+ math +", english: "+ english + ", sum: "+ sum;
	}
	
	public int hashCode() {
		return name.hashCode() + sum * 17;
	}

	public boolean equals(Object o) {
		if(!(o instanceof Student))
			throw new ClassCastException("Not Student class!");
		Student s = (Student)o;
		return this.name.equals(s.name) && this.chinese == s.chinese && this.math == s.math && this.english == s.english;
	}
	
	public int compareTo(Student o) {
		int compare = Integer.valueOf(this.sum).compareTo(Integer.valueOf(o.sum));
		if(compare == 0)
			return this.name.compareTo(o.name);
		return compare;
	}
}
