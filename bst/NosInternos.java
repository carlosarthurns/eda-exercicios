import java.util.*;

class NosInternos {
    private Node root;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] lista = sc.nextLine().split(" ");

        NosInternos bst = new NosInternos();
        
        for (String a : lista) 
            bst.add(Integer.parseInt(a));

        System.out.println(bst.contaNos());
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void add(int v) {
        Node newNode = new Node(v);

        if (isEmpty()) {
            this.root = newNode;
        } else {

            Node curr = this.root;

            while (curr != null) {

                if (v > curr.v) {
                    if (curr.right == null) {
                        curr.right = newNode;
                        newNode.parent = curr;
                        return;
                    }

                    curr = curr.right;
                } else {
                    if (curr.left == null) {
                        curr.left = newNode;
                        newNode.parent = curr;
                        return;
                    }

                    curr = curr.left;
                }
            }
        }
    }

    public int contaNos() {
        return contaNos(this.root);
    }

    private int contaNos(Node node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 0;
        return 1 + contaNos(node.right) + contaNos(node.left);
    }
}
class Node {
    int v;
    Node right;
    Node left;
    Node parent;

    public Node(int v) {
        this.v = v;
    }
}
