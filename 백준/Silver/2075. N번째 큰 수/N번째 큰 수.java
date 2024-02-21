
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)  {
   
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();


        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0 ;i<n;i++){
            for(int j = 0 ; j<n;j++){
                queue.add(sc.nextInt());
            }
        }
        int i =1;
        while (!queue.isEmpty()){
            if(i == n){
                System.out.println(queue.poll());
                break;
            }
            queue.poll();
            i++;
        }
    }
}