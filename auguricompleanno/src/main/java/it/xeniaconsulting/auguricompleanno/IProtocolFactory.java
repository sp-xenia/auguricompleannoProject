package it.xeniaconsulting.auguricompleanno;

import java.util.List;

public interface IProtocolFactory {
	abstract List<NoteSender> createSenders(WriteCommand writer);
}
