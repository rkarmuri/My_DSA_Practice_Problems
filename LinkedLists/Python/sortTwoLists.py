class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

def sortTwoLists(first, second):
    # Initialize the dummy node with a placeholder value (e.g., -1 or any value)
    dummy = Node(0)
    tmp = dummy

    # Traverse both lists and append the smaller value to the result list
    while first and second:
        if first.data < second.data:
            tmp.next = first
            first = first.next
        else:
            tmp.next = second
            second = second.next
        tmp = tmp.next  # Move tmp to the next node

    # If there are remaining nodes in either list, append them
    if first:
        tmp.next = first
    else:
        tmp.next = second

    return dummy.next

# Helper function to create a linked list from a list
def createLinkedList(arr):
    if not arr:
        return None
    head = Node(arr[0])
    current = head
    for val in arr[1:]:
        current.next = Node(val)
        current = current.next
    return head

# Helper function to print the linked list
def printLinkedList(head):
    while head:
        print(head.data, end=' -> ')
        head = head.next
    print('None')

# Example usage
def main():
    first_list = [1, 3, 5]
    second_list = [2, 4, 6]

    first = createLinkedList(first_list)
    second = createLinkedList(second_list)

    merged_head = sortTwoLists(first, second)
    print("Merged linked list:")
    printLinkedList(merged_head)

if __name__ == "__main__":
    main()
