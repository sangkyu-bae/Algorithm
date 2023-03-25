import java.util.*;
class Solution {
     boolean[][] isVisit;
    int height;
    int width;
    int[] xMove={-1,0,1,0};
    int[] yMove={0,1,0,-1};
    public int solution(int[][] maps) {
          int answer = 0;
        height=maps.length;
        width=maps[0].length;
        isVisit=new boolean[height][width];
        answer=bfs(maps);
        System.out.println(answer);

        return answer;
    }
    int bfs(int[][] maps){
        Point startPoint=new Point(0,0,1);
        Queue<Point> queue=new LinkedList<>();
        queue.add(startPoint);
        while (!queue.isEmpty()){
            Point nowPoint= queue.poll();
            int nowX= nowPoint.x;
            int nowY=nowPoint.y;

            isVisit[nowY][nowX]=true;
            if(nowX==width-1&&nowY==height-1){
                return nowPoint.level;
            }

            for(int i=0;i<4;i++){
                int moveX=nowX+xMove[i];
                int moveY=nowY+yMove[i];
                if(!(moveX<0||moveX>=width||moveY<0||moveY>=height)){
                    if(!isVisit[moveY][moveX]&&maps[moveY][moveX]==1){
                        Point point=new Point(moveX,moveY,nowPoint.level+1);
                         isVisit[moveY][moveX]=true;
                        queue.add(point);
                    }
                }
            }
        }

        return -1;
    }
    
        static class Point {
        int x;
        int y;
        int level;

        public Point(int x, int y,int level) {
            this.x = x;
            this.y = y;
            this.level=level;
        }
    }
}