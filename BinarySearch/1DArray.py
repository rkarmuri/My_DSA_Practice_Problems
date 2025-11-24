def searchRotatedSortedArray(arr,n,target):
    low, high = 0, n-1
    while low<=high:
        mid = (low+high)//2
        if arr[mid]==target:
            return mid
        # If left part is sorted
        if arr[low]<=arr[mid]:
            # If target lies within the left part
            if arr[low]<=target and target<=arr[mid]:
                high = mid - 1
            else:
                low = mid + 1
        # If right part is sorted
        else:
            # If target lies within the right part
            if arr[mid]<=target and target<=arr[high]:
                low = mid + 1
            else:
                high = mid - 1
    
    return -1
    
def searchRotatedSortedArrayDuplicates(arr,n,target):
    # Since the array contains duplicates, it is hard to find
    # the correct sorted halves. Therefore, we shrink the array
    # positions if low==mid and mid==high. Then, we check the 
    # sorted halves individually.
    low, high = 0, n-1
    while low<=high:
        mid = (low+high)//2
        if arr[mid]==target:
            return True
        # Shrink the array positions the values low==mid and mid==high
        if arr[low]==arr[mid] and arr[mid]==arr[high]:
            low = low + 1
            high = high - 1
        # If the left half is sorted
        elif arr[low]<=arr[mid]:
            # If the target lies within the left half
            if arr[low]<=target and target<=arr[mid]:
                high = mid - 1
            else:
                low = mid + 1
        # If the right half is sorted
        else:
            # If target lies within the right half
            if arr[mid]<=target and target<=arr[high]:
                low = mid + 1
            else:
                high = mid - 1
    
    return False
    
def minimumElementRotatedSortedArray(arr):
    # Intution is to find the sorted half and get the min from it
    # Then eliminate the sorted half, then check the other half
    low, high = 0, len(arr)-1
    ans = arr[0]
    while low<=high:
        mid = (low+high)//2
        # If the search space is already sorted
        if arr[low]<=arr[high]:
            ans = min(ans,arr[low])
            break
        # Check if the left half is sorted
        if arr[low]<=arr[mid]:
            # Save the minimum from left half and eliminate it
            ans = min(ans,arr[low])
            low = mid + 1
        # Check if the right half is sorted
        else:
            # Save the minimum from the right half and eliminate it
            ans = min(ans,arr[mid])
            high = mid - 1

    return ans
    
def minimumElementRotatedSortedArrayDuplicates(arr):
    # Intution is to find the sorted half and get the min from it
    # Then eliminate the sorted half, then check the other half
    low, high = 0, len(arr)-1
    ans = arr[0]
    while low<=high:
        mid = (low+high)//2
        # Shrink the array if low==mid and mid==high
        if arr[low]==arr[mid] and arr[mid]==arr[high]:
            ans = min(ans,arr[low]) # If the search space is already sorted
            low = low + 1
            high = high - 1
        # Check if the left half is sorted
        elif arr[low]<=arr[mid]:
            # Save the minimum from left half and eliminate it
            ans = min(ans,arr[low])
            low = mid + 1
        # Check if the right half is sorted
        else:
            # Save the minimum from the right half and eliminate it
            ans = min(ans,arr[mid])
            high = mid - 1

    return ans

def findKRotation(arr):
    # Intution is to find the sorted half and get the min from it
    # Then eliminate the sorted half, then check the other half
    # The index of the minimum element is the no of rotated time
    low, high = 0, len(arr)-1
    ans, index = arr[0], 0
    while low<=high:
        mid = (low+high)//2
        # If the search space is already sorted
        if arr[low]<=arr[high]:
            if arr[low]<ans:
                ans = arr[low]
                index = low
            break
        # Check if the left half is sorted
        if arr[low]<=arr[mid]:
            # Save the minimum from left half and eliminate it
            if arr[low]<ans:
                ans = arr[low]
                index = low
            low = mid + 1
        # Check if the right half is sorted
        else:
            # Save the minimum from the right half and eliminate it
            if arr[mid]<ans:
                ans = arr[mid]
                index = mid
            high = mid - 1

    return index

