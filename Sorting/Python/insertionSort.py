def insertionSort(arr):
    n = len(arr)
    for i in range(n):
        j = i
        while j>0 and arr[j-1]>arr[j]:
            arr[j-1],arr[j]=arr[j],arr[j-1]
            j = j-1

    '''for i in range(n):
            for j in range(i,0,-1):
                if arr[j-1]>arr[j]:
                    arr[j-1],arr[j]=arr[j],arr[j-1]
                else:
                    break'''
    
    return arr

# The worst and average time complexities of Insertion sort is: O(N*N)
# The best case is when all elements are sorted, then the time complexity is: O(N)

def test_insertion_sort():
    # Test Case 1: Random array
    arr1 = [54, 26, 93, 17, 77, 31, 44, 55, 20]
    assert insertionSort(arr1) == sorted(arr1)

    # Test Case 2: Sorted array (ascending)
    arr2 = [10, 20, 30, 40, 50, 60]
    assert insertionSort(arr2) == sorted(arr2)

    # Test Case 3: Sorted array (descending)
    arr3 = [90, 80, 70, 60, 50, 40]
    assert insertionSort(arr3) == sorted(arr3)

    # Test Case 4: Array with duplicate elements
    arr4 = [5, 2, 7, 2, 3, 5, 9, 3]
    assert insertionSort(arr4) == sorted(arr4)

    # Test Case 5: Array with negative numbers
    arr5 = [-10, -5, -3, -8, -15]
    assert insertionSort(arr5) == sorted(arr5)

    # Test Case 6: Empty array
    arr6 = []
    assert insertionSort(arr6) == sorted(arr6)

    # Test Case 7: Array with one element
    arr7 = [42]
    assert insertionSort(arr7) == sorted(arr7)

# Run the test cases
test_insertion_sort()
print("All test cases passed!")