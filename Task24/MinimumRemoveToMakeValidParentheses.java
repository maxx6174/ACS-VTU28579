import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {

    public static String minRemoveToMakeValid(String s) {

        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        boolean[] remove = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')') {

                if (stack.isEmpty()) {
                    remove[i] = true;
                } else {
                    stack.pop();
                }
            }
        }

        while (!stack.isEmpty()) {
            remove[stack.pop()] = true;
        }

        for (int i = 0; i < s.length(); i++) {
            if (!remove[i]) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String s = "lee(t(c)o)de)";

        System.out.println(minRemoveToMakeValid(s));
    }
}
