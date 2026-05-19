import java.util.Scanner;

public class MinBst {
    private Node root;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] lista = sc.nextLine().split(" ");
        MinBst bst = new MinBst();

        for (String l : lista)
            bst.add(Integer.parseInt(l));

        System.out.println(bst.min());
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
                if (v > curr.v) {
                    
                    if (curr.right == null) {
                        curr.right = newNode;
                        return;
                    }

                    curr = curr.right;
                } else {

                    if (curr.left == null) {
                        curr.left = newNode;
                        return;
                    }

                    curr = curr.left;
                }
            }
        }
    }

    public String min() {
        String out = "";

        Node curr = this.root;
        while (curr != null) { 
            out += curr.v + " ";
            curr = curr.left;
        }

        return out.trim();
    }
}

class Node {
    int v;
    Node right;
    Node left;

    public Node(int v) {
        this.v = v;
    }
}
