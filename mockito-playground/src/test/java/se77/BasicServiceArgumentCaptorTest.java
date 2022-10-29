package se77;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

// Example how to get access to an argument of a call to a mock.
@ExtendWith(MockitoExtension.class)
public class BasicServiceArgumentCaptorTest {
	
	@Mock
	private BasicService service;
	
	@Test
	public void testArgumentCapture() {
		
		// call method on mock during the test
		service.doStuffWitOneParameter(Integer.valueOf(1));
		
		// define a captor for the argument type you need
		ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);
		
		// use the captor during verification
		verify(service).doStuffWitOneParameter(captor.capture());
		
		// now you have access to the parameter that was used earlier during the call
		assertEquals(Integer.valueOf(1), captor.getValue());
	}

}
