import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str1,str2;
		str1=sc.nextLine();
		str2=sc.nextLine();
		char arrStr1[]=str1.toCharArray();
		char arrStr2[]=str2.toCharArray();
		int n1=str1.length(),n2=str2.length();
		sc.close();
		Compare cmp=new Compare();
		ArrayList<String> res=new ArrayList<String>();
		ArrayList<Integer> arr=cmp.match(str2, str1);
		String op1="",op2="",op3="",op4="",op5=str1;
		for(int i=0;i<n1;i++) {
			if(i%2==0)
				op1=op1+str2;
			else
				op1=op1+arrStr1[i];
		}
		int n=arr.size();
		if(arr.size()>1) {
			String rev=new StringBuilder(str2).reverse().toString();
			op2=str1.substring(0, arr.get(n-1))+rev+str1.substring(arr.get(n-1)+n2,n1);
			op3=str1.substring(0,arr.get(0))+str1.substring(arr.get(0)+n2,n1);
		}
		else {
			op3=str1;
			op2=str1+str2;}
		if(n2%2!=0) 
			op4=str2.substring(0, (n2/2)+1)+str1+str2.substring((n2/2)+1, n2);
		else
			op4=str2.substring(0, (n2/2))+str1+str2.substring((n2/2), n2);
		for(int i=0;i<n2;i++) {
			op5=op5.replace(arrStr2[i], '*');
		}
		res.add(op1);
		res.add(op2);
		res.add(op3);
		res.add(op4);
		res.add(op5)
;		System.out.print(res);
	}

}
