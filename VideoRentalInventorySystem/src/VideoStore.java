import java.util.*;

public class VideoStore extends Video{
	ArrayList<Video> store=new ArrayList<Video>();
	static int i=0;
	void addVideo(String name) {
		store.add(new Video(name));
		store.get(i).checkOut=false;
		store.get(i).rating=0;
		System.out.println("Video "+name+" added successfully");
		i++;
	}
	void doCheckOut(String name) {
		boolean flg=false;
		for(int j=0;j<store.size();j++) {
			if(store.get(j).videoName.equals(name)){
				store.get(j).doCheckOut();
				flg=true;
				break;
			}
		}
		if(!flg)
		System.out.println("Either the invenotory is empty or their is no video with this name");
	}
	void doReturn(String name) {
		boolean flg=false;
		for(int j=0;j<store.size();j++) {
			if(store.get(j).videoName.equals(name)){
				store.get(j).checkOut=false;
				store.get(j).doReturn();
				flg=true;
				break;
			}
		}
		if(!flg)
		System.out.println("Either the invenotory is empty or their is no video with this name");
	}
	void recieveRating(String name,int rating) 
	{
		boolean flg=false;
		for(int j=0;j<store.size();j++) {
			if(store.get(j).videoName.equals(name)){
				flg=true;
				store.get(j).recieveRating(rating);
				break;
			}
		}
		if(flg)
		System.out.println("Rating "+rating+" has mapped to the video "+name);
		else
			System.out.println("Either the invenotory is empty or their is no video with this name");
	}
	void listInventory() {
		System.out.println("----------------------------------------------------------");
		System.out.println("Video Name\t|\tCheckout Status\t|\tRating\t");
		for(int j=0;j<i;j++) {
			System.out.println(store.get(j).videoName+"\t\t|\t\t"+store.get(j).checkOut+"\t|\t"+store.get(j).rating);
		}
		System.out.println("----------------------------------------------------------");

	}
}
