
/**
 * Write a description of max_sub_array_linear here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class max_sub_array_linear {
    public static double max_sum_subarray(double[] A){
        double max_so_far=Integer.MIN_VALUE;
        double max_ending_here=0;
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
    
    public static void main (String[] args){
        double [] inputs=new double [args.length];
        for(int i=0;i<args.length;i+=1){
            inputs[i]=Double.parseDouble(args[i]);
        }
        double max_sum=max_sum_subarray(inputs);
        System.out.println("Max sum: "+max_sum);
    }
}
