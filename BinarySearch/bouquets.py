def minDays(arr,m,k):
    # Low is the minimum and high is the maximum of the array
    low, high = min(arr), max(arr)
    ans = -1

    # Edge case is if the expected bouquets > size of array
    if m*k>len(arr):
        return -1

    while low<=high:
        mid = (low+high)//2
        # Check if there is are possible blooms to make the bouquet
        if possibleBouquet(arr,mid,m,k):
            ans = mid
            high = mid - 1
        else:
            low = mid + 1

    return ans

def possibleBouquet(arr,day,m,k):
        n = len(arr)  # size of the array
        cnt = 0
        noOfB = 0
        # count the number of bouquets
        for i in range(n):
            if arr[i] <= day: # Check if the flower blooms
                cnt += 1 # Increase the count when the flower blooms
            else:
                noOfB += cnt // k # Add the bouquet based on the count
                cnt = 0 
        noOfB += cnt // k # Add left over blooms if any
        return noOfB >= m # Check if blooms equals bouquets


def main():
    bloomDay = [1,10,3,10,2]
    m = 3
    k = 1
    res = minDays(bloomDay,m,k)
    print("The minimum no of days needed to make",m,"bouquets: ",res)

if __name__ == "__main__":
    main()

    