
/**
 * Write a description of Manachers_algo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Manachers_algo {
    public static String modify_string(String s){
        String ans="#";
        int n=s.length();
        for(int i=0;i<n;i++){
            ans=ans+s.substring(i,i+1)+"#";
        }
        return ans;
    }
    
    public static String longest_palindromic_substring(String s){
        int n=s.length();
        int[] p=new int[n];
        int l,r;
        l=0;
        r=-1;
        for(int i=0;i<n;i++){
            int k;
            if(i>r){
                k=0;
            }
            else{
                int j=l+r-i;
                k=Math.min(p[j],r-i);
            }
            while (i-k>=0 && i+k<n && s.charAt(i+k)==s.charAt(i-k)) k++;
            k-=1;
            p[i]=k;
            if (i+k>r){
                r=i+k;
                l=i-k;
            }
        }
        
        int ind=0;
        int mx=0;
        for(int i=0;i<n;i++){
            if (p[i]>mx){
                mx=p[i];
                ind=i;
            }
        }
        
        return s.substring(ind-p[ind],ind+p[ind]+1);
    }
    
    public static String remove_hash(String s){
        int n=s.length();
        String ans="";
        for(int i=0;i<n;i++){
            if (s.charAt(i)!='#'){
                ans=ans+s.charAt(i);
            }
        }
        
        return ans;
    } 
    
    public static void main(String[] args){
        String s="acbcacb";
        String s1=modify_string(s);
        String s2=longest_palindromic_substring(s1);
        String ans=remove_hash(s2);
        System.out.println("longest palindromic substring is: "+ans);
    }
}
