import java.util.Scanner;

public class AlturaBst {
    private Node root;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] values = sc.nextLine().split(" ");
        AlturaBst bst = new AlturaBst();

        for (String v : values)
            bst.add(Integer.parseInt(v));

        System.out.println(bst.height());
    }

    private boolean isEmpty() {
        return this.root == null;
    }

    public void add(int v) {
        Node newNode = new Node(v);

        if (isEmpty()) {
            this.root = newNode;
        } else {
            Node curr = this.root;

            while (curr != null) {
                if (v < curr.v) {
                    if (curr.left == null) {
                        curr.left = newNode;
                        newNode.parent = curr;
                        return;
                    }

                    curr = curr.left;
                } else {
                    if (curr.right == null) {
                        curr.right = newNode;
                        newNode.parent = curr;
                        return;
                    }

                    curr = curr.right;
                }
            }
        }
    }

    public int height() {
        if (isEmpty()) return -1;
        return Math.max(height(this.root.left), height(this.root.right));
    }

    private int height(Node n) {
        if (n == null) return 0;
        return 1 + Math.max(height(n.left), height(n.right));
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
