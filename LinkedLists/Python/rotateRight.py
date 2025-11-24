from typing import Optional
from typing import List
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if not head or not head.next or k == 0:
            return head

        # Find the length of the linked list and the tail node
        l = 1
        tail = head
        while tail.next:
            l += 1
            tail = tail.next
        
        # If k is a multiple of the length of the list, no rotation is needed
        k = k % l
        if k == 0:
            return head
        
        # Connect the tail to the head to make it a circular list
        tail.next = head
        
        # Find the new tail, which is (l - k)th node from the beginning
        new_tail = self.findNthNode(head, l - k)
        new_head = new_tail.next
        
        # Break the circular list to get the desired result
        new_tail.next = None

        return new_head

    # Helper function to find the nth node in the list
    def findNthNode(self, head, n):
        current = head
        for _ in range(n - 1):
            current = current.next
        return current

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
    print("The given linked list is: ",end=' ')
    printLinkedList(head)
    k = 2
    solution = Solution()
    new_head = solution.rotateRight(head, k)
    print("The linked list after",k,"rotations:",end=' ')
    printLinkedList(new_head)

if __name__ == "__main__":
    main()