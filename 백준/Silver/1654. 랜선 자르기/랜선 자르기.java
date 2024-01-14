import java.io.*;
import java.util.Scanner;

public class Main {

    static long binarySearch(int[] lanArr, long lanMiterSum, int cutCnt){
        long l = 1, r = (1L << 31)-1;

        long optional = -1;
        while (l <= r){

            long m = (l+r)/2;

            if(calculateCnt(lanArr,m) >= cutCnt){
                l = m+1;
                optional = m;
            }else{
                r = m-1;
            }
        }

        return optional;
    }

    public static int calculateCnt(int[] lanArr, long cutMiter){
        int sum = 0;
        for(int i : lanArr){
            sum += i / cutMiter;
        }

        return sum;
    }

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] lanArr = new int[N];
        int lanSum = 0;
        for(int i = 0 ;i < N;i++){
            int lanNum = sc.nextInt();
            lanArr[i] = lanNum;
            lanSum += lanNum;
        }

        long a = binarySearch(lanArr,lanSum,M);
        System.out.println(a);
    }
}