import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int binarySearch(int[] trees, int cut){
        int maxInt =trees[trees.length-1];
        int l = 0, r = maxInt ;
        int optimal = -1;

        while (l <= r){
            int m = (l+r)/2;

            if(isPossible(m,trees,cut)){
                optimal = m;
                l = m+1;
            }else{
                r = m-1;
            }
        }

        return optimal;
    }

    public static boolean isPossible(int treeCutHeight,int[] trees, int thresholdHeight){

        long cutTreeNum = 0;

        for(int tree :trees){

            int cut = tree - treeCutHeight;
            if(cut > 0){
                cutTreeNum += cut;
            }
        }

        return cutTreeNum >= thresholdHeight;
    }

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] trees = new int[N];

        for(int i = 0 ;i < N;i++){
            trees[i] = sc.nextInt();
        }
        Arrays.sort(trees);

        int a =binarySearch(trees,M);
        System.out.print(a);
    }
}