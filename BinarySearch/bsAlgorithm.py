def binarySearch(arr,n,target):
    low, high = 0, n
    while low<=high: # Search space must be between low and high
        mid = (low+high)//2
        if arr[mid]==target:    return mid
        elif target>arr[mid]:   low = mid+1
        else:   high = mid - 1
    
    return -1

def binarySearchRecursive(arr,low,high,target):
    if low>high: return -1 # Search space must be between low and high
    mid = (low+high)//2
    if arr[mid]==target:    return mid
    elif target>arr[mid]:   return binarySearchRecursive(arr,mid+1,high,target)
    return binarySearchRecursive(arr,low,mid-1,target)

def main():
    arr = [3,4,6,7,9,12,16,17]
    n = len(arr)-1
    target = 7
    res = binarySearch(arr,n,target)
    res2 = binarySearchRecursive(arr,0,n,target)
    print("Did you find the target using iteration? ", res)
    print("Did you find the target using recursion? ", res2)
    

if __name__ == "__main__":
    main()
