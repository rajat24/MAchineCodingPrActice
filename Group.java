import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Group {

		public Group group = null;
		String groupName;
		ArrayList<User> users;
		static HashMap<String,ArrayList<User>> userGroupMap = new HashMap<String,ArrayList<User>>();
		static HashMap<String,ArrayList<Bill>> billGroupMap = new HashMap<String,ArrayList<Bill>>();
		
		public Group(String groupName) {
			this.groupName = groupName;
			
		}
		
		//adding users to group
		public static void addUsersToGroup(String groupName, ArrayList<User> users) {
			
			if(!userGroupMap.containsKey(groupName)) {
				userGroupMap.put(groupName, users);
			}else {
				ArrayList<User> list = userGroupMap.get(groupName);
				list.addAll(users);
				userGroupMap.put(groupName, list);
			}
		}
		
		// adding bills to the group
		public static void addTransactionToGroup(String groupName, ArrayList<Bill> transaction) {
			
			if(!billGroupMap.containsKey(groupName)) {
				billGroupMap.put(groupName, transaction);
			}else {
				ArrayList<Bill> list= billGroupMap.get(groupName);
				list.addAll(transaction);
			}
		}
		
		public static Double getBalanceOfPersonInGroup(String groupName, String userName) {
			
				
			//getBalanceImplementation
			Double totalExpense = 0.0;
			Double userExpense = 0.0;
			Double eachUserSplitAmpont = 0.0;
			ArrayList<Bill> transactionList = billGroupMap.get(groupName);
			
			for(Bill bill : transactionList) {
				if(bill.user.user_name.equals(userName)) {
					userExpense = bill.amountPaid;
				}
				totalExpense=totalExpense+bill.amountPaid;
				
			}
			int numberOfUsersInGroup = getNumbersOfUsersInGroup(groupName);
			eachUserSplitAmpont = totalExpense/numberOfUsersInGroup;
			userExpense=userExpense- eachUserSplitAmpont;
			
			return userExpense;
			
			
			
		}
		
		public static ArrayList<Bill> getBalanceOfeachPersonInGroup(String groupName) {
	
			ArrayList<User> userList= userGroupMap.get(groupName);
			ArrayList<Bill> expenseList = new ArrayList<Bill>();
			
			for(User user :userList) {
				Double amount = getBalanceOfPersonInGroup(groupName, user.user_name);
				Bill t = new Bill(user, amount);
				expenseList.add(t);
			}
			
			return expenseList;
			 
		}
		
		public static Double getBalanceofPersonAccrossGroups(User user) {
			
			Double totalBalance=0.0;
			
			for(String groupName: userGroupMap.keySet()) {
				ArrayList<User> userList = userGroupMap.get(groupName);
				for(User u :userList) {
					if(u.user_name.equals(user.user_name)) {
						totalBalance=totalBalance+getBalanceOfPersonInGroup(groupName, u.user_name);
					}
				}
			}
			return totalBalance;
		}
		public static int getNumbersOfUsersInGroup(String groupname) {
			int numberOfUsers;
			ArrayList<User> userList = userGroupMap.get(groupname);
			numberOfUsers= userList.size();
			
			return numberOfUsers;
		}
		
}
