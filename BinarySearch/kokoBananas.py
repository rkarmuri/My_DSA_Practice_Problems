import math
def kokoBananas(piles,h):
    # Intution is to find the maximum element of the array
    # And the range is b/n 1->max(arr). Apply binary search
    # and the result is when the low reaches the pivot point
    low, high = 1,max(piles)
    ans = 1
    while low<=high:
        mid = (low+high)//2
        # Find time to eat each pile
        totalhours = getHours(piles,mid)
        # If the total hours accepts the mid value
        if totalhours<=h:
            res = mid # Possible value but you still go left
            high = mid - 1 # Eliminate the right half
        # If the total hours is less than the target
        else:
            low = mid + 1 # Eliminate the left half
    
    return res # can be 'low' as it is the pivot

def getHours(piles,bananasperhour):
    totalhrs = 0
    # Pass across the piles and calculate time to eat each pile
    for i in range(len(piles)):
        totalhrs += math.ceil(piles[i] / bananasperhour)
    return totalhrs


def main():
    piles = [30,11,23,4,20]
    h = 5
    res = kokoBananas(piles,h)
    print("The minimum hours to eat the bananas are: ",res)


if __name__ == "__main__":
    main()