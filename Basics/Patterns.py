def pattern1(n):
    print('Pattern 1')
    print('--------------------')
    for i in range(1,n+1):
        for j in range(1,n+1):
            print('*',end='')
        print()
        
def pattern2(n):
    print('Pattern 2')
    print('--------------------')
    for i in range(1,n+1):
        print('*'*i)
        
def pattern3(n):
    print('Pattern 3')
    print('--------------------')
    for i in range(1,n+1):
        for j in range(i):
            print(j+1,end='')
        print()
        
def pattern4(n):
    print('Pattern 4')
    print('--------------------')
    for i in range(1,n+1):
        for j in range(i):
            print(i,end='')
        print()
        
def pattern5(n):
    print('Pattern 5')
    print('--------------------')
    for i in range(1,n+1):
        for j in range(n-i+1):
            print('*',end='')
        print()
        
def pattern6(n):
    print('Pattern 6')
    print('--------------------')
    for i in range(1,n+1):
        for j in range(1,n-i+2):
            print(j,end='')
        print()
        
def pattern7(n):
    print('Pattern 7')
    print('--------------------')
    for i in range(1,n+1):
        for j in range(n-i):
            print(' ',end='')
        for j in range(2*i-1):
            print('*',end='')
        for j in range(n-i):
            print(' ',end='')
        print()
        
def pattern8(n):
    print('Pattern 8')
    print('--------------------')
    for i in range(1,n+1):
        for j in range(i-1):
            print(' ',end='')
        for j in range(2*(n-i)+1):
            print('*',end='')
        for j in range(i-1):
            print(' ',end='')
        print()
        
def pattern9(n):
    print('Pattern 9')
    print('--------------------')
    for i in range(1,n+1):
        for j in range(n-i):
            print(' ',end='')
        for j in range(2*i-1):
            print('*',end='')
        for j in range(n-i):
            print(' ',end='')
        print()
        
    for i in range(1,n+1):
        for j in range(i-1):
            print(' ',end='')
        for j in range(2*(n-i)+1):
            print('*',end='')
        for j in range(i-1):
            print(' ',end='')
        print()
        
def pattern10(n):
    print('Pattern 10')
    print('--------------------')
    for i in range(1,n+1):
        print('*'*i)
    for i in range(1,n):
        for j in range(n-i):
            print('*',end='')
        print()
        
def pattern11(n):
    print('Pattern 11')
    print('--------------------')
    for i in range(1,n+1):
        start = 1
        if i%2==0:
            start = 0
        for j in range(i):
            print(start,end=' ')
            start = 1 - start
        print()
        
def pattern12(n):
    print('Pattern 12')
    print('--------------------')
    for i in range(1,n+1):
        for j in range(i):
            print(j+1,end='')
        for j in range(2*(n-i)):
            print(' ',end='')
        for j in range(i,0,-1):
            print(j,end='')
        print()
        
def pattern13(n):
    print('Pattern 13')
    print('--------------------')
    num = 1
    for i in range(1,n+1):
        for j in range(i):
            print(num,end=' ')
            num = num + 1
        print()
        
def pattern14(n):
    print('Pattern 14')
    print('--------------------')
    letter = 'A'
    for i in range(1,n+1):
        for j in range(i):
            print(chr(ord(letter)+j),end='')
        print()
    
def pattern15(n):
    print('Pattern 15')
    print('--------------------')
    letter = 'A'
    for i in range(1,n+1):
        for j in range(n-i+1):
            print(chr(ord(letter)+j),end='')
        print()

def pattern16(n):
    print('Pattern 16')
    print('--------------------')
    letter = 'A'
    for i in range(1,n+1):
        for j in range(i):
            print(chr(ord(letter)+i-1),end='')
        print()
        
def pattern17(n):
    print('Pattern 17')
    print('--------------------')
    letter = 'A'
    for i in range(1,n+1):
        for j in range(n-i):
            print(' ',end='')
        for j in range(i):
            print(chr(ord(letter)+j),end='')
        for j in range(i-1):
            print(chr(ord(letter)+i-j-2),end='')
        print()
        
def pattern18(n):
    print('Pattern 18')
    print('--------------------')
    letter = 'E'
    for i in range(1,n+1):
        for j in range(i):
            print(chr(ord(letter)-i+j+1),end=' ')
        print()
        
def pattern19(n):
    print('Pattern 19')
    print('--------------------')
    for i in range(1,n+1):
        for j in range(n-i+1):
            print('*',end='')
        for j in range(2*(i-1)):
            print(' ',end='')
        for j in range(n-i+1):
            print('*',end='')
        print()
        
    for i in range(1,n+1):
        for j in range(i):
            print('*',end='')
        for j in range(2*(n-i)):
            print(' ',end='')
        for j in range(i):
            print('*',end='')
        print()
        
def pattern20(n):
    print('Pattern 20')
    print('--------------------')
    for i in range(1,n+1):
        for j in range(i):
            print('*',end='')
        for j in range(2*(n-i)):
            print(' ',end='')
        for j in range(i):
            print('*',end='')
        print()
        
    for i in range(1,n):
        for j in range(n-i):
            print('*',end='')
        for j in range(2*i):
            print(' ',end='')
        for j in range(n-i):
            print('*',end='')
        print()
        
def pattern21(n):
    print('Pattern 21')
    print('--------------------')
    for i in range(1,n+1):
        for j in range(1,n+1):
            if i==n or j==n or i==1 or j==1:
                print('*',end='')
            else:
                print(' ',end='')
        print()
        
def pattern22(n):
    print('Patter 22')
    print('--------------------')
    p = 2*n - 1
    for i in range(p):
        for j in range(p):
            top = i
            left = j
            right = 2*n - 2 - j
            bottom = 2*n - 2 - i 
            res = n - min(min(top,bottom),min(right,left))
            print(res,end='')
        print()

patterns = [pattern1, pattern2, pattern3, pattern4, pattern5, pattern6, pattern7, pattern8, pattern9, pattern10, pattern11, pattern12, pattern13, pattern14, pattern15, pattern16, pattern17, pattern18, pattern19, pattern20, pattern21,pattern22]

for pattern in patterns:
    print('--------------------')
    pattern(5)
print()