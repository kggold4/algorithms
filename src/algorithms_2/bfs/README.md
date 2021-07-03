* (written by Kfir Goldfarb)

## BFS algorithm pseudo-code:
### Complexity = O(|E| + |V|)

* G - graph when G = (V, E)
    * V - set of the nodes in G
    * E - set of the edges in G
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
### Complexity = O(|E| + 2|V|)

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
### Complexity = O(|E| + |V|) + O(|E| + |V| - 1) + O(|E| + |V| - 2) + ... + O(|E| + 1) = O(|E| + |V|^2)

```
number_of_connected_components(G):
    counter = 0
    T = G
    while all node in G are not BLACK:
        BFS(T)
        T = T - all the BLACK nodes of T
        counter++
    *end-while
    return counter 
```

## BFS return connected components of node pseudo-code:
### Complexity = O(|E| + |V|) + O(|E| + |V| - 1) + O(|E| + |V| - 2) + ... + O(|E| + 1) = O(|E| + |V|^2)

```
connected_components(G, s):
    T = G
    while all node in G are not BLACK:
        BFS(T)
        T = T - all the BLACK nodes of T
        if BLACK nodes of T contains s:
            temp_list = all the BLACK nodes of T
            return temp_list
        *end-if
    *end-while
    return empty list
```

## BFS fround diam of graph pseudo-code solution-1:
### Complexity = O(|E+V| * |V|)

* diam - the max diam in the graph

```
graph_diam(G):
    diam = 0
    for each s in G:
        BFS(G, s)
        max = MAX(distance[s])
        if max > diam:
            diam = max
        *end-if
    *end-for
    return diam
```

## BFS fround diam of graph pseudo-code solution-2:
### Complexity = O(2(|E| + |V|)) = O(|E| + |V|)

* diam - the max diam in the graph

```
graph_diam(G):
    select random s in G
    BFS(G, s)
    u = the node with the max value in distance list
    BFS(G, u)
    return max value in distance list    
```
