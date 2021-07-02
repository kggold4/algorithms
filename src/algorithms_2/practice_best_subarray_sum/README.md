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
BestCycle(A):
    sum = 0
    B = new array(n)
    for from i=0 to n:
        sum = sum + A[i]
        B[i] = -A[i]
    *end-for
    
    sum_A = best(A)
    sum_B = best(B)
    
    if sum + sum_B < sum_A:
        return sum_A
    else:
        return sum + sum_B
    *end-if
```

## Gas Stations Problem Algorithm pseudo-code:
### Complexity = O(n)

* A - integer array that represents the fuel that can be refilled in the station i
* B - integer array that represents the cost of fuel to go from station i to station i+1
* n - number of gas stations

```
Gas_Stations(A, B):
    C[n] = new array
    for from i=0 to n:
        C[i] = A[i] - B[i]
    *end-for
    
    return BestCycle(C)
```

## Best Matrix Algorithm pseudo-code:
### Complexity = O(m*n)

* M  - given integer matrix
* n = M rows length
* m = M cols length

```
BestMatrix(M):
    max_sum = -∞
    temp_sum = 0
    H[n][m] = new matrix
    for from i=0 to m-1:
        H[0][i] = M[0][i]
    *end-for
    
    for from i=0 to n-1:
        for from j=0 to m-1:
            H[i][j] = H[i-1][j] + M[i][j]
        *end-for
    *end-for
    
    for from i=0 to n-1;:
        for from j=0 to n-1:
            A[m] = new array
            for from k=0 to m-1:
                if i == 0:
                    A[k] = H[j][k]
                else:
                    A[k] = H[j][k] - H[i-1][k]
                *end-if
            *end*for
            
        temp_sum = Best(A)
        if  temp_sum > max:
            max = temp_sum
        *end-if
    *end-for
   
    return max_sum
```
