package it.xeniaconsulting.auguricompleanno;

import java.util.ArrayList;

public interface NoteSender {
	abstract void send(ArrayList<Friend> friends);
	abstract boolean isProtocolSupported(String protocol);
	abstract String getUsedProtocol();
}
