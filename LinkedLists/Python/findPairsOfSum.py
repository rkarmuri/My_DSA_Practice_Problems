from typing import Optional
from typing import List

class Node:
    def __init__(self, data1, next1=None, prev1=None):
        self.data = data1
        self.next = next1
        self.prev = prev1

class Solution:
    def findPairsWithGivenSum(self, target : int, head : Optional['Node']) -> List[List[int]]:
        # code here
        left = head
        right = self.findTail(head)
        res = []
        
        if not head:
            return res
        
        while left.data<right.data:
            if left.data + right.data == target:
                res.append([left.data,right.data])
                left = left.next
                right = right.prev
            elif left.data + right.data < target:
                left = left.next
            else:
                right = right.prev
                
        return res
        
    def findTail(self,head):
        tail = head
        while tail.next:
            tail = tail.next
            
        return tail

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
    arr = [1, 2, 4, 5, 6, 8, 9]
    x = 10
    head = createDoublyLinkedList(arr)
    print("Original doubly linked list:",end=' ')
    printDoublyLinkedList(head)

    solution = Solution()
    head = solution.findPairsWithGivenSum(x,head)
    print("\nPairs with given sum of", x, "are:",head)

if __name__ == "__main__":
    main()
