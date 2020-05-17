public class DeleteBinarySearchTree {
    public class Node {
        private int key;
        private Node left, right;

        public Node(int key) {
            this.key = key;
            left = null;
            right = null;
        }
    }

    private Node root;

    public DeleteBinarySearchTree() {
        this.root = null;
    }

    private Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        return root;
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }

    //Hàm thực hiện việc sắp xếp, in và Duyệt trung tố cây nhị phân
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    //Phương thức gọi hàm sắp xếp trung tố
    public void inorder() {
        inorderRec(root);
    }

    //xoa
    private Node deleteRec(Node root, int key) {
        if (root == null) return root;

        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);

        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.key = minValue(root.right);

            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    private int minValue(Node root) {
        int minV = root.key;
        if (root.left != null) {
            minV = root.left.key;
            root = root.left;
        }
        return minV;
    }

    public void delete(int key) {
        root = deleteRec(root, key);
    }
}
