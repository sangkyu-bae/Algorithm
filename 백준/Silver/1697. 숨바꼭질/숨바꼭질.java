

import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int goal = sc.nextInt();

        boolean[] isVisit= new boolean[100001];

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x,0));

        int answer = 0;
        while (!queue.isEmpty()){
            Point point =queue.poll();

            if(point.x == goal){
                answer = point.time;
                break;
            }

            int movePlus = point.x + 1;
            int minPlus = point.x - 1;
            int absPlus = point.x * 2;

            if(movePlus < 100001 && movePlus >= 0&& !isVisit[movePlus]){
                Point movePoint = new Point(movePlus,point.time+1);
                isVisit[movePlus] = true;
                queue.add(movePoint);
            }

            if(minPlus < 100001 && minPlus >= 0 && !isVisit[minPlus]){
                Point movePoint = new Point(minPlus, point.time+1);
                isVisit[minPlus] = true;
                queue.add(movePoint);
            }

            if(absPlus < 100001 && absPlus >0 && !isVisit[absPlus]){
                Point movePoint = new Point(absPlus,point.time+1);
                isVisit[absPlus] = true;
                queue.add(movePoint);
            }

        }
        System.out.println(answer);


    }

    static public class Point {
        int x;
        int time;

        Point(int x, int time) {
            this.x = x;
            this.time =time;
        }
    }
}
