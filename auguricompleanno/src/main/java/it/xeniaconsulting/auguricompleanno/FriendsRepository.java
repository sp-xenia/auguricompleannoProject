package it.xeniaconsulting.auguricompleanno;

import java.util.ArrayList;
import java.util.Date;

public interface FriendsRepository {
	abstract ArrayList<Friend> friendsWhoseBirthdayIs(Date date);
}
