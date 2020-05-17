public class Main {
    public static void main(String[] args) {
        DeleteBinarySearchTree tree=new DeleteBinarySearchTree();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        /* Let us create following BST
             50
          /     \
         30      70
        /  \    /  \
       20   40  60   80 */

        System.out.println("Truoc khi xoa 70: ");
        tree.inorder();
        System.out.println("\nSau khi xoa 70: ");
        tree.delete(70);
        tree.inorder();
    }
}
