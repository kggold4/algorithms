* (written by Kfir Goldfarb)
## BFS algorithm pseudo-code:
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


## BFS print-path pseudo-code:
### Complexity = O(|V|)

```
print-path-bfs(G, s, e):
    if s == e:
        print s
    else if parent[e] = null:
        print "not valid path from" s "to" e
    else:
        print-path(G, s, parent[e])
    *end-if
    print e
```

## BFS is_connected pseudo-code:

```
is_connected(G):
    BFS(G)
    for each color in colors of G:
        if color != BLACK:
            return false
        *end-if
    *end-for
    return true
```

## BFS number of connected components pseudo-code:

```
connected_components(G):
    counter = 0
    T = G
    while all node in T are not BLACK:
        BFS(T)
        counter++
        T = T - all the BLACK nodes
    *end-while
    return counter 
```
