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