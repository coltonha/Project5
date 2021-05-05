package project5;

public class PhoneBook extends BinaryTreeBasis{
    public PhoneBook() {

    }
    public PhoneBook(Person rootItem){
        super(rootItem);
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

	public void delete(String searchKey) throws TreeException {
		root = deleteItem(root, searchKey);
	}

	public void delete(Person item) throws TreeException {
		root = deleteItem(root, item.getKey());
	}

	public void change(String searchKey, String newPhone){
		retrieve(searchKey).setPhoneNumber(newPhone);
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
		if (newItem.getKey().compareTo(nodeItem.getKey()) < 0) { //compareTo works on String(keyeditem) lexicographically
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
			if (searchKey.compareTo(nodeItem.getKey()) == 0) {
				// item is in the root of some subtree
				treeItem = tNode.getItem();
			} else if (searchKey.compareTo(nodeItem.getKey()) < 0) {
				// search the left subtree
				treeItem = retrieveItem(tNode.getLeftChild(), searchKey);
			} else { // search the right subtree
				treeItem = retrieveItem(tNode.getRightChild(), searchKey);
			}
		}
		return treeItem;
	}

    protected TreeNode deleteItem(TreeNode tNode, String searchKey) {
		// calls delete Node
		TreeNode newSubtree;
		if (tNode == null) {
			throw new TreeException("TreeException:Item is now found");
		} else {
			Person nodeItem = tNode.getItem();
			if (searchKey.compareTo(nodeItem.getKey()) == 0) {
				// item is in the root of some subtree
				tNode = deleteNode(tNode); // delete the item
			}
			// else search for the item
			else if (searchKey.compareTo(nodeItem.getKey()) < 0) {
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
