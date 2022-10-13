import java.lang.management.ThreadMXBean;

public class BinarySearchTree {
  TreeNode root;

  public void insert(TreeNode node){
    this.root = insertHelper(this.root, node);
  }
  private TreeNode insertHelper(TreeNode rootValue, TreeNode node){
    int value = node.data;
    if(rootValue == null) {
      rootValue = node;
      return rootValue;
    }else if(value < rootValue.data) {
      rootValue.left = insertHelper(rootValue.left, node); 
    }else{
      rootValue.right = insertHelper(rootValue.right, node);
    }
    return rootValue;
  }

  public void display(){
    displayHelper(this.root);
  }
  private void displayHelper(TreeNode thisRoot){
    if (thisRoot != null) {
      displayHelper(thisRoot.left);
      System.out.println(thisRoot.data);
      displayHelper(thisRoot.right);
    }
  }

  public boolean search(int value){
    return searchHelper(this.root, value);
  }
  private boolean searchHelper (TreeNode root, int value){
    if (root == null){
      return false;
    }else if(root.data == value){
      return true;
    }else if(root.data > value){
      return searchHelper(root.left , value);
    }else{
      return searchHelper(root.right, value);
    }
  }


  public void remove (int value){
    if(search(value)){
      removeHelper(this.root, value);
    }else{
      System.out.println(value+" could not be found");
    }
  }
  private TreeNode removeHelper(TreeNode root, int value){
    if(root == null){//break point, just make sure we remove the element
      return root;
    }else if(value < root.data) {//..
      root.left = removeHelper(root.left, value);
    }else if(value > root.data) {//同search一樣,睇value大細去比path去個object
      root.right = removeHelper(root.right, value);
    }else{//not found//因為root.left or root.right 唔會大小於自己,所以一定會去到else,即係揾到依行;
      //作用,因為remove左value,會令到tree下面既value link唔到上面,但自己就null左,咁就有問題
      if (root.left == null && root.right == null){//下面冇其他path,所以可以null左去,即remove value from this null
        root = null;
        //下面係左右邊有野
      }else if(root.right != null) {//found successor to replace this node 
        root.data = successor(root);
        root.right = removeHelper(root.right, root.data);
      }else {//found predecessor to replace this node 
        root.data = predecessor(root);
        root.left = removeHelper(root.left, root.data);
      }
    }
    return root;
  }

  private int successor(TreeNode root){//find the least value below the right child of this root node 
    root = root.right;
    while(root.left != null){
      root=root.left;
    }
    return root.data;
  }
  private int predecessor(TreeNode root){//find the greatest value below the right child of this root node 
    root = root.left;
    while(root.right != null){
      root=root.right;
    }
    return root.data;
  }
}
