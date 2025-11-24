def merge(arr,low,mid,high):
    left,right = low, mid+1
    tmp = []
    # Compare the left half with the right half
    while left<=mid and right<=high:
        if arr[left]<=arr[right]:
            tmp.append(arr[left])
            left += 1
        else:
            tmp.append(arr[right])
            right += 1
    
    # If the left half has anything leftover add it to the tmp
    while left<=mid:
        tmp.append(arr[left])
        left += 1
    # If the left half has anything leftover add it to the tmp
    while right<=high:
        tmp.append(arr[right])
        right += 1

    # Store all the elements of tmp in the original array
    for i in range(low,high+1):
        arr[i] = tmp[i - low]

    return arr

# The worst case time complexity is: O(N Log N)
# The space complexity is: O(N)

def mergeSort(arr,low,high):
    if low==high:
        return
    
    mid = (low+high)//2
    mergeSort(arr,low,mid) # Divide the first half of array
    mergeSort(arr,mid+1,high) # Divide the second half of array
    merge(arr,low,mid,high) # Merge both the halves

def main():
    arr = [10,9,8,7,6,5,4,3,2,1]
    low,high = 0,len(arr)-1
    mergeSort(arr,low,high)
    print("The merge sorted array is: ",arr)

if __name__ == "__main__":
    main()
