# Problem 1: Find the maximum element of array 
# Brute force is by sorting the arrays 
def maxOfArrayBruteForce(arr):
    arr.sort()
    print(arr[len(arr)-1])

    # Time complexity: O(Nlog N) - time taken for sorting
    # Space complextiy: O(N)

# Optimal solution is using a variable to store maximum value
def maxOfArrayOptimal(arr):
    maxi = arr[0]

    for i in range(len(arr)):
        if arr[i]>maxi:
            maxi = max(maxi,arr[i])

    print(maxi)

    # Time complexity: O(N) Space Complexity: O(1)


arr = [5,3,4,13,12,22,4,2,2,16,32,9]

#maxOfArrayBruteForce(arr)
#maxOfArrayOptimal(arr)

# Problem 2: Check if the array is sorted or not
# Brute Force is to traverse through the array and check with each element with all others
def checkSortedArrayBrute(arr):
    for i in range(len(arr)):
        for j in range(i+1,len(arr)):
            if arr[j]>=arr[i]: return False

    return True

# Optimal solution is traversing only once and check each element with next element
def checkSortedArrayOptimal(arr):
    for i in range(1,len(arr)):
        if arr[i]<=arr[i-1]: return False
    return True

#checkSortedArrayBrute(arr)
#checkSortedArrayOptimal(arr)

# Problem 3: Find 2nd largest and 2nd smallest elements in an array
# Brute Force is to sort the array and return the 2nd and last 2nd elements of the array
# but this approach doesn't work if there are any duplicates
def secondSmallLargeBrute(arr):
    arr.sort()
    print("Second smallest number is", arr[1])
    print("Second Largest number is", arr[len(arr)-2])

# Better approach is to traverse through array and store the smallest and larget array
# then we traverse again to compare the smallest and largest elements and find numbers that are
# just below and above them
def secondSmallLargeBetter(arr):
    small,large = float('inf'),float('-inf')
    secondSmall,secondLarge = float('inf'),float('-inf')

    for i in range(len(arr)):
        small = min(arr[i],small)
        large = max(arr[i],large)

    for i in range(len(arr)):
        if arr[i]<secondSmall and arr[i]!=small:
            secondSmall = arr[i]
        if arr[i]>secondLarge and arr[i]!=large:
            secondLarge = arr[i]

    print("Second smallest number is", secondSmall)
    print("Second larget number is", secondLarge)

#secondSmallLargeBrute(arr)
#secondSmallLargeBetter(arr)

# Problem 4: Linear Search
def findElement(arr,num):
    for i in range(len(arr)):
        if arr[i]==num:
            print("Index of the element is",i)
    print(-1)

#findElement(arr,13)

# Problem 5: Left Rotate the Array by One
# Brute force is to store all elements in a dummy array
def leftRotateBrute(arr):
    temp =[0]*(len(arr))
    for i in range(1,len(arr)):
        temp[i-1]=arr[i]
    temp[len(arr)-1]=arr[0]
    print(temp)

# Optimal solution is to store the 1st element of array in a temp variable
def leftRotateOptimal(arr):
    temp = arr[0]
    for i in range(1,len(arr)):
        arr[i-1]=arr[i]
    arr[len(arr)-1]=temp
    print(arr)

#leftRotateBrute(arr)
#leftRotateOptimal(arr)

# Problem 6: Maximum consectuive ones
# Problem Statement: Given an array that contains only 1 and 0 return 
# the count of maximum consecutive ones in the array.
def maxConsecOne(arr):
    count,maxi = 0,0
    for i in range(len(arr)):
        if arr[i]==1:
            count += 1
        else:   count = 0
        maxi = max(maxi,count)

    print('Maximum number of 1s are', maxi)

arr2 = [0,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1]
#maxConsecOne(arr2)

# Problem 7: Move all zeroes to the end of array
def moveZeroEndBrute(arr):
    temp = []
    for i in range(len(arr)):
        if arr[i]!=0:
            temp.append(arr[i])

    nz = len(temp)
    for i in range(nz):
        arr[i]=temp[i]

    for i in range(nz,len(arr)):
        arr[i]=0
        
    print(arr)

