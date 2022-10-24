package se77;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

// Example for a test when a mock should not have been called after execution. 
@ExtendWith(MockitoExtension.class)
public class ClassWithVoidMethodsNeverCalledTest {
	
	// lets create a mock with the annotation
	@Mock
	ClassWithVoidMethods mock;
	
	// inject the mock into the test method
	@Test
	public void testMethodNotCalled(@Mock ClassWithVoidMethods mock) {
				
		// call method1
		mock.method1();
		
		// verify method1 was called
		verify(mock).method1();
		
		// verify that method2 was not called
		verify(mock, never()).method2();
		
		// test that no other method was called at all on the mock
		verifyNoMoreInteractions(mock);
		
	}

}
