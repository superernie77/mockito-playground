package se77;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

// Example for the use of ArgumentMatchers. These canbe used in stubbing or for test verifiction.
//For more info on Mockito check the Javadocs https://javadoc.io/static/org.mockito/mockito-core/3.12.4/org/mockito/Mockito.html
@ExtendWith(MockitoExtension.class)
public class BasicClassArgumentMatcherTest {
	
	// Mock the BasicService class. It is an dependency used in the BasicClass.
	@Mock
	BasicService service;

	// Inject the mock into the BasicClass we want to test.
	@InjectMocks
	BasicClass classToTest;
	
	
	@BeforeEach
	public void setup() {
		// This defines the accepted parameter values of the method. In this case any of the given types are accepted.
		Mockito.when(service.doStuffWithParameters(anyString(), any(Integer.class), anyBoolean())).thenReturn("mocked");
	}
	
	@Test
	public void testDoStuffWithParameters() {
		String result = service.doStuffWithParameters("test", 5, false);
		
		assertEquals("mocked", result);
		
		// verify that the method has been called by the exact parameters with ArgumentMatchers 
		verify(service).doStuffWithParameters( eq("test") ,  eq( Integer.valueOf(5)) , eq(false));
	}

}
