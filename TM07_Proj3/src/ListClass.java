import java.util.ArrayList;
import java.util.Iterator;
class ListClass{
	ArrayList<String> arr=new ArrayList<String>();
	void add(String item) {
		arr.add(item);
		System.out.println("Inserted successfully.");
	}
	boolean search(String item) {
		Iterator<String> i=arr.iterator();
		while(i.hasNext()) {
			if(i.next().equals(item))
				return true;
		}
		return false;
	}
	void display1() {
		if(arr.size()<0) {
			System.out.print("Sorry, List is empty!");
			return;
		}
		else {
			System.out.print("The item in the list are:");
			Iterator<String> i=arr.iterator();	
			while(i.hasNext()) {
				System.out.println(i.next());
			}
		}
	}
	boolean delete(String item) {
		int index=0;
		Iterator<String> i=arr.iterator();
		while(i.hasNext()) {
			if(i.next().equals(item)) {
			arr.remove(index);
			return true;
			}
			index++;
		}
		return false;
	}
	
}