class Node:
    def __init__(self,data1,next1=None):
        self.data = data1
        self.next = next1

def convertarr2LL(arr):
    head = Node(arr[0])
    mover = head
    
    for i in arr[1:]:
        tmp = Node(i)
        mover.next = tmp
        mover = tmp
        
    return head
    
def palinBrute(head):
    tmp = head
    st = []
    
    while tmp:
        st.append(tmp.data)
        tmp = tmp.next
        
    start,end=0,len(st)-1
    while start<end:
        if st[start]!=st[end]:
            return False
        start += 1
        end -= 1
    return True
    
def palinOptimal(head):
    if not head or not head.next:
        return True
    
    # First find the middle node of the linked list    
    slow = fast = head
    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next
        
    # Reverse the second half of the linked list
    right = reverseLL(slow)
    left = head
    
    # Compare the first half with the second half one by one
    while right:
        if left.data!=right.data:
            return False
        left = left.next
        right = right.next
        
    return True
    
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
    arr = [1, 2, 3, 4, 3, 2, 1]
    res = convertarr2LL(arr)
    print("Array after converting to linked list is:",end=' ')
    printLL(res)
    output = palinOptimal(res)
    print("Resultant linked list after reversing: ",output)
    
if __name__ == "__main__":
    main()