import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] ans = new int[N];
        String[] strArr = new String[N];
        for(int i = 0;i < N ;i++){
            strArr[i] = sc.next();
        }


        for(int i =0 ;i<strArr.length;i++){
            String str = strArr[i];
            int leftIndex = 0;
            int rightIndex = str.length()-1;
            int answer = 0;

            while (leftIndex <= rightIndex){
                char leftChar = str.charAt(leftIndex);
                char rightChar = str.charAt(rightIndex);
                if(leftChar!=rightChar){
                    if(isPal(str,leftIndex+1,rightIndex) || isPal(str,leftIndex,rightIndex-1)){
                        answer = 1;
                    }else{
                        answer = 2;
                    }
                    break;
                }

                leftIndex++;
                rightIndex--;
            }
            System.out.println(answer);
            ans[i] = answer;
        }
    }

    public static boolean isPal(String str,int leftIndex, int rightIndex){
        while (leftIndex <= rightIndex){
            char leftChar = str.charAt(leftIndex);
            char rightChar = str.charAt(rightIndex);
            if(leftChar!=rightChar){
                return false;
            }

            leftIndex++;
            rightIndex--;
        }
        return true;
    }
}