def findUniqueElementBrute(arr):
    n = len(arr)
    if n == 1:
        return arr[0]
    
    for i in range(n):
        if i == 0:
            if arr[i] != arr[i + 1]:
                return arr[i]
        elif i == n - 1:
            if arr[i] != arr[i - 1]:
                return arr[i]
        else:
            if arr[i] != arr[i - 1] and arr[i] != arr[i + 1]:
                return arr[i]
                
    return None
    
def findUniqueElementXOR(arr):
    unique = 0
    for num in arr:
        unique ^= num
    return unique

def findUniqueElementBS(arr):
    # Intution is to find the left and right halves of the unique
    # element. If the element is on right half, eliminate left half.
    # And if the element is on left half, eliminate right half.
    n = len(arr)
    # Write the edge cases and shrink the array by one step 
    if n==1:
        return arr[0]
    if arr[0]!=arr[1]:
        return arr[0]
    if arr[n-1]!=arr[n-2]:
        return arr[n-1]
    
    low, high = 1, n-2
    while low<=high:
        mid = (low+high)//2
        # Check the left and right elements of the mid
        if arr[mid]!=arr[mid-1] and arr[mid]!=arr[mid+1]:
            return arr[mid]
        # Eliminate the left half if unique is on the right
        if (mid%2==0 and arr[mid]==arr[mid+1]) or (mid%2==1 and arr[mid]==arr[mid-1]):
            low = mid + 1
        # Eliminate the right half if unique is on the left
        else:
            high = mid - 1
    
    return -1

def findPeakElementBrute(arr):
    # Brute Force is linear search
    n = len(arr)
    if n==1:
        return 0
    for i in range(n):
        if i==0:
            if arr[i]>arr[i+1]:
                return i
        if i==n-1:
            if arr[i]>arr[i-1]:
                return i
        if arr[i]>arr[i-1] and arr[i]>arr[i+1]:
            return i

    return -1

def findPeakElementBS(arr):
    # Intution is to look at the array in the form of a curve
    # Shrink the array by checking the edge case on either sides
    n = len(arr)
    # Edge cases
    if n==1:
        return 0
    if arr[0]>arr[1]:
        return 0
    if arr[n-1]>arr[n-2]:
        return n-1

    low, high = 1, n-2
    while low<=high:
        mid = (low+high)//2
        # If mid is the peak element
        if arr[mid]>arr[mid-1] and arr[mid]>arr[mid+1]:
            return mid
        # If the mid is on the increasing curve
        elif arr[mid]>arr[mid-1]:
            low = mid + 1
        # If the mid is on the decreasing curve
        else:
            high = mid - 1
        '''# If there are multiple peaks, we can go either way
        else:
            #low = mid + 1 # # either of the conditions work
            high = mid - 1 # either of the conditions work '''

    return -1

def main():
    arr = [7,8,9,1,2,3,4,5,6]
    n = len(arr)
    target = 7
    arr2 = [7,0,1,2,2,3,4,5,6]
    n2 = len(arr2)
    target2 = 0
    arr3 = [3,3,7,7,10,11,11]
    arr4 = [1,2,1,3,5,6,4]
    res = searchRotatedSortedArray(arr,n,target)
    print("The target",target,"is present at the Index: ",res)
    res2 = searchRotatedSortedArrayDuplicates(arr2,n2,target2)
    print("Is the target",target2,"present in the array?: ",res2)
    res3 = minimumElementRotatedSortedArray(arr)
    print("The minimum element in the array is: ",res3)
    res4 = minimumElementRotatedSortedArrayDuplicates(arr2)
    print("The minimum element in the array with duplicates is: ",res4)
    res5 = findKRotation(arr)
    print("The array is rotated",res5,"times")
    res6 = findUniqueElementBrute(arr3)
    print("The unique element using Brute force is: ",res6)
    res7 = findUniqueElementXOR(arr3)
    print("The unique element using XOR is: ",res7)
    res8 = findUniqueElementBS(arr3)
    print("The unique element using Binary Search is: ", res8)
    res9 = findPeakElementBrute(arr4)
    print("The peak element using brute force is: ", res9)
    res10 = findPeakElementBS(arr4)
    print("The peak element using Binary Search is: ",res10)
    
if __name__ == "__main__":
    main()