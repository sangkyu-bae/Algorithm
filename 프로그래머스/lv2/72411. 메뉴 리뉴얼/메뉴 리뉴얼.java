import java.util.*;

class Solution {
	public static String[] solution(String[] orders, int[] course) {
		ArrayList<String> list = new ArrayList<String>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int combi : course) {
			map.clear();
			for(String order : orders) {
				boolean[] visited = new boolean[order.length()];
				combination(map, order, visited, order.length(), 0, combi);
			}
			List<Map.Entry<String,Integer>> entryset = new LinkedList<>(map.entrySet());
			entryset.sort(((o1,o2)-> map.get(o2.getKey())-map.get(o1.getKey())));
			int max=2;
			for(Map.Entry<String, Integer> entry: entryset) {
				if(entry.getValue()>=max) {
					list.add(entry.getKey());
					max = entry.getValue();
				}
			}
			Collections.sort(list);
		}	
		String[] answer = list.toArray(new String[list.size()]);
		return answer;
	}
	static void combination(HashMap<String,Integer> map,String arr, boolean[] visited, int n, int start, int r) {
		if (r == 0) {
			String s="";
        	for(int i=0;i<n;i++) if(visited[i]) s=s.concat(Character.toString(arr.charAt(i))); 
        	char[] chars = s.toCharArray();
        	Arrays.sort(chars);
        	s = new String(chars);
        	map.put(s,map.getOrDefault(s, 0)+1);
        	return;
        }
        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(map,arr, visited, n, i+1, r-1);
            visited[i] = false;
        }
    }	
}