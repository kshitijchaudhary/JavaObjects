// Santosh khanal
// c0921949
// Assignment1 
// 27 September 2024

package Assignment1;
import java.util.Optional;

 class Person {
	private String name;
	private Integer age;
	private Optional<Dog> dog; //optional for the dog owned by person
	
	//constructor without god
	public Person(String name, Integer age) {
		this(name, age, null);
	}
	
	//constructor with dog
	public Person(String name, Integer age, Dog dog) {
		this.name = name;
		this.age = age;
		this.dog = Optional.ofNullable(dog);
	}
	

	public boolean hasOldDog() {
		return dog.map(d -> d.getAge() >= 10).orElse(false);
	}
	

	public void changeDogsName(String newName) {
		dog.ifPresentOrElse(
				d -> d.setName(newName),
				() -> {throw new RuntimeException(this.name + "does not own a dog!");}
				);					
			}
	
	//Getters and setters
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
	
	public Optional<Dog> getDog(){
		return dog;
	}
	
	public void setDog(Optional <Dog> dog) {
		this.dog = dog;
	}
	

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		
		Person person = (Person) o;
		return name.equals(person.name) && age.equals(person.age) && dog.equals(person.dog);
	}
}

