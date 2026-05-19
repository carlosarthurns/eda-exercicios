import java.util.ArrayList;
import java.util.Scanner;

public class RemocaoBst {
    private Node root;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] valores = sc.nextLine().split(" ");
        String[] removidos = sc.nextLine().split(" ");
        RemocaoBst bst = new RemocaoBst();

        for (String v : valores)
            bst.add(Integer.parseInt(v));

        for (String r : removidos) {
            int num = Integer.parseInt(r);
            Node target = bst.remove(num);
            if (bst.isEmpty()) {
                System.out.println("null");
                return;
            } else {
                System.out.println(bst.preOrder());
            } 

        }

    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void add(int element) {
        if (isEmpty())
            this.root = new Node(element);
        else {            
            Node aux = this.root;            
            while (aux != null) {                
                if (element < aux.value) {
                    if (aux.left == null) { 
                        Node newNode = new Node(element);
                        aux.left = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    
                    aux = aux.left;
                } else {
                    if (aux.right == null) { 
                        Node newNode = new Node(element);
                        aux.right = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    
                    aux = aux.right;
                }
            }
        }        
    }

    public ArrayList<Integer> preOrder() {
        ArrayList<Integer> saida = new ArrayList<>();
        preOrder(this.root, saida);
        return saida;
    }

    private void preOrder(Node n, ArrayList<Integer> lista) {
        if (n != null) {
            lista.add(n.value);
            preOrder(n.left,lista);
            preOrder(n.right,lista);
        }
    }

    public Node search(int v) {
        if (isEmpty()) return null;
        Node curr = this.root;

        while (curr != null) {
            if (v == curr.value) return curr;
            if (v > curr.value) curr = curr.right;
            else if (v < curr.value) curr = curr.left;
        }

        return null;
    }

    public Node remove(int valor) {
        Node target = search(valor);
        if (target == null) return null;
        return remove(target);
    }

    private Node remove(Node target) {
        if (isLeaf(target)) {
            if (this.root == target) this.root = null;
            else {
                if (target.value < target.parent.value) target.parent.left = null;
                else                            target.parent.right = null;
            }
        } else if (hasOnlyLeftChild(target)) {
            if (this.root == target) {
                this.root = target.left;
                target.parent = null;
            } else {
                if (target.value < target.parent.value) target.parent.left = target.left;
                else                            target.parent.right = target.left;

                target.left.parent = target.parent;
            }
        } else if (hasOnlyRightChild(target)) {
            if (this.root == target) {
                this.root = target.right;
                target.parent = null;
            } else {
                if (target.value < target.parent.value) target.parent.left = target.right;
                else                            target.parent.right = target.right;

                target.right.parent = target.parent;
            }
        } else {
            Node next = next(target);
            remove(next);
            target.value = next.value;
        }

        return target;
    }

    private boolean isLeaf(Node n) {
        return (n.right == null) && (n.left == null);
    }

    private boolean hasOnlyLeftChild(Node n) {
        return (n.right == null) && (n.left != null);
    }

    private boolean hasOnlyRightChild(Node n) {
        return (n.right != null) && (n.left == null);
    }

    private Node next(Node n) {
        if (n.right != null) return min(n.right);
        else {
            Node curr = n.parent;
            
            while (curr != null && curr.value < n.value)
                curr = curr.parent;

            return curr;
        }
    }

    private Node min(Node n) {
        Node curr = n;
    
        while (curr.left != null)
            curr = curr.left;
    
        return curr;
    }

}

class Node {
    int value;
    Node parent;
    Node right;
    Node left;

    public Node(int v) {
        this.value = v;
    }
}