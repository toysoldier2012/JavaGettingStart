package designpattern;

import lombok.ToString;

public class BuilderClient {
	public static void main(String[] args) {
		ComputerDirector computerDirector = new ComputerDirector();
		ComputerBuilder computerBuilder = new MacComputerBuilder("a1", "ramA");
		computerDirector.makeComputer(computerBuilder);
		Computer computer = computerBuilder.getComputer();
		System.out.println(computer);
	}
}

@ToString
class Computer {
	private String cpu;
	private String ram;
	private int usbCount;
	private String keyboard;
	private String display;

	public Computer(String cpu, String ram) {
		this.cpu = cpu;
		this.ram = ram;
	}

	public void setUsbCount(int usbCount) {
		this.usbCount = usbCount;
	}

	public void setKeyboard(String keyboard) {
		this.keyboard = keyboard;
	}

	public void setDisplay(String display) {
		this.display = display;
	}
}

abstract class ComputerBuilder {
	public abstract void setUsbCount();
	public abstract void setKeyboard();
	public abstract void setDisplay();

	public abstract Computer getComputer();
}

class MacComputerBuilder extends ComputerBuilder {
	private Computer computer;
	public MacComputerBuilder(String cpu, String ram) {
		computer = new Computer(cpu, ram);
	}
	@Override
	public void setUsbCount() {
		computer.setUsbCount(2);
	}
	@Override
	public void setKeyboard() {
		computer.setKeyboard("苹果键盘");
	}
	@Override
	public void setDisplay() {
		computer.setDisplay("苹果显示器");
	}
	@Override
	public Computer getComputer() {
		return computer;
	}
}

class LenovoComputerBuilder extends ComputerBuilder {
	private Computer computer;
	public LenovoComputerBuilder(String cpu, String ram) {
		computer=new Computer(cpu,ram);
	}
	@Override
	public void setUsbCount() {
		computer.setUsbCount(4);
	}
	@Override
	public void setKeyboard() {
		computer.setKeyboard("联想键盘");
	}
	@Override
	public void setDisplay() {
		computer.setDisplay("联想显示器");
	}
	@Override
	public Computer getComputer() {
		return computer;
	}
}

class ComputerDirector {
	public void makeComputer(ComputerBuilder builder){
		builder.setUsbCount();
		builder.setDisplay();
		builder.setKeyboard();
	}
}

