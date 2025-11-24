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
    
def add(head1,head2):
    t1,t2 = head1,head2
    dummy = Node(-1) # Place holder to make the retrievel easy
    curr = dummy # Pointer to traverse
    carry = 0
    
    # Traverse across both the lists
    while t1 or t2:
        res = carry
        # Add the sum of each lists into result
        if t1:
            res = res + t1.data
        if t2:
            res = res + t2.data
        
        # Compute the result for each digit
        newNode = Node(res%10) # This will yield the reminder of sum
        carry = res//10 # This yields the carry over
        
        curr.next = newNode
        curr = curr.next
        
        if t1:
            t1 = t1.next
        if t2:
            t2 = t2.next
        
    if carry:
        newNode = Node(carry)
        curr.next = newNode # As current is at the tail just point it to the new node
        
    return dummy.next
        
def printLL(head):
    while head:
        print(head.data,end=' ')
        head = head.next
    print()
    
def main():
    arr = [3,5]
    arr2 = [4,8,9,9]
    res1 = convertarr2LL(arr)
    res2 = convertarr2LL(arr2)
    res = add(res1,res2)
    print("The linked list is: ",end='')
    printLL(res)
    
if __name__ == "__main__":
    main()