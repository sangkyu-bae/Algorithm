import java.util.*;
class Solution {
        int boardLength;
    int [][][] visited;
    int[][] point = {{1,0},{-1,0},{0,1},{0,-1}};
     int money = Integer.MAX_VALUE;
    public int solution(int[][] board) {
          boardLength = board.length;
        visited = new int[boardLength][boardLength][4];
        bfs(board);

        return money;
    }
      public void bfs(int[][] board) {
        int x=0, y=0, direction=-1, cost=0;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y,x,direction,cost));


        while(!q.isEmpty()) {
            Node now = q.poll();

            if(now.x == boardLength -1 && now.y == boardLength -1) {
                money = Math.min(money,now.cost);
            }

            for(int dir=0; dir<4; dir++) {
                int dr = now.x + point[dir][0];
                int dc = now.y + point[dir][1];

                if(dr<0 || dr >= boardLength || dc<0 || dc >= boardLength || board[dr][dc] == 1) {
                    continue;
                }

                int nextCost = now.cost;
                if(now.dir == -1 || now.dir == dir) {
                    nextCost += 100;
                } else {
                    nextCost += 600;
                }

                if(visited[dr][dc][dir] == 0 || board[dr][dc] >= nextCost) {
                    q.add(new Node(dr,dc,dir,nextCost));
                    visited[dr][dc][dir] = 1;
                    board[dr][dc] = nextCost;
                }
            }
        }
    }

    public class Node {
        int x, y, dir, cost;

        public Node(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }
}