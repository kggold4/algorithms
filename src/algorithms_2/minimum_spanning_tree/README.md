* (written by Kfir Goldfarb)

## Kruskal Algorithm pseudo-code:
### Complexity = O(|E| * log(|E|))

* G - graph when G = (V, E)
    * V - set of the nodes in G
    * E - set of the edges in G
* d - union-find data structure
* n = |V|

```
kruskal(G):
    sort(|E|, comperator = for each e in E sort by minimum weight)
    DisjoinSets d = new DisjoinSets(n)
    T = new Tree
    
    for each e in E:
        if(d.union(e.v1, e,v2)):
            T.add(e)
        *end-if
        if(T.size() == n-1):
            return T
        *end-if
    *end-for
    
    return T
```

## Reversed Kruskal (Reverse-Delete) Algorithm pseudo-code:
### Complexity = O(|E| * log(|E|))

* G - graph when G = (V, E)
    * V - set of the nodes in G
    * E - set of the edges in G
* n = |V|

```
reverse_delete(G):
    sort(|E|, comperator = for each e in E sort by minimum weight)
    T = new Tree
    i = 0
    while(i < |E|):
        e = E[i]
        G.delete(e)
        
        if(G.is_connected()):
            T.add(e)
            i++
        else:
            G.add(e)
            T.delete(e)
        *end-if
    *end-while

    return T
```

## Prim Algorithm pseudo-code:
### Complexity = O(|E| * log(|V|))

* G - graph when G = (V, E)
    * V - set of the nodes in G
    * E - set of the edges in G
* n = |V|
    
```
prim(G):
    T = new Tree
    prev[n] = new array
    distance[n] = new array
    visited[n] = new array
    
    for each v in G:
        prev[v] = null
        distance[v] = ∞
        visited[v] = false
    *end-for
        
    PriorityQueue q = new PriorityQueue
    Node s = random node from G
    distance[s] = 0
    q.enqueue(s, priority=0)
    
    while(!q.empty()):
        Node u = q.extractMin()
        if(pred[u] != null):
            T.add(edge(prev[u], u))
        *end-if
        
        for each v in G[u]:
            if(!visited[v] and distance[v] < edge(u,v).weight):
                distance[v] = edge(u,v).weight
                prev[v] = u
                visited[v] = true
                if(q.contains(v)):
                    q.decreaseKey(v,distance[v])
                else:
                    q.enqueue(v,distance[v])
                *end-if
            *end-if
        *end-for
        
        visited[u] = true
    *end-while
        
    return T
```

## Boruvka Algorithm pseudo-code:
### Complexity = O(|E| * log(|V|))

* G - graph when G = (V, E)
    * V - set of the nodes in G
    * E - set of the edges in G
* d - union-find data structure
    
```
boruvka(G):
    DisjoinSets d = new DisjoinSets(|V|)
    T = new Tree
    isFinnished = false
    while(!isFinnished):
        cheapest[n] = new array
        for each e in E:
            g1 = d.find(e.v1)
            g2 = d.find(e.v2)
            if(g1 != g2):
                if(e.weight < cheapest[g1].weight): cheapest[g1] = e
                if(e.weight < cheapest[g2].weight): cheapest[g2] = e
            *end-if
        *end-for
        
        isFinnished = true
        for i=0 to n:
            if(cheapest[i] != null):
                T.add(cheapest[i])
                d.union(cheapest[i].v1, cheapest[i].v2)
                isFinnished = false
            *end-if
        *end-for
    *end-while
    
    return T
```
