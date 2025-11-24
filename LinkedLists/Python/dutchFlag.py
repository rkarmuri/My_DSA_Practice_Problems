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
    
def dutchFlagBrute(head):
    if not head or not head.next:
        return head
    tmp = head
    cnt0,cnt1,cnt2 = 0,0,0 # Take counters for each
    
    while tmp:
        if tmp.data == 0:   cnt0 += 1
        elif tmp.data == 1:   cnt1 += 1
        else:   cnt2 += 1
        tmp = tmp.next
    
    tmp = head
    while tmp:
        if cnt0>0:
            tmp.data = 0
            cnt0 = cnt0 - 1
        elif cnt1>0:
            tmp.data = 1
            cnt1 = cnt1 - 1
        else:
            tmp.data = 2
            cnt2 = cnt2 - 1
        tmp=tmp.next
        
    return head
    
def dutchFlagOptimal(head):
    if not head or not head.next:
        return head
        
    zeroHead = Node(-1,None)
    oneHead = Node(-1,None)
    twoHead = Node(-1,None)
    zero = zeroHead
    one = oneHead
    two = twoHead
    
    tmp = head
    while tmp:
        if tmp.data==0:
            zero.next = tmp
            zero = zero.next
        elif tmp.data == 1:
            one.next = tmp
            one = one.next
        else:
            two.next = tmp
            two = two.next
        tmp = tmp.next
        
    zero.next = oneHead.next if oneHead.next else twoHead.next
    one.next = twoHead.next
    two.next = None
    
    return zeroHead.next
    
def printLL(head):
    while head:
        print(head.data,end=' ')
        head = head.next
    print()
    
def main():
    arr = [0,2,1,1,0,0,0,2,1,1,1,2,2]
    res = convertarr2LL(arr)
    sor = dutchFlagBrute(res)
    print("The sorted linked list of brute force is: ",end='')
    printLL(sor)
    sor2 = dutchFlagOptimal(res)
    print("The sorted linked list of optimal is: ",end='')
    printLL(sor2)
    
if __name__ == "__main__":
    main()