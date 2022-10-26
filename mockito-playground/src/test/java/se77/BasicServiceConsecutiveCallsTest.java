package se77;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BasicServiceConsecutiveCallsTest {
	
	@Mock
	private BasicService service;
	
	@BeforeEach
	public void setup() {
		// this specifies up to three method invocations on the mock. third one will throw an exception
		when(service.doComplexStuff()).thenReturn("one", "two").thenThrow(new RuntimeException());
	}
	
	@Test
	public void testConsecutiveCalls() {
		
		// first call return "one"
		assertEquals("one", service.doComplexStuff());
		
		// first call return "two"	
		assertEquals("two", service.doComplexStuff());
		
		// third call throws exception
		assertThrows(RuntimeException.class, () -> service.doComplexStuff());
		
	}

}
