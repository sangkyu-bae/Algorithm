import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] nums;
    static int[] op = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        nums = new int[N];
        for(int i = 0 ;i<N;i++){
            nums[i] = sc.nextInt();
        }

        for(int i =0 ;i<4;i++){
            op[i] = sc.nextInt();
        }

        dfs(1,nums[0]);

        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int depth,int sum){

        if(depth == N){
            max = Math.max(sum,max);
            min = Math.min(sum,min);
            return;
        }

        for(int i = 0; i < 4;i++){
            if(op[i] <= 0){
                continue;
            }
            op[i]--;
            if(i == 0){
                dfs(depth+1,sum + nums[depth]);
            }

            if(i == 1){
                dfs(depth+1,sum - nums[depth]);
            }

            if(i == 2){
                dfs(depth+1,sum * nums[depth]);
            }

            if(i == 3){
                dfs(depth+1,sum / nums[depth]);
            }

            op[i]++;
        }
    }
}
