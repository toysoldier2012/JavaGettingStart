package designpattern;

public class AbstractFactoryClient {

	public static void main(String[] args) {
		IFactory factory1 = new ConcreteFactory1();
		factory1.createProductA().getProduct();
		factory1.createProductB().getProduct();

		IFactory factory2 = new ConcreteFactory2();
		factory2.createProductA().getProduct();
		factory2.createProductB().getProduct();
	}
}

interface IFactory {
	IProductA createProductA();
	IProductB createProductB();
}

class ConcreteFactory1 implements IFactory {

	@Override
	public IProductA createProductA() {
		System.out.println("In 1 factory");
		return new ConcreteProductA1();
	}

	@Override
	public IProductB createProductB() {
		System.out.println("In 1 factory");
		return new ConcreteProductB1();
	}
}

class ConcreteFactory2 implements IFactory {

	@Override
	public IProductA createProductA() {
		System.out.println("In 2 factory");
		return new ConcreteProductA2();
	}

	@Override
	public IProductB createProductB() {
		System.out.println("In 2 factory");
		return new ConcreteProductB2();
	}
}
