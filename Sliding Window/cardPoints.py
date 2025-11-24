def cardPoints(nums,k):
    lsum = rsum = maxSum = 0
    rIndex = len(nums) - 1

    for i in range(k):
        lsum = lsum + nums[i]

    maxSum = lsum

    for i in range(k-1,-1,-1):
        lsum = lsum - nums[i]
        rsum = rsum + nums[rIndex]
        maxSum = max(maxSum, lsum + rsum)

        rIndex = rIndex - 1

    return maxSum

cards = [6,2,3,4,7,2,1,7,1]
k = 4
res = cardPoints(cards, k)
print("The maximum number of points that can be obtained is: ", res)