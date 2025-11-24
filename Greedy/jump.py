def canJump(nums):
    maxIndex = 0

    for i in range(len(nums)):
        # Check if i crosses the max index
        if i>maxIndex:
            return False
        print(f"i: {i}, maxIndex: {maxIndex}")
        # max index is the sum of current index and number
        maxIndex = max(maxIndex, i + nums[i]) 

    return True


def main():
    bt = [3,2,1,0,4]
    res = canJump(bt)
    print("Jump is possible? ",res)


if __name__ =="__main__":
    main()