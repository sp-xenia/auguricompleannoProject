package it.xeniaconsulting.auguricompleanno;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FlatFileFriendsRepository implements FriendsRepository {
	private String path;
	
	public FlatFileFriendsRepository(String path) {
		this.path=path;
	}
	
	public ArrayList<Friend> friendsWhoseBirthdayIs(Date date) {
		ArrayList<Friend> ret = new ArrayList<Friend>();
		try {
			ArrayList<Friend> friends = getFriendsList();
			for(Friend f : friends)
				if(f.getBirthday().equals(date)) ret.add(f);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return ret;
		
	}
	
	private ArrayList<Friend> getFriendsList() throws IOException, ParseException {
		ArrayList<Friend> ret = new ArrayList<Friend>();
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		try {
			String line = br.readLine();
			while(line != null) {
				String[] tokens = line.split(", ");
				String lastName = tokens[0];
				String firstName = tokens[1];
				Date date = new SimpleDateFormat("yyyy/MM/dd").parse(tokens[2]);
				String email = tokens[3];
				Friend f = new Friend(lastName,firstName,email,date);
				ret.add(f);
				line = br.readLine();
			}
		} finally {
			fr.close();
			br.close();
		}
		return ret;
	}
}

