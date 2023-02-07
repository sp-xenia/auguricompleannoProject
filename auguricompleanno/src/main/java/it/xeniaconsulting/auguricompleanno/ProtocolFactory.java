package it.xeniaconsulting.auguricompleanno;

import java.util.Arrays;
import java.util.List;

public class ProtocolFactory implements IProtocolFactory {
	
	private String senderEmail = "name@example.com";
	private String hostServer = "my-mail-server";
	
	public List<NoteSender> createSenders(WriteCommand writer) {
		NoteSender emailSender = new EmailNoteSender(senderEmail, hostServer, writer);
		return Arrays.asList(emailSender);
	}
}
