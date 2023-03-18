import java.util.*;
class Solution {
        int[][]maze;
      int[][]cloneMaze;
    Point initPoint=null;
    Point leaverPoint=null;
    Point exitPoint=null;
   int[] xMove={-1,0,1,0};
    int[] yMove={0,1,0,-1};
     boolean[][] isVisit;
    public int solution(String[] maps) {
    maze = new int[maps.length][maps[0].length()];
          int width=maze[0].length;
        int height=maze.length;
        isVisit= new boolean[height][width];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                char map = maps[i].charAt(j);
                if (map == 'S') {
                    initPoint = new Point(j, i,0);
                    maze[i][j] = 3;
                } else if (map == 'O') {
                    maze[i][j] = 0;
                } else if (map == 'L') {
                    leaverPoint = new Point(j, i,0);
                    maze[i][j] = 1;
                } else if (map == 'E') {
                    exitPoint = new Point(j, i,0);
                    maze[i][j] = 2;
                } else if (map == 'X') {
                    maze[i][j] = -1;
                }
            }
        }

        int leverLength= bfs(initPoint,leaverPoint);
        if(leverLength==-1){
            return -1;
        }
        isVisit= new boolean[height][width];
        int exitLength=bfs(leaverPoint,exitPoint);
        if(exitLength==-1){
            return -1;
        }

        return leverLength+exitLength;
    }
     static class Point{
        int x;
        int y;

        int level;

        public Point(int x, int y,int level) {
            this.x = x;
            this.y = y;
            this.level=level;
        }
    }
     int bfs(Point point,Point wantPoint){
          int width=maze[0].length;
        int height=maze.length;

        Queue<Point> queue=new LinkedList<>();
        queue.add(point);
        isVisit[point.y][point.x]=true;

        while (!queue.isEmpty()){
            Point nowPoint=queue.poll();
            int nowX=nowPoint.x;
            int nowY=nowPoint.y;
            int nowLevel=nowPoint.level;
            if(wantPoint.x==nowX&&wantPoint.y==nowY){
                return nowLevel;
            }

            for(int i=0;i<4;i++){
                int moveX=nowX+xMove[i];
                int moveY=nowY+yMove[i];
                if(!(moveX<0||moveX>=width||moveY<0||moveY>=height)){
                    if(!isVisit[moveY][moveX]&&maze[moveY][moveX]>-1){
                        queue.add(new Point(moveX,moveY,nowLevel+1));
                        isVisit[moveY][moveX]=true;
                    }
                }
            }
        }
        return -1;
    }

}