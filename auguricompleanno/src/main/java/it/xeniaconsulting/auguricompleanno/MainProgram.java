package it.xeniaconsulting.auguricompleanno;

import java.util.Date;

public class MainProgram {
	private static String friendsFile = "friends.txt";
	
	public static void main(String[] args) {
		FlatFileFriendsRepository friendsRep = new FlatFileFriendsRepository(friendsFile);
		ProtocolFactory pf = new ProtocolFactory();
		WriteCommand writer = new WriteCommand();
		BirthdayService bs = new BirthdayService(friendsRep, pf, writer);
		bs.sendBirthdayNotes(new Date(), "email");
	}
	
}
