import java.io.*;
import java.util.*;

public class Main {


    static int[] map;
    static boolean[] isVisit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for(int i = 0 ; i<N;i++){
            int idx = sc.nextInt();
            map = new int[idx+1];
            isVisit = new boolean[idx+1];

            for(int j = 1 ; j <= idx;j++){
                map[j] = sc.nextInt();
            }

            int cnt = 0;

            for(int k = 1 ; k <= idx ;k++){
                if(!isVisit[k]){
                    cnt++;
                    dfs(k);
                }
            }

            System.out.println(cnt);
        }
    }

    public static void dfs(int node){
        isVisit[node] = true;

        if(!isVisit[map[node]]){
            dfs(map[node]);
        }
    }

}