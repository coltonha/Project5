package project5;

public class TreeNode {
    private Person person;
    private TreeNode leftChild;
    private TreeNode rightChild;
    
    public TreeNode() {
        person = null;
        leftChild = null;
        rightChild = null;
    }
    public TreeNode(Person newPerson) {
        person=newPerson;
        leftChild = null;
        rightChild = null;
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
