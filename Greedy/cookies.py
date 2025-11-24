def findContentChildren(g,s):
    n, m = len(g), len(s)
    left, right = 0, 0
    # Sort both the lists
    g.sort()
    s.sort()
    # Compare both the lists based on the condition
    while left<n and right<m:
        if g[left]<=s[right]:
            left += 1

        right += 1

    return left

def main():
    g = [1,2] 
    s = [1,2,3]
    res = findContentChildren(g,s)
    print("No of content children is: ", res)


if __name__ == "__main__":
    main()