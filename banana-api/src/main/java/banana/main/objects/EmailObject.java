package banana.main.objects;

import java.util.List;

public class EmailObject {
	
	private String subject;
	private String message;
	private List<String> to;
	private List<String> cc;
	private String from;
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public List<String> getTo() {
		return to;
	}
	
	public void setTo(List<String> to) {
		this.to = to;
	}
	
	public List<String> getCc() {
		return cc;
	}
	
	public void setCc(List<String> cc) {
		this.cc = cc;
	}
	
	public String getFrom() {
		return from;
	}
	
	public void setFrom(String from) {
		this.from = from;
	}

}
