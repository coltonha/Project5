package project5;

public class TreeNode {
    private Person item;
    private TreeNode leftChild;
    private TreeNode rightChild;
    
    public TreeNode() {
        item = null;
        leftChild = null;
        rightChild = null;
    }
    public TreeNode(Person newItem) {
        item=newItem;
        leftChild = null;
        rightChild = null;
    }
    public TreeNode(Person newItem, TreeNode left, TreeNode right){
		setItem(newItem);
		setLeftChild(left);
		setRightChild(right);
	}

    public Person getItem(){
        return item;
    }
    public void setItem(Person item) {
		this.item = item;
	}

    public void setLeftChild(TreeNode newNode) {
        leftChild = newNode;
    }
    public void setRightChild(TreeNode newNode) {
        rightChild = newNode;
    }
    public TreeNode getLeftChild() {
        return leftChild;
    }
    public TreeNode getRightChild() {
        return rightChild;
    }
}
