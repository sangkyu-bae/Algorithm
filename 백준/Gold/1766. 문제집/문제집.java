import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] indegree = new int[n+1];
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0;i<=n;i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            list.get(a).add(b);
            indegree[b]++;
        }

        PriorityQueue <Integer> queue = new PriorityQueue<>();

        for(int i = 1; i<=n;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }

        while (!queue.isEmpty()){
            int now = queue.poll();

            System.out.print(now+" ");
            for(int next : list.get(now)){
                indegree[next]--;
                if(indegree[next] == 0){
                    queue.add(next);
                }
            }
        }
    }
}