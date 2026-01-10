public class FindMissingRepeatingNos {
    public static String findMissingRepeatingNumbers(int[] arr){
        long n = arr.length;

        long sumOfN = n * (n + 1) / 2;
        long sumOfSqOfN = n * (n + 1) * (2 * n + 1) / 6;

        long sumOfArr = 0;
        long sumOfSqArr = 0;

        // Find sum of elements and sum of squares of elements in the array
        for(int num : arr){
            sumOfArr += num;
            sumOfSqArr += (long)num * (long)num;
        }

        long diff = sumOfN - sumOfArr; // missing - repeating
        long sqDiff = sumOfSqOfN - sumOfSqArr; // missing^2 - repeating^2

        // a^2 - b^2 = (a-b)(a+b) 
        // => missing^2 - repeating^2 = (missing - repeating)(missing + repeating)
        // => missing + repeating = sqDiff / diff

        long sum = sqDiff / diff; // missing + repeating

        int missing = (int)((diff + sum) / 2); // => (missing + repeating)+(missing - repeating) / 2
        int repeating = (int)(sum - missing); // => (missing + repeating) - missing
        return missing + " " + repeating;
    }

    // Extreme Naive Approach: Use two loops to find the missing and repeating numbers
    public static String findMissingRepeatingNumbersBF(int[] arr){
        int n = arr.length;
        int repeating = -1, missing = -1;

        for(int i = 1; i <= n; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                if(arr[j] == i){
                    count++;
                }
            }
            if(count == 0){
                missing = i;
            } else if(count > 1){
                repeating = i;
            }
            // If both numbers are found, break the loop
            if(missing != -1 && repeating != -1){
                break;
            }
        }
        return missing + " " + repeating;
    }

    // Hashing Approach: Use an auxiliary array to count occurrences
    public static String findMissingRepeatingNumbersHashing(int[] arr){
        int n = arr.length;
        int[] hash = new int[n + 1];
        int missing = -1, repeating = -1;

        // Count occurrences of each number in the array
        for(int num : arr){
            hash[num]++;
        }

        // Identify the missing and repeating numbers
        for(int i = 1; i <= n; i++){
            if(hash[i] == 0){
                missing = i;
            } else if(hash[i] > 1){
                repeating = i;
            }
            // If both numbers are found, break the loop
            if(missing != -1 && repeating != -1){
                break;
            }
        }

        String res = missing + " " + repeating;;
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 3, 5, 4};
        String result = findMissingRepeatingNumbers(arr);
        System.out.println("Missing Number: " + result.split(" ")[0]);
        System.out.println("Repeating Number: " + result.split(" ")[1]);

        String resultBF = findMissingRepeatingNumbersBF(arr);
        System.out.println("Missing Number (Brute Force): " + resultBF.split(" ")[0]);
        System.out.println("Repeating Number (Brute Force): " + resultBF.split(" ")[1]);

        String resultHashing = findMissingRepeatingNumbersHashing(arr);
        System.out.println("Missing Number (Hashing): " + resultHashing.split(" ")[0]);
        System.out.println("Repeating Number (Hashing): " + resultHashing.split(" ")[1]);
    }
}
