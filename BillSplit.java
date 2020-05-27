import java.util.ArrayList;

public class BillSplit {

	public static void main(String[] args) {
		
		
		User user1  = new User("Rajat", 1);
		User user2  = new User("Subrat", 2);
		User user3 = new User("Ajay", 3);
		User user4 = new User("Komal", 4);
		
		
		ArrayList<User> userList1 = new ArrayList<User>();
		userList1.add(user4);
		userList1.add(user3);
		userList1.add(user2);
		userList1.add(user1);
		
		ArrayList<User> userList2 = new ArrayList<User>();
		userList2.add(user3);
		userList2.add(user2);
		userList2.add(user1);
		Group group1 = new Group("Komal's house party");
		Group group2 = new Group("Londe party");
		//System.out.println(group1.groupName);
		Group.addUsersToGroup(group1.groupName, userList1);
		Group.addUsersToGroup(group2.groupName, userList2);
		
		Bill bill1 =new Bill(user1, 100.0);
		Bill bill2 = new Bill(user2, 100.0);
		Bill bill3 = new Bill(user3, 100.0);
		
		Bill bill4 =new Bill(user1, 80.0);
		Bill bill5 = new Bill(user2, 100.0);
	
		
		ArrayList<Bill> billList1 = new ArrayList<Bill>();
		billList1.add(bill1);
		billList1.add(bill2);
		billList1.add(bill3);
		
		ArrayList<Bill> billList2 = new ArrayList<Bill>();
		billList2.add(bill4);
		billList2.add(bill5);
		
		Group.addTransactionToGroup(group1.groupName, billList1);
		Group.addTransactionToGroup(group2.groupName, billList2);
		
		Double userBalanceinGroup = Group.getBalanceOfPersonInGroup(group1.groupName,user3.user_name);
		System.out.println(userBalanceinGroup);
		
		ArrayList<Bill> expenseListOFUser = Group.getBalanceOfeachPersonInGroup(group1.groupName);
		for(Bill individualUSerExpense : expenseListOFUser) {
			System.out.println(individualUSerExpense.user.user_name+ " :: "+individualUSerExpense.amountPaid);
		}
		
		
		  Double userBalanceinGroup2 =
		  Group.getBalanceOfPersonInGroup(group2.groupName,user3.user_name);
		  System.out.println(userBalanceinGroup2);
		 
		Double TotalExpenseAcrossGrops = Group.getBalanceofPersonAccrossGroups(user1);
		System.out.println(TotalExpenseAcrossGrops);
		
		

	}

}
