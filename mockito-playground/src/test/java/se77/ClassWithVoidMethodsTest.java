package se77;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ClassWithVoidMethodsTest {
	
	private ClassWithVoidMethods classToMock;
	
	@BeforeEach
	public void setup() {
		
		classToMock = Mockito.mock(ClassWithVoidMethods.class);
		
		// method call on the mock does nothing
		doNothing().when(classToMock).method1();
		
		// this will call the real method
		doCallRealMethod().when(classToMock).method2();
		
		// this will throw an exception
		doThrow(new RuntimeException()).when(classToMock).method3();
	}
	
	@Test
	public void testMethods() {
		
		// this will not print anything n the console
		classToMock.method1();
		
		// this will print ("Method 2 called" in the console
		classToMock.method2();
		
		
		// verify that method has been called
		verify(classToMock).method1();

		// verify that method has been called
		verify(classToMock).method2();
		
		// test that method3 throws an exception
		assertThrows(RuntimeException.class, () -> classToMock.method3() );
	}

}
