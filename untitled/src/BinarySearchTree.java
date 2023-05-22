public class BinarySearchTree <K extends Comparable<K>, V> {
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
        Node currentNode = rootNode;
        if(get(key) == null)
            return;
        while(true) {
            if(key.compareTo(currentNode.key) < 0)
                currentNode = currentNode.left;
            else if(key.compareTo(currentNode.key) > 0)
                currentNode = currentNode.right;
            else
                break;
        }
        if(currentNode.left == null) {
            currentNode.key = currentNode.right.key;
            currentNode.val = currentNode.right.val;
            currentNode.left = currentNode.right.left;
            currentNode.right = currentNode.right.right;
            size--;
        }
        else if(currentNode.right == null){
            currentNode.key = currentNode.left.key;
            currentNode.val = currentNode.left.val;
            currentNode.right = currentNode.left.right;
            currentNode.left = currentNode.left.left;
            size--;
        }
        else {
            Node buffNode = currentNode.left;
            while(buffNode.left.left != null){
                buffNode = buffNode.left;
            }
            currentNode.key = buffNode.left.key;
            currentNode.val = buffNode.left.val;
            buffNode.left = null;
            size--;
        }
    }
    public Iterable<K> iterator(){
        return null;
    }
}
