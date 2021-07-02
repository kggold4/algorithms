* (written by Kfir Goldfarb)

## Huffman Coding Algorithm pseudo-code:
### Complexity = O(n) / O(n*log(n)) (depends on implementing)

* A - given list of integers
* A.f - represents the frequencies of the characters in A
* A.c - represents the characters itself in A
* n = |A|

```
HuffmanCode(A):
    Sort(A, comperator=A.f) // depends of the argument if already sorted or not
    Queue q1 = new Queue, q2 = new Queue
    for from i=0 to n:
        q.enqueue(new Node(A[i]))
    *end-for
    
    while(q1.size() + q2.size() > 1):
        x = getMin(q1, q2)
        y = getMin(q1, q2)
        z = new Node(x.data.f + y.data.f)
        z.left = x, z.right = y
        q2.enqueue(z)
    *end-while
    
    if q1.empty():
        return q2.dequeue()
    else:
        return q.dequeue()
    *end-if
*end-HuffmanCode
    
getMin(Queue q1, Queue q2):
    if q1.empty():
        return q2.deqeueu()
    else if q2.empty():
        return q1.deqeue()
    else if q1.top().data.f < q2.top().data.f:
        return q1.deqeueu()
    else:
        retrun q2.deqeue()
    *end-if
*end-getMin
```
