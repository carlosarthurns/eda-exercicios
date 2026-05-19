import java.util.*;

class Predecessor{
    private Node root;
    private int size;

    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        
        String[] lista = sc.nextLine().split(" ");
        int buscado = sc.nextInt();
        sc.nextLine();

        Predecessor bst = new Predecessor();

        for (String v : lista) {
            bst.add(Integer.parseInt(v));
        }

        Node n = bst.search(buscado);
        System.out.println(bst.predecessor(n));
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void add(int value) {
        this.size++;

        if (isEmpty()) this.root = new Node(value);
        else {
            Node curr = this.root;
            Node newNode = new Node(value);
            while (curr != null) {
                if (newNode.v > curr.v) {
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

    public ArrayList<Integer> predecessor(Node n) {
        ArrayList<Integer> out = new ArrayList<>();
        out.add(n.v);

        Node curr = n;
        if (curr.left != null) {
            curr = curr.left;
            out.add(curr.v);
            while (curr.right != null) {
                curr = curr.right;
                out.add(curr.v);
            }
        } else {
            while (curr.parent != null) {
                curr = curr.parent;
                out.add(curr.v);
                if (curr.v < n.v) break;
            }
        }

        return out;
    }

    public void printBST() {
        printBST(this.root);
    }

    private void printBST(Node n) {
        if (n == null) return;

        System.out.println(n.v + " ");
        printBST(n.left);
        printBST(n.right);
    }

    public Node search(int value) {
        if (isEmpty()) return null;
        Node curr = this.root;

        while (curr != null) {
            if (curr.v == value) return curr;
            if (curr.v < value) curr = curr.right;
            else curr = curr.left;
        }

        return null;
    }
}

class Node {

    int v;
    Node left;
    Node right;
    Node parent;

    Node(int v) {
        this.v = v;
    }
}
