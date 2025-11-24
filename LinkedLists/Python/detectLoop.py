class Node:
    def __init__(self,data1,next1=None):
        self.data = data1
        self.next = next1

def loopBrute(head):
    st = set()
    tmp = head
    
    while tmp:
        if tmp in st:
            return True
        st.add(tmp)
        tmp = tmp.next
    
    return False
# Since the distance b/n slow and fast is bound to be 1 in a loop
# We move fast by 2 nodes
def loopOptimal(head):
    slow = fast = head

    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next
        if slow==fast:
            return True

    return False

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
    loop1 = loopBrute(head)
    print('Does loop exists using brute force? ',loop1)
    loop2 = loopOptimal(head)
    print('Does loop exists using tortoise hare? ',loop2)

if __name__ == "__main__":
    main()