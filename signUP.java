package miniSocialNetwork;

import java.util.ArrayList;

public class signUP {

	private static ArrayList<Integer> registeredUsers = new ArrayList<Integer>();
	private int id;
	
	public signUP(user u) {
		this.id  = u.id; 
		if(!registeredUsers.contains(id)) {
			registeredUsers.add(id);
		}
	}
	
	static public int numberOfUsersInNetwork() {
		return registeredUsers.size();
	}
	
}
