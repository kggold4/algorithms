* (written by Kfir Goldfarb)
## Reverse LinkedList algorithm pseudo-code:
### Complexity = O(n)

* head - the head node of the linked list

```
reverse(head):

    // base case
    if(head == null || head.next == null):
        return head
    *end-if

    // other cases
    curr = head.copy()
    prev = next = null

    while(curr != null):
        next = curr.next
        curr.next = prev
        prev = curr
        curr = next
    *end-while
    
    head = prev
    return head
```
