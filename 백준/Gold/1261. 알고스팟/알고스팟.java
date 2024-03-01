import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int INF = 1000000000;
         int m= sc.nextInt();
        int n =sc.nextInt();

        int[][] map = new int[n + 1][m + 1];
        int[][] cost = new int[n + 1][m + 1];

        for(int i = 1;i <= n;i++){
            char[] input = sc.next().toCharArray();
            for(int j = 1; j <= m; j++){
                map[i][j] = input[j - 1] -'0';
                cost[i][j] = INF;
            }
        }

        PriorityQueue<Node> queue = new PriorityQueue<>((o1,o2)->{
            return o1.cost - o2.cost;
        });

        queue.add(new Node(1,1,0));
        cost[1][1] = 0;

        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,1,-1};

        while (!queue.isEmpty()){
            Node now = queue.poll();
            if(cost[now.row][now.col] < now.cost)break;
            if(now.row == n && now.col == m)break;
            for(int i = 0; i < 4; i++){
                int nr = dr[i] + now.row;
                int nc = dc[i] + now.col;
                if(nr < 1 || nr > n || nc < 1 || nc > m) continue;

                if(cost[nr][nc] > cost[now.row][now.col] + map[nr][nc]){
                    cost[nr][nc] = cost[now.row][now.col] + map[nr][nc];
                    queue.add(new Node(nr,nc,cost[nr][nc]));
                }
            }
        }

        System.out.println(cost[n][m]);
    }
}
class Node{
    int row;
    int col;
    int cost;

    public Node(int row,int col,int cost){
        this.row = row;
        this.col = col;
        this.cost = cost;
    }
}