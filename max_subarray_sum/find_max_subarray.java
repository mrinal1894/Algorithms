
/**
 * Write a description of find_max_subarray here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class find_max_subarray {
    public static double[] find_max_crossing(double[] A,int low,int mid,int high){
        int max_left=mid;
        double left_sum=A[mid];
        double sum=0;
        for (int i=mid;i>=low;i-=1){
            sum=sum+A[i];
            if (sum>left_sum){
                left_sum=sum;
                max_left=i;
            }
        }
        int max_right=mid+1;
        double right_sum=A[mid+1];
        sum=0;
        for (int i=mid+1;i<=high;i+=1){
            sum=sum+A[i];
            if (sum>right_sum){
                right_sum=sum;
                max_right=i;
            }
        }
        double[] ans={max_left,max_right,left_sum+right_sum};
        return ans;
    }
    
    public static double[] find_max_subarray(double[] A,int low,int high){
        if (high==low){
            double[] ans={low,high,A[low]};
            return ans;
        }
        int mid=(low+high)/2;
        double[] left_max=find_max_subarray(A,low,mid);
        double[] right_max=find_max_subarray(A,mid+1,high);
        double[] cross_max=find_max_crossing(A,low,mid,high);
        if (left_max[2]>=right_max[2] && left_max[2]>=cross_max[2]){
            return left_max;
        }
        if (right_max[2]>=left_max[2] && right_max[2]>=cross_max[2]){
            return right_max;
        }
        return cross_max;
    }
    
    public static void main(String[] args){
        double [] inputs=new double [args.length];
        for(int i=0;i<args.length;i+=1){
            inputs[i]=Double.parseDouble(args[i]);
        }
        double[] maxs=find_max_subarray(inputs,0,args.length-1);
        System.out.println("start index: "+(int)maxs[0]);
        System.out.println("end index: "+(int)maxs[1]);
        System.out.println("max sum: "+maxs[2]);
    }
}
