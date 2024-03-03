
import java.io.*;
import java.util.*;

public class Main {
    static int[] cost;
    static int INF = 1000000000;
    static List<List<Node>> list =new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n =sc.nextInt();
        int m= sc.nextInt();
        int x = sc.nextInt();
        cost = new int[n + 1];
        if(m==0){
            System.out.println(-1);
            return;
        }
        for(int i = 0 ; i <= n ;i++){
            list.add(new ArrayList<>());
            cost[i] = INF;
        }

        for(int i = 1 ;i <= m;i++){
            int src =sc.nextInt();
            int dist = sc.nextInt();
            int c = sc.nextInt();

            list.get(src).add(new Node(dist,c));
        }
        int answer = -1;

        for(int i = 1 ; i<=n;i++){
             answer = Math.max(answer,dis(i,x) + dis(x,i));
        }

        System.out.println(answer);
    }

    static void reset(){
        for(int i =0 ;i<cost.length;i++){
            cost[i] = INF;
        }
    }

    static int dis(int start,int end){
        PriorityQueue <Node> queue = new PriorityQueue<>((o1,o2)->{
            return o1.cost - o2.cost;
        });

        cost[start] = 0;
        queue.add(new Node(start,0));

        while (!queue.isEmpty()){
            Node now = queue.poll();
            if(now.cost > cost[now.dist]){
                continue;
            }
            for(Node next : list.get(now.dist)){
                if(cost[next.dist] > cost[now.dist] + next.cost){
                    cost[next.dist] = cost[now.dist] + next.cost;
                    queue.add(new Node(next.dist,next.cost));
                }
            }
        }

        int answer = cost[end];
        reset();
        return answer;
    }
}
class Node{
    int dist;
    int cost;

    public Node(int dist,int cost){
        this.dist = dist;
        this.cost = cost;
    }
}