
/**
 * Write a description of matrix_muliplication here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.Arrays;

public class matrix_multiplication {
    public static int[][] A;
    public static int[][] B;
    public static int nearest_power2(int a){
        int val=1;
        while (true){
            if (val>=a){
                return val;
            }
            val=val<<1;
        }
    }
    public static int[][] Matrix_combine(int[][] a11,int[][] a12,int[][] a21, int[][] a22){
        int n= 2*a11.length;
        int[][] a_full=new int[n][n];
        for (int i=0;i<n;i+=1){
            for(int j=0;j<n;j+=1){
                if (i<n/2 && j<n/2){
                    a_full[i][j]=a11[i][j];
                }
                if (i<n/2 && j>=n/2){
                    a_full[i][j]=a12[i][j-n/2];
                }
                if (i>=n/2 && j<n/2){
                    a_full[i][j]=a21[i-n/2][j];
                }
                if (i>=n/2 && j>=n/2){
                    a_full[i][j]=a22[i-n/2][j-n/2];
                }
            }
        }
        return a_full;
    } 
    public static int[][] Matrix_add(int[][] one, int[][] two){
        int n=one.length;
        int[][] sum= new int[n][n];
        for (int i=0;i<n;i+=1){
            for(int j=0;j<n;j+=1){
                sum[i][j]=one[i][j]+two[i][j];
            }
        }
        return sum;
    }
    public static int[][] Matrix_sub(int[][] one, int[][] two){
        int n=one.length;
        int[][] sum= new int[n][n];
        for (int i=0;i<n;i+=1){
            for(int j=0;j<n;j+=1){
                sum[i][j]=one[i][j]-two[i][j];
            }
        }
        return sum;
    }
    public static int[][] submatrix(int[][] m,int rowb,int rowe,int colb,int cole){
        int n=rowe-rowb;
        int[][] sub_m=new int[n][n];
        for (int i=0;i<n;i+=1){
            for (int j=0;j<n;j+=1){
                sub_m[i][j]=m[i+rowb][j+colb];
            }
        }
        return sub_m;
    }
    public static int[][] Matrix_multiply(int[][] ma,int[][] mb){
        int n=ma.length;
        if (n==1){
            int[][] c1=new int[1][1];
            c1[0][0]=ma[0][0]*mb[0][0];
            return c1;
        }
        else{
            int half=n/2;
            int[][] mb11=submatrix(mb,0,half,0,half);
            int[][] mb12=submatrix(mb,0,half,half,n);
            int[][] mb21=submatrix(mb,half,n,0,half);
            int[][] mb22=submatrix(mb,half,n,half,n);
            int[][] ma11=submatrix(ma,0,half,0,half);
            int[][] ma12=submatrix(ma,0,half,half,n);
            int[][] ma21=submatrix(ma,half,n,0,half);
            int[][] ma22=submatrix(ma,half,n,half,n);
            int[][] c11=Matrix_add(Matrix_multiply(ma11,mb11),Matrix_multiply(ma12,mb21));
            int[][] c12=Matrix_add(Matrix_multiply(ma11,mb12),Matrix_multiply(ma12,mb22));
            int[][] c21=Matrix_add(Matrix_multiply(ma21,mb11),Matrix_multiply(ma22,mb21));
            int[][] c22=Matrix_add(Matrix_multiply(ma21,mb12),Matrix_multiply(ma22,mb22));
            int[][] c_full=Matrix_combine(c11,c12,c21,c22);
            return c_full;
        }
    }
    public static void main(String[] args){
        int n=Integer.parseInt(args[0]);
        n=nearest_power2(n);
        int[] rows_indexA=new int[n];
        int[] columns_indexA=new int[n]; 
        int[] rows_indexB=new int[n];
        int[] columns_indexB=new int[n];
        Scanner myobj= new Scanner(System.in);
        int[][] a=new int[n][n];
        int[][] b=new int[n][n];
        char matrix;
        for(int m=0;m<2;m+=1){
            if(m==0){matrix='A';}
            else{matrix='B';}
            for(int i=0;i<n;i+=1){
                rows_indexA[i]=i;
                columns_indexA[i]=i;
                rows_indexB[i]=i;
                columns_indexB[i]=i;
                for(int j=0;j<n;j+=1){
                    System.out.println(matrix+"("+i+","+j+")"+"=");
                    int num=Integer.parseInt(myobj.nextLine());
                    if(m==0){a[i][j]=num;}
                    else{b[i][j]=num;}
                }
            }
        }
        int[][] C;
        A=a;
        B=b;
        C=Matrix_multiply(A,B);
        System.out.print("\n");
        System.out.println("C=");
        for (int i=0;i<n;i+=1){
            for (int j=0;j<n;j+=1){
                System.out.printf("%6d",C[i][j]);
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }
}
