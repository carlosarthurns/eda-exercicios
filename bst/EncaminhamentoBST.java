import java.util.ArrayList;
import java.util.Scanner;

public class EncaminhamentoBST {
    private Node root;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] values = sc.nextLine().split(" ");
        EncaminhamentoBST bst = new EncaminhamentoBST();

        for (String v : values) 
            bst.add(Integer.parseInt(v));

        System.out.println(bst.preOrder());
        System.out.println(bst.Order());
        System.out.println(bst.posOrder());
    }

    private boolean isEmpty() {
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
    public ArrayList<Integer> Order() {
        ArrayList<Integer> saida = new ArrayList<>();
        order(this.root, saida);
        return saida;
    }

    private void order(Node n, ArrayList<Integer> lista) {
        if (n != null) {
            order(n.left,lista);
            lista.add(n.value);            
            order(n.right,lista);
        }
    }

    public ArrayList<Integer> posOrder() {
        ArrayList<Integer> saida = new ArrayList<>();
        posOrder(this.root, saida);
        return saida;
    }

    private void posOrder(Node n, ArrayList<Integer> lista) {
        if (n != null) {            
            posOrder(n.left,lista);
            posOrder(n.right,lista);
            lista.add(n.value);
        }
    }
}

class Node {
    int value;
    Node left;
    Node right;
    Node parent;

    public Node(int v) {
        this.value = v;
    }
}