import java.util.*;

public class BFS {
    private Node root;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] lista = sc.nextLine().split(" ");

        BFS bfs = new BFS();

        for (String l : lista)
            bfs.add(Integer.parseInt(l));

        System.out.println(bfs.printBFS());
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

    public String printBFS() {
        LinkedList<Node> out = new LinkedList<Node>();
        String saida = "";

        if (!isEmpty()) {
            out.addLast(this.root);
            while (!out.isEmpty()) {
                Node curr = out.removeFirst();

                saida += curr.v + " ";

                if (curr.left != null) out.addLast(curr.left);
                if (curr.right != null) out.addLast(curr.right);
            }
        }

        return saida.trim();
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
