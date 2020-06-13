import java.util.ArrayList;

public class Compare {
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
	ArrayList<Integer> match(String pat,String txt){
        int i=0,j=0,n,m;
        char pat1[]=pat.toCharArray();
		char txt1[]=txt.toCharArray();
        ArrayList<Integer> l1 = new ArrayList<Integer>(); 
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
