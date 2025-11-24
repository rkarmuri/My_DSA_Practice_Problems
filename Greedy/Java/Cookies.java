import java.util.Arrays;

// Intution: Sort both arrays and use two pointers to match students with cookies
// Greedy Approach: Always try to satisfy the current student with the smallest cookie that is big enough

public class Cookies {
    public static int minCookies(int[] Student, int[] Cookies) {
        // Time Complexity: O(n log n + m log m + n + m) => O(n log n + m log m)
        // Space Complexity: O(1)
        Arrays.sort(Student);
        Arrays.sort(Cookies);
        int n = Student.length;
        int m = Cookies.length;

        int l = 0, r = 0;
        while (l < n && r < m) {
            if (Student[l] <= Cookies[r]) {
                l++;
            }
            r++;
            
        }
        return l;
    }

    public static void main(String[] args) {
        int[] Student = {1, 2, 3, 4, 5};
        int[] Cookies = {3, 3, 3, 3, 3};
        System.out.println(minCookies(Student, Cookies));  // Output: 3
    }

}