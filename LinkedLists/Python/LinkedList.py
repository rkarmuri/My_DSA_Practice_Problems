class Node:
    def __init__(self,data1,next1=None):
        self.data = data1
        self.next = next1
        
def convertarr2LL(arr):
    head = Node(arr[0])
    mover = head
    
    for i in range(1,len(arr)):
        tmp = Node(arr[i])
        mover.next = tmp # Connect mover to tmp
        mover = tmp
        
    return head
    
def lengthLL(head):
    cnt = 0
    while head:
        cnt = cnt + 1
        head = head.next
        
    return cnt
    
def checkElement(head,element):
    while head:
        if head.data==element:
            return True
        head = head.next
    
    return False
    
def removeHead(head):
    if not head or not head.next:
        return None
    
    tmp = head
    tmp = tmp.next
    head = tmp
    
    return head
    
def removeTail(head):
    if not head or not head.next:
        return None
        
    tmp = head
    while tmp.next.next: # Until 2nd last ele
        tmp = tmp.next
    
    tmp.next = None # Remove the tail
    return head
        
def removeK(head,k):
    if not head:
        return head
    
    if k==1:
        head = head.next
        return head
        
    tmp = head
    cnt = 0
    prev = None
    while tmp:
        cnt += 1
        if cnt==k:
            prev.next = tmp.next
            break
        prev = tmp
        tmp = tmp.next
    
    return head
    
def removeElement(head,e):
    if not head:
        return head
        
    if head.data==e:
        head = head.next
        return head
        
    tmp = head
    prev = None
    while tmp:
        if tmp.data==e:
            prev.next = tmp.next
            break
        prev = tmp
        tmp = tmp.next
    
    return head
    
def insertHead(head,val):
    tmp = Node(val,head)
    return tmp
    
def insertTail(head,val):
    if not head:
        return Node(val,head)
        
    tmp = head
    while tmp.next:
        tmp = tmp.next
    
    new_node = Node(val)
    tmp.next = new_node
    return head
    
def insertK(head,val,k):
    if not head:
        if k==1:
            return Node(val,head)
        else:
            return head
            
    if k==1:
        return Node(val,head)
        
    cnt = 0
    tmp = head
    while tmp:
        cnt = cnt + 1
        if cnt==k-1:
            new_node = Node(val,tmp.next)
            tmp.next = new_node
            break
        tmp = tmp.next
    
    return head
    
def insertBeforeElement(head,val,e):
    if not head:
        return None
    
    if head.data==e:
        return Node(val,head)
        
    tmp = head
    while tmp.next:
        if tmp.next.data == e:
            new_node = Node(val,tmp.next)
            tmp.next = new_node
            break
        tmp = tmp.next
        
    return head
    
def printLL(head):
    while head:
        print(head.data,end=' ')
        head = head.next
    print()
    
def main():
    arr = [4,5,9,2,7]
    arr2 = [2,5,6,8,4]
    res = convertarr2LL(arr)
    res2 = convertarr2LL(arr2)
    printLL(res)
    print("Length of the linked list is: ",lengthLL(res))
    print("Is the element found in the Linked list?",checkElement(res,5))
    remove1 = removeHead(res)
    print("Linked list after removing head: ",end='')
    printLL(remove1)
    remove2 = removeTail(res)
    print("Linked list after removing tail: ",end='')
    printLL(remove2)
    remove3 = removeK(res2,3)
    print("Linked list after removing kth element: ",end='')
    printLL(remove3)
    remove4 = removeElement(res2,4)
    print("Linked list after removing the element itself: ",end='')
    printLL(remove4)
    insert1 = insertHead(res,1)
    print("Linked list after inserting at the head: ",end='')
    printLL(insert1)
    insert2 = insertTail(res,6)
    print("Linked list after inserting at the tail: ",end='')
    printLL(insert2)
    insert3 = insertK(res,0,4)
    print("Linked list after inserting at k: ", end='')
    printLL(insert3)
    insert4 = insertBeforeElement(res,1,4)
    print("Linked list after inserting before element: ", end='')
    printLL(insert4)
    
if __name__ == "__main__":
    main()
    