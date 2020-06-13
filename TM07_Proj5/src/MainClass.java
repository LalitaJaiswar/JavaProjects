import java.util.*;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		HashMap<Double,Integer> volume=new HashMap<Double,Integer>();
		Set<Box> st=new HashSet<Box>();
		System.out.println("Enter the number of box:");
		int n=sc.nextInt();
		for(int i=0;i<n;i++) {
			System.out.println("Enter the box "+(i+1)+" details:");
			double l,h,w;
			System.out.println("Enter length:");
			l=sc.nextDouble();	
			System.out.println("Enter width:");
			w=sc.nextDouble();	
			System.out.println("Enter height:");
			h=sc.nextDouble();	
			if(!volume.containsKey(l*h*w)) {
				st.add(new Box(l,w,h));
				volume.put(l*h*w, 1);
			}
				
			}
		sc.close();
		System.out.println("Unique boxes in the set are:");
		Iterator<Box> i=st.iterator();
		while(i.hasNext()) {
			Box e=i.next();
			System.out.println("Length="+e.length+" Width="+e.width+" Height="+e.height+" Volume="+(e.length*e.height*e.width));
		}
		
	}

}
