* (written by Kfir Goldfarb)

## DFS recursive algorithm pseudo-code:
### Complexity = O(|E| + |V|)

* G - graph when G = (V, E)
    * V - set of the nodes in G
    * E - set of the edges in G
* n = |V|
* ```G[v]``` - contain v neighbors
* visited - contains for each node true ir false if has been visited ot not

```
DFS(G, s):
    if visited[s]:
        return
    *end if
    
    visited[s] = true
    for each v in G[s]:
        DFS(G, s)
    *end-for
        
start = 0
DFS(s)
```

## Count number of connected components with DFS recursive algorithm pseudo-code:
### Complexity = O(|E| + |V|)

* n - number of nodes in the graph
* neighbors - contain each node his neighbors
* count = 0 - count number of connected components
* components = empty integer array
* visited - contains for each node true ir false if has been visited ot not

```
findComponents():
    for from i to n:
        count++
        dfs(i)
    *end-for
    return (count, components)

DFS(G, s):
    visited[s] = true
    components[s] = count
    for each v in neighbors[s]:
        if !visited[v]:
            DFS(G, s)
        *end-if
    *end-for
```
