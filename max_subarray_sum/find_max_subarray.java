
/**
 * Write a description of find_max_subarray here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class find_max_subarray {
    public static int[] find_max_crossing(int[] A,int low,int mid,int high){
        int max_left=mid;
        int left_sum=A[mid];
        int sum=0;
        for (int i=mid;i>=low;i-=1){
            sum=sum+A[i];
            if (sum>left_sum){
                left_sum=sum;
                max_left=i;
            }
        }
        int max_right=mid+1;
        int right_sum=A[mid+1];
        sum=0;
        for (int i=mid+1;i<=high;i+=1){
            sum=sum+A[i];
            if (sum>right_sum){
                right_sum=sum;
                max_right=i;
            }
        }
        int[] ans={max_left,max_right,left_sum+right_sum};
        return ans;
    }
    
    public static int[] find_max_subarray(int[] A,int low,int high){
        if (high==low){
            int[] ans={low,high,A[low]};
            return ans;
        }
        int mid=(low+high)/2;
        int[] left_max=find_max_subarray(A,low,mid);
        int[] right_max=find_max_subarray(A,mid+1,high);
        int[] cross_max=find_max_crossing(A,low,mid,high);
        if (left_max[2]>=right_max[2] && left_max[2]>=cross_max[2]){
            return left_max;
        }
        if (right_max[2]>=left_max[2] && right_max[2]>=cross_max[2]){
            return right_max;
        }
        return cross_max;
    }
    
    public static void main(int[] args){
        int[] maxs=find_max_subarray(args,0,args.length-1);
        System.out.println(maxs[0]);
        System.out.println(maxs[1]);
        System.out.println(maxs[2]);
    }
}
