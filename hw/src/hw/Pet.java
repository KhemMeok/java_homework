package hw;

public class Pet {
	private String name;
	private String color;
	private int wigth;
	private int hight;
	public Pet(String name, String color, int wigth, int hight) {
		super();
		this.name = name;
		this.color = color;
		this.wigth = wigth;
		this.hight = hight;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getWigth() {
		return wigth;
	}
	public void setWigth(int wigth) {
		this.wigth = wigth;
	}
	public int getHight() {
		return hight;
	}
	public void setHight(int hight) {
		this.hight = hight;
	}
	@Override
	public String toString() {
		return "Pet [name=" + name + ", color=" + color + ", wigth=" + wigth + ", hight=" + hight + "]";
	}
	
}
