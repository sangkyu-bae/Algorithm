import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; tc++){
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] time = new int[n+1];
            int[][] arr = new int[n+1][n+1];
            int[] dp = new int[n + 1];
            int[] indegree = new int[n+1];
            for(int i = 1; i<=n;i++){
                time[i] = sc.nextInt();
            }

            for(int i=1 ; i<=k;i++){
                int x = sc.nextInt();
                int y = sc.nextInt();

                arr[x][y] = 1;
                indegree[y]++;
            }
            Queue<Integer> queue = new LinkedList<>();
            for(int i = 1; i<=n;i++){
                if(indegree[i] == 0){
                    queue.add(i);
                    dp[i] = time[i];
                }
            }

            while (!queue.isEmpty()){
                int now = queue.poll();

                for(int i = 1; i<=n;i++){
                    if(arr[now][i] == 1){
                        indegree[i]--;
                        dp[i] = Math.max(dp[i],dp[now]+ time[i]);

                        if(indegree[i] == 0){
                            queue.add(i);
                        }
                    }
                }
            }

            int w = sc.nextInt();
            System.out.println(dp[w]);
        }

    }
}