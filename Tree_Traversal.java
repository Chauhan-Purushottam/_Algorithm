/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree_traversal;

/**
 *
 * @author purusho
 */
import java.util.*;
import java.util.LinkedList;

public class Tree_Traversal {
    
    public static class Node{
        
        int data;
         Node left,right;
         public Node(int item)
         {
             data = item;
             left=null;
             right=null;
         }
    }
    
    public static class Tree
    {
        Node root;
        
        public static Node insert(Node root,int data){
                if(root==null){

                   return new Node(data);
                }
                else{
                    Node current;
                    if(data<root.data){
                        current = insert(root.left,data);
                        root.left = current;
                    }
                    else{
                        current = insert(root.right,data);
                        root.right = current;
                    }
                    return root;
                }
                
           
        }
        
        public static void Inorder(Node t)
        {
            if(t!=null){
                
                Inorder(t.left);
                System.out.print(t.data+" ");
                Inorder(t.right);
            }
        }
        public static void Preorder(Node t)
        {
            if(t!=null){
                System.out.print(t.data+" ");
                Preorder(t.left);
                Preorder(t.right);
            }
        }
        
        public static void Postorder(Node t)
        {
            if(t!=null)
            {
                
                Postorder(t.left);
                Postorder(t.right);
                System.out.print(t.data+" ");
            }
        }
        public static void levelOrder(Node t)
        {
            Queue <Node> q = new LinkedList<>();
            q.add(t);
            while(!q.isEmpty()){
                Node tmp = q.poll();
                System.out.print(tmp.data+" ");
                if(tmp.left!=null){
                    q.add(tmp.left);
                }
                if(tmp.right!=null){
                    q.add(tmp.right);
                }
            }
        }
        public static void doubleOrder(Node t){
            if(t!=null)
            {
                System.out.print(t.data+" ");
                doubleOrder(t.left);
                System.out.print(t.data+" ");
                doubleOrder(t.right);
            }
        }
        
        public static void tripleOrder(Node t){
            if(t!=null)
            {
                System.out.print(t.data+" ");
                tripleOrder(t.left);
                System.out.print(t.data+" ");
                tripleOrder(t.right);
                System.out.print(t.data+" ");
            }
        }
                
        

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    Scanner sc = new Scanner(System.in);
       //Tree t = new Tree();     static method can be accessed by class name also
        Node root= null;
        System.out.println("**************Enter no of element in the tree**************");
        int n = sc.nextInt();
        System.out.println("************Enter "+ n + " element contains in tree*******************");
        while(n-->0)
        {
            int data = sc.nextInt();
            root = Tree.insert(root,data);
        }
        System.out.print("*****************Pre order traversal of the tree is:-**************\n");
        Tree.Preorder(root);
        System.out.print("\n");
        
        System.out.print("*****************In order traversal of the tree is:-****************\n");
        Tree.Inorder(root);
        System.out.print("\n");
        
        System.out.print("*****************Post order traversal of the tree is:-***************\n");
        Tree.Postorder(root);
        System.out.print("\n");
        
        System.out.print("*****************Level order traversal of the tree is:-***************\n");
        Tree.levelOrder(root);
        System.out.print("\n");
        
        System.out.print("*****************Double order traversal of the tree is:-**************\n");
        Tree.doubleOrder(root);
        System.out.print("\n");
        
        System.out.print("*****************Triple order traversal of the tree is:-**************\n");
        Tree.tripleOrder(root);
        System.out.print("\n");
        sc.close();

        
    }
    
}
