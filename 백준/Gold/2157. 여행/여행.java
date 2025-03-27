
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        int dp[][] = new int[M + 1][N + 1];
//        List<List<Node>> map = new ArrayList<>();
        List<Node>[] map = new List[N+1];
        for (int i = 0 ; i <= N ; i++){
            map[i]=(new ArrayList<>());
        }

        for(int i = 0; i < K ;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if(a > b){
                continue;
            }

            map[a].add(new Node(b,c));
        }

        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);

        int count = 1;
        while (!queue.isEmpty() && count < M){

            int size = queue.size();

//            for(int i = size; i > 0 ; i--){
//                int now = queue.poll();
//                for(Node node : map[now]){
//                    int nextIndex = node.index;
//                    int nextPoint = dp[count][now] + node.point;
//
//
//                    if(dp[count+1][nextIndex] > nextPoint){
//                        continue;
//                    }
//
//                    dp[count+1][nextIndex] = nextPoint;
//                    queue.add(nextIndex);
//
//                }
//            }
            while(size-->0) { // count마다 갈 수 있는 경로 dp 계산
                int now = queue.poll();
                for(Node node: map[now]) {
                    int next = node.index;
                    int nextCount = dp[count][now]+node.point;

                    if(dp[count+1][next]>=nextCount) continue;

                    dp[count+1][next] = nextCount;
                    queue.add(next);
                }
            }

            count++;

        }

        int result = 0;

        for(int i = 0; i <= M; i ++){
            result = Math.max(dp[i][N],result);
        }

        System.out.println(result);
    }


    static class Node{
        int index;
        int point;


        public Node(int index,int point){
            this.point = point;
            this.index = index;
        }
    }
}
