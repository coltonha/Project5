/**
 *  Project: #5
 *  Source Code File:BinaryTreeBasis.java
 *  Author: Sungwoong Ha
 *  Description: This is java implementation of BinaryTreeBasis.
 *  Due: 5/13/21
 */

package project5;

public abstract class BinaryTreeBasis {
	protected TreeNode root;
	
	//default constructor creates null
	public BinaryTreeBasis(){
		root = null;
	}
	
	//constructor to create start of tree
	public BinaryTreeBasis(Person rootNode){
		root = new TreeNode(rootNode);
	}
	
	public boolean isEmpty(){
		//returns true if tree is empty else returns false
		return root == null;
	}
	
	public void makeEmpty(){
		//removes all nodes from tree
		root = null;
	}
	
	public Person getRootItem() throws TreeException{
		if(root==null){
			throw new TreeException( "Tree Exception: Empty Tree");
		}else{
			return root.getItem();
		}
	}
	public abstract void setRootItem(Person newItem);
	

}
