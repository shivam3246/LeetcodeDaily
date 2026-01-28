import java.util.*;
public class BinaryTrees {
   static class Node{
        int data;
        Node left;
        Node right;
        public Node(int item){
            this.left = null;
            this.right = null;
            this.data = item;
        }
    }
    Node root;
    //Left->Root->Right
    static void printInOrder(Node node){
        if(node==null){
            return;
        }
        printInOrder(node.left);
        System.out.print(node.data+" ");
        printInOrder(node.right);
    }
    //Root->left->Right
    void printPreOrder(Node node){
        if(node==null){
            return;
        }
        System.out.println(node.data+" ");
        printPreOrder(node.left);
        printPreOrder(node.right);

    }
    //left->right->root
    void printPostOrder(Node node){
        if(node==null){
            return;
        }
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.println(node.data+" ");
    }
    void iterativeInOrder(Node root){
        if(root==null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        //Left-root-right
        Node curr = root;
        while(curr!=null || !stack.isEmpty()){
            //Reach the left most of the current node
            while(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            //Process the node
            stack.pop();
            System.out.println(curr.data+ " ");
            curr = curr.right;
        }
    }
    void levelOrder(Node root){
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node temp = q.poll();
            System.out.println(temp.data+" ");
            if(temp.left!=null){
                q.add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
            }
        }
    }
    public static void main(String[] args) {
        BinaryTrees t = new BinaryTrees();
        t.root = new Node(1);
        t.root.left = new Node(2);
        t.root.right = new Node(3);
        t.root.left.left = new Node(4);
        t.root.left.right = new Node(5);
        printInOrder(t.root);
    }
    
}
