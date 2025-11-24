class Node:
    def __init__(self,data1,next1):
        self.data = data1
        self.next = next1
        
def convertarr2LL(arr):
    head = Node(arr[0],None)
    mover = head
    
    for i in range(1,len(arr)):
        tmp = Node(arr[i],None)
        mover.next = tmp
        mover = tmp
        
    return head
    
def removeNthFromEnd1(head,n):
    # Intuition is to find the node before the nth node
    tmp = head
    cnt = 0
    while tmp:
        cnt += 1
        tmp = tmp.next
    
    if cnt==n:
        return head.next
    
    res = cnt - n
    tmp = head
    while tmp and res>1: # Until the node before the nth node
        res = res - 1
        tmp = tmp.next
        
    if tmp and tmp.next:
        tmp.next = tmp.next.next
    
    return head
    
def removeNthFromEnd2(head,n):
    # Using fast slow pointers
    # Intution is to reach the node before the nth node
    slow = fast = head
    # Move the fast pointer by n steps
    for _ in range(n):
        fast = fast.next

    if not fast: # If the n is equal to length of linked list
        return head.next

    # Move both slow and fast pointers by 1 step until fast reaches null
    # This will make the slow pointer come to the node before the nth node
    while fast.next:
        slow = slow.next
        fast = fast.next

    # Since we know the node before the nth node, we just move the pointers
    slow.next = slow.next.next

    return head

def printLL(head):
    while head:
        print(head.data,end=' ')
        head = head.next
    print()
    
def main():
    arr = [4,5,8,9]
    arr2 = [1,2,3,4,5]
    res = convertarr2LL(arr)
    res2 = convertarr2LL(arr2)
    sor = removeNthFromEnd1(res,4)
    print("The removed the nth node from linked list is: ",end='')
    printLL(sor)
    sor2 = removeNthFromEnd2(res2,2)
    print("The removed the nth node from linked list is: ",end='')
    printLL(sor2)
    
if __name__ == "__main__":
    main()