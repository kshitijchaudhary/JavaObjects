// Santosh khanal
// c0921949
// Assignment1 
// 27 September 2024

package Assignment1;


//Using JUnit5 for testing
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DogPersonTest {
	
	//Test Constructor and getters for Dog class
    @Test
    void testDogConstructorAndGetters() {
        Dog dog = new Dog("Herry", 5);
        assertEquals("Herry", dog.getName());
        assertEquals(5, dog.getAge());
    }
    
    //Test setters
    @Test
    void testDogSetters() {
        Dog dog = new Dog("Herry", 5);
        dog.setName("Jerry");
        dog.setAge(6);
        assertEquals("Jerry", dog.getName());
        assertEquals(6, dog.getAge());
    }
    
    //Test Equals method
    @Test
    void testDogEquals() {
        Dog dog1 = new Dog("Herry", 5);
        Dog dog2 = new Dog("Herry", 5);
        Dog dog3 = new Dog("Jerry", 6);
        assertEquals(dog1, dog2);
        assertNotEquals(dog1, dog3);
    }

    //Test Person class without Dog
    @Test
    void testPersonConstructorWithoutDog() {
        Person person = new Person("Santosh", 27);
        assertEquals("Santosh", person.getName());
        assertEquals(27, person.getAge());
        assertTrue(person.getDog().isEmpty());
    }
    
  //Test Person class with Dog
    @Test
    void testPersonConstructorWithDog() {
        Dog dog = new Dog("Herry", 5);
        Person person = new Person("Santosh", 27, dog);
        assertEquals("Santosh", person.getName());
        assertEquals(27, person.getAge());
        assertTrue(person.getDog().isPresent());
        assertEquals(dog, person.getDog().get());
    }
    
  //Test hasOldDog()  with No Dog
    @Test
    void testHasOldDogWithNoDog() {
        Person person = new Person("Santosh", 27);
        assertFalse(person.hasOldDog());
    }
    
    //Test hasOldDog()  with Young Dog
    @Test
    void testHasOldDogWithYoungDog() {
        Person person = new Person("Santosh", 27, new Dog("Herry", 5));
        assertFalse(person.hasOldDog());
    }

    //Test hasOldDog()  with Old Dog
    @Test
    void testHasOldDogWithOldDog() {
        Person person = new Person("Santosh", 27, new Dog("Herry", 10));
        assertTrue(person.hasOldDog());
    }

    //Test changeDogsName()  with Dog
    @Test
    void testChangeDogsNameWithDog() {
        Dog dog = new Dog("Herry", 5);
        Person person = new Person("Santosh", 27, dog);
        person.changeDogsName("Jerry");
        assertEquals("Jerry", person.getDog().get().getName());
    }

    //Test changeDogsName() without Dog
    @Test
    void testChangeDogsNameWithoutDog() {
        Person person = new Person("Santosh", 27);
        Exception exception = assertThrows(RuntimeException.class, () -> {
            person.changeDogsName("Jerry");
        });
        String expectedMessage = "Santosh does not own a dog!";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}