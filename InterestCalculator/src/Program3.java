import java.util.*;

public class Program3 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int noOfDays=0,ageOfACHolder=0;
		double amount=0;
		while(true) {
		System.out.println("Main Menu\n-------------");
		System.out.println("1. Interest Calculator-SB\n2. Interest Calculator-FD\n3. Interest Calculator-RD\n4. Exit\nEnter your choice:");
		int choice=sc.nextInt();
		switch(choice) {
		case 1:
			System.out.println("Enter the average amount in your account:");
			amount=sc.nextDouble();
			if(amount<0)
				System.out.println("Please enter only non-negative values!");
			SBAccount sb=new SBAccount(amount);
			System.out.println("Interest Gained: "+sb.calculateInterest());
			break;
		case 2:
			System.out.println("Enter the FD amount:");
			amount=sc.nextDouble();
			System.out.println("Enter the no of Days:");
			noOfDays=sc.nextInt();
			System.out.println("Enter your age:");
			ageOfACHolder=sc.nextInt();
			if(amount<0 || noOfDays<0 || ageOfACHolder<0) {
				System.out.println("Please enter only non-negative values!");
				break;}
			FDAccount fd=new FDAccount(amount,noOfDays,ageOfACHolder);
			fd.initial();
			System.out.println("Interest Gained:"+fd.calculateInterest());
			break;
		case 3:
			System.out.println("Enter the RD amount:");
			amount=sc.nextDouble();
			System.out.println("Enter the no of Days:");
			noOfDays=sc.nextInt();
			System.out.println("Enter your age:");
			ageOfACHolder=sc.nextInt();
			if(amount<0 || noOfDays<0 || ageOfACHolder<0) {
				System.out.println("Please enter only non-negative values!");
				break;}
			RDAccount rd=new RDAccount(amount,noOfDays,ageOfACHolder);
			rd.initial();
			System.out.println("Interest Gained:"+rd.calculateInterest());
			break;
		case 4:
			System.out.println("Exiting...Thanks for using the application!");
			System.exit(0);
			break;
		}
		sc.close();
		}
	}
}
