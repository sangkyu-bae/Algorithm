import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Integer>> list = new ArrayList<>();
        int[] indegree = new int[n+1];
        Queue<Integer> queue = new LinkedList<>();
        boolean[] check = new boolean[n+1];

        for(int i = 1; i<=n+1;i++){
            list.add(new ArrayList<>());
        }

        for(int i = 1; i<=m ;i++){
            int cnt = sc.nextInt();
            int in = 0;
            for(int j =0;j<cnt;j++){
                int degree = sc.nextInt();

                if(j != 0){
                    list.get(in).add(degree);
                    indegree[degree]++;
                }
                in = degree;
            }
        }


        for (int i=1; i <= n;i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        List<Integer> answer = new ArrayList<>();
        while (!queue.isEmpty()){
            int index = queue.poll();
            check[index] =true;
            answer.add(index);
            if(answer.size() > n){
                System.out.println(0);
                return;
            }
            for(int next : list.get(index)){
                indegree[next]--;
                if(indegree[next] == 0){
                    queue.add(next);
                }
            }
        }

        for(int i = 1 ;i<=n;i++){
            if(!check[i]){
                System.out.println(0);
                return;
            }
        }
        
        for(Integer ans : answer){
            System.out.println(ans);
        }
    }
}