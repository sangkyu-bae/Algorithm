import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] arr;
    static int[] check;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        check = new int[500001];
        arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());

        for(int i=1 ;i <= n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        System.out.println(divide(1,n));
    }

    static int divide (int start, int end){
        int mid = (start + end + 1)/2;
        if(start == mid) return start;
        if(decision(mid)){
            return divide(mid, end);
        } else{
            return divide(start, mid -1);
        }
    }
    public static boolean decision(int length){
        int start = 1;
        int end = 1;
        int pack = 0;
        Arrays.fill(check,-1);
        while (end <= n){

            if(check[arr[end]] >= start ){
                start = check[arr[end]] + 1;
            }

            check[arr[end]] = end;

            if(end - start + 1 == length){
                pack++;
                start = end + 1;
            }

            if(pack == m){
                return true;
            }

            end++;
        }
        return false;
    }
}