package it.xeniaconsulting.auguricompleanno;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BirthdayService {
	private FriendsRepository friendsRepository;
	private List<NoteSender> senders;
	
	public BirthdayService(FriendsRepository friendsRepository, IProtocolFactory pf, WriteCommand writer) {
		this.friendsRepository=friendsRepository;
		senders = pf.createSenders(writer);
	}
	
	public void sendBirthdayNotes(Date date, String protocol) {
		ArrayList<Friend> friendsCelebrating = friendsRepository.friendsWhoseBirthdayIs(date);
		for(NoteSender sender : senders) {
			if(sender.isProtocolSupported(protocol)) {
				sender.send(friendsCelebrating);
			}
		}
	}

	
}
