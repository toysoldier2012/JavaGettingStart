package designpattern;

public interface IProductB {
	void getProduct();

}

class ConcreteProductB1 implements IProductB {
	@Override
	public void getProduct() {
		System.out.println("type B1");
	}
}

class ConcreteProductB2 implements IProductB {
	@Override
	public void getProduct() {
		System.out.println("type B2");
	}
}

class ConcreteProductB3 implements IProductB {
	@Override
	public void getProduct() {
		System.out.println("type B3");
	}
}
