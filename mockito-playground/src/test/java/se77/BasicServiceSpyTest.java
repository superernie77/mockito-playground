package se77;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

// Example of creating a spy to check invocations on a real object
@ExtendWith(MockitoExtension.class)
public class BasicServiceSpyTest {
	
	@Test
	public void testSpyOnService() {
		
		// first crete the real object
		BasicService service = new BasicService();
		
		// ... then create a spy on the object
		BasicService serviceSpy = spy(service);
		
		// you can now also stub methods on the spy (partial mocking)
		when(serviceSpy.doComplexStuff()).thenReturn("spy invocation");
		
		// test the the stubbing worked
		assertEquals("spy invocation",  serviceSpy.doComplexStuff() );
		
		// verify that the method was called
		verify(serviceSpy).doComplexStuff();
		
		// this works also on unstubbed methods
		serviceSpy.doStuffWithParameters("one", 2, false);
		
		// verify that the method was called
		verify(serviceSpy).doStuffWithParameters("one", 2, false);
		
	}

}
