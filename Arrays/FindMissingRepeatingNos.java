public class FindMissingRepeatingNos {
    public static int[] findMissingRepeatingNumbers(int[] arr){
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
        return new int[]{missing, repeating};
    }

    // Extreme Naive Approach: Use two loops to find the missing and repeating numbers
    public static int[] findMissingRepeatingNumbersBF(int[] arr){
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
        return new int[]{missing, repeating};
    }

    // Hashing Approach: Use an auxiliary array to count occurrences
    public static int[] findMissingRepeatingNumbersHashing(int[] arr){
        int n = arr.length;
        int[] hash = new int[n + 1];
        int missing = -1, repeating = -1;

        for(int num : arr){
            hash[num]++;
        }

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
        return new int[]{missing, repeating};
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 3, 5, 4};
        int[] result = findMissingRepeatingNumbers(arr);
        System.out.println("Missing Number: " + result[0]);
        System.out.println("Repeating Number: " + result[1]);

        int[] resultBF = findMissingRepeatingNumbersBF(arr);
        System.out.println("Missing Number (Brute Force): " + resultBF[0]);
        System.out.println("Repeating Number (Brute Force): " + resultBF[1]);

        int[] resultHashing = findMissingRepeatingNumbersHashing(arr);
        System.out.println("Missing Number (Hashing): " + resultHashing[0]);
        System.out.println("Repeating Number (Hashing): " + resultHashing[1]);
    }
}
