package miniSocialNetwork;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class Post {

	ArrayList<ArrayList<Node>> postDataList = new ArrayList<ArrayList<Node>>();
	
	
	ArrayList<Node> alldataList = new ArrayList<Post.Node>();
	
	Node head;
	
	class Node{
		int id;
		Timestamp ts; 
		String post;
		
		
		Node(int id, String post, Timestamp ts){
			this.id = id;
			this.post = post;
			this.ts = ts;
			
		}
	}
		
	public void addPost(int id, String post) {
		getTimestamp timestamp =new getTimestamp();
		Timestamp ts = timestamp.getCurrentTimestamp();
		
		Node node = new Node(id,post,ts);
		
		
		int size = postDataList.size();
	//	System.out.println("size is: "+size+ " id is: "+id);
		
		if(size<=id || size==0) {
			for(int i=0;i<=id-size;i++) {
				//System.out.println("addinf");
				postDataList.add(new ArrayList<Node>());
			}
		}
		alldataList.add(node);
		addPostInList(postDataList,id,node);
	}
	
	public void addPostInList(ArrayList<ArrayList<Node>> postDataList, int id, Node dataNode) {
		postDataList.get(id).add(dataNode);
	}
	
	public void viewTimeline(ArrayList<Integer> list, int id) {
		
		HashSet<Integer> set = new HashSet<Integer>();
		for(Integer i : list) {
			set.add(i);
		}
		set.add(id);
		
		System.out.println("Welcome to your timline user ###"+id);
		
		for(Node node : alldataList) {
			if(set.contains(node.id)) {
				//System.out.println("::time::"+node.ts);
				System.out.println("User"+node.id+" posted :: "+node.post+ "   @ "+node.ts);
			}
		}
		
		/*
		 * int count = postDataList.get(id).size();
		 * 
		 * for(int i =0;i<count;i++) { Node node = postDataList.get(id).get(i);
		 * System.out.println("Post#"+i+"    ::time::"+node.ts);
		 * System.out.println(node.post);
		 * 
		 * }
		 */
		//System.out.println(postDataList.get(id));
	}
}
