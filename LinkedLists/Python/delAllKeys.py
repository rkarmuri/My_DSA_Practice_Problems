class Node:
    def __init__(self, data1, next1=None, prev1=None):
        self.data = data1
        self.next = next1
        self.prev = prev1

class Solution:
    # Function to delete all the occurrences of a key from the linked list.
    def deleteAllOccurOfX(self, head, x):
        # Pointer to the current node
        tmp = head

        # Loop through the linked list
        while tmp:
            if tmp.data == x:
                # If the node to be deleted is the head node
                if tmp == head:
                    head = tmp.next
                    if head:
                        head.prev = None
                prevNode = tmp.prev
                nextNode = tmp.next
                if nextNode:
                    nextNode.prev = prevNode
                if prevNode:
                    prevNode.next = nextNode
                
                tmp = nextNode
            else:
                # Move to the next node if no deletion
                tmp = tmp.next

        return head

# Helper function to create a doubly linked list from a list
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

# Helper function to print a doubly linked list
def printDoublyLinkedList(head):
    current = head
    while current:
        print(current.data, end=' ')
        current = current.next
    print()

# Example usage
def main():
    arr = [1, 2, 3, 4, 3, 5, 3,2,6,2,9,2]
    x = 2
    head = createDoublyLinkedList(arr)
    print("Original doubly linked list:",end=' ')
    printDoublyLinkedList(head)

    solution = Solution()
    head = solution.deleteAllOccurOfX(head, x)
    print("\nDoubly linked list after deleting all occurrences of", x, ":",end=' ')
    printDoublyLinkedList(head)

if __name__ == "__main__":
    main()