def moveZeroEndOptimal(arr):
    slow = 0
    for fast in range(len(arr)):
        if arr[fast]!=0:
            arr[slow],arr[fast]=arr[fast],arr[slow]
            slow += 1
    print(arr)

#moveZeroEndBrute(arr2)
#moveZeroEndOptimal(arr2)
# Problem 8: Rotate array by K elements
def rotateArray(arr,k,l):
    k = k % len(arr)

    if l=='right':
        arr.reverse()
        arr[:k] = reversed(arr[:k])
        arr[k:] = reversed(arr[k:])
        print(arr)
    elif l=='left':
        arr[:k] = reversed(arr[:k])
        arr[k:] = reversed(arr[k:])
        arr.reverse()
        print(arr)

#rotateArray(arr,2,'left')

# Problem 9: Remove Duplicates in-place from Sorted Array
def removeDuplicatesSet(arr):
    st = set()

    for i in range(len(arr)):
        st.add(arr[i])

    k = len(st)
    print(k)

    j = 0
    for i in st:
        arr[j] = i
        j += 1
    print(arr)

def removeDuplicatesTwoPointers(arr):
    i=0

    for j in range(1,len(arr)):
        if arr[j]!=arr[i]:
            i = i + 1
            arr[i]=arr[j]

    print(i+1)

arr3 = [1,1,1,2,2,2,2,3,3,3,4,4,4,5,5,6,6]
#removeDuplicatesSet(arr3)
#removeDuplicatesTwoPointers(arr3)

# Problem 10: Find the missing number in an array
def missingNumberBrute(arr):
    for i in range(len(arr)):
        flag = 0
        for j in range(len(arr)):
            if arr[j]==i:
                flag=1
                break

        if flag==0:
            print(i)

def missingNumberHash(arr):
    hashed = [0]*(len(arr)+1)

    for i in range(len(arr)-1):
        hashed[arr[i]] += 1

    for i in range(len(arr)):
        if hashed[arr[i]]==0:
            print(i)

def missingNumberSummation(arr):
    n = len(arr)
    summation = (n*(n+1))//2
    print(summation-sum(arr))

def missingNumberXOR(arr):
    xor1,xor2 = 0,0
    n = len(arr)-1

    for i in range(n):
        xor1 ^= i
        xor2 ^= arr[i]

    print(xor1^xor2)

arr4 = [3,0,1]
#missingNumberBrute(arr4)
#missingNumberHash(arr4)
#missingNumberSummation(arr4)
#missingNumberXOR(arr4)

# Problem 11: Find the number that appears once, and the other numbers twice
def uniqueNumberBrute(arr):
    for i in range(len(arr)):
        count = 0
        for j in range(len(arr)):
            if arr[j]==arr[i]:
                count += 1

        if count==1:
            print(arr[i])

def uniqueNumberHash(arr):
    hashed = [0]*len(arr)

    for i in arr:
        hashed[i]+=1
        #print(hashed[i])
    
    for i in arr:
        if hashed[i]==1:
            print(i)

def uniqueNumberDict(arr):
    dict = {}

    for num in arr:
        dict[num] = dict.get(num,0) + 1

    for num,count in dict.items():
        if count==1:
            print(num)

def uniqueNumberXOR(arr):
    xor = 0
    for i in range(len(arr)):
        xor = xor ^ arr[i]

    print(xor)

arr5 = [4,2,2,1,1]
#uniqueNumberBrute(arr5)
#uniqueNumberHash(arr5)
#uniqueNumberDict(arr5)
#uniqueNumberXOR(arr5)

# Problem 12: Union of Two Sorted Arrays
def unionArraysSet(a,b):
    st = set()
    res= []

    for i in a:
        st.add(i)

    for j in b:
        st.add(j)

    for i in st:
        res.append(i)

    print(res)

def unionArrayTwoPointers(a,b):
    m,n=len(a),len(b)
    i,j=0,0
    res=[]

    while i<m and j<n:
        if a[i]<=b[j]:
            if len(res)==0 or res[-1]!=a[i]:    res.append(a[i])
            i += 1
        else:
            if len(res)==0 or res[-1]!=b[j]:    res.append(b[j])
            j += 1

    while i<m:
        if res[-1]!=a[i]:   res.append(a[i])
        i += 1

    while j<n:
        if res[-1]!=b[j]:   res.append(b[j])
        j += 1

    print(res)

