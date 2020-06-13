import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ListClass lc=new ListClass();
		String item=" ";
		while(true) {
			System.out.println("1. Insert\n2. Search\n3. Delete\n4. Display\n5. Exit\nEnter your choice:");
			int choice=sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1:
				System.out.println("Enter the item to be inserted:");
				item=sc.nextLine();
				lc.add(item);
				break;
			case 2:
				System.out.println("Enter the item to search:");
				item=sc.nextLine();
				if(lc.search(item))
					System.out.println("Item found in the list");
				else
					System.out.println("Item not found in the list.");
				break;
			case 3:
				System.out.println("Enter the item to delete:");
				item=sc.nextLine();
				if(lc.search(item))
					System.out.println("Item deleted successfully");
				else
					System.out.println("Item not found in the list.");
				break;
			case 4:
				lc.display1();
				break;
			case 5:
				System.out.println("Exiting...");
				System.exit(0);
			}
		}
	}

}
