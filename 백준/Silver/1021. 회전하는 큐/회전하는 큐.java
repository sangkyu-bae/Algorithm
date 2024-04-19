import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] nArr = new int[m];
        for(int i = 0; i < m;i++){
            nArr[i] = sc.nextInt();
        }

        Queue<Integer> queue =new LinkedList();

        for(int i = 1; i <= n;i++){
            queue.add(i);
        }

        int answer = 0;
        for(int i = 0 ;i<m;i++){

            int cnt = 0;

            while (queue.peek() != nArr[i]){
                queue.offer(queue.poll());
                cnt++;
            }

            answer += Math.min(cnt,(queue.size() - cnt));

            queue.poll();
        }

        System.out.println(answer);
    }
}