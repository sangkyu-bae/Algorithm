import java.util.*;
class Solution {
        int[][] map;
    boolean[][] isVisit;

    Point goalPoint;
    int[] xMove = {-1, 0, 1, 0};
    int[] yMove = {0, 1, 0, -1};
    int width;
    int height;

    public int solution(String[] board) {
        int answer = 0;
        width = board[0].length();
        height = board.length;
        map = new int[height][width];
        isVisit = new boolean[height][width];

        Point startPoint = null;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                char nowChar = board[i].charAt(j);
                if (nowChar == '.') {
                    map[i][j] = 0;
                } else if (nowChar == 'D') {
                    map[i][j] = -1;
                } else if (nowChar == 'R') {
                    map[i][j] = 1;
                    startPoint = new Point(j, i, 0);
                } else if (nowChar == 'G') {
                    map[i][j] = 2;
                    goalPoint = new Point(j, i, 0);
                }
            }
        }

        // boolean isPossible = isPossibleVisit();
        // if (!isPossible) return -1;

        answer = bfs(startPoint);
        return answer;
    }
    
     int bfs(Point nowPoint) {
     Queue<Point> queue = new LinkedList<>();
        queue.add(nowPoint);
        isVisit[nowPoint.y][nowPoint.x] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int initX= point.x;
            int initY= point.y;
            if (initX== goalPoint.x && initY == goalPoint.y) {
                return point.level;
            }

            for (int i = 0; i < 4; i++) {
                int x = point.x;
                int y = point.y;
                while (!(x < 0 || x >= width || y < 0 || y >= height)&&map[y][x]!=-1){
                    x+=xMove[i];
                    y+=yMove[i];
                }
                x-=xMove[i];
                y-=yMove[i];
//                if(!isVisit[y][x]&&!(point.x==x&&point.y==y)){
//                    isVisit[y][x]=true;
//                    queue.add(new Point(x,y, point.level+1));
//                }
                if(isVisit[y][x]||(point.x==x&&point.y==y))continue;
                isVisit[y][x]=true;
                queue.add(new Point(x,y, point.level+1));
            }
        }
        return -1;
    }
      boolean isPossibleVisit() {
        boolean isPossible = false;
        int y = goalPoint.y;
        int x = goalPoint.x;
        for (int i = 0; i < 4; i++) {
            int moveX = x + xMove[i];
            int moveY = y + yMove[i];
            if (!(moveX < 0 || moveX >= width || moveY < 0 || moveY >= height)) {
                if (map[moveY][moveX] == -1) {
                    isPossible = true;
                }
            }
        }

        return isPossible;
    }
    
    static class Point {
        int x;
        int y;
        int level;

        public Point(int x, int y, int level) {
            this.x = x;
            this.y = y;
            this.level = level;
        }
    }
}