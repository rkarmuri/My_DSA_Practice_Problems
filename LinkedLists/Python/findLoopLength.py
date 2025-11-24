class Node:
    def __init__(self,data1,next1):
        self.data = data1
        self.next = next1

def loopLengthBrute(head):
    st = {} # Stores node value with it's timer
    timer = 1 # Use timer to find the distance between the loop
    tmp = head
    
    while tmp:
        if tmp in st: # if same node is found, subtract the timers 
            value = st[tmp]
            return timer-value
        st[tmp] = timer
        timer += 1
        tmp = tmp.next
    
    return 0
# Since the distance b/n slow and fast is bound to be 1 in a loop
# We move fast by 2 nodes
def loopLengthOptimal(head):
    slow = fast = head

    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next
        if slow==fast:
            return findLength(slow,fast)

    return 0
    
def findLength(slow,fast):
    cnt = 1
    fast = fast.next # Since both slow and fast are on same nodes, move fast to the next node for counting
    while slow!=fast:
        cnt += 1
        fast = fast.next
    return cnt

def printLL(head):
    while head:
        print(head.data,end=' ')
        head = head.next
    print()

def main():
    head = Node(1,None)
    second = Node(2,None)
    third = Node(3,None)
    fourth = Node(4,None)
    fifth = Node(5,None)

    head.next = second
    second.next = third
    third.next = fourth
    fourth.next = fifth
    fifth.next = third
    loop1 = loopLengthBrute(head)
    print('The length of loop using brute force is: ',loop1)
    loop2 = loopLengthOptimal(head)
    print('The length of loop using tortoise hare is: ',loop2)

if __name__ == "__main__":
    main()