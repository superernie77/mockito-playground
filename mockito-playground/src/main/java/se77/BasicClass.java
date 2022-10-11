package se77;

public class BasicClass {
	
	
	private BasicService service = new BasicService();
	
	public String doStuff() {
		return service.doComplexStuff();
	}
	

}
