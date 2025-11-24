class Node:
    def __init__(self,data1,next1 = None):
        self.data = data1
        self.next = next1
        
def convertarr2LL(arr):
    head = Node(arr[0])
    mover = head
    
    for i in range(1,len(arr)):
        tmp = Node(arr[i])
        mover.next = tmp
        mover = tmp
        
    return head

def delMiddleBrute(head):
    if not head or not head.next:
        return
    tmp = head
    n = 0
    while tmp:
        n += 1
        tmp = tmp.next
        
    m = n//2
    tmp = head
    while tmp:
        m -= 1
        if m==0:
            tmp.next = tmp.next.next
            break
        tmp = tmp.next
    
    return head
    
def delMiddleOptimal(head):
    if not head or not head.next:
        return None
    slow = fast = head
    fast = fast.next.next   
    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next
    
    slow.next = slow.next.next

    return head
    
def printLL(head):
    while head:
        print(head.data,end=' ')
        head = head.next
    print()
    
def main():
    arr = [4,8,6,9,3]
    arr2 = [1,2,3,4,5]
    res = convertarr2LL(arr)
    res2 = convertarr2LL(arr2)
    output = delMiddleBrute(res)
    print("The linked list using brute-force is: ",end='')
    printLL(output)
    output2 = delMiddleOptimal(res2)
    print("The linked list using tortoise-hare is: ",end='')
    printLL(output2)
    
if __name__ == "__main__":
    main()