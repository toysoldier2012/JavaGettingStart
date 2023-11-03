package java8;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionalInterface {
	public static void main(String[] args) {
		test1();
	}

	public static void test1() {
		Predicate<User> predicate = user -> user.getAge() > 18;

		User user = new User("xiaoyu", 18);
		user.setAge(5);
		System.out.println(user.check(predicate));
		System.out.println(user);
	}

	public static void test2() {
		List<User> userList = new ArrayList<>();

		userList.add(new User("xiaoyu", 18));
		userList.add(new User("yezi", 15));
		userList.add(new User("lalala", 20));

		userList.stream().filter(user -> user.getAge() > 18).forEach(System.out::println);
		System.out.println(userList.stream().findAny().get());
		System.out.println(userList.stream().max(Comparator.comparingInt(User::getAge)).get());
		System.out.println(userList.stream().allMatch(user -> user.getAge() > 8));
		System.out.println(userList.stream().count());
		userList.stream().dropWhile(user -> user.getAge() == 18).forEach(System.out::println);
		Stream.of(2, 4, 6, 8, 7, 10, 12)
				.dropWhile(n -> n % 2 == 0)
				.forEach(System.out::println);
		userList.stream().limit(2).forEach(System.out::println);
		System.out.println(userList.stream().noneMatch(user -> user.getAge() < 5));
		System.out.println(userList.stream().map(User::getAge).reduce((sum, age) -> sum += age).or(() -> Optional.of(0)).get());
//		userList.stream().collect(Collectors)
	}

	public static void test3() {
		Object o = new Object();

		User student = null;
		//ofNullable 接收的值可以为 null
		Optional<User> optional = Optional.ofNullable(student);
		//如果上面ofNullable 里接收的值 为 null ，下面使用 get() 获取对象会报空指针异常
//		User student2 = optional.get();

		User student1 = new User("王五", 80);
		Optional<User> optional1 = Optional.ofNullable(student1);
		optional1.ifPresentOrElse(value -> System.out.println("student不为空，姓名：" + value.getName()), () -> System.out.println("student为空"));

		List<String> companyNames = Arrays.asList("paypal", "oracle", "", "microsoft", "", "apple");
		Optional<List<String>> listOptional = Optional.of(companyNames);
		//获取companyNames的长度
		int size = listOptional.map(List::size).orElse(0);
		listOptional.map(List::size).or(() -> Optional.of(0)).get();


		Integer year = 2022;
		Optional<Integer> yearOptional = Optional.ofNullable(year);
		boolean is2022 = yearOptional.filter(y -> y == 2022).isPresent();
		System.out.println(is2022);//true
		boolean is2023 = yearOptional.filter(y -> y == 2017).isPresent();
		System.out.println(is2023);//false

	}

	public static void test4() {
		List<Student> studentList = List.of(
				new Student("xiaoyu", 5, "aaaaa", "11111", false),
				new Student("56462", 1, "bbbbb", "22222", false),
				new Student("784131", 2, "ccccc", "11111", false),
				new Student("xiaoyu4551", 3, "aaaaa", "33333", false),
				new Student("xiaoyu4587", 8, "ccccc", "22222", false),
				new Student("xiaoyuazeaze", 1, "aaaaa", "11111", false),
				new Student("xiaoyu779841", 0, "ccccc", "33333", false)
		);
//		题目1：筛选学生不及格次数3次及3次以上的学生列表

		List<String> names = studentList.stream().filter(student -> student.getFailCount() >= 3).map(Student::getName).collect(Collectors.toList());
		System.out.println(names);


//		题目2：筛选班主任和科任老师负责的学生中有多少个不及格次数超过2次的

		System.out.println(studentList.stream().filter(student -> student.getFailCount() >= 2).collect(Collectors.groupingBy(Student::getChineseTeacher)));
		System.out.println(studentList.stream().filter(student -> student.getFailCount() > 2).sorted(Comparator.comparing(Student::getClassTeacher)).collect(Collectors.groupingBy(Student::getClassTeacher)));
		studentList.stream().filter(student -> student.getFailCount() > 2).sorted(Comparator.comparing(Student::getClassTeacher)).forEach(System.out::println);

		System.out.println("题目3：筛选不及格次数超过2次且班主任不是安妮和张远的");
		Predicate<Student> predicate1 = student -> student.getFailCount() > 2;
		Predicate<Student> predicate2 = student -> !"22222".equals(student.getClassTeacher());
		Predicate<Student> predicate3 = student -> !"33333".equals(student.getClassTeacher());

		studentList.stream().filter(predicate1.and(predicate2).and(predicate3)).forEach(System.out::println);

		System.out.println("题目4：提取学生列表中所有学生的名字");

		studentList.stream().map(Student::getName).forEach(System.out::println);

		System.out.println("题目5：提取不及格次数为0的学生为三好学生并给isMeritStudent 赋值");

		studentList.stream().filter(student -> student.getFailCount() == 0).forEach(student -> student.setMeritStudent(true));
		studentList.forEach(System.out::println);

		System.out.println("题目6：统计所有老师的名字");

		System.out.println(studentList.stream().map(Student::getClassTeacher).distinct().collect(Collectors.toList()));
		System.out.println(studentList.stream().map(Student::getChineseTeacher).distinct().collect(Collectors.toList()));

		System.out.println("题目7：有如下整数1，-1，-2，-3，-4，-5 使用Stream取元素绝对值并打印");

		List<Integer> list = List.of(1, -1, -2, -3, -4, -5);

		list.stream().map(Math::abs).forEach(System.out::println);

		System.out.println("题目8：给定一个数字列表，如何返回一个由每个数的平方构成的列表");

		list.stream().map(integer -> (int) Math.pow(integer, 2)).forEach(System.out::println);

//		如下有7个元素黄药师，冯蘅，郭靖，黄蓉，郭蓉 ，郭襄，郭破虏
//
		System.out.println("题目9：使用stream将以郭字开头的元素存入新集合");

		List<String> list2 = List.of("huangyaoshi", "fengheng", "guojing", "huangrong", "guorong", "guoxiang", "huopolu");

		System.out.println(list2.stream().filter(string -> string.startsWith("guo")).collect(Collectors.toList()));

//		已知ArrayList集合中有如下元素{陈玄风、梅超风、陆乘风、曲灵风、武眠风、冯默风、罗玉风}
		System.out.println("题目10：取出前两个元素并在控制台打印输出");

		System.out.println(list2.stream().limit(2).collect(Collectors.toList()));

		System.out.println("题目11：取出后两个元素并在控制台打印输出");

		System.out.println(list2.stream().skip(list2.size() - 2).collect(Collectors.toList()));

		System.out.println("题目12：找出2011年发生的所有交易， 并按交易额排序（从低到高）");

		studentList.stream().filter(student -> "aaaaa".equals(student.getChineseTeacher())).sorted(Comparator.comparingInt(Student::getFailCount)).forEach(System.out::println);

		System.out.println("题目13：怎样使用map和reduce方法数一数流中有多少个Employee呢？");

		System.out.println(studentList.stream().map(student -> 1).reduce((sum, count) -> sum += count).get());

//		题目14：现在有两个Arraylist集合，分别存储6名男演员和6女演员的名称，要求完成如下的操作：
//
//		女演员只要姓林的,并且不要第一个
//
		System.out.println("题目15：把过滤后的男演员女演员合并");

		Stream.concat(studentList.stream(), studentList.stream()).forEach(System.out::println);

		String[] arr = {"河北省", "山西省", "吉林省", "辽宁省",
				"黑龙江省", "陕西省", "甘肃省", "青海省", "山东省",
				"福建省", "浙江省", "台湾省", "河南省", "湖北省",
				"湖南省", "江西省", "江苏省", "安徽省", "广东省",
				"海南省", "四川省", "贵州省", "云南省", "北京市",
				"天津市", "上海市", "重庆市", "内蒙古自治区",
				"新疆维吾尔自治区", "宁夏回族自治区", "广西壮族自治区",
				"西藏自治区", "香港特别行政区", "澳门特别行政区"};

		System.out.println("题目17：统计三个字的省份的个数");



		System.out.println("题目18：统计名字中包含方位名词的省份（东西南北）的个数");

		System.out.println(Arrays.stream(arr).filter(str -> {
			boolean isContain = false;
			for (Direction d : Direction.values()) {
				isContain = isContain || str.contains(d.getDirection());
			}
			return isContain;
		}).count());
	}
}

@Data
@AllArgsConstructor
class User implements Comparable<User> {
	private String name;
	private int age;

	public boolean check(Predicate<User> predicate) {
		return predicate.test(this);
	}

	@Override
	public int compareTo(User user) {
		int c = this.name.compareTo(user.getName());
		if (c != 0) return c;

		return Integer.compare(this.age, user.getAge());
	}
}

@Data
@AllArgsConstructor
class Student {
	//		Student 类
//		具有属性：
//		不及格次数failCount，
//		名字name，
//		科任老师chineseTeacher，
//		班主任classTeacher
	private String name;
	private int failCount;
	private String chineseTeacher;
	private String classTeacher;
	private boolean isMeritStudent;
}

@Data
@AllArgsConstructor
class Actor {
	private String name;
}

enum Direction {
	EAST("东"), WEST("西"), NORTH("北"), SOUTH("南");

	private String direction;

	private Direction(String d){
		this.direction = d;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}
}