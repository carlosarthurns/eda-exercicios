import java.util.ArrayList;
public class Busca {
    private Node root;
    public static void main(String[] args) {
        
    }

    private boolean isEmpty() {
        return this.root == null;
    }

    public ArrayList<Integer> search(int v) {
        ArrayList<Integer> out = new ArrayList<>();
        if (isEmpty()) return null;
        Node currNode = this.root;
        out.add(currNode.v);

        while (currNode != null) {
            if (currNode.v == v) {
                out.add(currNode.v);
                return out;
            } if (v < currNode.v) { 
                out.add(currNode.v);
                currNode = currNode.left;
            } else if (v > currNode.v) {
                out.add(currNode.v);
                currNode = currNode.right;
            }
        }

        return out;
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
}

class Node {
    int v;
    Node left;
    Node right;
    Node parent;

    public Node(int v) {
        this.v = v;
    }
}