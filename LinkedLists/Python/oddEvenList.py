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
    
def oddEvenListBrute(head):
    if not head or not head.next:
        return head

    arr = []
    tmp = head
    while tmp and tmp.next: # Collect all the odd indexed lists into the array
        arr.append(tmp.data)
        tmp = tmp.next.next
    if tmp: # Check after moving the tmp, if it is still not null
        arr.append(tmp.data)

    temp = head.next
    while temp and temp.next: # Collect all the even indexed lists into the array
        arr.append(temp.data)
        temp = temp.next.next
    if temp: # Check after moving the tmp, if it is still not null
        arr.append(temp.data)

    curr = head
    i = 0
    while curr:
        curr.data = arr[i]
        i += 1
        curr = curr.next

    return head

def oddEvenList(head):
    if not head or not head.next:
        return head
    
    odd,even = head,head.next # Start both the positions simultaneously
    firstEven = head.next # Store the 1st even to point the last odd to it
    
    while even and even.next: # We would only need to think about even position for traversing
        odd.next = odd.next.next
        even.next = even.next.next
        
        odd = odd.next # Move the odd pointer
        even = even.next # Move the even pointer
    
    odd.next = firstEven # Connect the last odd to the first even
    
    return head
        
def printLL(head):
    while head:
        print(head.data,end='->')
        head = head.next
    print()
    
def main():
    arr = [4,8,6,9,7]
    res = convertarr2LL(arr)
    res2 = convertarr2LL(arr)
    sor = oddEvenListBrute(res)
    print("The odd even sorted linked list of brute force is: ",end='')
    printLL(sor)
    sor2 = oddEvenList(res2)
    print("The odd even sorted linked list of optimal is: ",end='')
    printLL(sor2)
    
if __name__ == "__main__":
    main()