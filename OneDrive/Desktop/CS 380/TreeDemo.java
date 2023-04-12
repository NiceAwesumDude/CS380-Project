class Node{
   int value;
   Node left, right;
   
   public Node(int value){
      this.value = value;
      left = null;
      right = null;
   }

}

class BinarySearchTree{

   Node root;
   
   
   /*
   recursive insert method
   */
   public Node insert(Node root, int value){
      //base case
      if(root == null){
         root = new Node(value);
         return root;
      }
      
      //recursive step
      if(value < root.value){
         root.left = insert(root.left, value); 
      }else{
         root.right = insert(root.right, value);
      }
      
      return root;
   }
   
   
   
   /*
   pre-order traversal
   */
   public void preOrderTraversal(Node root){
      //implement me
      if(root == null){
         return;
      }
      System.out.print(root.value + ", ");
      preOrderTraversal(root.left);
      preOrderTraversal(root.right);
   }

   
   
   /*
   in-order traversal
   */
   public void inOrderTraversal(Node root){
      //implement me
      if(root == null){
         return;
      }
      inOrderTraversal(root.left);
      System.out.print(root.value + ", ");
      inOrderTraversal(root.right);
   }
   
   
   
   /*
   post-order traversal
   */
   public void postOrderTraversal(Node root){
      //implement me
      if(root == null){
         return;
      }
      postOrderTraversal(root.left);
      postOrderTraversal(root.right);
      System.out.print(root.value + ", ");

   }
   
   
   
   /*
   a method to find the node in the tree
   with a specific value
   */
   public boolean find(Node root, int key){
	  //implement me
     if(root == null){
      return false;
     }
     if(root.value == key){
      return true;
     }
     if(key < root.value){
      find(root.left, key);
     }
      return find(root.right, key);
   
                 
   }
   
   
   
   /*
   a method to find the node in the tree
   with a smallest key
   */
   public int getMin(Node root){
      //implement me
     if(root == null){
      System.out.println("empty tree");
     }
     if(root.left == null){
      return root.value;
     }
     return getMin(root.left);

   }
  
  
  
   /*
   a method to find the node in the tree
   with a largest key
   */
   public int getMax(Node root){
	  //implement me
     if(root == null){
      System.out.println("Empty tree");
     }
     if(root.right == null){
      return root.value;
     }
     return getMax(root.right);
   }
   
   
   
   /*
   this method will not compile until getMax
   is implemented
   */
   public Node delete(Node root, int key){
      
      if(root == null){
         return root;
      }else if(key < root.value){
         root.left = delete(root.left, key);
      }else if(key > root.value){
         root.right = delete(root.right, key);
      }else{
         //node has been found
         if(root.left==null && root.right==null){
            //case #1: leaf node
            root = null;
         }else if(root.right == null){
            //case #2 : only left child
            root = root.left;
         }else if(root.left == null){
            //case #2 : only right child
            root = root.right;
         }else{
            //case #3 : 2 children
            root.value = getMax(root.left);
            root.left = delete(root.left, root.value);
         }
      }
      return root;  
   }
   
   
   
}

public class TreeDemo{
   public static void main(String[] args){
      BinarySearchTree t1  = new BinarySearchTree();
      t1.root = t1.insert(t1.root,24);
      t1.root = t1.insert(t1.root,80);
      t1.root = t1.insert(t1.root,18);
      t1.root = t1.insert(t1.root,9);
      t1.root = t1.insert(t1.root,90);
      t1.root = t1.insert(t1.root,22);

      System.out.print("pre-order :   ");
      t1.preOrderTraversal(t1.root);
      System.out.println();
            
      System.out.print("in-order :   ");
      t1.inOrderTraversal(t1.root);
      System.out.println();

      System.out.print("post-order :   ");
      t1.postOrderTraversal(t1.root);
      System.out.println();
           
      
   }  
}