

import java.io.*;
import java.util.*;

public class Main {

    static int [][] map;
    static int [][]copyMap;

    static boolean[][] isVisit;

    static int N;
    static int M;

    static int []dx = {0,1,0,-1};
    static int []dy = {1,0,-1,0};



    public static void main(String[] args)  {
      
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();



        map = new int[N+1][M+1];
        copyMap = new int[N+1][M+1];
        isVisit = new boolean[N+1][M+1];
        Queue<Point> queue =new LinkedList<>();


        for(int i = 1 ; i <= N ; i++){
            for(int j = 1; j <= M ;j++){
                int ice = sc.nextInt();

                if(ice != 0){
                    queue.add(new Point(j,i,1));
                }

                map[i][j] = ice;
                copyMap[i][j] = ice;
            }
        }

        if(!isGroup()){
            System.out.println(0);
            return;
        }
        int count = 1;
        while (!queue.isEmpty()){
            Point point = queue.poll();

            if(point.cnt != count){
                for (int i = 0; i <= N; i++) {
                    map[i] = Arrays.copyOf(copyMap[i], M + 1);
                }

                if(!isGroup()){
                    System.out.println(count);
                    return;
                }

                count = point.cnt;

            }

            for(int i = 0 ;i < 4; i++){
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];



                if(nx < 1 || nx > M || ny < 1 || ny > N){
                    continue;
                }


                if(map[ny][nx] == 0 && copyMap[point.y][point.x] > 0){
                    copyMap[point.y][point.x]--;
                }
            }

            if(copyMap[point.y][point.x] > 0){
                queue.add(new Point(point.x, point.y,point.cnt+1));
            }
        }

        System.out.println(0);
    }

    static boolean isGroup(){
        for(int i = 1; i <= N; i++){
            for (int j = 1; j <= M ;j++){
                isVisit[i][j] = false;
            }
        }

        int cnt = 0;
        for(int i = 1; i <= N; i++){
            for (int j = 1; j <= M ;j++){
                if(!isVisit[i][j] && map[i][j] != 0){
                    dfs(j,i);
                    cnt++;
                }
            }
        }

        if(cnt > 1){
            return false;
        }
        return true;
    }

    static void dfs(int x, int y){
        isVisit[y][x] = true;

        for(int i = 0; i < 4 ; i ++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 1 || nx > M || ny < 1 || ny > N){
                continue;
            }

            if(isVisit[ny][nx]){
               continue;
            }

            if(map[ny][nx] < 1){
                continue;
            }

            dfs(nx,ny);
        }
    }



    static class Point{
        int x;
        int y;

        int cnt;

        public Point(int x, int y,int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}



