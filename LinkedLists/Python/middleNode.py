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

def middleBrute(head):
    tmp = head
    cnt = 0

    while tmp:
        cnt += 1
        tmp = tmp.next
    
    mid = cnt//2 + 1
    tmp2 = head
    while tmp2:
        mid = mid-1
        if mid==0:
            break
        tmp2 = tmp2.next

    """for i in range(cnt//2):
        tmp2 = tmp2.next
    """

    return tmp2

def middleOptimal(head):
    slow = fast = head

    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next

    return slow

def printLL(head):
    while head:
        print(head.data,end=' ')
        head = head.next
    print()

def main():
    arr = [4,5,9,3,6,1]
    res = convertarr2LL(arr)
    print('Linked list elements are: ')
    printLL(res)
    mid1 = middleBrute(res)
    print('Middle node is: ',mid1.data)
    mid2 = middleOptimal(res)
    print('Middle node is: ',mid2.data)

if __name__ == "__main__":
    main()