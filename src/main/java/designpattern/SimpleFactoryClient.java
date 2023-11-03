package designpattern;

public class SimpleFactoryClient {
	public static void main(String[] args) {
		new SimpleFactroy("b").createProduct("a").getProduct();
	}
}

class SimpleFactroy {
	public SimpleFactroy(String type) {
	}

	public IProductA createProduct(String type) {
		switch (type) {
			case "a" -> {
				System.out.println("type A");
				return new ConcreteProductA1();
			}
			case "b" -> {
				return new ConcreteProductA2();
			}
			case "c" -> {
				return new ConcreteProductA3();
			}
			default -> {
				return null;
			}
		}
	}
}