import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] middle = new int[N][M];

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                middle[i][j] = sc.nextInt();
            }
        }

        int[] index = new int[N];
        for(int i = 0; i < N ; i++){
            Arrays.sort(middle[i]);
            index[i] = 0;
        }

        int result = Integer.MAX_VALUE;

        while (true){

            int max = 0;
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for(int i = 0; i < N ; i ++){
                int score = middle[i][index[i]];

                if(score > max){
                    max = score;
                }
                if(score < min){
                    min = score;
                    minIndex = i;
                }
            }

            result = Math.min(max-min,result);
            index[minIndex]++;

            if(index[minIndex] >= M ){
                break;
            }
        }

        System.out.println(result);

    }

}
