package it.xeniaconsulting.auguricompleanno;

import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

public class EmailNoteSender implements NoteSender {
	private String senderEmail;
	private Session session;
	private String protocol = "email";
	private WriteCommand writer;
	
	public EmailNoteSender(String senderEmail, String smtpHostServer, WriteCommand writer) {
		this.senderEmail=senderEmail;
		this.writer=writer;
		
		Properties props = new Properties();
	    props.put("mail.smtp.host", smtpHostServer);
		session = Session.getInstance(props, null);
	}
	
	public void send(ArrayList<Friend> friends) {
		ArrayList<BirthdayNote> bdayNotes = writer.writeNotesFor(friends);
		for(BirthdayNote bdayNote : bdayNotes) {
			sendNote(bdayNote);
		}
	}
	
	public boolean isProtocolSupported(String protocol) {
		return this.protocol.equals(protocol);
	}
	
	public String getUsedProtocol() {
		return protocol;
	}
	
	private void sendNote(BirthdayNote bdayNote) {
	    try {
	    	MimeMessage msg = new MimeMessage(session);
	    	msg.setFrom(senderEmail);
	    	msg.setRecipients(Message.RecipientType.TO,bdayNote.getRecipient());
	    	msg.setSubject("Happy birthday!");
	    	msg.setSentDate(new Date());
	    	msg.setText(bdayNote.getMessage());
	    	Transport.send(msg);
	    } catch(MessagingException e) {
	    	e.printStackTrace();
	    }
	}
}
