import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] dp=new int[N];
        int[] arr = new int[N];
        int max = 0;
        for(int i = 0 ; i<N ; i++){
            int num = sc.nextInt();
            arr[i] = num;
            dp[i] = 1;
            for(int j = 0; j < i;j++){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            
            max = Math.max(dp[i],max);
        }

        System.out.println(max);
    }
}



