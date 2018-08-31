package collection;
import java.util.*;

/*
 * Exercise 1 
 * Generic in Collection
 */
class Student{
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

class listStudent {
	// The generic after new ArrayList can be omitted
	ArrayList<Student> al = new ArrayList<>(); 
	
	public void enterStuInfo(Student s) {
		al.add(s);
	}
	
	public void show() {
		//Using Generic
		for(Iterator<Student> it = al.iterator(); it.hasNext(); ) {
			//No need to cast it.next() to Student class
			Student tmp = it.next();
			System.out.println(tmp.getName()+" ------ "+ tmp.getId());
		}
		
	}
}

/*
 * Exercise 2 
 * Generic in Class 
 */
class Personne<T> {
	public void show(T t) {
		System.out.println(t.toString());
	}
	
	public void print(T t) {
		System.out.println(t.toString());
	}
}

/*
 * Exercise 3
 * Generic in Method
 */
class Banana {
	public <T> void show(T t) {
		System.out.println(t.toString());
	}
	
	public <T> void print(T t) {
		System.out.println(t.toString());
	}
}

/*
 * Exercise 4
 * Generic in Class and Method
 */
class Apple<T> {
	public void show(T t) {
		System.out.println(t.toString());
	}
	
	public <Q> void print(Q q) {
		System.out.println(q.toString());
	}
}

/*
 * Exercise 5
 * Generic in Class and Method
 */
class Pineapple<T> {
	public void show(T t) {
		System.out.println(t.toString());
	}
	
	public <Q> void print(Q q) {
		System.out.println(q.toString());
	}
	
	public static <R> void display(R r) {
		System.out.println(r.toString());
	}
}

/*
 * Exercise 6
 * Generic in Interface
 */
interface Inter<T> {
	public void show(T t);
}

/*
 * Exercise 7
 * Generic Method in Interface 
 */
interface InterInter {
	public <T> void show(T t);
}

/*
 * Exercise 8
 * 3 ways to implement the interface
 */
class Orange implements Inter<String> {
	public void show(String s) {
		System.out.println(s);
	}
}

//Meaningless
class Peach implements Inter<Object> {
	public void show(Object o) {
		System.out.println("123");
	}
}

class Pear<T> implements Inter<T> {
	public void show(T t) {
		System.out.println(t);
	}
}

/*
 * Advance application Generic limit
 * 可以将T或者某种类型换成？，进而可以设置泛型上下限
 * ? extends E
 * ? super E
 * T与?的区别是，T可以当成一个具体的对象，进行操作
 */

public class GenericExercise {
	public static void main(String[] args) {
		//Exercise 1
		listStudent ls = new listStudent();
		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student();
		
		s1.setId(1);
		s1.setName("David");
		s2.setId(2);
		s2.setName("Julia");
		s3.setId(3);
		s3.setName("Henri");
		
		ls.enterStuInfo(s1);
		ls.enterStuInfo(s2);
		ls.enterStuInfo(s3);
		
		ls.show();
		
		//Exercise 2
		Personne<Student> p = new Personne<>();
		p.show(s1);
		p.print(s2);
		
		Personne<Object> q = new Personne<Object>();
		int a = 1;
		int b = 2;
		q.show(s1);
		q.show(a);
		
		//Exercise 3
		Banana bnn = new Banana();
		bnn.show(s1);
		bnn.print(b);
	}
}
