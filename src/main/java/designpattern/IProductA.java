package designpattern;

interface IProductA {
	void getProduct();

}

class ConcreteProductA1 implements IProductA {
	@Override
	public void getProduct() {
		System.out.println("type A1");
	}
}

class ConcreteProductA2 implements IProductA {
	@Override
	public void getProduct() {
		System.out.println("type A2");
	}
}

class ConcreteProductA3 implements IProductA {
	@Override
	public void getProduct() {
		System.out.println("type A3");
	}
}