def intersectionArrays(a,b):
    '''res=[]
    for i in a:
        if i in b and i not in res:
            res.append(i)
    '''
    res = [value for value in a if value in b]

    print(res) 

a = [1,2,3,4,5,6,7]
b = [2,3,4,4,5,7]
#unionArraysSet(a,b)
#unionArrayTwoPointers(a,b)
#intersectionArrays(a,b)

# Problem 13: Two Sum
def twoSumBrute(a,target):
    res = []
    for i in range(len(a)):
        for j in range(i+1,len(a)):
            if i==j: continue
            if a[i]+a[j]==target:
                res.append(i)
                res.append(j)
    print(res)
def twoSumDict(a,target):
    dict={}
    res=[]

    for i in range(len(a)):
        diff = target - a[i]
        if diff in dict:
            res.append(i)
        else:
            dict[a[i]]=i
    
    print(res)
def twoSumTwoPointers(a,target):
    a.sort()
    left,right = 0,len(a)-1
    res=[]
    while left<right:
        diff = a[left]+a[right]
        if diff==target:    
            res.append(left)
            res.append(right)
            break
        elif diff<target: left +=1
        else: right -= 1
    print(res)

arr6=[4,1,2,3,1]
target = 5
#twoSumBrute(arr6,target)
#twoSumDict(arr6,target)
#twoSumTwoPointers(arr6,target)

# Problem 14: Search in a sorted 2D matrix

def searchMatrixBrute(a,target):
    m = len(a)
    n = len(a[0])
    for i in range(m):
        for j in range(n):
            if a[i][j]==target:
                print('True')
                print('The location is', i,j)

# Intution is to treat it like a 1D as the matrix is already sorted
# Now we use binary search from 0th position to last row last column element
def searchMatrixBinary(a,target):
    m,n=len(a),len(a[0])
    low = 0
    high = (n*m)-1
    if not a: print("False")
    while low<=high:
        mid = (low+(high-low))//2
        row = mid//n # Rows will multiples of n
        col = mid%n # Columns will be modulus of n
        # example: (1,1) here is row=5/4, col=5%4 and (2,3) is row=11/4, col=11%4
        if a[row][col]==target:  print('True')
        elif a[row][col]<target: low=mid+1
        else:   high=mid-1

    print('False')

def searchMatrixBinary2(a,target):
    if not a:   return False
    m,n = len(a),len(a[0])
    row,col = 0,n-1

    while row<m and col>=0:
        if a[row][col]==target: return True
        elif a[row][col]>target: col -= 1
        else:   row+=1

    return False

matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
matrixTarget = 16
#searchMatrixBrute(matrix,matrixTarget)
#searchMatrixBinary(matrix,matrixTarget)
#searchMatrixBinary2(matrix,matrixTarget)


# Problem 14: Leaders in an Array
def leaderArrayBrute(a):
    res=[]
    for i in range(len(a)):
        leader = True
        for j in range(i+1,len(a)):
            if a[j]>a[i]:   
                leader = False
                break
        if leader:
            res.append(a[i])
    print(res)
def leaderArrayOptimal(a):
    res=[]
    end = len(a)-1
    max_ele = a[end]

    res.append(a[end])
    for i in range(end-1,-1,-1):
        if a[i]>max_ele:    
            res.append(a[i])
            max_ele = a[i]

    print(res)

leadarr = [4,7,1,0]
#leaderArrayBrute(leadarr)
#leaderArrayOptimal(leadarr)

# Problem 15: Spiral Traversal of Matrix
# Intution is right->bottom->left->top
def spiralMatrix(a):
    rows,cols=len(a),len(a[0])
    left,right =0, cols-1
    top, bottom = 0, rows-1
    res = []

    while left<=right and top<=bottom: # Until no more rows and cols left in between
        # First we move from left to right
        for i in range(left,right+1):
            res.append(a[top][i]) # Top row is constant
        top = top + 1

        # Next we move from top to bottom
        for i in range(top,bottom+1):
            res.append(a[i][right]) # Right column is constant
        right = right - 1

        # Check if there is neither a row nor a column exists in between
        if not (left<right and top<bottom):
            break

        # Next we move from right to left
        for i in range(right,left-1,-1):
            res.append(a[bottom][i]) # bottom row is constant
        bottom = bottom - 1
        

        # Next we move from bottom to top
        for i in range(bottom,top-1,-1):
            res.append(a[i][left]) # left column is constant
        left = left + 1
    
    print(res)

