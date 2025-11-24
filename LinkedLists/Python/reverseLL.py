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
    
def reverseLL(head):
    if not head or not head.next:
        return head
    tmp = head
    dummy = None
    while tmp:
        front = tmp.next
        tmp.next = dummy
        dummy = tmp
        tmp = front
    
    return dummy
    
def reverseLL2(head):
    if not head or not head.next:
        return head
        
    newHead = reverseLL2(head.next)
    front = head.next
    front.next = head
    head.next = None
    return newHead
        
def printLL(head):
    while head:
        print(head.data,end=' ')
        head = head.next
    print('None')
    
def main():
    arr = [4,8,6,9]
    res = convertarr2LL(arr)
    rev = reverseLL(res)
    print("The iterative linked list is: ",end='')
    printLL(rev)
    rev2 = reverseLL2(rev)
    print("The recursive linked list is: ",end='')
    printLL(rev2)
    
if __name__ == "__main__":
    main()