import java.util.Scanner;

class SomaFolhas {
    private Node root;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] lista = sc.nextLine().split(" ");

        SomaFolhas bst =  new SomaFolhas();

        for (String l : lista)
            bst.add(Integer.parseInt(l));

        System.out.println(bst.somaFolhas());
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

    public int somaFolhas() {
        return somaFolhas(this.root);
    }

    private int somaFolhas(Node node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return node.v;
        return somaFolhas(node.left) + somaFolhas(node.right);
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