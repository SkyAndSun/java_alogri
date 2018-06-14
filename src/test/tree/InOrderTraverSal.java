package test.tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.HashSet;
import java.util.Stack;

/**
 * 中序遍历
 *
 * 中序遍历的遍历顺序为 左子树->根结点->右子树 ，也就是说第一次访问到某个结点时，不会立刻打印当前结点，需要左子树完成后再打印根节点，然后访问右子树。
 * 这样的话，在整个中序遍历的过程中，对于非叶子结点，每个结点需要被访问两次。
 */
public class InOrderTraverSal {
    private static Stack<Node> stack = new Stack<Node>();
    private static HashSet<Node> resultsMap = new HashSet<>();
    private static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args){
        Node root = TreeUtil.makeTree();
        inOrderTraversal(root);
        System.out.println(result);
    }

    private static void inOrderTraversal(Node root){
        Node currentNode = root;
        while(true){
            //判断左子树是否被遍历
            //如果左子树为空，则认为左子树被遍历
            if (isLeftSubtreeTraversaled(currentNode)){
                saveResultNode(currentNode);
                if (currentNode.right != null){
                    currentNode = currentNode.right;
                } else {
                    try{
                        currentNode = stack.pop();
                    } catch (EmptyStackException e){
                        currentNode = null;
                    }
                }
            } else {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }

            if (currentNode == null)
                break;
        }
    }

    /**
     * 将需要打印的结点按顺序保存在result中，同时也记录在resultsMap中。resultsMap可以快速查询出某个结点是否已经被打印。
     * 如果考虑存储空间，可以只用result这个Arraylist来保存结果，代价是查询结点是否被打印时必须要逐个比较整个Arraylist，速度会慢一些。
     */
    private static void saveResultNode(Node node){
        result.add(node.value);
        resultsMap.add(node);
    }

    //
    private static boolean isLeftSubtreeTraversaled(Node node){
        return node.left == null || resultsMap.contains(node.left);
    }
}
