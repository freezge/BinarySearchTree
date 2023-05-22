# ADS Assignment 5
### Assignment 5 | Binary Search Tree
### Task
```
Implement Binary Search Tree (50%)

Add size (10%)

Implement in-order traversal for iterator() (20%)

Make it possible for both key and value to be accessible during the iteration (10%)

Github repo (10%)
```
### Code for Main
```
public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();
        tree.put(10, "Sample1");//test
        tree.put(5, "Sample2");//test
        tree.put(15, "Sample3");//test
        tree.put(3, "Sample4");//test
        tree.put(8, "Sample5");//test
        tree.put(13, "Sample6");//test
        tree.put(18, "Sample7");//test
//        tree.delete(10);//test
//        tree.delete(8);//test
//        tree.delete(15);//test
//        System.out.println(tree.get(10));//test
//        System.out.println(tree.get(5));//test
//        System.out.println(tree.get(15));//test
//        System.out.println(tree.get(3));//test
//        System.out.println(tree.get(8));//test
//        System.out.println(tree.get(13));//test
//        System.out.println(tree.get(18));//test
//        System.out.println(tree.getSize());//test
        for (MyArray i : tree.iterator()) {//test
            System.out.println("key:" + i.getKey() + " value:" + i.getVal());
        }
    }
}
```
### Code for BinarySearchTree
```
import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree <K extends Comparable<K>, V> {
    BinarySearchTree(){}//constructor
    private Node rootNode;//main node of binary tree
    private int size;//for size
    private class Node{
        private K key;//key of node
        private V val;//value of node
        private Node left, right;//children
        public Node(K key, V val){//constructor
            this.key = key;
            this.val = val;
        }
    }
    public void put(K key, V val){//insert new data into binary tree
        Node currentNode = rootNode;
        if (rootNode == null){//for first insert
            size++;
            rootNode = new Node(key,val);
            return;
        }
        while(true) {//to find where we're inserting to
            if(key.compareTo(currentNode.key) < 0){//if lower we go left
                if (currentNode.left == null){//if left is empty we create new
                    currentNode.left = new Node(key, val);
                    size++;
                    break;
                }
                currentNode = currentNode.left;
            }
            else if(key.compareTo(currentNode.key) > 0){//if higher we go right
                if(currentNode.right == null){//if right is empty we create new
                    currentNode.right = new Node(key, val);
                    size++;
                    break;
                }
                currentNode = currentNode.right;
            }
            else {//if equal we found our value
                currentNode.val = val;
                break;
            }
        }
    }
    public V get(K key){//get value from binary tree through key
        Node currentNode = rootNode;
        while(currentNode != null){//doing the same thing from put
            if(key.compareTo(currentNode.key) < 0){
                currentNode = currentNode.left;
            }
            else if(key.compareTo(currentNode.key) > 0){
                currentNode = currentNode.right;
            }
            else{
                return currentNode.val;
            }
        }
        return null;
    }
    public void delete(K key){//to remove from binary tree
        if(get(key) == null)//checking if key exists
            return;
        if (size == 1){//checking if it's the first node
            rootNode = null;
            return;
        }
        Node currentNode = rootNode;
        Node parentNode = currentNode;
        while(true) {//to find our value
            if(key.compareTo(currentNode.key) < 0){
                parentNode = currentNode;//saving parent to remove needed value
                currentNode = currentNode.left;
            }
            else if(key.compareTo(currentNode.key) > 0){
                parentNode = currentNode;//saving parent to remove needed value
                currentNode = currentNode.right;
            }
            else
                break;
        }
        if(currentNode.left == null && currentNode.right == null){//if parent is childless
            if(key.compareTo(parentNode.key) < 0){//to understand which one we delete
                parentNode.left = null;
            }
            else if(key.compareTo(parentNode.key) > 0){//to understand which one we delete
                parentNode.right = null;
            }
            size--;
        }
        else if(currentNode.left == null) {//if only right child
            currentNode.key = currentNode.right.key;//changing key
            currentNode.val = currentNode.right.val;//changing value
            if (currentNode.right.left != null)
                currentNode.left = currentNode.right.left;//changing references
            if (currentNode.right.right != null)
                currentNode.right = currentNode.right.right;//changing references
            else
                currentNode.right = null;
            size--;
        }
        else if(currentNode.right == null){//if only left child
            currentNode.key = currentNode.left.key;//changing key
            currentNode.val = currentNode.left.val;//changing value
            if (currentNode.left.right != null)
                currentNode.right = currentNode.left.right;//changing references
            if (currentNode.left.left != null)
                currentNode.left = currentNode.left.left;//changing references
            else
                currentNode.left = null;
            size--;
        }
        else {
            Node parentBuffNode = currentNode;//if parent has 2 children
            Node buffNode = currentNode.right;//to take right child's minimal value
            while(buffNode.left != null){//loop
                parentBuffNode = buffNode;
                buffNode = buffNode.left;
            }
            currentNode.key = parentBuffNode.left.key;//changing key
            currentNode.val = parentBuffNode.left.val;//changing value
            parentBuffNode.left = null;//removing right child's minimal value
            size--;
        }
    }
    public int getSize(){//to get size
        return size;
    }
    public Iterable<MyArray<K,V>> iterator(){
        List<MyArray<K, V>> arr = new ArrayList<>();
        inOrderTraversal(rootNode, arr);//inorder traversal to collect key+value
        return arr;//iterable collection of key+value
    }
    private void inOrderTraversal(Node node, List<MyArray<K, V>> arr) {
        if (node != null) {
            inOrderTraversal(node.left, arr);//left subtree
            arr.add(new MyArray<>(node.key, node.val));//add the key+value to the list
            inOrderTraversal(node.right, arr);//right subtree
        }
    }
}
```
### Code for MyArray
```
public class MyArray <K,V> {//class for key value of nodes in binary tree
    private K key;
    private V val;
    public MyArray(K key, V val){//constructor for pairs
        this.key = key;
        this.val = val;
    }
        public K getKey() {//getter for key
            return key;
        }
        public V getVal() {//getter for value
            return val;
        }
}
```
