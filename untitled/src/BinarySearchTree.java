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

    }
    public  Iterable<K> iterator(){
        return null;
    }
}
