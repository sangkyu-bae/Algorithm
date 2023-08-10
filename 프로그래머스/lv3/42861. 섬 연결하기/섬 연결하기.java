import java.util.*;
class Solution {
      int[] parent;
    public int solution(int n, int[][] costs) {
         int answer = 0;
        parent = new int[n];

        Arrays.sort(costs,(o1,o2)->Integer.compare(o1[2],o2[2]));

        for(int i = 0;i<n;i++){
            parent[i]=i;
        }

        for(int i=0;i<costs.length;i++){
            if(find(costs[i][0]) != find(costs[i][1])){
                System.out.println("<선택된 간선>");
                System.out.println(Arrays.toString(costs[i]));
                union(costs[i][0] , costs[i][1] );
                answer += costs[i][2];
                System.out.println("<각 노드가 가리키고 있는 부모>");
                System.out.println(Arrays.toString(parent) + "\n");
                continue;
            }
        }


        return answer;
    }
    void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }

    int find(int x) {
        if (parent[x] == x)
            return x;
        else
            return find(parent[x]);
    }
}