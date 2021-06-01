# -*- coding: utf-8 -*-

# -- Sheet --

def binary_search(arr, item, left=0, right=len(arr)-1):
    if left <= right:
        middle = left + (right - left) // 2
        
        if arr[middle] == item:
            return middle

        elif item > arr[middle]:
            return binary_search(arr, item, middle+1, right)

        else:
            return binary_search(arr, item, left, middle-1)

    else:
        return -1

