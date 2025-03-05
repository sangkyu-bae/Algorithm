import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] map = new int[N];
        int[] count = new int[100001]; // 숫자의 등장 횟수를 저장할 배열

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0, result = 0;

        while (end < N) {
            // 현재 숫자의 개수가 K 이상이면 start를 이동
            while (end < N && count[map[end]] < K) {
                count[map[end]]++;
                end++;
            }

            // 최장 연속 부분 수열 길이 갱신
            result = Math.max(result, end - start);

            // start를 이동하며 현재 수 제거
            count[map[start]]--;
            start++;
        }

        System.out.println(result);
    }
}