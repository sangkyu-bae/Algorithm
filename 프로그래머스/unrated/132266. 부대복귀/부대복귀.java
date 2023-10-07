import java.util.*;
class Solution {
     int[] dist;
    ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    int N;
    int des;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
      int[] answer = new int[sources.length];
        int length = n;
        N =n+1;

        des = destination;
        for(int i = 0;i<length+1;i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i< roads.length;i++){
            graph.get(roads[i][0]).add(new Node(roads[i][1],1));
            graph.get(roads[i][1]).add(new Node(roads[i][0],1));
        }

        dist = new int[length+1];
        dijkstra(destination);
        
        for(int i = 0;i<sources.length;i++){
            int min = dist[sources[i]];
            min = min == Integer.MAX_VALUE ? -1 :min;
            answer[i] = min;
        }
        
        return answer;
    }
    
     static class Node implements Comparable<Node> {
        int idx, cost;

        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }
    void dijkstra(int start){
     boolean[] visited = new boolean[N];
        for(int i = 0; i < dist.length;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;
        PriorityQueue<Node> queue = new PriorityQueue();
        queue.add(new Node(start,0));

        while (!queue.isEmpty()){
            Node node = queue.poll();
            if (visited[node.idx]) {
                continue;
            }
            visited[node.idx] = true;

            if(dist[node.idx] < node.cost) continue;
            for(int i = 0; i < graph.get(node.idx).size() ; i++){
                int next = graph.get(node.idx).get(i).idx;
                int nextDistance = node.cost + graph.get(node.idx).get(i).cost;

                if(nextDistance < dist[next]){
                    dist[next] = nextDistance;
                    queue.add(new Node(next,nextDistance));
                }
            }
        }
    }
}