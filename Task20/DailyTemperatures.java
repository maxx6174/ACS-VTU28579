import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] temperatures) {

        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {

            while (!stack.isEmpty() &&
                   temperatures[i] > temperatures[stack.peek()]) {

                int previousIndex = stack.pop();
                result[previousIndex] = i - previousIndex;
            }

            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};

        int[] result = dailyTemperatures(temperatures);

        System.out.println(Arrays.toString(result));
    }
}
