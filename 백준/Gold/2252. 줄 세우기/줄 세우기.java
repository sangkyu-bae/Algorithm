import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        Map<Integer,List<Integer>> map = new HashMap<>();

        for(int i = 1;i<=n;i++){
            map.put(i,new ArrayList<>());
        }
        int[] indegree = new int[n+1];
        boolean[] check = new boolean[n+1];
        for(int i = 0 ;i<m;i++){
            int src =sc.nextInt();
            int dist = sc.nextInt();

            List<Integer> list;
            if(map.containsKey(src)){
                list = map.get(src);
                list.add(dist);

            }else{
                list = new ArrayList<>();
                list.add(dist);
            }

            map.put(src,list);
            indegree[dist]++;
        }

        Queue <Integer> queue = new LinkedList<>();

        for(int i =1 ;i<=n;i++){
            if(indegree[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()){
            int now = queue.poll();
            check[now] = true;

            System.out.println(now+" ");
            for(int next : map.get(now)){
                if(check[next]){
                    continue;
                }
                indegree[next]--;
                if(indegree[next] == 0){
                    queue.add(next);
                }
            }
        }


    }
}