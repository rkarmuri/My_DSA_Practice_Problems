def bubbleSort(arr):
    n = len(arr)
    for i in range(n-1):
        didSwap = 0  # Flag to track if any swaps were made in this pass
        for j in range(1, n-i):
            if arr[j-1] > arr[j]:
                arr[j-1], arr[j] = arr[j], arr[j-1]  # Swap if the previous element is greater than the current element
                didSwap = 1  # Set flag to indicate a swap occurred
        if didSwap == 0:  # If no swaps were made in this pass, the array is already sorted
            break  # Exit the loop
    return arr

def bubbleSortRecur(arr,n):
    if n<=1:
        return
    # For every recursion the max element is moved to the last
    for i in range(1,n):
        if arr[i-1]>arr[i]:
            arr[i-1],arr[i] = arr[i],arr[i-1]

    # Recur for the remaining unsorted part of the array
    bubbleSortRecur(arr,n-1)
    return arr

# The worst and average time complexities of Bubble sort is: O(N*N)
# The best case is when all elements are sorted, then the time complexity is: O(N)

def test_bubble_sort():
    # Test Case 1: Random array
    arr1 = [54, 26, 93, 17, 77, 31, 44, 55, 20]
    assert bubbleSort(arr1) == sorted(arr1)

    # Test Case 2: Sorted array (ascending)
    arr2 = [10, 20, 30, 40, 50, 60]
    assert bubbleSort(arr2) == sorted(arr2)

    # Test Case 3: Sorted array (descending)
    arr3 = [90, 80, 70, 60, 50, 40]
    assert bubbleSort(arr3) == sorted(arr3)

    # Test Case 4: Array with duplicate elements
    arr4 = [5, 2, 7, 2, 3, 5, 9, 3]
    assert bubbleSort(arr4) == sorted(arr4)

    # Test Case 5: Array with negative numbers
    arr5 = [-10, -5, -3, -8, -15]
    assert bubbleSort(arr5) == sorted(arr5)

    # Test Case 6: Empty array
    arr6 = []
    assert bubbleSort(arr6) == sorted(arr6)

    # Test Case 7: Array with one element
    arr7 = [42]
    assert bubbleSort(arr7) == sorted(arr7)

def test_bubble_sort2():
    # Test Case 1: Random array
    arr1 = [54, 26, 93, 17, 77, 31, 44, 55, 20]
    assert bubbleSortRecur(arr1,len(arr1)) == sorted(arr1)

    # Test Case 2: Sorted array (ascending)
    arr2 = [10, 20, 30, 40, 50, 60]
    assert bubbleSortRecur(arr2,len(arr2)) == sorted(arr2)

    # Test Case 3: Sorted array (descending)
    arr3 = [90, 80, 70, 60, 50, 40]
    assert bubbleSortRecur(arr3,len(arr3)) == sorted(arr3)

    # Test Case 4: Array with duplicate elements
    arr4 = [5, 2, 7, 2, 3, 5, 9, 3]
    assert bubbleSortRecur(arr4,len(arr4)) == sorted(arr4)

    # Test Case 5: Array with negative numbers
    arr5 = [-10, -5, -3, -8, -15]
    assert bubbleSortRecur(arr5,len(arr5)) == sorted(arr5)

    # Test Case 6: Empty array
    arr6 = []
    bubbleSortRecur(arr6,len(arr6))
    assert arr6 == sorted(arr6)

    # Test Case 7: Array with one element
    arr7 = [42]
    bubbleSortRecur(arr7,len(arr7))
    assert arr7 == sorted(arr7)

# Run the test cases
test_bubble_sort()
print("All test cases passed!")
test_bubble_sort2()
print("All test cases 2 also passed!")
