* (written by Kfir Goldfarb)

## Euler Cycle algorithm pseudo-code:
### Complexity = O(|E| + |V|)

* G - graph when G = (V, E)
    * V - set of the nodes in G
    * E - set of the edges in G
* counter - count the number of nodes with odd rank

```
EulerCycle(G):
    Stack s = new Stack
    List path = new List
    counter = 0
    start = 0
    for each v in V:
        if(G[v].rank % 2 == 1):
            counter++
            start = v
        *end-if
    *end-for
    
    if counter > 2:
        return
    *end-if
    
    s.push(start)
    while(!s.empty()):
        if(G[s.top()].rank() > 0):
            u = G[v].getFirst()
            s.push(u)
            G.remove(v,u)
        else:
            path.add(s.pop())
        *end-if
    *end-while
            
    return path

```
