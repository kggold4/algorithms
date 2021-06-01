* (written by Kfir Goldfarb)

## DFS algorithm pseudo-code:
### Complexity = O(|E| + |V|)

* n - number of nodes in the graph
* neighbors - contain each node his neighbors
* visited - contains for each node true ir false if has been visited ot not

```
DFS(G, s):
    if visited[s]:
        return
    
    visited[s] = true
    for each v in neighbors[s]:
        DFS(G, s)
        
start = 0
BFS(s)
```