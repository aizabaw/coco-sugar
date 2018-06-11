package banana.main.constants;

public enum Role {
	
	MANAGER (1, "Manager"), 
	STAFF (2, "Staff"),
	CASHIER (3, "Cashier");
	
	private final int id;
	private final String name;
	
	Role (int id, String name) {
		
		this.id = id;
		this.name = name;
		
	}
	
	public String toString() {
		return this.name();
	}

}
