package designpattern;

public class FactoryClient {
	public static void main(String[] args) {
		Factory factoryA = new ConcreteFactoryA();
		factoryA.doSomething();
	}
}

abstract class Factory {
	public abstract IProductA factoryMethod();
	public void doSomething() {
		IProductA product = factoryMethod();
	}
}

class ConcreteFactoryA extends Factory {
	@Override
	public IProductA factoryMethod() {
		return new ConcreteProductA1();
	}
}

class ConcreteFactoryB extends Factory {
	@Override
	public IProductA factoryMethod() {
		return new ConcreteProductA2();
	}
}

class ConcreteFactoryC extends Factory {
	@Override
	public IProductA factoryMethod() {
		return new ConcreteProductA3();
	}
}
