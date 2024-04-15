import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static boolean[] isVisit;
    static int N;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        N= sc.nextInt();

        map = new int[N][N];
        isVisit = new boolean[N];

        for(int i = 0 ; i< N ; i++){
            for(int j = 0; j < N; j++){
                map[i][j] = sc.nextInt();
            }
        }
        dfs(0,0,0,0);
        System.out.println(answer);

    }
    
    public static void dfs(int start, int node, int sum, int cnt){
        if(cnt == N && start == node){
            answer = Math.min(answer,sum);
            return;
        }
        
        for(int i = 0;i < N;i++){
            if(!isVisit[i] && map[node][i] != 0){
                isVisit[i] = true;
                dfs(start,i,sum + map[node][i],cnt+1);
                isVisit[i] = false;
            }
        }
    }
}
