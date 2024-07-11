

import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph;
    static boolean[] visited;

    static int v,m1,m2;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        m1 = sc.nextInt();
        m2 = sc.nextInt();

        graph = new int[v+1][v+1];
        visited = new boolean[v+1];
        for(int i = 0 ; i < m1 ; i++){
            int src = sc.nextInt();
            int dist =sc.nextInt();
            graph[src][dist] = 1;
            graph[dist][src] = 1;
        }

        dfs(m2);
        visited = new boolean[v+1];
        System.out.println();
        bfs(m2);
    }

    static void dfs(int depth){
        visited[depth] = true;
        System.out.print(depth+ " ");
        for(int i = 1; i <= v; i++){
            if(!visited[i] && graph[depth][i] == 1){
                dfs(i);
            }
        }
    }
    static Queue<Integer> queue = new LinkedList<>();
    static void bfs(int depth){
        queue.add(depth);
        visited[depth] = true;
        while (!queue.isEmpty()){
            int s = queue.poll();
            System.out.print(s +" ");

            for(int i = 1; i <= v; i++){
                if(!visited[i] && graph[s][i] == 1){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

    }
}
