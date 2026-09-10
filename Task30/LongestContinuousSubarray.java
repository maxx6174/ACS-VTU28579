import java.util.*;

public class LongestContinuousSubarray {
    public static int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDq = new ArrayDeque<>();
        Deque<Integer> minDq = new ArrayDeque<>();

        int left = 0;
        int ans = 0;

        for (int right = 0; right < nums.length; right++) {

            while (!maxDq.isEmpty() && nums[maxDq.peekLast()] < nums[right]) {
                maxDq.pollLast();
            }
            maxDq.offerLast(right);

            while (!minDq.isEmpty() && nums[minDq.peekLast()] > nums[right]) {
                minDq.pollLast();
            }
            minDq.offerLast(right);

            while (nums[maxDq.peekFirst()] - nums[minDq.peekFirst()] > limit) {
                left++;

                if (!maxDq.isEmpty() && maxDq.peekFirst() < left) {
                    maxDq.pollFirst();
                }

                if (!minDq.isEmpty() && minDq.peekFirst() < left) {
                    minDq.pollFirst();
                }
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {8, 2, 4, 7};
        int limit = 4;

        System.out.println(longestSubarray(nums, limit));
    }
}
