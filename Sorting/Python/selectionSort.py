def selectionSort(arr):
    n = len(arr)
    # Find the minimum index first and then swap it with the current index
    for i in range(n-1):
        # Assume the current index is the minimum
        mini = i
        # Find the index of the minimum element in the unsorted portion
        for j in range(i+1, n):
            if arr[j] < arr[mini]:
                mini = j
        # Swap the minimum element with the first element of the unsorted portion
        arr[mini], arr[i] = arr[i], arr[mini]
    return arr

# The best, worst, and average time complexities for the selection sort is: O(N*N)

def test_selection_sort():
    # Test Case 1: Random array
    arr1 = [54, 26, 93, 17, 77, 31, 44, 55, 20]
    assert selectionSort(arr1) == sorted(arr1)

    # Test Case 2: Sorted array (ascending)
    arr2 = [10, 20, 30, 40, 50, 60]
    assert selectionSort(arr2) == sorted(arr2)

    # Test Case 3: Sorted array (descending)
    arr3 = [90, 80, 70, 60, 50, 40]
    assert selectionSort(arr3) == sorted(arr3)

    # Test Case 4: Array with duplicate elements
    arr4 = [5, 2, 7, 2, 3, 5, 9, 3]
    assert selectionSort(arr4) == sorted(arr4)

    # Test Case 5: Array with negative numbers
    arr5 = [-10, -5, -3, -8, -15]
    assert selectionSort(arr5) == sorted(arr5)

    # Test Case 6: Empty array
    arr6 = []
    assert selectionSort(arr6) == sorted(arr6)

    # Test Case 7: Array with one element
    arr7 = [42]
    assert selectionSort(arr7) == sorted(arr7)

# Run the test cases
test_selection_sort()
print("All test cases passed!")


