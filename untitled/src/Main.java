public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();
        tree.put(10, "Sample1");
        tree.put(5, "Sample2");
        tree.put(15, "Sample3");
        tree.put(3, "Sample4");
        tree.put(8, "Sample5");
        tree.put(13, "Sample6");
        tree.put(18, "Sample7");
//        tree.delete(10);
//        tree.delete(8);
//        tree.delete(15);
//        System.out.println(tree.get(10));
//        System.out.println(tree.get(5));
//        System.out.println(tree.get(15));
//        System.out.println(tree.get(3));
//        System.out.println(tree.get(8));
//        System.out.println(tree.get(13));
//        System.out.println(tree.get(18));
//        System.out.println(tree.getSize());
        for (MyArray i : tree.iterator()) {
            System.out.println("key:" + i.getKey() + " value:" + i.getVal());
        }
    }
}