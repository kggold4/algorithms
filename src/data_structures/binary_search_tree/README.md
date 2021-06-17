# Binary Search Tree

### preorder traversal order pseudo-code

```
preorder():
    preorder(root)
    
preorder(node):
    if(node != null):
        print(node.data + ' ')
        preorder(node.left)
        preorder(node.right)
    *end-if
    
```

### inorder traversal order pseudo-code

```

inorder():
    inorder(root)

inorder(node):
    if(node != null):
        inorder(node.left)
        print(node.data + ' ')
        inorder(node.right)
    *end-if
    
```

### postorder traversal order pseudo-code

```

postorder():
    postorder(root)

postorder(node):
    if(node != null):
        postorder(node.left)
        postorder(node.right)
        print(node.data + ' ')
    *end-if

```
