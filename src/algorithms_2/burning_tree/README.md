* (written by Kfir Goldfarb)

## Burning Tree (find centers) algorithm pseudo-code:
### Complexity = O(|V|) = O(n)

* G - the tree/graph data-structure
* L - list of node
* n = |V|

```
find_centers(G):
    for each v in G:
        if G[v].size == 1:
            L.add(v)
        
        *end-if
    *end-for
    
    G' = G // deep copy
    while n > 2:
        L' = new list // list for the new leafs after the iterate the loop
        for each v in L:
            n--
            u = G'[v] // get neighbor of v
            G'[u].remove(v) // remove the leaf from the list of his neighbor
            if G'[u].size == 1:
                L'.add(u)
                
            *end-if
        *end-for
        
        L = L' // set new leafs
    *end-while
```
