/**
 *  Project: #5
 *  Source Code File:PhoneBook.java
 *  Author: Sungwoong Ha
 *  Description: This is java implementation of BST PhoneBook.
 *  Due: 5/13/21
 */
package project5;

import java.io.*;
import java.util.ArrayList;

public class PhoneBook {
	protected TreeNode root;

	public PhoneBook() {
		root=null;
    }
    public PhoneBook(Person rootItem){
		root = new TreeNode(rootItem);
    }
    //end constructor*/;
	public void setRootItem(Person newItem) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
    
    public void insert(Person newItem) {
		root = insertItem(root, newItem);
	}

	public Person retrieve(String searchKey) {
		return retrieveItem(root, searchKey);
	}

	public void delete(String searchKey) throws Exception {
		root = deleteItem(root, searchKey);
	}

	public void delete(Person item) throws Exception {
		root = deleteItem(root, item.getName());
	}
	public void readtree(ArrayList<Person> arr, int start , int end){
		root=readTree(arr, start, end);
	}

	public void change(String searchKey, String newPhone){
		retrieve(searchKey).setPhoneNumber(newPhone);
	}
	
    public void printPreorder() throws Exception {
		printPreorder(root); 
	}
	public void printInorder() throws Exception {
		printInorder(root); 
	}

	protected TreeNode readTree(ArrayList<Person> arr, int start , int end){
        /* Base Case */
        if (start > end) {
            return null;
        }
        /* Get the middle element and make it root */
        int mid = (start + end) / 2;
        TreeNode tNode = new TreeNode(arr.get(mid));
        /* Recursively construct the left subtree and make it
         left child of root */
        tNode.setLeftChild(readTree(arr, start, mid - 1));
        /* Recursively construct the right subtree and make it
         right child of root */
        tNode.setRightChild(readTree(arr, mid + 1, end));
          
        return tNode;
	}

	protected void printInorder(TreeNode node) throws Exception
    {
        if (node == null)
            return;
        /* first print left subtree */
        printInorder(node.getLeftChild());
		/* then recur on data of node */
		FileOutputStream fos=new FileOutputStream("Phonebook.txt",true);
		PrintWriter pw=new PrintWriter(fos);
		pw.println(node.getItem().toString());
		pw.close();
        /* now recur on right subtree */
        printInorder(node.getRightChild());
    }

	protected void printPreorder(TreeNode node) throws Exception
    {
        if (node == null)
            return;
 		FileOutputStream fos=new FileOutputStream("Phonebook.txt",true);
		PrintWriter pw=new PrintWriter(fos);
        /* first print data of node */
        pw.println(node.getItem().toString());
 		pw.close();
        /* then recur on left sutree */
        printPreorder(node.getLeftChild());
 
        /* now recur on right subtree */
        printPreorder(node.getRightChild());
		
    }

    protected TreeNode insertItem(TreeNode tNode, Person newItem) {
		TreeNode newSubtree;
		if (tNode == null) {
			// position of insertion found; insert after leaf
			// create a new node
			tNode = new TreeNode(newItem);
			return tNode;
		}
		Person nodeItem = tNode.getItem();
		// search for the insertion position
		if (newItem.getName().compareTo(nodeItem.getName()) < 0) { //compareTo works on String(keyeditem) lexicographically
			// search the left subtree
			newSubtree = insertItem(tNode.getLeftChild(), newItem);
			tNode.setLeftChild(newSubtree);
			return tNode;
		} else { // search right treee
			newSubtree = insertItem(tNode.getRightChild(), newItem);
			tNode.setRightChild(newSubtree);
			return tNode;
		}

	}

    protected Person retrieveItem(TreeNode tNode, String searchKey) {
		Person treeItem;
		if (tNode == null) {
			treeItem = null;
		} else {
			Person nodeItem = tNode.getItem();
			if (searchKey.compareTo(nodeItem.getName()) == 0) {
				// item is in the root of some subtree
				treeItem = tNode.getItem();
			} else if (searchKey.compareTo(nodeItem.getName()) < 0) {
				// search the left subtree
				treeItem = retrieveItem(tNode.getLeftChild(), searchKey);
			} else { // search the right subtree
				treeItem = retrieveItem(tNode.getRightChild(), searchKey);
			}
		}
		return treeItem;
	}

    protected TreeNode deleteItem(TreeNode tNode, String searchKey) throws Exception {
		// calls delete Node
		TreeNode newSubtree;
		if (tNode == null) {
			throw new Exception();
		} else {
			Person nodeItem = tNode.getItem();
			if (searchKey.compareTo(nodeItem.getName()) == 0) {
				// item is in the root of some subtree
				tNode = deleteNode(tNode); // delete the item
			}
			// else search for the item
			else if (searchKey.compareTo(nodeItem.getName()) < 0) {
				newSubtree = deleteItem(tNode.getLeftChild(), searchKey);
				tNode.setLeftChild(newSubtree);
			} else {// search the right tree
				newSubtree = deleteItem(tNode.getRightChild(), searchKey);
				tNode.setRightChild(newSubtree);

			}
		}
		return tNode;
	}
	
	protected TreeNode deleteNode(TreeNode tNode) {
		// Algorithm note: there are four cases to consider:
		// the Tnode is a leaf
		// the Tnode has no left child
		// the Tnode has no right child
		// The Tnode has two Children
		// Call: findLeftMost and deleteLeftMost
		Person replacementItem;

		// test for a leaf
		if ((tNode.getLeftChild() == null) && (tNode.getRightChild() == null)) {
			return null;
		}

		// test for no left child
		else if (tNode.getLeftChild() == null) {
			return tNode.getRightChild();
		}// end if no left child

		// test for no right child
		else if (tNode.getRightChild() == null) {
			return tNode.getLeftChild();
		}
		// there are two children
		else {
			replacementItem = findLeftmost(tNode.getRightChild());
			tNode.setItem(replacementItem);
			tNode.setRightChild(deleteLeftmost(tNode.getRightChild()));
			return tNode;
		}
	}

    /**
	 * Travels down tree from root asking: is there a left child 
	 * if there is a left child it continues until reaching a leaf
	 */
	protected Person findLeftmost(TreeNode tNode) {
		if (tNode.getLeftChild() == null) {
			return tNode.getItem();
		} else {
			return findLeftmost(tNode.getLeftChild());
		}
	}

	/**
	 * finds left most child until reaching a leaf and deletes that item
	 */
	protected TreeNode deleteLeftmost(TreeNode tNode) {
		if (tNode.getLeftChild() == null) {
			return tNode.getRightChild();
		} else {
			tNode.setLeftChild(deleteLeftmost(tNode.getLeftChild()));
			return tNode;
		}
	}


}//end BST Phonebook
