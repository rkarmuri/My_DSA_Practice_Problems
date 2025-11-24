public class MinMaxDistanceOfGas {
    public double minimiseMaxDistance(int[] arr, int k) {
        int n = arr.length;
        int[] howMany = new int[n - 1];
        for(int gasStations = 1; gasStations<=k;gasStations++){
            double maxSection = -1;
            int maxIndex = -1;
            for(int i=0;i<n-1;i++){
                double diff = arr[i+1] - arr[i];
                double sectionLength = diff/(double)(howMany[i]+1);

                if(sectionLength > maxSection){
                    maxSection = sectionLength;
                    maxIndex = i;
                }
            }
            howMany[maxIndex]++;
        }

        double maxAns = -1;
        for(int i=0;i<n-1;i++){
            double diff = arr[i+1] - arr[i];
            double sectionLength = diff / (double)(howMany[i]+1);
            maxAns = Math.max(maxAns, sectionLength);
        }

        return maxAns;
    }

    public static void main(String[] args) {
        MinMaxDistanceOfGas sol = new MinMaxDistanceOfGas();
        int[] arr = {0, 10, 20, 30};
        int k = 3;
        double result = sol.minimiseMaxDistance(arr, k);
        System.out.println("The minimized maximum distance between gas stations is: " + result);
    }
}
