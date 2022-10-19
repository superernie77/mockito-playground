package se77;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

// Example to check if a method on a mock has been called a specified number of times after the test. 
@ExtendWith(MockitoExtension.class)
public class BasicClassInvocationNumberTest {

	// mock the BasicService class. It is a dependency used in the BasicClass.
	@Mock
	private BasicService service;

	// Inject the service-mock into the class we want to test
	@InjectMocks
	private BasicClass classToTest;

	@BeforeEach
	public void setup() {
		// Return the String "mocked!" when the doComplexStuff-method is called on the
		// mock. This is called "stubbing".
		Mockito.when(service.doComplexStuff()).thenReturn("mocked!");
	}

	// Test the method of the classToTest
	@Test
	public void testDoStuffWithMultipleCalls() {

		// call the method once
		String result = classToTest.doStuff();

		// call the method a second time
		String result2 = classToTest.doStuff();

		// verify that the method of the mocked service has been called twice
		verify(service, times(2)).doComplexStuff();
		
		// or if we don't want to check the exact number ...
		verify(service, atLeast(2)).doComplexStuff();
		
		// there are also other checks available, like never(), atMostOnce(), atLeastOnce() ...

		// ... and check the result. It contains the value we defined in the
		// setup-method.
		assertEquals("mocked!", result);
		assertEquals("mocked!", result2);
	}
}
