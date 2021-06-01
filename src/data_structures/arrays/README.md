* (written by Kfir Goldfarb)
## Binary Search algorithm pseudo-code:
### Complexity = O(log(n))

```
binary_search(arr, item):
    return binary_search(arr, item, 0, arr.length-1)

binary_search(arr, item, l, r):
    if l <= r:
        mid = l + (r - l) / 2
        
        if arr[mid] == item:
            return mid
        elif arr[mid] < item:
            return binary_search(arr, item, mid+1, r)
        else:
            return binary_search(arr, item, l, mid-1)
        *end-if
        
    else:
        return -1
    *end-if
```
