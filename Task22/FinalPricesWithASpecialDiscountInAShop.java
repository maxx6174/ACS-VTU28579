import java.util.Arrays;
import java.util.Stack;

public class FinalPricesWithASpecialDiscountInAShop {

    public static int[] finalPrices(int[] prices) {

        Stack<Integer> stack = new Stack<>();

        for (int i = prices.length - 1; i >= 0; i--) {

            int originalPrice = prices[i];

            while (!stack.isEmpty() && stack.peek() > originalPrice) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                prices[i] = originalPrice - stack.peek();
            }

            stack.push(originalPrice);
        }

        return prices;
    }

    public static void main(String[] args) {

        int[] prices = {8, 4, 6, 2, 3};

        int[] result = finalPrices(prices);

        System.out.println(Arrays.toString(result));
    }
}
