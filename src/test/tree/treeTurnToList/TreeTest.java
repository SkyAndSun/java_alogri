package test.tree.treeTurnToList;

/**
 * 测试
 */
public class TreeTest {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insertNode(10);
        binaryTree.insertNode(14);
        binaryTree.insertNode(6);
        binaryTree.insertNode(8);
        binaryTree.insertNode(12);
        binaryTree.insertNode(4);
        binaryTree.insertNode(16);
        //打印二叉树的中序遍历结果，以查看插入函数是否正确
        binaryTree.inorderTraverse(binaryTree.getRoot());
        System.out.println("------------------");
        //将树转换为链表
        binaryTree.reverse();
        //将转换后的结果打印出来
        binaryTree.display();
    }
}
