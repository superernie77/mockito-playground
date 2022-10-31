package se77;

import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

// Example of how to reset a mock after use
@ExtendWith(MockitoExtension.class)
public class BasicClassResetMockTest {
	
	@Mock
	private BasicClass basicClass;
	
	@Test
	public void testResetMock() {
		
		// call a method
		basicClass.doStuff();
		
		// verify that the method was called
		verify(basicClass).doStuff();
		
		// reset the mock
		reset(basicClass);
		
		// ´for Mockito the mock has never been used
		verifyNoInteractions(basicClass);
	}
		

}
