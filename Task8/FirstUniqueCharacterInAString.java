public class FirstUniqueCharacterInAString {

    public static int firstUniqChar(String s) {

        int[] count = new int[26];

        // Count frequency of each character
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        // Find the first character that appears once
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        String s = "leetcode";

        int result = firstUniqChar(s);

        System.out.println("First unique character index: " + result);
    }
}