#spiralMatrix(matrix)

# Problem 16: Rotate Image by 90 degree
def rotateMatrix90(a):
    rows = len(a)

    # Transpose the matrix, i.e., make columns rows and viceversa
    for i in range(rows):
        for j in range(i):
            a[i][j],a[j][i]=a[j][i],a[i][j]

    # Reverse the rows
    for i in range(rows):
        a[i].reverse()

    print(a)
#rotateMatrix90(matrix)

# Problem 17: Buy and sell stock I
def StockBrute(a):
    maxProfit = 0
    for i in range(len(a)):
        for j in range(1,len(a)):
            if a[j]>a[i]:
                maxProfit = max(maxProfit,a[j]-a[i])

    print(maxProfit)

def StockOptimal(a):
    profit = 0
    mini = a[0]
    for i in range(len(a)):
        profit = max(profit,a[i]-mini)
        mini = min(mini,a[i])

    print(profit)

stock = [7,1,5,3,6,4]

#StockBrute(stock)
#StockOptimal(stock)

# Problem 18: Rearrange Array Elements by Sign - Vareity 1 (if signs are equal)
def rearrangeArrayBrute(a):
    pos,neg = [],[]
    for i in a:
        if i>0: pos.append(i)
        else:   neg.append(i)

    for i in range(len(pos)):
        a[2*i] = pos[i]
    for i in range(len(neg)):
        a[2*i+1] = neg[i]

    print(a)

def rearrangeArrayOptimal(a):
    n=len(a)
    res=[0]*n
    posIndex,negIndex=0,1
    
    for i in range(n):
        if a[i]>0:
            res[posIndex]=a[i]
            posIndex += 2
        else:   
            res[negIndex]=a[i]
            negIndex += 2

    print(res)

# If signs are not equal
def rearrangeArray(a):
    pos,neg = [],[]

    for i in a:
        if i>0: pos.append(i)
        else: neg.append(i)

    if len(pos)>len(neg):
        for i in range(len(neg)):
            a[2*i] = pos[i]
            a[2*i+1] = neg[i]

        index = len(neg)*2 # as both equal no of pos and neg are filled in Array
        for i in range(len(pos)-len(neg)):
            a[index] = pos[len(neg)+i]
            index += 1

    elif len(pos)<len(neg):
        for i in range(len(pos)):
            a[2*i] = pos[i]
            a[2*i+1] = neg[i]

        index = len(pos)*2
        for i in range(len(neg)-len(pos)):
            a[index] = neg[len(pos)+i]
            index += 1

    print(a)


consecarr = [3,1,2,-2,-5,-4]
consecarr2 = [3,1,2,4,5,-3,-2]
#rearrangeArrayBrute(consecarr)
#rearrangeArrayOptimal(consecarr)
#rearrangeArray(consecarr2)

# Problem 19: Find the duplicate in an array of N+1 integers
# Regular methods include Brute force, Count variable, Hashing, Sorting, Binary Search. 
def duplicateArray(a):
    slow,fast = a[0],a[0]

    # If slow and fast meet then there is a cycle
    while True:
        slow = a[slow]
        fast = a[a[fast]]
        if slow==fast:  break
    
    fast = a[0]
    # Now we move slow and fast both by only one, if they meet at a point then it is a duplicate
    while slow!=fast:
        slow = a[slow]
        fast = a[fast]
    
    print(slow)

duparr = [1,3,4,2,4]
#duplicateArray(duparr)

# Problem 20: Find the maximum sum of subarray from the given array (Kadane's algorithm)
def maxsumSubarrayBrute(a):
    maxi = float('-inf')

    for i in range(len(a)):
        for j in range(i,len(a)):
            summation = 0
            for k in range(i,j+1):
                summation = summation + a[k]

            maxi = max(maxi,summation)

    print(maxi)

