package project5;

public class BinaryTreeBasis {
    private TreeNode root;
    
    public BinaryTreeBasis(){
        root=null;
    } //end default constructor
    
    public BinaryTreeBasis(String rootItem){
        root=new TreeNode(rootItem);
    }//end constructor

    public boolean isEmpty() {
        // Returns true if the tree is empty, else returns false.
        return root == null;
    } // end isEmpty
    
    public void makeEmpty() {
        // Removes all nodes from the tree.
        root = null;
    } // end makeEmpty
    
    public T getRootItem() throws TreeException {
        // Returns the item in the tree’s root.
        if (root == null) {
            throw new TreeException("TreeException: Empty tree");
        }
        
        else {
            return root.item;
        } // end if
    } // end getRootItem
}
