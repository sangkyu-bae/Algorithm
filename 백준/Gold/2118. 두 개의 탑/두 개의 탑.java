import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] topArr = new int[N];
        int sum = 0;
        for(int i = 0;i < N ;i++){
            int top = sc.nextInt();
            topArr[i] = top;
            sum += top;
        }

        int checkSum = 0;
        int pairIndex = 0;
        int answer = 0;
        int distCounterClockWise = sum;

        for(int i = 0; i < N ;i++){
            while (distCounterClockWise > checkSum){
                checkSum +=  topArr[pairIndex];
                distCounterClockWise -= topArr[pairIndex];
                pairIndex = (pairIndex+1) % N;
            }
            
            answer = Math.max(answer,distCounterClockWise);
            distCounterClockWise += topArr[i];
            checkSum -= topArr[i];
        }

        System.out.println(answer);
    }


}