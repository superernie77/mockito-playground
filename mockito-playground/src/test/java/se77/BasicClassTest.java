package se77;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

// This is an example for the simplest test with a mocked class. 
@ExtendWith(MockitoExtension.class)
public class BasicClassTest {
	
	// mock the BasicService class. This one is used inside the BasicClass.
	@Mock
	BasicService service;
	
	// Inject the mock into the class we want to test
	@InjectMocks
	BasicClass classToTest;
	
	 // Setup the behavior of the mocked class
	@BeforeEach
	public void setup() {
		// Return the String "mocked!" when the doComplexStuff-method is called on the mock.
		Mockito.when(service.doComplexStuff()).thenReturn("mocked!");
	}
	
	// Test the method of the class
	@Test 
	public void testDoStuff() {
		
		// call the method
		String result = classToTest.doStuff();
		
		// ... and verify the result. It contains the value we defined in the setup-method.
		assertEquals("mocked!", result);
		
	}
}
