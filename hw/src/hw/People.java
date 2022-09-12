package hw;

import java.util.ArrayList;
import java.util.List;

public class People {
	private String name;
	private String gender;
	private int age;
	private ArrayList<Pet> pet = new ArrayList<Pet>();
	 
	public People(String name, String gender, int age, List<Pet> pet) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.pet = (ArrayList<Pet>) pet;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	 
	 
	public List<Pet> getPet() {
		return pet;
	}
	public void setPet(ArrayList<Pet> pet) {
		this.pet = pet;
	}
	@Override
	public String toString() {
		return "People [name=" + name + ", gender=" + gender + ", age=" + age + ", pet=" + pet.toString() + "]";
	}
	
	
}
