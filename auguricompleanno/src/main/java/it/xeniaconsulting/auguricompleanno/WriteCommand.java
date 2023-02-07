package it.xeniaconsulting.auguricompleanno;

import java.util.ArrayList;

public class WriteCommand {
	
	public ArrayList<BirthdayNote> writeNotesFor(ArrayList<Friend> friends) {
		ArrayList<BirthdayNote> ret = new ArrayList<BirthdayNote>();
		for(Friend f : friends) {
			String s = "Happy birthday, dear "+f.getFirstName()+"!";
			String email = f.getEmail();
			ret.add(new BirthdayNote(email,s));
		}
		return ret;
	}
}
