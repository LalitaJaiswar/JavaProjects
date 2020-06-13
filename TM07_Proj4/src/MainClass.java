import java.util.*;

public class MainClass {
	public static void main(String args[]) {
		Map<Character,ArrayList<Integer>> map1=new TreeMap<Character,ArrayList<Integer>>();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the no of cards:");
		int n=sc.nextInt();
		for(int i=0;i<n;i++) {
			System.out.println("Enter a card:");
			char c=sc.next().charAt(0);
			sc.nextLine();
			int number=sc.nextInt();
			if(map1.containsKey(c)) {
				map1.get(c).add(number);
			}
			else {
				map1.put(c,new ArrayList<Integer>());
				map1.get(c).add(number);}
		}
		sc.close();
		Iterator<Character> i=map1.keySet().iterator();
		System.out.println("Distinct symbol are:");
		while(i.hasNext())
			System.out.print(i.next()+" ");
		i=map1.keySet().iterator();
		while(i.hasNext()) {
			char c=i.next();
			int sum=0,len=map1.get(c).size();
			System.out.println("\nCards in "+c+" are:");
			for(int j=0;j<len;j++) {
				sum=sum+map1.get(c).get(j);
				System.out.println(c+" "+map1.get(c).get(j)+" ");
				}
			System.out.println("Number of cards : "+len+"\nSum of numbers : "+sum);
		}
	}
}
