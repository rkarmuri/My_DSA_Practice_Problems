from typing import Optional
from typing import List
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        tmp = head
        prevNode = None
        nextNode = None

        while tmp:
            # Find the kth Node for each iteration
            kNode = self.findkNode(tmp, k)
            # If the kNode is null or leftover smaller list is <k
            if not kNode:
                if prevNode:
                    prevNode.next = tmp
                break

            nextNode = kNode.next  # Save the next node for future use before making kNode null
            kNode.next = None
            reversedHead = self.reverseLL(tmp)
            if tmp == head:
                head = reversedHead
            else:
                prevNode.next = reversedHead

            prevNode = tmp
            tmp = nextNode

        return head

    def findkNode(self, tmp, k):
        k -= 1 # Since tmp starts with the head or 1st position
        while tmp and k > 0:
            k -= 1
            tmp = tmp.next
        
        return tmp

    def reverseLL(self, head):
        tmp = head
        prevNode = None

        while tmp:
            front = tmp.next
            tmp.next = prevNode
            prevNode = tmp
            tmp = front

        return prevNode

# Helper functions to test the implementation
def createLinkedList(arr):
    if not arr:
        return None
    head = ListNode(arr[0])
    current = head
    for val in arr[1:]:
        newNode = ListNode(val)
        current.next = newNode
        current = newNode
    return head

def printLinkedList(head):
    while head:
        print(head.val, end=' ')
        head = head.next
    print()

# Example usage
def main():
    arr = [1, 2, 3, 4, 5]
    head = createLinkedList(arr)
    k = 4
    solution = Solution()
    new_head = solution.reverseKGroup(head, k)
    print("The linked list after reversing in", k,"-groups:",end=' ')
    printLinkedList(new_head)

if __name__ == "__main__":
    main()