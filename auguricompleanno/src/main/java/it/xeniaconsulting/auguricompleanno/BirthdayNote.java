package it.xeniaconsulting.auguricompleanno;

public class BirthdayNote {
	private String recipient;
	private String message;
	
	public BirthdayNote(String recipient, String message) {
		this.recipient=recipient;
		this.message=message;
	}
	
	public String getRecipient() {
		return recipient;
	}
	
	public String getMessage() {
		return message;
	}
	
}
