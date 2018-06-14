package test.tree.binaryTree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 节点的数据结构定义
 *
 *  * 1. 求二叉树中的节点个数: getNodeNumRec（递归），getNodeNum（迭代）
 * 2. 求二叉树的深度: getDepthRec（递归），getDepth
 * 3. 前序遍历，中序遍历，后序遍历: preorderTraversalRec, preorderTraversal, inorderTraversalRec, postorderTraversalRec
 * (https://en.wikipedia.org/wiki/Tree_traversal#Pre-order_2)
 * 4.分层遍历二叉树（按层次从上往下，从左往右）: levelTraversal, levelTraversalRec（递归解法！）
 * 5. 将二叉查找树变为有序的双向链表: convertBST2DLLRec, convertBST2DLL
 * 6. 求二叉树第K层的节点个数：getNodeNumKthLevelRec, getNodeNumKthLevel
 * 7. 求二叉树中叶子节点的个数：getNodeNumLeafRec, getNodeNumLeaf
 * 8. 判断两棵二叉树是否相同的树：isSameRec, isSame
 * 9. 判断二叉树是不是平衡二叉树：isAVLRec
 * 10. 求二叉树的镜像（破坏和不破坏原来的树两种情况）：mirrorRec, mirrorCopyRec
 * 10.1 判断两个树是否互相镜像：isMirrorRec
 * 11. 求二叉树中两个节点的最低公共祖先节点：getLastCommonParent, getLastCommonParentRec, getLastCommonParentRec2
 * 12. 求二叉树中节点的最大距离：getMaxDistanceRec
 * 13. 由前序遍历序列和中序遍历序列重建二叉树：rebuildBinaryTreeRec
 * 14.判断二叉树是不是完全二叉树：isCompleteBinaryTree, isCompleteBinaryTreeRec
 *
 *
 */
public class Node {


    // 定义树
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }

    /**
     * 求二叉树中的节点个数递归解法： O(n)
     * 1.如果二叉树为空，节点个数为 0
     * 2.如果二叉树不为空，二叉树节点个数 = 左子树节点个数 + 右子树节点个数 + 1
     */
    public static int getNodeNumRec(TreeNode root){
        if (root == null )
            return 0;
        else
            return getNodeNumRec(root.left) + getNodeNumRec(root.right) + 1;
    }

    /**
     * 求二叉树中节点个数迭代解法 O(n)  基本思想同LevelOrderTraversal，
     *  即用一个Queue，在Java里面可以用LinkedList来模拟
     */
    public static int getNodeNum(TreeNode root){
        if (root == null)
            return 0;
        int count = 1;
        Queue<TreeNode> queue = new LinkedList<>();// 队列，先进先出
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode cur = queue.remove(); //从队头位置移除
            if (cur.left != null){ // 如果有左孩子，加到队尾
                queue.add(cur.left);
                count ++;
            }
            if (cur.right != null ){
                queue.add(cur.right); //如果有 右孩子，加到队尾
                count ++;
            }
        }
        return count;
    }

    /**
     * 求二叉树的深度（高度） 递归解法：O(n)
     * 1.如果二叉树为空，二叉树的深度为0、
     * 2.如果二叉树不为空，二叉树的深度 = max(左子树深度，右子树深度）+1
     */
    public static int getDeptRec(TreeNode root){
        if (root == null)
            return 0;

        int leftDept = getDeptRec(root.left);
        int rightDept = getDeptRec(root.right);
        return Math.max(leftDept, rightDept) +1;
    }

    /**
     * 求二叉树的深度（高度） 迭代解法： O(n)
     * 基本思想同LevelOrderTraversal，还是用一个Queue
     */
    public static int getDepth(TreeNode root){
        if (root == null)
            return 0;

        int depth = 0; //深度
        int currentLevelNodes = 1; // 当前Level， node的数量
        int nextLeveNodes = 0; // 下一层level，node的数量

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.remove(); //从对头开始移除
            currentLevelNodes --; // 减少当前Level node 的数量
            if (cur.left != null ){ // 如果右左孩子，加到队尾
                queue.add(cur.left);
                nextLeveNodes ++; // 并增加下一层Level node 的数量
            }
            if (cur.right != null ){
                queue.add(cur.right);
                nextLeveNodes ++;
            }

            if(currentLevelNodes == 0){// 说明已经遍历完当前层的所有节点
                depth ++; // 增加深度
                currentLevelNodes = nextLeveNodes; // 初始化下u一层的遍历
                nextLeveNodes = 0;
            }
        }
        return depth;
    }

    /**
     * 前序遍历，中序遍历，后序遍历 前序遍历递归解法：
     * （1）如果二叉树为空，空操作
     * （2）如果二叉树不为空，访问根节点，前序遍历左子树，前序遍历右子树
     */
    public static void preorderTraversalRec(TreeNode root){
        if (root == null)
            return;
        System.out.print(root.val+" ");
        preorderTraversalRec(root.left);
        preorderTraversalRec(root.right);
    }


    /**
     *  前序遍历迭代解法：用一个辅助stack，总是把右孩子放进栈
     *  http://www.youtube.com/watch?v=uPTCbdHSFg4
     */
    public static void preorderTraversal(TreeNode root){
        if(root == null)
            return;

        Stack<TreeNode> stack = new Stack<>(); //辅助stack
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode cur = stack.pop(); // 出栈栈顶元素
            System.out.print(cur.val + " ");

            //关键点： 要先压入右孩子，在压入左孩子， 这样在出栈的时候会先打印左孩子 再打印右孩子
            if(cur.right != null )
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
    }

    /**
     * 中序遍历递归解法
     * （1）如果二叉树为空，空操作。
     * （2）如果二叉树不为空，中序遍历左子树，访问根节点，中序遍历右子树
     */
    public static void inorderTraversalRec(TreeNode root){
        if (root == null)
            return;

        inorderTraversalRec(root.left);
        System.out.print(root.val+" ");
        inorderTraversalRec(root.right);
    }

    /**
     * 中序遍历迭代解法 ，用栈先把根节点的所有左孩子都添加到栈内，
     * 然后输出栈顶元素，再处理栈顶元素的右子树
     * http://www.youtube.com/watch?v=50v1sJkjxoc
     *
     * 还有一种方法能不用递归和栈，基于线索二叉树的方法，较麻烦以后补上
     * http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
     */
    public static void inorderTraversal(TreeNode root){
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while(true){
            while(cur != null){ // 先添加一个非空节点所有的左孩子到栈
                stack.push(cur);
                cur = cur.left;
            }

            if (stack.isEmpty())
                break;

            // 因为此时已经没有左孩子了，所以输出栈顶元素
            cur = stack.pop();
            System.out.print(cur.val + " ");
            cur = cur.right; // 准备处理右zishu
        }
    }

    /**
     * 后序遍历递归解法
     * （1）如果二叉树为空，空操作
     * （2）如果二叉树不为空，后序遍历左子树，后序遍历右子树，访问根节点
     */
    public static void postorderTraversalRec(TreeNode root) {
        if (root == null)
            return;

        postorderTraversalRec(root.left);
        postorderTraversalRec(root.right);
        System.out.print(root.val + " ");
    }

    /**
     *  后序遍历迭代解法
     *  http://www.youtube.com/watch?v=hv-mJUs5mvU
     *
     */
    public static void postorderTraversal(TreeNode root){
        if (root== null)
            return;

        Stack<TreeNode> s = new Stack<>(); // 第一个stack 用于添加node 和 它的左右孩子
        Stack<TreeNode> output = new Stack<>(); // 第二个stack 用于翻转第一个stack输出

        s.push(root);

        while(!s.isEmpty()){ // 确保所有元素都 被翻转转移到第二个stack
            TreeNode cur = s.pop(); // 把栈顶元素添加到第二个stack
            output.push(cur);

            if (cur.left != null) // 把栈顶元素的左孩子 和 右孩子 分别添加入第一个satack
                s.push(cur.left);

            if (cur.right != null )
                s.push(cur.right);
        }

        while(! output.isEmpty()){
            //遍历输出第二个 stack，即为后序遍历
            System.out.print(output.pop().val + " ");
        }

    }

    /**
     * 分层遍历二叉树（按层次从上往下，从左往右）迭代
     * 相当于广度优先搜索，使用队列实现。队列初始化，将根节点压入队列。当队列不为空，进行如下操作：弹出一个节点
     * ，访问，若左子节点或右子节点不为空，将其压入队列
     */
    public static void levelTraversal(TreeNode root){
        if (root == null)
            return;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);

        while(!queue.isEmpty()){
            TreeNode cur = queue.removeFirst();
            System.out.print(cur.val + " ");
            if(cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }

    }




    /**
     *  分层遍历二叉树（递归）
     *  很少有人会用递归去做level traversal
     *  基本思想是用一个大的ArrayList，里面包含了每一层的ArrayList。
     *  大的ArrayList的size和level有关系
     *
     *  这是我目前见到的最好的递归解法！
     *  http://discuss.leetcode.com/questions/49/binary-tree-level-order-traversal#answer-container-2543
     */
    public static void levelTraversalRec(TreeNode root){
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        dfs(root, 0, ret);
        System.out.println(ret);
    }

    private static void dfs(TreeNode root, int level,  ArrayList<ArrayList<Integer>> ret){
        if (root == null)
            return;

        //添加一个新的ArrayList表示新的一层
        if (level >= ret.size()){
            ret.add(new ArrayList<Integer>());
        }

        ret.get(level).add(root.val); // 把节点添加到表示那一层的ArrayList里
        dfs(root.left,level+1, ret);    // 递归处理下一层的左子树和右子树
        dfs(root.right, level+1, ret);
    }



    /**
     * 将二叉查找树变为有序的双向链表 要求不能创建新节点，只调整指针。
     * 递归解法：
     * 参考了http://stackoverflow.com/questions/11511898/converting-a-binary-search-tree-to-doubly-linked-list#answer-11530016
     * 感觉是最清晰的递归解法，但要注意递归完，root会在链表的中间位置，因此要手动
     * 把root移到链表头或链表尾
     */
    public static TreeNode convertBST2DLLRec(TreeNode root){
        root = convertBST2DLLSubRec(root);

        // root会在链表的中间位置，因此要手动把root移到链表头
        while (root.left != null )
            root = root.left;
        return root;
    }

    /**
     * 递归转换 BST 为 双向链表 （DLL)
     */
    public static TreeNode convertBST2DLLSubRec(TreeNode root){
        if (root == null || (root.left== null && root.right == null))
            return root;

        TreeNode tmp = null;
        if (root.left != null ){
            tmp = convertBST2DLLSubRec(root.left);  // 处理左子树
            while(tmp.right != null){   // 寻找最右节点
                tmp = tmp.right;
            }
            tmp.right = root;   // 把左子树处理后结果和root链接
            root.left = tmp;
        }

        if (root.right != null){    // 处理左子树
            tmp = convertBST2DLLSubRec(root.right);
            while(tmp.left != null){    // 寻找最左节点
                tmp = tmp.left;
            }
            tmp.left = root;    // 把右子树处理后结果和root链接
            root.right = tmp;
        }
        return root;
    }

    /**
     * 将二叉查找树变为有序的双向链表，迭代解法
     *
     */
    public static TreeNode convertBST2DLL(TreeNode root){
        if (root == null)
            return null;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;    // 指向当前处理节点
        TreeNode old = null;    // 指向前一个处理的节点
        TreeNode head = null;   // 链表头

        while(true){
            while(cur != null ){    // 先添加一个非空节点所有的左孩子到栈
                stack.push(cur);
                cur = cur.left;
            }

            if (stack.isEmpty())
                break;

            // 因为此时已经没有左孩子了，所以输出栈顶元素
            cur = stack.pop();
            if (old != null){
                old.right = cur;
            }
            // 第一个节点为双向链表头节点
            if (head == null ){
                head = cur;
            }

            old = cur;  // 更新old
            cur = cur.right;    // 准备处理右子树
        }
        return head;
    }


    /**
     * 求二叉树第K层的节点个数   递归解法：
     * （1）如果二叉树为空或者k<1返回0
     * （2）如果二叉树不为空并且k==1，返回1
     * （3）如果二叉树不为空且k>1，返回root左子树中k-1层的节点个数与root右子树k-1层节点个数之和
     *
     * 求以root为根的k层节点数目 等价于 求以root左孩子为根的k-1层（因为少了root那一层）节点数目 加上
     * 以root右孩子为根的k-1层（因为少了root那一层）节点数目
     *
     * 所以遇到树，先把它拆成左子树和右子树，把问题降解
     *
     */
    public static int getNodeNumKthLevelRec(TreeNode root, int k){
        if (root == null || k<1)
            return 0;

        if (k==1)
            return 1;

        int numLeft = getNodeNumKthLevelRec(root.left, k-1);   // 求root左子树的k-1层节点数
        int numRight = getNodeNumKthLevelRec(root.right, k-1);  // 求 root右子树的k-1层节点数
        return numLeft + numRight;
    }

    /**
     * 求二叉树第k层的节点个数 迭代解法
     * @param root
     * @param k
     * @return
     */
    public static int getNodeNumKthLevel(TreeNode root, int k){
        if (root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        int currentLevelNodes = 1;  // 当前Level， node的数量
        int nextLevelNodes = 0;     // 下一层Level，node的数量

        while (!queue.isEmpty() && i<k){
            TreeNode cur = queue.remove();  // 从队头位置移除
            currentLevelNodes --;   // 减少当前Level node的数量
            if (cur.left != null){  // 如果有左孩子，加到队尾
                queue.add(cur.left);
                nextLevelNodes ++;  // 并增加下一层Level node的数量
            }
            if (cur.right != null){
                queue.add(cur.right);
                nextLevelNodes ++;
            }

            if (currentLevelNodes == 0){    // 说明已经遍历完当前层的所以节点
                currentLevelNodes = nextLevelNodes; // 初始化下一层的遍历
                nextLevelNodes = 0;
                i++;    // 进入下一层
            }
        }
        return currentLevelNodes;
    }


    /**
                1
               / \
              2   3
             / \   \
            4  5   6
    */
    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        TreeNode r6 = new TreeNode(6);

        r1.left = r2;
        r1.right = r3;
        r2.left = r4;
        r2.right = r5;
        r3.right = r6;

//        System.out.println(getNodeNumRec(r1));
//        System.out.println(getNodeNum(r1));
//        System.out.println(getDeptRec(r1));
//        System.out.println(getDepth(r1));
//        preorderTraversalRec(r1);
//        preorderTraversal(r1);
//        inorderTraversalRec(r1);
//        inorderTraversal(r1);
//        postorderTraversalRec(r1);
//        postorderTraversal(r1);
//        levelTraversal(r1);
//        levelTraversalRec(r1);
     /*   TreeNode tmp = convertBST2DLLRec(r1);
        while(true){
            if (tmp == null)
                break;
            System.out.print(tmp.val + " ");
            if (tmp.right == null)
                break;
            tmp = tmp.right;
        }
*/
        /*TreeNode t = convertBST2DLL(r1);
        while(true){
            if (t == null)
                break;
            System.out.print(t.val + " ");
            if (t.right == null)
                break;
            t = t.right;
        }*/

//        System.out.println(getNodeNumKthLevelRec(r1,2));
        System.out.println(getNodeNumKthLevel(r1,2));
    }
}
