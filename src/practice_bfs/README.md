## BFS algorithm pseudo-code:
* (written by Kfir Goldfarb)
### Complexity = O(|E| + |V|)

* G - list of all nodes in the graph
* s - the starting node
* Color = {WHITE, GREY, BLACK}
* distance - for each node save the distance between him to the start node - number of edges to go throw
* parent - for each node save his parent node
* N - list of neighbors of each node
* Q - Queue data structure

```
BFS(G, s):
    for each v in G\{s}:
        color[v] = WHITE
        distance[v] = infinity
        parent[v] = null
    *end-for

    color[s] = GREY
    distance[s] = 0
    parent[s] = null
    
    Q.enqueue(s)
    while(!q.empty):
        u = Q.dequeue
        for each v in N[u]:
            if color[v] == WHITE:
                color[v] = GREY
                distance[v] = distance[u] + 1
                parent[v] = u
                Q.enqueue(v)
            *end-if
        *end-for
        color[u] = BLACK
    *end-while
```
