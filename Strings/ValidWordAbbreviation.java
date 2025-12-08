public class ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        int n = word.length(), m = abbr.length();

        while(i < n && j < m) {
            char c = abbr.charAt(j);

            if(Character.isDigit(c)) {
                if(c == '0') return false; // Leading zero is not allowed
                int num = 0;
                while(j < m && Character.isDigit(abbr.charAt(j))) {
                    num = num * 10 + (abbr.charAt(j) - '0');
                    j++;
                }
                i += num; // Move i forward by the number represented
            } else {
                if(i >= n || word.charAt(i) != c) {
                    return false; // Mismatch found
                }
                i++;
                j++;
            }
        }
        return i == n && j == m;
    }

    public static void main(String[] args) {
        ValidWordAbbreviation validator = new ValidWordAbbreviation();
        System.out.println(validator.validWordAbbreviation("internationalization", "i12iz4n")); // true
        System.out.println(validator.validWordAbbreviation("apple", "a3e")); // true
        System.out.println(validator.validWordAbbreviation("apple", "a2e")); // false
        System.out.println(validator.validWordAbbreviation("substitution", "s10n")); // true
        System.out.println(validator.validWordAbbreviation("substitution", "s01n")); // false
    }
}
