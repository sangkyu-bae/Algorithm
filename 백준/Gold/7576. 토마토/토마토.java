import java.io.*;
import java.util.*;

public class Main {

    static int[] xPoint = {1, -1, 0, 0};
    static int[] yPoint = {0, 0, 1, -1};
    static int[][] map;

    static boolean[][] isVisit;


    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();


        map = new int[N][M];
        isVisit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        Queue <Point> queue = new LinkedList<>();

        for(int i = 0; i < map.length;i++){
            for(int j = 0;j < map[i].length;j++){
                if(map[i][j] == 1){
                    queue.add(new Point(j,i,0));
                    isVisit[i][j] = true;
                }else if(map[i][j] == -1){
                    isVisit[i][j] = true;
                }
            }
        }

        int cnt = 0;

        while (!queue.isEmpty()){
            Point point = queue.poll();
            cnt = point.moveCnt;

            for(int i = 0; i < 4; i++){
                int nx = point.x + xPoint[i];
                int ny = point.y + yPoint[i];

                if(nx < 0 || nx >= M || ny < 0 || ny >= N || isVisit[ny][nx]){
                    continue;
                }

                if(map[ny][nx] == 0) {
                    queue.add(new Point(nx, ny, point.moveCnt + 1));
                    isVisit[ny][nx] = true;
                    map[ny][nx] =1;
                }
            }
        }

        for(boolean i[] : isVisit){
            for(boolean j : i){
                if(j == false){
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(cnt);
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