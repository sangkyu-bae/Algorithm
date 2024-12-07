

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for(int q = 0 ; q < n ; q++){
            int num = sc.nextInt();

            List<Integer> coins = new ArrayList<>();

            for(int j = 1; j <= num; j++){
                int index = sc.nextInt();
                coins.add(index);
            }

            int target = sc.nextInt();

            int[] dp = new int[target + 1];


            for(int i = 0 ; i < num ; i++){
                for(int j = 1 ; j <= target; j++){
                    int coin = coins.get(i);
                    if(j - coin == 0){
                        dp[j] = dp[j] + 1;
                    }else if (j - coin >0){
                        dp[j] = dp[j] + dp[j - coin];
                    }
                }
            }

            System.out.println(dp[target]);
        }

    }
}



