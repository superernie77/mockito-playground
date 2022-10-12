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
// For more info on Mockito check the Javadocs https://javadoc.io/static/org.mockito/mockito-core/3.12.4/org/mockito/Mockito.html
@ExtendWith(MockitoExtension.class)
public class BasicClassTest {

	// mock the BasicService class. It is an dependency used in the BasicClass.
	@Mock
	BasicService service;

	// Inject the mock into the class we want to test
	@InjectMocks
	BasicClass classToTest;

	// Setup the behavior of the mocked class
	@BeforeEach
	public void setup() {
		// Return the String "mocked!" when the doComplexStuff-method is called on the
		// mock. This is called "stubbing".
		Mockito.when(service.doComplexStuff()).thenReturn("mocked!");
	}

	// Test the method of the class
	@Test
	public void testDoStuffWithJunitAssert() {

		// call the method
		String result = classToTest.doStuff();

		// ... and verify the result. It contains the value we defined in the
		// setup-method.
		assertEquals("mocked!", result);

	}

	// Tests that the service method has been called. This is similar to the first test, but 
	// checks the correct behavior of the content of the BasicClass.
	@Test
	public void testDoStuffWithMockitoVerify() {

		// call the method
		classToTest.doStuff();

		// ... and verify that the service-method has been called exactly once. 
		Mockito.verify(service).doComplexStuff();
	}
}
