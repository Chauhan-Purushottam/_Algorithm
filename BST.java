/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author purushottam
 */

   
//import for Scanner and other utility classes
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

public class BST {
    
    public static class Node{
        int val;
        Node left,right;
        Node(int val)
        {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    
    static Node root = null;
    
    public static Node insert(Node root,int val) {
        if(root == null){
            root = new Node(val);       // Recursive version of insertion in BST
            return root;
        }
        else
        {
            if(val<=root.val){
                root.left = insert(root.left,val);}
            else{
                root.right = insert(root.right,val);}
        }
        return root;
    }
    
    public static Node search(Node root, int val){
        if(root==null || root.val == val){
            return root;}
        if(root.val<val){
            return(search(root.right,val));}
        else{
            return(search(root.left,val));}
            
    }
    
    public static Node delete(Node root,int val){
        if(root == null){
            return root;
        }
        if(root.val<val){
            root.right = delete(root.right,val);
        }
        else if(root.val>val){
            root.left = delete(root.left,val); 
        }
        else{
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            else{
                root.val = minVal(root.right);
                root.right = delete(root.right,root.val);
            }
        }
        return root;
    }
     static int minVal(Node root){
         int minval = root.val;
         while(root.left!=null){
             minval = root.left.val;
             root = root.left; 
         }
        return (minval);
     }
    
    public static void preorder(Node root) {
        if(root!=null)
        {
            System.out.print(root.val+" ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    
    public static void inorder(Node root){
        if(root!=null)
        {
            inorder(root.left);
            System.out.print(root.val+" ");
            inorder(root.right);
        }
    }
    
    public static void postorder(Node root){
        if(root!=null)
        {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.val+" ");
        }
    }
    
    public static int nodeCount(Node count){
            if(count!=null){
                return (1+ nodeCount(count.left)+nodeCount(count.right));
            }
            else{
                return 0;
            }
    }
    public static void main(String args[] ) throws Exception {
        
        
        try (Scanner s = new Scanner(System.in)) {
            System.out.println("Enter the number of Element to insert in the tree");
            int n = s.nextInt();
            for(int i = 0;i<n;i++)
            {
                root = insert(root,s.nextInt());
            }
            System.out.println("Preorder Traversal of BST :- ");
            preorder(root);
            System.out.println("\n inorder Traversal of BST :- ");
            inorder(root);
            System.out.println("\n Postorder Traversal of BST :- ");
            postorder(root);
            System.out.println("\n Number of Node in BST :- " + nodeCount(root));
            System.out.println("Enter the number you want to delete ");
            int num = s.nextInt();
            root = delete(root,num);
            inorder(root);   
            
        }
        }
    }


