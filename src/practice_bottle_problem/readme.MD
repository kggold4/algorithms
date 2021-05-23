* (written by Kfir Goldfarb)

## Bottle Problem algorithm pseudo-code:

### helping index function:
```
index(i, j, n):
    return (n + i) * j + i
```

### bottle problem:
```
bottle(m, n):
    dim = (m+1) * (n+1)
    mat = boolean[dim][dim]
    
    for from i to dim:
        for from j to dim
            mat[i][j] = false
        *end-for
    *end-for
    
    for from i to m:
        for from j to n:
            ind = index(i, j, n)
            
            // empty
            mat[ind][index(i, 0, n)] = true
            mat[ind][index(0, j, n)] = true
            
            // fill
            mat[ind][index(i, n, n)] = true
            mat[ind][index(m, j, n)] = true
            
            // pass
            mat[ind][index(MAX(0, i+j-n), MIN(n, i+j), n) = true
            mat[ind][index(MIN(m, i+j), MIN(0, i+j-m), n) = true
        *end-for    
    *end-for
    
    return mat         
```



[comment]: <> (### Complexity = O&#40;|E| + |V|&#41;)