package it.xeniaconsulting.auguricompleanno;

import java.util.ArrayList;

public class TestNoteSender implements NoteSender {
	
	private String protocol;
	
	public boolean isProtocolSupported(String protocol) {
		this.protocol=protocol;
		return false;
	}
	
	public String getUsedProtocol() {
		return protocol;
	}
	
	public void send(ArrayList<Friend> friends) {
		
	}
}
