import java.io.*;
import java.util.*;

public class Main {

    static int n ,m;
    static int [][] graph;
    static boolean[] visited;

    static int cnt = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        graph = new int[n+1][n+1];
        visited = new boolean[n+1];

        for(int  i = 0; i < m ;i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            graph[start][end] = 1;
            graph[end][start] = 1;
        }
        dfs(1);
        System.out.println(cnt-1);
    }

    static void dfs(int start){
        visited[start] = true;
        cnt ++;
        for(int i = 1; i <= n ;i++){
            if(graph[start][i] > 0 && !visited[i]){
                dfs(i);
            }
        }

    }
}