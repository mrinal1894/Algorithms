
import java.util.Arrays;

public class heap_sort {
    public static void heapsort(double[] a){
        build_max_heap(a);
        int heap_size=a.length;
        double inter;
        for(int i=a.length-1;i>=1;i-=1){
            inter=a[i];
            a[i]=a[0];
            a[0]=inter;
            heap_size-=1;
            Max_heapify(a,0,heap_size);
        }
    }
    public static void build_max_heap(double[] a){
        for(int i=a.length/2+1;i>=0;i-=1){
            Max_heapify(a,i,a.length);
        }
    }
    public static void Max_heapify(double[] a,int i,int size){
        int l=2*(i+1);
        int r=2*(i+1)+1;
        int largest;
        if (l-1<size && a[l-1]>a[i]){
            largest=l-1;
        }
        else {largest=i;}
        if (r-1<size && a[r-1]>a[largest]){
            largest=r-1;
        }
        if(largest!=i){
            double inter;
            inter=a[largest];
            a[largest]=a[i];
            a[i]=inter;
            Max_heapify(a,largest,size);
        }
    }
    public static void main(String[] args){
        double[] A={5,13,2,25,7,17,20,8,4};
        int i=2;
        heapsort(A);
        System.out.println(Arrays.toString(A));
    }
}
