import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] S = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0;
        int removed = 0, maxEvenLength = 0;
        int evenCount = 0;

        while (right < N) {
            if (S[right] % 2 == 0) {
                evenCount++;
            } else {
                removed++;
            }
            right++;

            while (removed > K) {
                if (S[left] % 2 == 0) {
                    evenCount--;
                } else {
                    removed--;
                }
                left++;
            }

            maxEvenLength = Math.max(maxEvenLength, evenCount);
        }

        System.out.println(maxEvenLength);
    }
}