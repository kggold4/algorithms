# Binary Search Tree

### Preorder traversal order pseudo-code

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

### Inorder traversal order pseudo-code

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

### Postorder traversal order pseudo-code

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

### Get a size of a binary search tree pseudo-code
```
size(root):
    if root == null: return 0
    else return size(root.left) + size(root.right) + 1
```
