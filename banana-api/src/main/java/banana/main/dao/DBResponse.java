package banana.main.dao;

public class DBResponse {
	
	public enum DBStatus {
		SUCCESS, 
		NOT_FOUND, 
		INVALID_PARAMETER,
		ALREADY_EXISTS, 
		CONNECTION_FAILED, 
		TIMEOUT, 
		FAILED;
	}
	
	private DBStatus status;
	private Object respObj;

	public DBResponse(DBStatus status) {
		this.status = status;
	}
	
	public DBResponse(DBStatus status, Object respObj) {
		this.status = status;
		this.respObj = respObj;
	}
	
	public DBStatus getStatus() {
		return status;
	}

	public void setStatus(DBStatus status) {
		this.status = status;
	}

	public Object getRespObj() {
		return respObj;
	}

	public void setRespObj(Object respObj) {
		this.respObj = respObj;
	}
	
	public String toString() {
		StringBuffer strBuff = new StringBuffer();
		strBuff.append("DBResponse: " + status);
		if (respObj != null) {
			strBuff.append(", " + respObj);
		}
		
		return strBuff.toString();
	}
	

}
