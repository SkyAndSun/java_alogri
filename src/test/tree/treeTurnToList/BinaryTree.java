package test.tree.treeTurnToList;

import java.util.ArrayList;

/**
 * 典型的排序二叉树
 */
public class BinaryTree {
    private Node root; //根节点
    private ArrayList<Node> list = new ArrayList<>(); //存放链表

    //往二叉树中插入数据
    public void insertNode(int data){
        Node node = new Node(data);
        if (root == null ){
           root = node;
        }else{
            Node current = root;
            Node parent = root;
            boolean isLeft = true;
            while(current != null){
                parent = current;
                // 数值比当前结点的大， 插入右边 ，反之，插入左边
                if (current.getData() < data){
                    current = current.getRight();
                    isLeft = false;
                }else{
                    current = current.getLeft();
                    isLeft = true;
                }
            }
            if (isLeft)
                parent.setLeft(node);
            else
                parent.setRight(node);
        }
    }

    // 中序遍历，同时将元素插入到链表中
    public void inorderTraverse(Node node){
        if (node != null){
            inorderTraverse(node.getLeft());
            System.out.print(node.getData() + "  ");
            list.add(node);
            inorderTraverse(node.getRight());
        }
    }

    // 转换为双向链表
    public void reverse(){
        int length = list.size();
        for (int i = 0; i < length; i++) {
            if (i-1 < 0){   // 对于第一个元素，其左右孩子都是右孩子
                list.get(i).setLeft(list.get(i+1));
                list.get(i).setRight(list.get(i+1));
            }
            if (i+1>=length){ //对于最后一个元素，其左右孩子都是左孩子
                list.get(i).setLeft(list.get(i-1));
                list.get(i).setRight(list.get(i-1));
            }
            if (i-1>=0 && i+1<length){
                list.get(i).setLeft(list.get(i-1));
                list.get(i).setRight(list.get(i+1));
            }
        }
    }

    //将牌号的双向链表输出
    public void display(){
        Node node = list.get(0);
        int number = list.size();
        while(number > 0){
            System.out.println("data="+ node.getData()+",previous="+node.getLeft().getData()+",next="+node.getRight().getData());
            node = node.getRight();
            number --;
        }
    }


    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public ArrayList<Node> getList() {
        return list;
    }

    public void setList(ArrayList<Node> list) {
        this.list = list;
    }
}
