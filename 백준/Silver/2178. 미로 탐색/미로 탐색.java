import java.io.*;
import java.util.*;

public class Main {

    static int[] xPoint = {1, -1, 0, 0};
    static int[] yPoint = {0, 0, 1, -1};
    static int[][] map;

    static boolean[][] isVisit;

    static int cnt = Integer.MAX_VALUE;

    static int xGoal;
    static int yGoal;

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        map = new int[N][M];
        isVisit = new boolean[N][M];
        xGoal = M - 1;
        yGoal = N - 1;

        for (int i = 0; i < N; i++) {
            String a = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = a.charAt(j) - '0';
            }
        }
        bfs(new Point(0,0,1));

        System.out.println(cnt);
    }

    public static void bfs(Point initPoint) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(initPoint);
        isVisit[initPoint.y][initPoint.x] = true;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;
            if(x== xGoal && y== yGoal){
                cnt = Math.min(cnt,point.moveCnt);
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + xPoint[i];
                int ny = y + yPoint[i];
                if (!(nx >= 0 && nx < map[0].length && ny >= 0 && ny < map.length && !isVisit[ny][nx])){
                    continue;
                }
                if(map[ny][nx] == 0){
                    continue;
                }
                Point movePoint = new Point(nx,ny, point.moveCnt+1);
                queue.add(movePoint);
                isVisit[ny][nx] = true;
            }
        }
    }


   public static class Point {
        int x;
        int y;
        int moveCnt;

        public Point(int x, int y,int cnt) {
            this.x = x;
            this.y = y;
            this.moveCnt = cnt;
        }
    }
}