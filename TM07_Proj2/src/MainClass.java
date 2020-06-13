import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

class Cards{
	char symbol;
	int number;
	Cards(char symbol,int number){
		this.number=number;
		this.symbol=symbol;
	}
}
public class MainClass {
	public static void main(String args[]) {
		Set<Cards> crd=new HashSet<Cards>();
		Scanner sc=new Scanner(System.in);
		Cards cc=null;
		System.out.println("Enter the no of cards:");
		int n=sc.nextInt();
		for(int i=0;i<n;i++) {
			System.out.println("Enter a card:");
			char c=sc.next().charAt(0);
			sc.nextLine();
			int number=sc.nextInt();
			if(i!=0) {
			if(cc.symbol!=c) 
			{
				cc=new Cards(c,number); 
			crd.add(cc);
			}}
			else {
				cc=new Cards(c,number); 
				crd.add(cc);
			}
		}
		sc.close();
		TreeMap<Integer,Cards> tm=new TreeMap<Integer,Cards>();
		for(Cards cd:crd) {
			if(cd.symbol=='a')
				tm.put(1, cd);
			else if(cd.symbol=='b')
				tm.put(2, cd);
			else if(cd.symbol=='c')
				tm.put(3, cd);
			else
				tm.put(4, cd);
		}
		for (Entry<Integer,Cards> entry : tm.entrySet())  
            System.out.println(entry.getValue().symbol +" "+ entry.getValue().number);  
	}

}
