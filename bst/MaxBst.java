import java.util.Scanner;

public class MaxBst {
    private Node root;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] values = sc.nextLine().split(" ");
        MaxBst bst = new MaxBst();

        for (String v : values)
            bst.add(Integer.parseInt(v));

        System.out.println(bst.max());
    }

    public void add(int value) {
        Node newNode = new Node(value);
        if (this.root == null) {
            this.root = newNode;
        } else {
            Node curr = this.root;
            while (curr != null) {
                if (value > curr.v) {
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

    public String max() {
        String out = "";

        Node curr = this.root;
        while (curr != null) {
            out += curr.v + " ";
            curr = curr.right;
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
