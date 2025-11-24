class Node:
    def __init__(self,data1,next1=None):
        self.data = data1
        self.next = next1

def loopStartBrute(head):
    st = set()
    tmp = head
    
    while tmp:
        if tmp in st:
            return tmp
        st.add(tmp)
        tmp = tmp.next
    
    return None
# Since the distance b/n slow and fast is bound to be 1 in a loop
# We move fast by 2 nodes
def loopStartOptimal(head):
    slow = fast = start = head

    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next
        if slow==fast:
            while start!=slow:
                start = start.next
                slow = slow.next
            return slow

    return None

def printLL(head):
    while head:
        print(head.data,end=' ')
        head = head.next
    print()

def main():
    head = Node(1)
    second = Node(2)
    third = Node(3)
    fourth = Node(4)
    fifth = Node(5)

    head.next = second
    second.next = third
    third.next = fourth
    fourth.next = fifth
    fifth.next = third
    loop1 = loopStartBrute(head)
    print('Starting point of loop using brute force: ',loop1.data)
    loop2 = loopStartOptimal(head)
    print('Starting point of loop exists tortoise hare: ',loop2.data)

if __name__ == "__main__":
    main()