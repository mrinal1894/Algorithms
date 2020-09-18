
/**
 * Write a description of matrix_mul here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.Arrays;

public class matrix_mul_index{
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
    public static int[][] Matrix_multiply(int[] rowsA,int[] columnsA,int[] rowsB,int[] columnsB){
        int n=rowsA.length;
        if (n==1){
            int[][] c1=new int[1][1];
            c1[0][0]=A[rowsA[0]][columnsA[0]]*B[rowsB[0]][columnsB[0]];
            return c1;
        }
        else{
            int half=n/2;
            int[][] c11=Matrix_add(Matrix_multiply(Arrays.copyOfRange(rowsA,0,half),Arrays.copyOfRange(columnsA,0,half),Arrays.copyOfRange(rowsB,0,half),Arrays.copyOfRange(columnsB,0,half)),Matrix_multiply(Arrays.copyOfRange(rowsA,0,half),Arrays.copyOfRange(columnsA,half,n),Arrays.copyOfRange(rowsB,half,n),Arrays.copyOfRange(columnsB,0,half)));
            int[][] c12=Matrix_add(Matrix_multiply(Arrays.copyOfRange(rowsA,0,half),Arrays.copyOfRange(columnsA,0,half),Arrays.copyOfRange(rowsB,0,half),Arrays.copyOfRange(columnsB,half,n)),Matrix_multiply(Arrays.copyOfRange(rowsA,0,half),Arrays.copyOfRange(columnsA,half,n),Arrays.copyOfRange(rowsB,half,n),Arrays.copyOfRange(columnsB,half,n)));
            int[][] c21=Matrix_add(Matrix_multiply(Arrays.copyOfRange(rowsA,half,n),Arrays.copyOfRange(columnsA,0,half),Arrays.copyOfRange(rowsB,0,half),Arrays.copyOfRange(columnsB,0,half)),Matrix_multiply(Arrays.copyOfRange(rowsA,half,n),Arrays.copyOfRange(columnsA,half,n),Arrays.copyOfRange(rowsB,half,n),Arrays.copyOfRange(columnsB,0,half)));
            int[][] c22=Matrix_add(Matrix_multiply(Arrays.copyOfRange(rowsA,half,n),Arrays.copyOfRange(columnsA,0,half),Arrays.copyOfRange(rowsB,0,half),Arrays.copyOfRange(columnsB,half,n)),Matrix_multiply(Arrays.copyOfRange(rowsA,half,n),Arrays.copyOfRange(columnsA,half,n),Arrays.copyOfRange(rowsB,half,n),Arrays.copyOfRange(columnsB,half,n)));
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
        C=Matrix_multiply(rows_indexA,columns_indexA,rows_indexB,columns_indexB);
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
