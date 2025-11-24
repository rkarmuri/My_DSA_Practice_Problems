public class LemonadeChange {
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // Intuitive Explanation:
    // We maintain counts of $5 and $10 bills. For each $20 bill,
    // we try to give change using one $10 and one $5 bill if possible,
    // otherwise we use three $5 bills. If we cannot provide the correct change
    // at any point, we return false. If we successfully process all bills,
    // we return true.
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            } else {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LemonadeChange obj = new LemonadeChange();
        int[] bills1 = {5, 5, 5, 10, 20};
        int[] bills2 = {5, 5, 10, 10, 20};
        System.out.println(obj.lemonadeChange(bills1)); // true
        System.out.println(obj.lemonadeChange(bills2)); // false
    }
}
