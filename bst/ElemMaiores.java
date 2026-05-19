import java.util.ArrayList;
import java.util.Scanner;

public class ElemMaiores {
    private Node root;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] values = sc.nextLine().split(" ");
        int examinado = sc.nextInt();

        ElemMaiores bst = new ElemMaiores();

        int numsMaiores = 0;
        for (String v : values) {
            int a = Integer.parseInt(v);
            if (a > examinado) numsMaiores++;
            bst.add(a);
        }

        System.out.println(bst.preOrder());
        System.out.println(numsMaiores);
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

    public ArrayList<Integer> preOrder() {
        ArrayList<Integer> out = new ArrayList<>();
        preOrder(this.root, out);
        return out;
    }

    private void preOrder(Node n, ArrayList<Integer> lista) {
        if (n != null) {
            lista.add(n.v);
            preOrder(n.left, lista);
            preOrder(n.right, lista);
        }
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
