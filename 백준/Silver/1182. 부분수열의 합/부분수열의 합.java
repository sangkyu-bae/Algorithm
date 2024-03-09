

import java.io.*;
import java.util.*;

public class Main {
    static int answer;
    static int[] arr;
    static boolean[] isVisit;
    static int s;
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        s= sc.nextInt();
        isVisit = new boolean[n + 1];

        arr = new int[n + 1];

        for(int i = 1; i<=n ;i++){
            arr[i] = sc.nextInt();
        }

        dfs(0,1);

        System.out.println(answer);
    }

    public static void dfs(int sum,int depth) {

        if (depth == arr.length) {
            return;
        }
        if (sum + arr[depth] == s) {
            answer++;
        }

        dfs(sum + arr[depth], depth + 1);
        dfs(sum, depth + 1);
    }
}
