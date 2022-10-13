public class Main{
  public static void main(String[] arg){
    BinarySearchTree tree = new BinarySearchTree();

    tree.insert(new TreeNode(5));
    tree.insert(new TreeNode(1));
    tree.insert(new TreeNode(9));
    tree.insert(new TreeNode(2));
    tree.insert(new TreeNode(3));

    tree.remove(1); 
    tree.display();

    //System.out.println(tree.search(5));
    //System.out.println(tree.search(4));

  }
}
