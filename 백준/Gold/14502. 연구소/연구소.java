

import java.io.*;
import java.util.*;

public class Main {

    //행
    static int n;
    //열
    static int m;
    static int [][] maps;

    static List<Virous> virousList = new ArrayList<>();

    static int[] dx ={1,0,-1,0};
    static int[] dy ={0,1,0,-1};

    static int virousCnt = 0;

    static int awsner = Integer.MIN_VALUE;

    static int wallCnt = 3;

    public static void main(String[] args)  {
    Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        maps = new int[n][m];
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maps[i][j] = sc.nextInt();
                if (maps[i][j] == 2) {
                    virousList.add(new Virous(i, j));
                    virousCnt++;
                }

                if (maps[i][j] == 1) {
                    wallCnt++;
                }
            }
        }

        dfs(0);

        System.out.println(awsner);
    }

    static void dfs(int wall){

        if(wall == 3){
            bfs();
            return;
        }

        for(int i = 0; i < n;i++){
            for(int j = 0; j < m;j++){
                if(maps[i][j] == 0){
                    maps[i][j] = 1;
                    dfs(wall+1);
                    maps[i][j] = 0;
                }
            }
        }
    }

    static void bfs(){
        Queue <Virous> queue =new LinkedList<>();
        for(Virous virous : virousList){
            queue.add(virous);
        }
        int copyMap[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            copyMap[i] = maps[i].clone();
        }

        int checkVirousCnt = virousCnt;
        while (!queue.isEmpty()){
            Virous virous = queue.poll();
            for(int i = 0 ; i<4;i++){

                int moveN = virous.n + dy[i];
                int moveM = virous.m + dx[i];

                if(moveN < 0 || moveN >= n || moveM < 0 || moveM >= m){
                    continue;
                }

                if(copyMap[moveN][moveM] == 0){
                    copyMap[moveN][moveM] = 2;
                    queue.add(new Virous(moveN,moveM));
                    checkVirousCnt++;
                }
            }
        }

        awsner = Math.max(awsner,(n*m)- checkVirousCnt- wallCnt);
    }

    static class Virous{
        int n;
        int m;

        Virous(int n, int m){
            this.n = n;
            this.m = m;
        }
    }



}
