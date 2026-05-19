import java.util.ArrayList;
import java.util.Scanner;

public class ValorProxBst {
    private Node root;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] values = sc.nextLine().split(" ");
        int procurado = sc.nextInt();

        ValorProxBst bst = new ValorProxBst();

        for (String v : values)
            bst.add(Integer.parseInt(v));

        System.out.println(bst.preOrdem());

        System.out.println(bst.closest(procurado));
    }
    private boolean isEmpty() {
        return this.root == null;
    }
    public void add(int value) {
        Node newNode = new Node(value);

        if (isEmpty()) {
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

    public ArrayList<Integer> preOrdem() {
        ArrayList<Integer> out = new ArrayList<>();
        preOrdem(this.root, out);
        return out;
    }

    private void  preOrdem(Node n, ArrayList<Integer> lista) {
        if (n != null) {
            lista.add(n.v);
            preOrdem(n.left, lista);
            preOrdem(n.right, lista);
        }
    }

    public int closest(int v) {
        if (isEmpty()) throw new RuntimeException();

        Node aux = this.root;
        Node closest = aux;
        while (aux != null) {
            if (Math.abs(aux.v - v) < Math.abs(closest.v - v)) closest = aux;

            if (v < aux.v) aux = aux.left;
            else if (v > aux.v) aux = aux.right;
            else break;
        }

        return closest.v;
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
