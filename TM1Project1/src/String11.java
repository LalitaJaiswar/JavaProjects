import java.util.*;

public class String11{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		String str1,str2;
		str1=sc.nextLine();
		str2=sc.nextLine();
		String11 s=new String11();
		char arrStr1[]=str1.toCharArray();
		char arrStr2[]=str2.toCharArray();
		int n1=str1.length(),n2=str2.length(),preindex=-1;
		List<Character> l1 = new ArrayList<Character>(); 
		List<Integer> arr = s.match(str2,str1);
		for(int i=0;i<arr.size();i++){
			int index=arr.get(i);
			if(index!=0 && index!=n1-1 && index+n2<n1){
				if(index-1!=preindex)
				l1.add(arrStr1[index-1]);
				l1.add(arrStr1[index+n2]);
				preindex=index+n2;
			}
			else if(index==0 && index+n2<n1){
			l1.add(arrStr1[index+n2]);
			preindex=index+n2;}
			else if(index+n2==n1 && index-1>=0 && preindex!=index-1){
			l1.add(arrStr1[index-1]);}
		}
		char ans[]=new char[l1.size()];
		for(int i=0;i<l1.size();i++)
		System.out.print(l1.get(i));
		
	}
	int[] computeLPS(char[] pat1,int m){
        int lps[]=new int[m];
        for(int i=0;i<m;i++)
            lps[i]=0;
        int l=0,i=1;
        while(i<m){
            if(pat1[i]==pat1[l]){
                l++;
                lps[i]=l;
                i++;
            }
            else{
                if(l!=0){
                    l=lps[l-1];
                }
                else{
                    lps[i]=0;
                    i++;
                }
            }
        }
        return lps;
    }
	List<Integer> match(String pat,String txt){
        int i=0,j=0,n,m;
        char pat1[]=pat.toCharArray();
		char txt1[]=txt.toCharArray();
        List<Integer> l1 = new ArrayList<Integer>(); 
        n=txt.length();
        m=pat.length();
        int lps[]=computeLPS(pat1,m); 
        while(i<n){
            if(txt1[i]==pat1[j]){
                i++;
                j++;
            }
            if(j==m){
                l1.add(i-j);
                j=lps[j-1];
            }
            else if(i<n && pat1[j]!=txt1[i]){
                if(j!=0)
                    j=lps[j-1];
                else
                    i++;
            }
        }
		return l1;
    }
}