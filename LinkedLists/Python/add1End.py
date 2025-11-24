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
    
def add1End(head):
    carry = helper(head)
    if carry == 1:
        newNode = Node(1,head)
        return newNode
    return head

# Do not alter the node data but only return carry value for every recursion
def helper(head):
    if not head:
        return 1
    carry = helper(head.next)
    head.data += carry
    if head.data < 10:
        return 0
    head.data = 0
    return 1

def add1End2(head):
    carry = 1 # Take carry as 1 for initial computation
    head = reverseLL(head) # Reverse the linked list to add one to the head
    tmp = head

    while tmp:
        tmp.data += carry
        if tmp.data<10: # If the result is less than 10
            carry = 0
            break
        else:
            tmp.data = 0
            carry = 1

        tmp = tmp.next
    # Add the carry node and link it to the head
    if carry==1:
        newNode = Node(1)
        newNode.next = head
        head = newNode
    else:
        head = reverseLL(head)
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

def printLL(head):
    while head:
        print(head.data,end='->')
        head = head.next
    print('None')
    
def main():
    arr = [9,9,9,9]
    arr2 = [1,5,9]
    res1 = convertarr2LL(arr2)
    res2 = convertarr2LL(arr)
    add = add1End(res1)
    add2 = add1End2(res2)
    print("The linked list after adding 1 using optimal solution is: ",end='')
    printLL(add)
    print("The linked list after adding 1 using iterative solution is: ",end='')
    printLL(add2)
    
if __name__ == "__main__":
    main()