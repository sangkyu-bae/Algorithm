class Solution {
        int target;
    public int[] solution(int[] sequence, int k) {
int n = sequence.length;
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        int[] answer = new int[] { -1, -1 };
        int minLength = n + 1;

        while (right < n) {
            if (sum == k) {
                int length = right - left + 1;
                if (length < minLength) {
                    answer[0] = left;
                    answer[1] = right;
                    minLength = length;
                }
                sum -= sequence[left++];
            } else if (sum < k) {
                right++;
                if (right < n) {
                    sum += sequence[right];
                }
            } else {
                sum -= sequence[left++];
            }
        }

        if (answer[0] == -1) {
            return new int[0];
        } else {
            return answer;
        }
    }
}