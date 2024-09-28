// Santosh khanal
// c0921949
// Assignment1 
// 27 September 2024

package Assignment1;

public class MainApp {
	public static void main(String[] args) {
		//Creating person without dog
		Person personWithoutDog = new Person("Santosh ", 27);
		
		try {
			personWithoutDog.changeDogsName("Tommy");
		} catch(RuntimeException e) {
			System.out.println("Unable to change dogs name:-"+ e.getMessage());
		}
	}

}
