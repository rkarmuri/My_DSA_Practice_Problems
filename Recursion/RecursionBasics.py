# Print numbers 1 to N using Recursion
def recursion1(i,n):
    if i>n:
        return
    print(i,end=' ')
    return recursion1(i+1,n)

# Print a name 1 to N using Recursion
def recursion2(i,n):
    if i>n:
        return
    print('Jerry',end=' ')
    return recursion2(i+1,n)
    
# Print numbers N to 1 using Recursion
def recursion3(i,n):
    if i>n:
        return
    print(n,end=' ')
    return recursion3(i,n-1)

# Print numbers 1 to N using Backtracking
def recursion5(i,n):
    if i<1:
        return
    recursion5(i-1,n)
    print(i,end=' ')
    
# Print numbers N to 1 using Backtracking
def recursion6(i,n):
    if i>n:
        return
    recursion6(i+1,n)
    print(i,end=' ')

# Print sum of n numbers using recursion functional method
def recursion4(n):
    if n==0:
        return 0
    return n+recursion4(n-1)
# Parameterized method
def recursion4b(i,summ):
    if i<1:
        print(summ)
        return
    return recursion4b(i-1,summ+i)

# Print factorial of n numbers using recursion functional method
def recursion5(n):
    if n==0:
        return 1
    return n*recursion5(n-1)
# Parameterized method
def recursion5b(n,prod):
    if n<1:
        print(prod)
        return
    return recursion5b(n-1,prod*n)

# Reverse an array using recursion with one pointer method
def reverseArray(i,arr,n):
    if(i>=n//2):    return
    arr[i],arr[n-i-1]=arr[n-i-1],arr[i]
    reverseArray(i+1,arr,n)

# Reversing array recursivley using two pointers
def reverseArray2(l,r,arr):
    if l>=r:    return
    arr[l],arr[r]=arr[r],arr[l]
    reverseArray2(l+1,r-1,arr)
    
arr = [1,2,3,4,5]
reverseArray2(0,4,arr)
print('Reverse of the array is: ',end='')
for i in arr:   print(i,end=' ')
print()

# Check if a string is Palindrome using recursion
def palindrome(i,s,n):
    if i>=n//2:    return True
    if s[i]!=s[n-i-1]:  return False
    return palindrome(i+1,s,n)
    
s = 'MADAM'
n = len(s)
print("The given string is Palindrome: ",palindrome(0,s,n))

# Find the fibonacci of a number using recursion
def fibonacci(n):
    if n<=1:    return n
    last,slast=fibonacci(n-1),fibonacci(n-2)
    return last+slast

n = 10
print("Fibonacci number of the first",n,"numbers is:",fibonacci(n))
