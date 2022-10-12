package se77;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

// Example on how to test error/exception cases with Mockito.
// For more info on Mockito check the Javadocs https://javadoc.io/static/org.mockito/mockito-core/3.12.4/org/mockito/Mockito.html
@ExtendWith(MockitoExtension.class)
public class BasicClassErrorTest {

	// Mock the BasicService class. It is an dependency used in the BasicClass.
	@Mock
	BasicService service;

	// Inject the mock into the BasicClass we want to test.
	@InjectMocks
	BasicClass classToTest;

	// Setup the behavior of the mocked class.
	@BeforeEach
	public void setup() {
		// Throw an RuntimeException when the doComplexStuff-method is called on the
		// mock. By this you can test correct error handling of your test class without
		// the need of causing a real exception.
		Mockito.when(service.doComplexStuff()).thenThrow(new RuntimeException());
	}

	// Test the method of the class
	@Test
	public void testDoStuffWithException() {

		// call the method and tell JUnit 5 to expect a RuntimeException.
		assertThrows(RuntimeException.class, () -> classToTest.doStuff());
	}

}
