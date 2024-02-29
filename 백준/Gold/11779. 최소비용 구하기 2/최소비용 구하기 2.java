import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)  {
       
        Scanner sc = new Scanner(System.in);
        int INF = 1000000000;
        int n =sc.nextInt(), e= sc.nextInt();
        int[] cost = new int[n + 1];
        int[] path = new int[n + 1];
        List<List<Edge>> list = new ArrayList<>();

        for(int i = 0; i <= n ;i++){
            cost[i] = INF;
            list.add(new ArrayList<>());
        }

        for(int i = 0; i<e;i++){
            int src = sc.nextInt();
            int dist = sc.nextInt();
            int c = sc.nextInt();

            list.get(src).add(new Edge(dist,c));
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        PriorityQueue<Edge> queue = new PriorityQueue<>((o1,o2)->{
            return o1.cost - o2.cost;
        });

        queue.add(new Edge(start,0));
        cost[start] = 0;
        while (!queue.isEmpty()){
            Edge now = queue.poll();

            if(now.cost > cost[now.dist]){
                continue;
            }

            for(Edge next : list.get(now.dist)){
                if(cost[next.dist] > next.cost + cost[now.dist] ){
                    cost[next.dist] = next.cost + cost[now.dist];
                    queue.add(new Edge(next.dist, next.cost));
                    path[next.dist] = now.dist;
                }
            }
        }

        Stack<Integer> stack = new Stack<>();
        int checkPath = end;
        while (checkPath != 0){
            stack.add(checkPath);
            checkPath = path[checkPath];
        }

        System.out.println(cost[end]);
        System.out.println(stack.size());

        while (!stack.isEmpty()){
            System.out.print(stack.pop() +" ");
        }
    }
}
class Edge{
    int dist;
    int cost;

    public Edge(int dist,int cost){
        this.dist = dist;
        this.cost = cost;
    }
}