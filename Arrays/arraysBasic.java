package Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class arraysBasic {
    // Problem 1 - Find the maximum element in an array
    static int maxEle(int[] arr) {
        int maxi = arr[0];

        for(int i=1;i<arr.length;i++){
            if(arr[i]>maxi){
                maxi = arr[i];
            }
        }
        return maxi;
    }
    // Problem 2 - Find the second largest element in an array
    static int secLargest(int[] arr) {
        int largest = -1, secLarge = -1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>largest){
                secLarge = largest;
                largest = arr[i];
            } else if(arr[i]>secLarge && arr[i]<largest){
                secLarge = arr[i];
            }
        }
        return secLarge;
    }
    // Problem 3 - Remove duplicates from an array using HashSet
    static int removeDuplicates(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        int k = set.size();
        int j=0;
        for(int x:set){
            arr[j++] = x; // Copying unique elements back to the array
        }
        return k;
    }
    // Problem 4 - Remove duplicates from a sorted array using two pointers
    static int removeDuplicatesOptimal(int[] arr) {
        int i=0;
        for(int j=1;j<arr.length;j++){
            if(arr[i]!=arr[j]){
                i++;
                arr[i]=arr[j]; // Copying unique elements to the front
            }
        }
        return i;
    }
    // Left rotate an array by 1 position
    static void leftRotate(int[] arr) {
        int temp = arr[0];
        for(int i=1;i<arr.length;i++){
            arr[i-1] = arr[i];
        }
        arr[arr.length-1] = temp;
    }
    // Left rotate an array by d positions using Brute Force
    static void leftRotateBruteForce(int[] arr, int d) {
        int[] temp = new int[d];
        
        // Copy the first d elements to a temporary array
        for(int i=0;i<d;i++){
            temp[i] = arr[i];
        }

        // Shift the remaining elements to the left
        for (int i = d; i < arr.length; i++) {
            arr[i - d] = arr[i];
        }
        // Copy the elements from the temporary array to the end of the original array
        for(int i=arr.length-d; i < arr.length; i++) {
            arr[i] = temp[i-(arr.length-d)];
        }
        // Time Complexity: O(d) + O(n-d) + O(d) = O(n+d)
        // Space Complexity: O(d)
    }
    // Left rotate an array by d positions using reversals 
    // Helper method to reverse elements in an array from index 'start' to 'end'
    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Left rotate an array by d positions using reversals 
    static void leftRotateOptimal(int[] arr, int d) {
        d = d % arr.length; // Handle cases where d >= arr.length
        reverse(arr, 0, d - 1); // Reverse first d elements
        reverse(arr, d, arr.length - 1); // Reverse remaining elements
        reverse(arr, 0, arr.length - 1); // Reverse the whole array
    }

    static void rightRotateOptimal(int[] arr, int d) {
        d = d%arr.length;
        reverse(arr,0, arr.length-1); // Reverse the whole array
        reverse(arr,0,d-1); // Reverse the first d elements
        reverse(arr,d,arr.length-1); // Reverse the remaining elements
    }

    // Move all zeroes to the end of the array using slow and fast pointers
    static void moverZeroesToEndOptimal(int[] arr) {
        int slow = 0;

        for (int fast = 0; fast < arr.length; fast++) {
            if (arr[fast] != 0) {
                int temp = arr[slow];
                arr[slow] = arr[fast]; // Move non-zero element to the slow pointer position
                arr[fast] = temp; 
                slow++;
            }
        }
    }

    // Union of two sorted arrays using HashSet
    static int[] unionOfSortedArraysUsingHashSet(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr1) {
            set.add(num);
        }
        for (int num : arr2) {
            set.add(num);
        }
        int[] result = new int[set.size()];
        int index = 0;
        for (int num : set) {
            result[index++] = num;
        }
        return result;
    }

    // Union of two sorted arrays
    static int[] unionOfSortedArrays(int[] arr1, int[] arr2) {
        int n = arr1.length, m = arr2.length;
        int i = 0, j = 0;
        List<Integer> unionList = new java.util.ArrayList<>();
        // Using two pointers to find the union of two sorted arrays
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                // Check if the last added element is not the same as arr1[i]
                if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != arr1[i]) {
                    unionList.add(arr1[i]);
                }
                i++;
            } else if (arr1[i] > arr2[j]) {
                // Check if the last added element is not the same as arr2[j]
                if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != arr2[j]) {
                    unionList.add(arr2[j]);
                }
                j++;
            } else {
                // If both are equal, add only once
                if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != arr1[i]) {
                    unionList.add(arr1[i]);
                }
                i++;
                j++;
            }
        }
        // Add remaining elements from arr1 and arr2
        while (i < n) {
            if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != arr1[i]) {
                unionList.add(arr1[i]);
            }
            i++;
        }
        while (j < m) {
            if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != arr2[j]) {
                unionList.add(arr2[j]);
            }
            j++;
        }
        // Convert List<Integer> to int[]
        int[] result = new int[unionList.size()];
        for (int l = 0; l < unionList.size(); l++) {
            result[l] = unionList.get(l);
        }
        return result;
        
    }

    private static int[] intersectionOfSortedArrays(int[] nums1, int[] nums2){
        int n = nums1.length, m = nums2.length;
        List<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(nums1[i]==nums2[j] && !visited[j]){
                    ans.add(nums1[i]);
                    visited[j] = true;
                    break;
                }
                else if(nums1[i] < nums2[j]){
                    break;
                }
            }
        }

        int[] res = new int[ans.size()];
        int index = 0;
        for(int i:ans){
            res[index++] = i;
        }

        return res;
    }

    // Intersection of two sorted arrays using HashSet
    private static int[] intersectionOfSortedArraysUsingHashSet(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> intersectionSet = new HashSet<>();

        for (int num : nums1) {
            set.add(num);
        }

        for (int num : nums2) {
            if (set.contains(num)) {
                intersectionSet.add(num);
            }
        }

        int[] result = new int[intersectionSet.size()];
        int index = 0;
        for (int num : intersectionSet) {
            result[index++] = num;
        }

        return result;
    }

    private static int[] intersectionOfSortedArraysOptimal(int[] nums1, int[] nums2){
        int n = nums1.length, m = nums2.length;
        List<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;
        while(i < n && j < m) {
            if(nums1[i] < nums2[j]) {
                i++;
            }
            else if (nums1[i] > nums2[j]){
                j++;
            }
            else {
                ans.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] res = new int[ans.size()];
        int index = 0;
        for(int k:ans){
            res[index++] = k;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {8,10,5,7,9}, arr2 = {1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,0,0};
        int[] arr3 = {1,2,3,4,5,6,7,8,9}, arr4 = {0,1,0,3,12,0};
        int[] arr5 = {1,2,3,4,5}, arr6 = {2,3,5,6,7};
        int[] nums1 = {1, 2, 2, 3, 3, 3}, nums2 = {2, 3, 3, 4, 5, 7};
        System.out.println("Maximum element of the array is: "+maxEle(arr));
        System.out.println("Second largest element of array is: "+secLargest(arr));
        //System.out.println("Array after removing duplicates using Hash set is: "+removeDuplicates(arr2));
        System.out.println("Array after removing duplicates using two pointers is: "+removeDuplicatesOptimal(arr2));
        leftRotate(arr);
        System.out.println("Array after left rotation by 1 position is: "+java.util.Arrays.toString(arr));
        leftRotateBruteForce(arr3, 3);
        System.out.println("Array after left rotation by 3 positions is: "+java.util.Arrays.toString(arr3));
        leftRotateOptimal(arr3, 5);
        System.out.println("Array after left rotation by 5 positions using optimal method is: "+java.util.Arrays.toString(arr3));
        rightRotateOptimal(arr4, 3);
        System.out.println("Array after right rotation by 3 positions using optimal method is: "+java.util.Arrays.toString(arr4));
        moverZeroesToEndOptimal(arr5);
        System.out.println("Array after moving zeroes to the end is: "+java.util.Arrays.toString(arr5));
        int[] unionResult = unionOfSortedArrays(arr5, arr6);
        System.out.println("Union of two sorted arrays is: " + java.util.Arrays.toString(unionResult));
        int[] unionHashSetResult = unionOfSortedArraysUsingHashSet(arr5, arr6);
        System.out.println("Union of two sorted arrays using HashSet is: " + java.util.Arrays.toString(unionHashSetResult));
        int[] intersectionResult = intersectionOfSortedArrays(arr5, arr6);
        System.out.println("Intersection of two sorted arrays is: " + java.util.Arrays.toString(intersectionResult));
        int[] intersectionResult2 = intersectionOfSortedArraysOptimal(nums1, nums2);
        System.out.println("Intersection of two sorted arrays Optimal is: " + java.util.Arrays.toString(intersectionResult2));
        int[] intersectionHashSetResult = intersectionOfSortedArraysUsingHashSet(nums1, nums2);
        System.out.println("Intersection of two sorted arrays using HashSet is: " + java.util.Arrays.toString(intersectionHashSetResult));
    }
}
