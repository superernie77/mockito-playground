package se77;

public class BasicClass {
	
	
	private BasicService service = new BasicService();
	
	public String doStuff() {
		return service.doComplexStuff();
	}
	
	public String doStuffWithParameters(String param1, Integer param2, boolean param3) {
		return service.doStuffWithParameters(param1, param2, param3);
	}

}
