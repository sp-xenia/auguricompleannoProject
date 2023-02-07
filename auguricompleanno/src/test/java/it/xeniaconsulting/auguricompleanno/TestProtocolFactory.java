package it.xeniaconsulting.auguricompleanno;

import java.util.Collections;
import java.util.List;

public class TestProtocolFactory implements IProtocolFactory {
	
	List<NoteSender> singletonList = Collections.singletonList((NoteSender)new TestNoteSender());
	
	public List<NoteSender> createSenders(WriteCommand writer) {
		return singletonList;
	}
}
