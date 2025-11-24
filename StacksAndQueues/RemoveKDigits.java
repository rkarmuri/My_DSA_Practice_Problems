import java.util.Stack;
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if (k == n) return "0";

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            char digit = num.charAt(i);

            while (!st.isEmpty() && k > 0 && st.peek() > digit) {
                st.pop();
                k--;
            }

            st.push(digit);
        }

        // If k is still greater than 0, remove from the end
        while (!st.isEmpty() && k > 0) {
            st.pop();
            k--;
        }

        // Build the resulting number
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        sb.reverse();

        // Remove leading zeros
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveKDigits solution = new RemoveKDigits();
        String num = "1432219";
        int k = 3;
        String result = solution.removeKdigits(num, k);
        System.out.println("Result after removing " + k + " digits: " + result); // Output: "1219"
    }
}
