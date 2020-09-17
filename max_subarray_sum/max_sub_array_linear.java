
/**
 * Write a description of max_sub_array_linear here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class max_sub_array_linear {
    public static int max_sum_subarray(int[] A){
        int max_so_far=Integer.MIN_VALUE;
        int max_ending_here=0;
        for (int i=0;i<A.length;i++){
            max_ending_here+=A[i];
            if (max_ending_here>max_so_far){
                max_so_far=max_ending_here;
            }
            if (max_ending_here<0){
                max_ending_here=0;
            }
        }
        return max_so_far;
    }
    
    public static void main (int[] args){
        int max_sum=max_sum_subarray(args);
        System.out.println(max_sum);
    }
}