def maxsumSubarrayBetter(a):
    maxi = float('-inf')
    start,end =0,0
    for i in range(len(a)):
        summ = 0
        for j in range(i,len(a)):
            summ = summ + a[j]
            if summ>maxi:
                maxi=summ
                start = i
                end = j
    print(maxi)
    print(a[start:end])

def kadaneAlgorithm(a):
    maxSub = 0
    curSum = 0
    start,end=0,0
    for i in range(len(a)):
        if curSum==0: start = i
        curSum = curSum + a[i]
        if curSum>maxSub:
            maxSub = curSum
            start = start
            end = i
        if curSum<0:
            curSum = 0
    
    print(maxSub)
    print(a[start:end+1])

kadanearr = [-2,1,-3,4,-1,2,1,-5,4]
#maxsumSubarrayBrute(kadanearr)
#maxsumSubarrayBetter(kadanearr)
#kadaneAlgorithm(kadanearr)

# Problem 21: Grid Unique Paths | Count paths from left-top to the right bottom of a matrix
def uniquePathsBrute(i,j,m,n):
    if i>=n or j>=m:    return 0
    if i==n-1 and j==m-1:   return 1
    else:
        return uniquePathsBrute(i+1,j,m,n) + uniquePathsBrute(i,j+1,m,n)

def uniquePathsDP(m,n):
    dp = [[-1 for _ in range(n+1)]for _ in range(m+1)]

    def countPaths(i,j,m,n,dp):
        if i==(m-1) and j==(n-1):    return 1
        if i>=m or j>=n:    return 0
        if dp[i][j]!=-1:    return dp[i][j]
        else:   
            dp[i][j] = countPaths(i+1,j,m,n,dp) + countPaths(i,j+1,m,n,dp)
            return dp[i][j]
        
    num = countPaths(0,0,m,n,dp)
    if m==1 and n==1:   return num
    return dp[0][0]

def uniquePathsComb(m,n):
    N = m+n-2 # (m-1)+(n-1) total possible paths down and right
    r = n-1 # or m-1 as 3C1==3C2
    res = 1
    for i in range(1,r+1):
        res*=(N-r+i)/i # 10C3 is 8x9x10/3x2x1 => 10/1 x 9/2 x 8/3
    return int(res)

ui,uj,um,un=0,0,3,3
#uniqueSol = uniquePathsBrute(ui,uj,um,un)
#uniqueSol = uniquePathsDP(um,un)
#uniqueSol = uniquePathsComb(um,un)
#print(uniqueSol)

# Problem 22: Sort an array of 0s, 1s and 2s(Dutch National Flag problem)
def sort012(arr):
    cnt0,cnt1,cnt2=0,0,0

    for i in arr:
        if i==0:    cnt0+=1
        elif i==1:  cnt1+=1
        elif i==2:  cnt2+=1

    for i in range(cnt0):
        arr[i]=0
    
    for i in range(cnt0,cnt0+cnt1):
        arr[i]=1
    
    for i in range(cnt1+cnt0,len(arr)):
        arr[i]=2

    return arr

def dutchflag(arr):
    low,mid,high = 0,0,len(arr)-1

    while mid<=high:
        if arr[mid]==0:
            arr[low],arr[mid]=arr[mid],arr[low]
            low +=1
            mid += 1
        elif arr[mid]==1: mid+=1
        elif arr[mid]==2:
            arr[high],arr[mid]=arr[mid],arr[high]
            high -= 1

    return arr

sort012arr=[2,0,2,1,2,1,0]
#res_sort012 = sort012(sort012arr)
#res_sort012 = dutchflag(sort012arr)
#print(res_sort012)    

# Problem 23: Roman to Integer
def RomansToInteger(s):
    romans = {'I':1,'V':5,'X':10,'L':50,'C':100,'D':500,'M':1000}
    result = 0

    for i in range(len(s)):
        if i<len(s)-1 and romans[s[i]]<romans[s[i+1]]:
            result -= romans[s[i]]
        else:
            result += romans[s[i]]

    print(result)

#RomansToInteger('LVIII')







