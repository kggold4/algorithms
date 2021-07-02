* (written by Kfir Goldfarb)

## Checking if two Binary Trees are Isomorphism Algorithm pseudo-code:
### Complexity = O(|V|)

* Node - struct with data and left, right Nodes
* r1, r2 are the root Nodes of two binary trees

```
is_isomorphic(r1, r2):
    if r1 == null and r2 == null:
        return true
    if r1 == null or r2 == null:
        return false
    if r1.data != r2.data:
        return false
    *end-if's
    
    return (
        ((is_isomorphic(r1.left, r2.left) and is_isomorphic(r1.right, r2.right))
        or
        ((is_isomorphic(r1.left, r2.right) and is_isomorphic(r1.right, r2.left))
        )
```