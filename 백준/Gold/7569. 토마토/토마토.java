import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int H = sc.nextInt();

        int []dx = {0,1,0,-1,0,0};
        int []dy = {1,0,-1,0,0,0};
        int []dz = {0,0,0,0,1,-1};

        int [][][] map = new int[H+1][M+1][N+1];

        Queue<Point> queue =new LinkedList<>();

        for(int i = 1 ;i <= H ; i++){
            for(int j = 1 ; j <= M ; j++){
                for(int z = 1; z <= N ; z++){
                    int tomato = sc.nextInt();
                    map[i][j][z] = tomato;

                    if(tomato == 1){
                        queue.add(new Point(z,j,i));
                    }
                }
            }
        }



        while (!queue.isEmpty()){
            Point point = queue.poll();
            for(int i = 0 ; i < 6; i++){
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                int nz = point.z + dz[i];

                if(nz <= 0 || nz > H || nx <= 0 || nx > N || ny <=0 || ny > M ){
                    continue;
                }

                if(map[nz][ny][nx] == 0){
                    map[nz][ny][nx] = map[point.z][point.y][point.x]+1;
                    queue.add(new Point(nx,ny,nz));
                }
            }

        }

        int result = Integer.MIN_VALUE;
        for(int i = 1 ; i <= H ; i ++){
            for(int j = 1; j <=M ; j++){
                for(int z = 1 ;z <=N ; z++){
                    if(map[i][j][z] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    result = Math.max(result,map[i][j][z]);
                }
            }
        }

        if(result == 1){
            result = 0;
        }else {
            result -=1;
        }

        System.out.println(result);

    }

    static class Point{
        int x;
        int y;
        int z;

        public Point(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}



