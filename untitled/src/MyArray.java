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
