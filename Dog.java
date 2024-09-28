// Santosh khanal
// c0921949
// Assignment1 27 September 2024

package Assignment1;


public class Dog {
	private String name;
	private Integer age;
	
	//Constructor  initializing the dog object
	public Dog(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	
	//Getters and Setters
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	

	@Override
	public boolean equals(Object o) {

		if (this == o)
			return true;
		
	
		if (o == null || getClass() != o.getClass())
			return false;

		Dog dog = (Dog) o;
		return name.equals(dog.name) && age.equals(dog.age);
	}
}
