package miniSocialNetwork;

import java.util.ArrayList;

public class socialNetwork {
	
	

	public static void main(String[] args) {
		
		user user1 = new user(1,"Rajat");
		signUP register1 = new signUP(user1);
		
		user user2 = new user(2,"Subrat");
		signUP register2 = new signUP(user2);
		
		user user3 = new user(3,"Ajay");
		signUP register3 = new signUP(user3);
		
		user user4 = new user(4,"Komal");
		signUP register4 = new signUP(user4);
		/*
		 * signUP admin = new signUP(0); signUP registerUser1 = new signUP(1); signUP
		 * registerUSer2 = new signUP(2); signUP registerUser3 = new signUP(3);
		 */
			
		
		 int num_registered_users = signUP.numberOfUsersInNetwork();
		 System.out.println("Number of registered users are ::" +
		 num_registered_users);
		 
		UserFollowList followlist = new UserFollowList();
		followlist.add(user1,user2);
		followlist.add(user1,user3);
		followlist.add(user1,user4);
		followlist.add(user2,user3);
		followlist.add(user3,user4);
		
		
		ArrayList<Integer> followerList = followlist.getParticularUsrFollowList(1);
		//to print folloew userIds
		
		  System.out.println("Follower for userId : "+1); for(Integer i : followerList)
		  { System.out.println(i); }
		 
		
		Post publishPost = new Post();
		publishPost.addPost(1, "My first post -admin");
		publishPost.addPost(1, "apun heroich h");
		ArrayList<Integer> list  = followlist.getParticularUsrFollowList(1);
		
		
		
		publishPost.addPost(2, "My first post -user1");
		publishPost.addPost(2, "apun bhi hero h");
		publishPost.addPost(1, "Bahubali se panga");
		publishPost.addPost(3, "Kya ukhaad lega re tu bahubali");
		publishPost.addPost(4, "MAi bhi bahubali");
		publishPost.addPost(4, "Bahubali ka beta");
		
		publishPost.viewTimeline(list,1);
		//publishPost.viewTimeline(1);
		
	}
}
