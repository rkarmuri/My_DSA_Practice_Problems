class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
        self.prev = None

class Solution:
    def removeDuplicates(self, head):
        if not head:
            return head

        tmp = head
        
        while tmp and tmp.next: # Until the tmp reaches the last node
            nextNode = tmp.next
            
            # Check all the duplicates in the sequence
            while nextNode and tmp.data==nextNode.data:
                nextNode = nextNode.next
                
            tmp.next = nextNode
            if nextNode:
                nextNode.prev = tmp
            tmp = nextNode
            
        return head

# Helper functions for testing
def createDoublyLinkedList(arr):
    if not arr:
        return None
    head = Node(arr[0])
    current = head
    for val in arr[1:]:
        newNode = Node(val)
        current.next = newNode
        newNode.prev = current
        current = newNode
    return head

def printDoublyLinkedList(head):
    while head:
        print(head.data, end=' ')
        head = head.next
    print()

# Example usage
def main():
    arr = [1,1,1,2,3,3,4,4,4,5,5,6,6,7,8,9]
    head = createDoublyLinkedList(arr)
    solution = Solution()
    print("Original list:",end=' ')
    printDoublyLinkedList(head)
    head = solution.removeDuplicates(head)
    print("\nList after removing duplicates:",end=' ')
    printDoublyLinkedList(head)

if __name__ == "__main__":
    main()
