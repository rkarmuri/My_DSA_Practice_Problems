def lowerBound(arr,n,x): # Smallest index >= target
    low, high = 0, n-1
    ans = n

    while low<=high:
        mid = (low+high)//2
        if arr[mid]>=x: # If the middle num is greater than or equals the target
            ans = mid # Probably the answer or decrement high
            high = mid - 1
        else:
            low = mid + 1

    return ans

def upperBound(arr,n,x): # Smallest index > target
    low, high = 0, n-1
    ans = n

    while low<=high:
        mid = (low+high)//2
        if arr[mid]>x: # Just remove equal sign for upper bound
            ans = mid
            high = mid - 1
        else:
            low = mid + 1

    return ans

def getFloorAndCeil(arr, n, x): # Floor: Largest index <= target, Ceil: LB
    low, high = 0, n-1
    floor, ceil = -1, -1

    while low <= high:
        mid = (low + high) // 2
        
        if arr[mid] == x:
            return arr[mid], arr[mid]
        elif arr[mid] <= x:
            floor = arr[mid]
            low = mid + 1
        else:
            ceil = arr[mid]
            high = mid - 1

    return floor, ceil

def firstLastOccurrence(arr,n,x):
    # First occurrence is found using the lower bound
    lb = lowerBound(arr,n,x)
    
    # Last occurrence is found using the upper bound
    ub = upperBound(arr,n,x)

    # Edge cases: when target is greater than the largest element 
    # or target is not found
    if lb==n or arr[lb]!=x: 
        return [-1,-1]
    
    # Upper bound is greater than the target so we reduce it by 1
    return [lb,ub-1]

# Simply using the binary search algorithm to find first and last occurrences
def firstOccurrence(nums,n,target):
    low, high = 0, n-1
    first = -1

    while low<=high:
        mid = (low+high)//2
        if nums[mid]==target:
            first = mid
            high = mid - 1 # You must check the first half of the list
        elif nums[mid]<target:
            low = mid + 1
        else:
            high = mid - 1
    
    return first

def lastOccurrence(nums,n,target):
    low, high = 0, n-1
    last = -1

    while low<=high:
        mid = (low+high)//2
        if nums[mid]==target:
            last = mid
            low = mid + 1 # You must check the second half of the list
        elif nums[mid]<target:
            low = mid + 1
        else:
            high = mid - 1
    
    return last

# Finding first and last occurrences without using bounds
def searchRange(nums,n, target):
    # Get the first occurrence
    first = firstOccurrence(nums,n,target)
    
    # If the target is not found in the list
    if first==-1:   return [-1,-1]
    
    # Get the last occurrence
    last = lastOccurrence(nums,n,target)
    return [first,last]


def countOccurrences(nums,n,x):
    ans = searchRange(nums,n,x)
    # If there is no occurrence return 0
    if ans[0]==-1: return 0
    return ans[1]-ans[0]+1

def main():
    arr = [13,39,105,117]
    arr2 = [1,2,3,4,8,8,8,11,13]
    n,n2 = len(arr),len(arr2)
    x, x2 = 105,8
    lb = lowerBound(arr,n,x)
    ub = upperBound(arr,n,x)
    fc = getFloorAndCeil(arr,n,x)
    occ = firstLastOccurrence(arr2,n2,x2)
    occ2 = searchRange(arr2,n2,x2)
    cnt = countOccurrences(arr2,n2,x2)
    print("The lower bound is at Index: ", lb)
    print("The upper bound is at Index: ", ub)
    print("The floor and ceil values are: ", fc,"respectively")
    print("The first and last occurrences of the target", x2, "are:",occ)
    print("The first and last occurrences of the target",x2,"without bounds are:",occ2)
    print("The number of occurrences of the target",x2,"is: ",cnt)

if __name__ == "__main__":
    main()