import java.util.*;

public class VideoLauncher extends VideoStore {
public static void main(String agrs[]) {
	VideoStore vs=new VideoStore();
	Scanner sc=new Scanner(System.in);
	String name=" ";
	while(true) {
	System.out.println("Main Menu\n----------\n----------");
	System.out.println("1. Add Video\n2.Check Out Videos\n3. Return Video\n4. Recieve Rating\n5. List Inventory\n6. Exit\nEnter your choice:");
	int choice=sc.nextInt();
	switch(choice) {
	case 1:
		sc.nextLine();
		System.out.println("Enter the name of video you want to add:");
		name=sc.nextLine();
		vs.addVideo(name);
		break;
	case 2:
		sc.nextLine();
		System.out.println("Enter the name of video you want to checkout:");
		name=sc.nextLine();
		vs.doCheckOut(name);
		break;
	case 3:
		sc.nextLine();
		System.out.println("Enter the name of video you want to return:");
		name=sc.nextLine();
		vs.doReturn(name);
		break;
	case 4:
		sc.nextLine();
		System.out.println("Enter the name of video you want to rate:");
		name=sc.nextLine();
		System.out.println("Enter the rating for the video:");
		int rating=sc.nextInt();
		vs.recieveRating(name, rating);
		break;
	case 5:
		vs.listInventory();
		break;
	case 6:
		System.out.println("Exiting....Thanks for using the application");
		sc.close();
		System.exit(0);
	}
	}
}
}
