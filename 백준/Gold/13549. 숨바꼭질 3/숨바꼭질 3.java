

import java.io.*;
import java.util.*;

public class Main {

    static boolean[] isVisit = new boolean[100001];
    static int sisPoint;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int su = sc.nextInt();
        int sis= sc.nextInt();

        sisPoint = sis;
        Queue<Point> queue = new LinkedList<>();
        Point point = new Point(0,su);
        queue.add(point);
        isVisit[su] = true;

        while (!queue.isEmpty()){
            Point nowPoint = queue.poll();
            if (nowPoint.point == sis){
                System.out.println(nowPoint.cnt);
                break;
            }
            int jumpPoint = nowPoint.point *2;
            int minPoint = nowPoint.point -1;
            int sumPoint = nowPoint.point +1;

            if(jumpPoint >= 0 && jumpPoint <= 100000){
                if(!isVisit[jumpPoint]){
                    queue.add(new Point(nowPoint.cnt,nowPoint.point*2));
                    isVisit[jumpPoint] = true;
                }
            }


            if(minPoint >= 0 && minPoint <= 100000){
                if(!isVisit[minPoint]){
                    queue.add(new Point(nowPoint.cnt+1, nowPoint.point-1));
                    isVisit[minPoint] = true;
                }
            }

            if(sumPoint >= 0 && sumPoint <= 100000){
                if(!isVisit[sumPoint]){
                    queue.add(new Point(nowPoint.cnt+1, nowPoint.point+1));
                    isVisit[sumPoint] = true;
                }
            }
        }
     }

     public static class Point{
        int cnt;

        int point;

        public Point(int cnt, int point){
            this.cnt = cnt;
            this.point = point;
        }
     }



}



