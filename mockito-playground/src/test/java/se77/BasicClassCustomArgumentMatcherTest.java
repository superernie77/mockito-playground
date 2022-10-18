package se77;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

//Example for the use of custom ArgumentMatchers in the verification part of the test. 
//For more info on Mockito check the Javadocs https://javadoc.io/static/org.mockito/mockito-core/3.12.4/org/mockito/Mockito.html
@ExtendWith(MockitoExtension.class)
public class BasicClassCustomArgumentMatcherTest {

	// Mock the BasicService class. It is an dependency used in the BasicClass.
	@Mock
	private BasicService service;

	// Inject the mock into the BasicClass we want to test.
	@InjectMocks
	private BasicClass classToTest;

	@BeforeEach
	public void setup() {
		// This defines the accepted parameter values of the method. In this case any of
		// the given types are accepted.
		when(service.doStuffWithParameters(anyString(), any(Integer.class), anyBoolean())).thenReturn("mocked");
	}

	@Test
	public void testDoStuffWithParameters() {
		String result = service.doStuffWithParameters("test", 5, false);

		assertEquals("mocked", result);

		// verify that the method has been called by the exact parameters with
		// cuatom ArgumentMatchers
		verify(service).doStuffWithParameters( 
				argThat( s -> s.equals("test")), // inside the Lambda anything can be checked that evaluates to a boolean for the given type  
				argThat( i -> i.equals(5)), 
				booleanThat(b -> b.equals(false)) ); // there is a version for any primitive type
	}

}
