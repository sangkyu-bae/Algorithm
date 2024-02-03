import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] topArr = new int[N];
        int sum = 0;
        for(int i = 0; i < N ; i++){
            int num = sc.nextInt();
            topArr[i] = num;
            sum += num;
        }

        int index =0 ;
        int checkSum = 0;
        int answer = 0;

        for(int i = 0 ; i < N; i++){
            while (sum > checkSum){
                checkSum += topArr[index];
                sum -= topArr[index];
                index = (index+1)%N;
            }

            answer = Math.max(sum,answer);
            sum += topArr[i];
            checkSum -= topArr[i];
        }

        System.out.println(answer);
    }

}