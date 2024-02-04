import java.io.*;
import java.util.*;

public class Main {
    static int n ,m;
    static int[] numbers;
    static boolean[] check;
    static int[]output;
    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        numbers = new int[n];
        check = new boolean[n];
        output = new int[m];
        for(int i = 0; i < n ;i++){
            numbers[i] = sc.nextInt();
        }

        Arrays.sort(numbers);
        dfs(0,0);
    }

    static void dfs(int depth,int start){
        if(depth == m){
            StringBuilder sb= new StringBuilder();
            for(int i = 0;i < m; i++){
                sb.append(output[i] + " ");
            }
            System.out.println(sb);
            return;
        }

        for(int i = start; i < n;i++){
            if(!check[i]){
                check[i] = true;
                output[depth] = numbers[i];
                dfs(depth+1,i+1);
                check[i] = false;
            }
        }
    }
}