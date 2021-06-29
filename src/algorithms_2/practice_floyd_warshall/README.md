* (written by Kfir Goldfarb)
## Boolean Floyd-Warshall algorithm pseudo-code:
### Complexity = O(n^3)

* G - Boolean matrix that represent a graph
* n = |V| - number of nodes in the graph

```
floyd-warshall(G):
    for from k=0 to n:
        for from i=0 to n:
            from from j=0 to n:
                G[i][j] = G[i][j] || (G[i][k] && G[j][k])
            *end-for
        *end-for
    *end-for
```

## Weighted Floyd-Warshall algorithm pseudo-code:
### Complexity = O(n^3)

* G - Integer matrix that represent a graph
* n = |V| - number of nodes in the graph

```
floyd_warshall(G):
    for from k=0 to n:
        for from i=0 to n:
            for from j=0 to n:
                if G[i][k] != ∞ && G[k][j] != ∞:
                    G[i][j] = MIN(G[i][j], G[i][k] + G[k][j])
                *end-if
            *end-for
        *end-for
    *end-for
```

## Boolean graph matrix is strongly connected algorithm pseudo-code - solution 1:
### Complexity = O(|V|^2) = O(n^2)

* G - Boolean matrix that represent a graph
* n = |V| - number of nodes in the graph

```
is_connected(G):
    for from i=0 to n:
        for from j=0 to n:
            if !G[i][j]:
                return false
            *end-if
        *end-for
    *end-for
    
    return true
```

## Boolean graph matrix is strongly connected algorithm pseudo-code - solution 2:
### Complexity = O(|V|) = O(n)

* G - Boolean matrix that represent a graph
* n = |V| - number of nodes in the graph

```
is_connected(G):
    for from i=0 to n:
        if !G[0][j]:
            return false
        *end-if
    *end-for
    
    return true

```

## Number of connected components' algorithm pseudo-code:
### Complexity = O(|V|^2) = O(n^2)

* G - Boolean matrix that represent a graph
* n = |V| - number of nodes in the graph
* help - helping array with the length of n

```
number_of_connected_components(G):
    counter = 0
    for from i=0 to n:
        if help[i] == 0:
            help[i] = ++counter
        *end-if
        
        for from j=i+1 to n:
            if G[i][j] && help[j] == 0:
                help[j] = counter
            *end-if
        *end-for
    *end-for
    
    return counter
```

## has negative circle algorithm pseudo-code:
### Complexity = O(|V|) = O(n)

* G - Boolean matrix that represent a graph
* n = |V| - number of nodes in the graph
```
find_negative_diagonal(G):
    for from i=0 to n:
        if G[i][i] < 0:
            return true
        *end-if
    *end-for
    
    return true
    
*end-find_negative_diagonal
    
    
has_negative_circle(G):
    floyd_warshall(G);
    return find_negative_diagonal(G);
    
*end-has_negative_circle
```








