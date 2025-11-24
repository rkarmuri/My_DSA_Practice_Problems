import math

# 1. Count the number of digits of a given number
def countDigits(num):
    cnt = 0
    num  = abs(num)
    while num>0:
        cnt+=1
        num//=10
    return cnt
    
# 2. Reverse a given number
def reverseNum(num):
    rev = 0
    while num>0:
        digit = num%10
        rev = rev*10 + digit
        num //= 10
    return rev
 
# 3. Check if a number is Palindrome
def palindromeNum(num):
    rev = 0
    temp = num
    while temp>0:
        digit = temp%10
        rev = rev*10 + digit
        temp = temp//10
    
    if rev==num:
        print('The number is palindrome',rev)
    else:
        print("Not a palindrome")

# 4. Check if the number is Armstrong   
def armstrongNum(num):
    arm = 0
    temp = num
    while temp>0:
        digit = temp%10
        arm = arm + digit**3
        temp = temp//10
        
    if arm==num:
        print('The number is an armstrong number',arm)
    else:
        print("the number is not an armstrong number")
        
# 5. Print all divisors of a number
def printDivisors(num):
    ans = []
    p = int(math.sqrt(num))
    for i in range(1,p+1):
        if num%i==0:
            print(i,end=' ')
            ans.append(i)
            if num//i!=i:
                print(num//i,end=' ')
                ans.append(num//i)
    print()
    return sorted(ans)
    
# 6. Check if the number is a prime number
def checkPrime(num):
    p = int(math.sqrt(num))
    for i in range(2,p+1):
        if num%i==0:
            return False
    return True

# 7. GCD of 2 numbers
def gcd(num1,num2):
    if num1==0:
        return num2
    elif num2==0:
        return num1
    ans = 1
    p = min(num1,num2)+1
    for i in range(1,p):
        if num1%i==0 and num2%i==0:
            ans = i
    
    return ans

def gcdOptimal(num1,num2):
    if num1==0:
        return num2
    elif num2==0:
        return num1
    return gcdOptimal(num2,num1%num2)

#lcm = (num1 * num2) // math.gcdOptimal(num1, num2)

# 8. Find the power of the number without using default libraries
def expo(x,n):
    m = n
    n = abs(n)
    if n==0:
        return 1
    ans = 1
    while n>0:
        if n%2==1:
            ans *= x
            n -= 1
        x *= x
        n //= 2

    if m<0:
        return 1/ans
    else:
        return ans

# 9. Sieve of Eratosthenes - O(N Log(Log N)) + O(N)
def SOE(n):
    prime = [1]*(n+1)
    prime[0]=prime[1]=0

    p = int(math.sqrt(n))+1
    for i in range(2,p):
        if prime[i]==1:
            for j in range(i*i,n+1,i): # Start with multiple of the same number
                prime[j]=0
    
    ans = []
    for i in range(2,n+1):
        if prime[i]==1:
            ans.append(i)
    
    return ans

# 10. Count the number of Primes between a range of L and R
# We use Sieve of Eratosthenes to find the prime numbers
def countPrimes(L,R):
    primes = SOE(R)
    cnt = 0
    for i in primes:
        if L<=i<=R:
            cnt+=1
    return cnt

# 11. Find prime factors of a given number
def primeFactors(n):
    ans = []
    p = int(math.sqrt(n))
    for i in range(2,p+1):
        if n%i==0:
            if checkPrime(i):   
                ans.append(i)
            if n//i!=i:
                if checkPrime(n//i):    
                    ans.append(n//i)
    return ans

def primeFactorsOptimal(n):
    ans = []
    p = int(math.sqrt(n))
    for i in range(2,p+1):
        if n%i==0:
            ans.append(i)
            while n%i==0:
                n = n//i
    
    if n>1:    ans.append(n)

    return ans

# 12. Find the smallest prime factor of list of numbers
def SPF(n):
    smallest_factors = [0]*(n+1)
    p = int(math.sqrt(n))
    
    for i in range(2,p+1):
        if smallest_factors[i]==0:
            smallest_factors[i]=i
            for j in range(i*i,n+1,i):
                if smallest_factors[j]==0:
                    smallest_factors[j]=i
    
    for i in range(2, n+1):
        if smallest_factors[i] == 0:
            smallest_factors[i] = i                
    return smallest_factors

a = countPrimes(30,90)
print(a)
numbers = [12,15,20,25,30,17,11]
x = max(numbers)
res = SPF(x)
for i in numbers:
    print('Smallest prime factor of',i,'is:',res[i])