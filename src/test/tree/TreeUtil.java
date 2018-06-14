package test.tree;

import java.util.ArrayList;

/**
 * 生成二叉树
 */
public class TreeUtil {

    public static Node makeTree(){
        ArrayList<Node> nodes = new ArrayList<>();
        for (int i=0; i<5; i++){
            nodes.add(new Node(i));
        }
        Node root = nodes.get(0);
        root.left = nodes.get(1);
        root.right = nodes.get(2);
        nodes.get(1).left = nodes.get(3);
        nodes.get(1).right = nodes.get(4);
        return root;
    }

    public static void main(String[] args) {
        Node node = makeTree();
        System.out.println(node);
    }
}
