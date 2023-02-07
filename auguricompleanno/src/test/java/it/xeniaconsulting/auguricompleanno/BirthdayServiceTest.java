package it.xeniaconsulting.auguricompleanno;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

public class BirthdayServiceTest {
   
	@Test
	public void testSender() {
		FlatFileFriendsRepository friendsRep = new FlatFileFriendsRepository("");
		IProtocolFactory pf = new TestProtocolFactory();
		WriteCommand writer = new WriteCommand();
		
		BirthdayService bs = new BirthdayService(friendsRep,pf,writer);
		
		bs.sendBirthdayNotes(new Date(), "email");
		TestNoteSender noteSender = (TestNoteSender)pf.createSenders(writer).get(0);
		assertEquals("email", noteSender.getUsedProtocol());
	}
}
