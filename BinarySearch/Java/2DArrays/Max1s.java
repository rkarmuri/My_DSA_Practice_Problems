public class Max1s {
    private static int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while(low<=high){
            int mid = (low+high)/2;

            if(arr[mid] >= target){
                high = mid - 1; // Move left to find the first occurrence
            } else {
                low = mid + 1; // Move right to find a larger value
            }
        }

        return low;
    }
    public int rowWithMax1s(int[][] mat) {
       int index = -1, maxCount = 0;
       for(int i=0;i<mat.length;i++){
        int m = mat[i].length;
        int cnt = m - lowerBound(mat[i], 1);
            if(cnt>maxCount){
                maxCount = cnt;
                index = i;
            }
       }

       return index;
    }

    // Brute Force Approach
    private int countOnes(int[] arr){
        int count = 0;
        for(int num : arr){
            if(num == 1) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Max1s sol = new Max1s();
        int[][] mat = {
            {0, 0, 0, 1, 1},
            {0, 1, 1, 1, 1},
            {0, 0, 1, 1, 1},
            {1, 1, 1, 1, 1}
        };
        int result = sol.rowWithMax1s(mat);
        System.out.println("Row with maximum number of 1s: " + result);
        int bruteForceResult = sol.countOnes(mat[result]);
        System.out.println("Count of 1s in the row (Brute Force): " + bruteForceResult);
    }
}
