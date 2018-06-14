package test.tree.treeTurnToList;

/**
 * 节点类，定义节点的数据结构
 */
public class Node {
    private int data;
    private Node left;
    private Node right;

    public Node(){}

    public Node(int data){
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
