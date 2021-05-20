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

