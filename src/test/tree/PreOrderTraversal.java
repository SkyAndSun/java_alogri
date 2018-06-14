package test.tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * 前序遍历
 *
 1.对于前序遍历，每当访问一个结点时，先打印结点。
 2.如果存在右子树，那么将右子树的根节点进行进栈保存，否则忽略。
 3.如果存在左子树，将遍历引用指向左子树根节点，否则出栈回溯。
 4.循环的退出条件是需要出栈操作时，栈为空，无法进行该操作。
 */
public class PreOrderTraversal {

    private static Stack<Node> stack = new Stack<Node>();
    private static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        Node root = TreeUtil.makeTree();
        preOrerTraversal(root);
        System.out.println(result);
    }

    private static void preOrerTraversal(Node root){
        Node currentNode = root;
        while(true){
            saveResultNode(currentNode);
            if (currentNode.right != null){
                stack.push(currentNode.right);
            }
            if (currentNode.left != null){
                currentNode = currentNode.left;
            } else {
                try{
                    currentNode = stack.pop();
                }catch (EmptyStackException e){
                    currentNode = null;
                }
            }

            if (currentNode == null)
                break;
        }
    }

    private static void saveResultNode(Node node) { //保存需要打印的结点
        result.add(node.value);
    }
}
