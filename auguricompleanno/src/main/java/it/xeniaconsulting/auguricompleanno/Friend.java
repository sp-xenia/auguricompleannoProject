package it.xeniaconsulting.auguricompleanno;

import java.util.Date;

public class Friend {
	private String firstName;
	private String lastName;
	private String email;
	private Date birthday;
	
	public Friend(String firstName, String lastName, String email, Date birthday) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
		this.birthday=birthday;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	
	@Override
	public String toString() {
		return ""+lastName+", "+firstName+", "+birthday+", "+email;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this==o) return true;
		if(!(o instanceof Friend)) return false;
		Friend f = (Friend)o;
		return firstName.equals(f.firstName) && (lastName.equals(f.lastName))
				&& (email.equals(f.email)) && (birthday.equals(f.birthday));
	}
	
	@Override
	public int hashCode() {
		int numPrimo = 31;
		int ret = 1;
		ret=ret*numPrimo*firstName.hashCode();
		ret=ret*numPrimo*lastName.hashCode();
		ret=ret*numPrimo*email.hashCode();
		ret=ret*numPrimo*birthday.hashCode();
		return ret;
	}
}
