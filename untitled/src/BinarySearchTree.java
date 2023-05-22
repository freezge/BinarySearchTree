public class BinarySearchTree <K extends Comparable<K>, V> {
    BinarySearchTree(){}
    private Node rootNode;
    private int size;
    private class Node{
        private K key;
        private V val;
        private Node left, right;
        public Node(K key, V val){
            this.key = key;
            this.val = val;
        }
    }
    public void put(K key, V val){
        Node currentNode = rootNode;
        if (rootNode == null){
            size++;
            rootNode = new Node(key,val);
            return;
        }
        while(true) {
            if(key.compareTo(currentNode.key) < 0){
                if (currentNode.left == null){
                    currentNode.left = new Node(key, val);
                    size++;
                    break;
                }
                currentNode = currentNode.left;
            }
            else if(key.compareTo(currentNode.key) > 0){
                if(currentNode.right == null){
                    currentNode.right = new Node(key, val);
                    size++;
                    break;
                }
                currentNode = currentNode.right;
            }
            else {
                currentNode.val = val;
                break;
            }
        }
    }
    public V get(K key){
        Node currentNode = rootNode;
        while(currentNode != null){
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
    public void delete(K key){
        if(get(key) == null)
            return;
        if (size == 1){
            rootNode = null;
            return;
        }
        Node currentNode = rootNode;
        Node parentNode = currentNode;
        while(true) {
            if(key.compareTo(currentNode.key) < 0){
                parentNode = currentNode;
                currentNode = currentNode.left;
            }
            else if(key.compareTo(currentNode.key) > 0){
                parentNode = currentNode;
                currentNode = currentNode.right;
            }
            else
                break;
        }
        if(currentNode.left == null && currentNode.right == null){
            if(key.compareTo(parentNode.key) < 0){
                parentNode.left = null;
            }
            else if(key.compareTo(parentNode.key) > 0){
                parentNode.right = null;
            }
            size--;
        }
        else if(currentNode.left == null) {
            currentNode.key = currentNode.right.key;
            currentNode.val = currentNode.right.val;
            if (currentNode.right.left != null)
                currentNode.left = currentNode.right.left;
            if (currentNode.right.right != null)
                currentNode.right = currentNode.right.right;
            else
                currentNode.right = null;
            size--;
        }
        else if(currentNode.right == null){
            currentNode.key = currentNode.left.key;
            currentNode.val = currentNode.left.val;
            if (currentNode.left.right != null)
                currentNode.right = currentNode.left.right;
            if (currentNode.left.left != null)
                currentNode.left = currentNode.left.left;
            else
                currentNode.left = null;
            size--;
        }
        else {
            Node parentBuffNode = currentNode;
            Node buffNode = currentNode.right;
            while(buffNode.left != null){
                parentBuffNode = buffNode;
                buffNode = buffNode.left;
            }
            currentNode.key = parentBuffNode.left.key;
            currentNode.val = parentBuffNode.left.val;
            parentBuffNode.left = null;
            size--;
        }
    }

    public Iterable<K> iterator(){
        return null;
    }
}
