import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] firstArr = new int[N];
        int[] secondArr = new int[M];

        for(int i = 0; i < N ;i++){
            firstArr[i] = sc.nextInt();
        }

        for(int i = 0; i < M ;i++){
            secondArr[i] = sc.nextInt();
        }

        int[] sumArr = new int[N+M];
        int sum = N+M;

        int firstIndex = 0;
        int secondIndex = 0;
        int sumIndex = 0;
        while (sumIndex < sum){

            if(secondIndex >= M){
                sumArr[sumIndex] = firstArr[firstIndex++];
                sumIndex++;
                continue;
            }else if(firstIndex >= N){
                sumArr[sumIndex] = secondArr[secondIndex++];
                sumIndex++;
                continue;
            }

            if( firstArr[firstIndex] <= secondArr[secondIndex]){
                sumArr[sumIndex] = firstArr[firstIndex++];
            }else if(secondArr[secondIndex] < firstArr[firstIndex]){
                sumArr[sumIndex] = secondArr[secondIndex++];
            }
            sumIndex++;
        }


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i : sumArr){
            bw.write(i + " ");
        }

        bw.write("\n");
        bw.flush();
    }
}