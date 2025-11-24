# Dynamic Programming 
# Problem 1: Fibonnaci series - Memoization(top-down approach i.e., divide main problem to base cases)
def fibMemo(n,dp):
    if n<=1:    return n
    if dp[n]!=-1:
        return dp[n]
    dp[n] = fibMemo(n-1,dp) + fibMemo(n-2,dp)
    return dp[n]

'''if __name__ == "__main__":
    n=6
    dp = [-1] * (n+1)
    print(fibMemo(n,dp))'''

# Fibonacci series - Tabulation(bottom-up approach i.e., take base cases and add upto main problem)
def fibTab():
    n=6
    dp =[-1]*(n+1)
    dp[0]=0
    dp[1]=1

    for i in range(2,len(dp)):
        dp[i]=dp[i-1]+dp[i-2]

    print(dp[n])

'''if __name__=="__main__":
    fibTab()'''

# Fibonacci series - Space Optimization (No use of array)
def fibOptimal():
    n=6
    MOD = sys.maxsize
    prev,prev2 = 1,0
    
    for i in range(2,n+1):
        cur = (prev + prev2)%MOD
        prev2 = prev
        prev = cur

    print(prev)

'''if __name__=="__main__":
    fibOptimal()'''

# Problem 2: Dynamic Programming : Frog Jump (DP 3)
# Intution is to jump from n-1 to 0 by a single jump or double jump
import sys
def frogMemoization(index,dp,height):
    if index == 0: return 0
    if dp[index]!=-1:   return dp[index]
    jumpTwo = sys.maxsize # if index is 1 then we cannot take 2 jumps backwards, so we take MAXSIZE
    jumpOne = frogMemoization(index-1,dp,height)+abs(height[index]-height[index-1]) # Energy between i to i-1
    if index>1:
        jumpTwo = frogMemoization(index-2,dp,height)+abs(height[index]-height[index-2])

    dp[index] = min(jumpOne,jumpTwo)
    return dp[index]
'''
if __name__=="__main__":
    height = [30,10,60,10,60,50]
    n = len(height)
    dp=[-1]*(n)
    print(frogMemoization(n-1,dp,height))'''

def frogTabulation():
    height = [30,10,60,10,60,50]
    dp=[-1 for _ in range(len(height))]
    dp[0]=0
    for i in range(1,len(height)):
        jumpTwo = sys.maxsize
        jumpOne = dp[i-1]+abs(height[i]-height[i-1])
        if i>1: jumpTwo = dp[i-2]+abs(height[i]-height[i-2])

        dp[i]= min(jumpOne,jumpTwo)

    print(dp[n-1])
'''
if __name__=="__main__":
    frogTabulation()'''

def frogOptimal():
    height = [30,10,60,10,60,50]
    prev,prev2 = 0,0

    for i in range(1,len(height)):
        jumpTwo = float('inf')
        jumpOne = prev + abs(height[i]-height[i-1])
        if i>1: jumpTwo = prev2 + abs(height[i]-height[i-2])
        cur = min(jumpOne,jumpTwo)
        prev2 = prev
        prev = cur

    print(prev)
    
'''
if __name__=="__main__":
    frogOptimal()'''

    



