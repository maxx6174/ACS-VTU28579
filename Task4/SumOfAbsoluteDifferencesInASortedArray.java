import java.util.Arrays;

public class SumOfAbsoluteDifferencesInASortedArray {

    public static int[] getSumAbsoluteDifferences(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];

        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;

        for (int i = 0; i < n; i++) {

            int rightSum = totalSum - leftSum - nums[i];

            int leftCount = i;
            int rightCount = n - i - 1;

            result[i] =
                    (nums[i] * leftCount - leftSum)
                    + (rightSum - nums[i] * rightCount);

            leftSum += nums[i];
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 5};

        int[] result = getSumAbsoluteDifferences(nums);

        System.out.println(Arrays.toString(result));
    }
}
