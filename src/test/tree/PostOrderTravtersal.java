package test.tree;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.HashSet;
import java.util.Stack;

/**
 * 后序遍历
 */
public class PostOrderTravtersal {
    private static Stack<Node> stack = new Stack<>();
    private static HashSet<Node> resultsMap = new HashSet<>();
    private static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        Node root = TreeUtil.makeTree();
        postOrderTraversal(root);
        System.out.println(result);
    }

    private static void postOrderTraversal(Node root){
        if (root == null)
            throw new IllegalArgumentException("root should not be null!");
        Node currentNode = root;
        while(true){
            //判断左子树是否被遍历
            //如果左子树为空，则认为左子树被遍历
            if(isLeftSubtreeTraversaled(currentNode)){

                // 同理于左子树
                if(isRightSubtreeTraversaled(currentNode)){
                    saveResultNode(currentNode);
                    try{
                        currentNode = stack.pop();
                    }catch (EmptyStackException e){
                        currentNode = null;
                    }
                }else{
                    stack.push(currentNode);
                    currentNode = currentNode.right;
                }
            }else {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }

            if (currentNode == null )
                break;
        }
    }

    private static void saveResultNode(Node node){
        result.add(node.value);
        resultsMap.add(node);
    }

    private static boolean isRightSubtreeTraversaled(Node node){
        return node.right == null || resultsMap.contains(node.right);
    }

    private static boolean isLeftSubtreeTraversaled(Node node){
        return node.left == null || resultsMap.contains(node.left);
    }
}
