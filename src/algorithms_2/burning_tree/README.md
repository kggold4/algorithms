* (written by Kfir Goldfarb)

## Burning Tree (find centers) algorithm pseudo-code:
### Complexity = O(|V|) = O(n)

* G - graph when G = (V, E)
    * V - set of the nodes in G
    * E - set of the edges in G
* n = |V|
* L - list of node


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
