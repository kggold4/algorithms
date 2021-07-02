* (written by Kfir Goldfarb)

## Find Graph Maximum Diameter Using BFS Algorithm pseudo-code:
### Complexity = O(|E| + |V|)

* G - graph when G = (V, E)
    * V - set of the nodes in G
    * E - set of the edges in G

```
GraphDiam(G):
    u = random node in the graph
    BFS(G, u)
    v = max_node of G.distance
    BFS(G, v)
    return max_value of G.distance
```
