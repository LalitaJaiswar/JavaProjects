import java.util.*;

public class MainClass {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the no of employee you want to store:");
		int n=sc.nextInt();
		HashMap<Integer,String[]> arr=new HashMap<Integer,String[]>();
		sc.nextLine();
		String firstName=" ",lastName=" ",mobile=" ",email=" ",address=" ";
		for(int i=0;i<n;i++) {
			System.out.println("Enter employee"+(i+1)+" details:\nEnter the Firstname:");
			firstName=sc.nextLine();
			System.out.println("Enter the last name:");
			lastName=sc.nextLine();
			System.out.println("Enter the mobile:");
			mobile=sc.nextLine();
			System.out.println("Enter the email:");
			email=sc.nextLine();
			System.out.println("Enter the address:");
			address=sc.nextLine();
			arr.put(i+1,new String[] {firstName,lastName,mobile,email,address});
		}
		if(arr.size()<1)
			System.out.print("No employee records to display!");
		else {
			System.out.format("Employee List:\n%-15s %-15s %-15s %-15s %-30s\n","firstName","lastName","mobile","email","address");
			for(int i=0;i<n;i++) {
				System.out.format("%-15s %-15s %-15s %-15s %-30s\n",firstName,lastName,mobile,email,address);
			}
		}

	}

}
