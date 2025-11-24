def sqrtBrute(n):
    ans = 1
    for i in range(1,n):
        if i*i<=n:
            ans = i
        else:
            break # As we know numbers beyond half cannot be sqaure roots
    
    return ans
    
def sqrtBS(n):
    low, high = 1, n
    ans = 1
    while low<=high:
        mid = (low+high)//2
        val = mid*mid
        # Check if the mid value is <= n
        if val<=n:
            ans = mid # Possible value, eliminate left no's
            low = mid + 1
        # Eliminate right no's as mid is greater than the no 
        else:
            high = mid - 1
    
    return ans # Can return either ans or high

def nthRootBrute(n,m):
    for i in range(1,m):
        root = powerFunction(i,n)
        if root==m:
            return i
        elif root>m:
            break
    return -1

def nthRootBS(n,m):
    low, high = 1, m
    while low<=high:
        mid = (low+high)//2
        root = powerFunction2(mid,n,m) 
        # Check if the mid is equal to the target
        if root==1:
            return mid
        # If the root is less than target, eliminate the left half
        elif root==0:
            low = mid + 1
        # If the root is greater than target, eliminate the right half
        else:
            high = mid - 1
    
    return -1 # If there is no root found

def powerFunction(x,n):
    if n==0:
        return 1
    ans = 1
    while n>0:
        if n%2==1:
            ans *= x
            n -= 1
        x *= x
        n //= 2

    return ans

# To handle overflow of the nth root
def powerFunction2(mid,n,m):
    ans = 1
    # Multiply the mid raised to the power n times
    for _ in range(1,n+1):
        ans = ans * mid
        # If the power result of mid exceeds the m, stop going beyond
        if ans>m:
            return 2
    if ans==m:
        return 1
    return 0

    
def main():
    n = 345
    res = sqrtBrute(n)
    res2 = sqrtBS(n)
    print("Square root of the number using Brute Force",n,"is: ",res)
    print("Square root of the number using Binary Search",n,"is: ",res2)
    p, q = 4, 16
    res3 = nthRootBrute(p,q)
    res4 = nthRootBS(p,q)
    print("The",p,"root of number",q,"using Brute Force is: ",res3)
    print("The",p,"root of number",q,"using Binary Search is: ",res4)

if __name__=="__main__":
    main()