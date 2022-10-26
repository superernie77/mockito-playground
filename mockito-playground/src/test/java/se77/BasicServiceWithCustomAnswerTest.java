package se77;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

// Example for a custom return value for a method invocation
@ExtendWith(MockitoExtension.class)
public class BasicServiceWithCustomAnswerTest {
	
	@Mock
	private BasicService service;
	
	@BeforeEach
	public void setup() {
		
		when(service.doStuffWithParameters(anyString(), anyInt(), anyBoolean())).thenAnswer( invocation -> {
			BasicService mock = (BasicService)invocation.getMock();
			String arg1 = (String)invocation.getArgument(0);
			return "Answer of mock: "+mock.toString()+" , first argument is: "+arg1;
		});
	}
	
	@Test
	public void testCustomAnswer() {
		assertEquals("Answer of mock: service , first argument is: one", service.doStuffWithParameters("one", 2, false));
	}

}
