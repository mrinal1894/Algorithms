
/**
 * Write a description of QuickSort here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Arrays;

public class QuickSort {
    public static int partition(int[] a,int p,int r){
        int x=a[r];
        int i=p-1;
        for(int j=p;j<=r-1;j++){
            if (a[j]<=x){ //change this <= to >= to sort in descending order
                i=i+1;
                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }
        int temp=a[r];
        a[r]=a[i+1];
        a[i+1]=temp;
        return i+1;
        
    }
    
    public static void Quick_sort(int[] a,int p,int r){
        if (p<r){
            int q=partition(a,p,r);
            Quick_sort(a,p,q-1);
            Quick_sort(a,q+1,r);
        }
    }
    
    public static void main(String[] args){
        int[] array={4,3,5,6,3,4,9,8,4,5,7,2,3};
        Quick_sort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
