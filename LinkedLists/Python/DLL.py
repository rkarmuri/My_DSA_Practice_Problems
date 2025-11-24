class Node:
    def __init__(self,data1,next1,prev1):
        self.data = data1
        self.next = next1
        self.prev = prev1
        
def convertarr2DLL(arr):
    head = Node(arr[0],None,None)
    prev = head
    
    for i in range(1,len(arr)):
        tmp = Node(arr[i],None,prev)
        prev.next = tmp
        prev = tmp
        
    return head
    
def removeHead(head):
    if not head or not head.next:
        return 
    
    prev = head
    head = prev.next
    prev.next = None
    head.prev = None
    return head
 
def removeTail(head):
    if not head or not head.next:
        return
    
    tmp = head
    while tmp.next:
        tmp = tmp.next
    
    prev = tmp.prev
    prev.next = None
    return head
    
def removeK(head,k):
    if not head:
        return
    
    cnt = 0
    kNode = head
    
    while kNode:
        cnt+=1
        if cnt==k:
            break
        kNode = kNode.next
        
    prev = kNode.prev # The node before the temporary element
    front = kNode.next # The node after the temporary element
    
    # Check all the edge cases
    if not prev and not front:
        return
    elif not prev:
        return removeHead(head)
    elif not front:
        return removeTail(head)
    
    # Remove the connections between the elements
    prev.next = front
    front.prev = prev
    kNode.next = None
    kNode.prev = None
    
    return head
    
def removeNode(tmp):
    prev = tmp.prev
    front = tmp.next
    
    if not front:
        prev.next = None
        tmp.prev = None
        return
    
    prev.next = front
    front.prev = prev
    tmp.next = tmp.prev = None

def insertBeforeHead(head,val):
    if not head:
        return
    newHead = Node(val,head,None)
    newHead.prev = None
    newHead.next = head
    head.prev = newHead
    return newHead
    
def insertBeforeTail(head, val):
    if not head:
        return insertBeforeHead(head,val)

    tmp = head
    while tmp.next:
        tmp = tmp.next

    prev_node = tmp.prev
    newTail = Node(val, tmp, prev_node)
    prev_node.next = newTail
    return head
    
def insertBeforeK(head,val,k):
    if k==1:
        return insertBeforeHead(head,val)
    tmp = head
    cnt = 0
    while tmp:
        cnt += 1
        if cnt==k:
            break
        tmp = tmp.next
    
    if not tmp:
        return insertBeforeTail(head, val)
    
    prev_node = tmp.prev
    new_node = Node(val, tmp, prev_node)

    if prev_node:
        prev_node.next = new_node

    tmp.prev = new_node
    return head

def insertBeforeNode(head,val):
    prev_node = head.prev
    newNode = Node(val,head,prev_node)
    prev_node.next = newNode
    head.prev = newNode

def BruteReverse(head):
    if not head or not head.next:
        return head
    
    tmp = head
    st = []

    while tmp:
        st.append(tmp.data)
        tmp = tmp.next

    tmp = head

    while tmp:
        tmp.data = st.pop()
        tmp = tmp.next

    return head

def OptimalReverse(head):
    if not head or not head.next:
        return head
    
    curr = head
    last = None

    # Swap the pointers of the nodes
    while curr:
        last = curr # Move the dummy pointer one step to right
        curr.prev, curr.next = curr.next, curr.prev
        curr = curr.prev # Since current next is pointing to previous
        
    return last
    
def printLL(head):
    while head:
        print(head.data,end=" ")
        head = head.next
    print()

def main():
    arr = [2,4,9,6,3]
    arr2 = [3,9,4,5]
    res2 = convertarr2DLL(arr2)
    res = convertarr2DLL(arr)
    print("Linked list elements are: ",end='')
    printLL(res)
    print('After removing the first element: ',end='')
    remove1 = removeHead(res)
    printLL(remove1)
    remove2 = removeTail(remove1)
    print('After removing the last element: ',end='')
    printLL(remove2)
    remove3 = removeK(remove2,2)
    print('After removing the kth element: ',end='')
    printLL(remove3)
    print('Remove the node: ',end='')
    removeNode(res2.next)
    printLL(res2)
    insert1 = insertBeforeHead(remove3,100)
    print('After inserting before the head: ',end='')
    printLL(insert1)
    insert2 = insertBeforeTail(insert1,83)
    print('After inserting before the tail: ',end='')
    printLL(insert2)
    insert3 = insertBeforeK(insert2,37,2)
    print('After inserting new item: ',end='')
    printLL(insert3)
    print('Insert before the node: ',insertBeforeNode(insert3.next.next,64))
    printLL(insert3)
    rev1 = BruteReverse(insert3)
    print("Brute force to reverse a doubly linked list: ",end='')
    printLL(rev1)
    rev2 = OptimalReverse(insert3)
    print("Optimal solution to reverse a doubly linked list: ",end='')
    printLL(rev2)
    
if __name__ == "__main__":
    main()