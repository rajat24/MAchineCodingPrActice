package miniSocialNetwork;

import java.util.ArrayList;

public class UserFollowList {

	private ArrayList<ArrayList<Integer>> followList = new ArrayList<ArrayList<Integer>>();
	
	
	public void add(user user1, user user2) {
		
		int id1 = user1.id;
		int id2 = user2.id;
		
		if(followList.size()<=id1 || followList.size()==0) {
			int k = id1-followList.size() +1;
			
			for(int i =0;i<k;i++) {
	
				followList.add(new ArrayList<Integer>());
			}
		}
		//calling the addEdge method to add the link between the two id's in our adjacency list.
		System.out.println(" follow list size:"+followList.size());
		addEdge(followList,id1,id2);
	}
	
	public void addEdge(ArrayList<ArrayList<Integer>> followList, int id1, int id2) {
		System.out.println("adding :"+id2+" to "+id1+" list") ;
		followList.get(id1).add(id2);
		//followList.get(id2).add(id1);
		
	}
	
	
	// to get the list of people followed by the provided user.
	public ArrayList<Integer> getParticularUsrFollowList(int id) {
	
		ArrayList<Integer> list = followList.get(id);
		
		return list;
	}
}

