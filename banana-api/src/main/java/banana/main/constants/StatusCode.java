package banana.main.constants;

public enum StatusCode {
	
	SUCCESS ("0000", "Successful"),
	
	//1xxx - db errors
	DB_SUCCESS("1000", "Successful db operation"),
	USER_ALREADY_EXISTS("1001", "User already exists");
	
	private String statusCode;
	private String statusDesc;
	
	StatusCode(String code, String desc) {
		this.statusCode = code;
		this.statusDesc = desc;
	}
	
	public String getStatusCode() {
		return this.statusCode;
	}
	
	public String getStatusDesc() {
		return this.statusDesc;
	}
	
	public String toString() {
		return this.statusCode + "-" + this.statusDesc;
	}

}
