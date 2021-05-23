* (written by Kfir Goldfarb)

## Find best sum in array algorithm pseudo-code:
### Complexity = O(n)

* A - integer array
* n - length of the array
* sum - max sum
* temp_sum - the temp sum
* t - temp index 
* s - start index
* e - end_index

```
best(A):
    temp_sum = s = e = t = 0
    sum = A[0]
    for from i=0 to n:
    
        temp_sum += A[i]
        if sum < temp_sum:
            sum = temp_sum
            s = t
            e = i
        *end-if
        
        if temp_sum < 0:
            temp sum = 0
            t = i + 1
        *end-if
    *end-for
```

## Find best sum in circle array algorithm pseudo-code:
### Complexity = O(n)

* A - integer array
* n - length of the array
* sum - max sum

```
cyrcle_best(A):
    sum = 0
    B = new array(n)
    for from i to n:
        sum = sum + A[i]
        B[i] = -A[i]
    *end-for
    
    sum_A = best(A)
    sum_B = best(B)
    
    if sum + sum_B < sum_A:
        return sum_B
    else:
        return sum + sum_A
    *end-if
```
