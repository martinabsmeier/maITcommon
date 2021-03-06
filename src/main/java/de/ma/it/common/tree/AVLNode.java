/*
 * This class implements AVL trees nodes.
 * Copyright (C) 2012 Martin Absmeier, IT Consulting Services
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package de.ma.it.common.tree;

/**
 * This class implements AVL trees nodes.
 * <p>
 * AVL tree nodes implement all the logical structure of the tree. Nodes are
 * created by the {@link AVLTree AVLTree} class.
 * </p>
 * <p>
 * The nodes are not independant from each other but must obey specific
 * balancing constraints and the tree structure is rearranged as elements
 * are inserted or deleted from the tree. The creation, modification and
 * tree related navigation methods have therefore restricted access. Only
 * the order-related navigation, reading and delete methods are public.
 * </p>
 * 
 * @see AVLTree
 * @author Martin Absmeier
 */
public class AVLNode<T extends Comparable<T>> {

	/** Element contained in the current node. */
	private T element;

	/** Left sub-tree. */
	private AVLNode<T> leftNode;

	/** Right sub-tree. */
	private AVLNode<T> rightNode;

	/** Parent tree. */
	private AVLNode<T> parentNode;

	/** Balance factor. */
	private Balance balance;

	/**
	 * Build a node for a specified element.
	 * 
	 * @param element
	 *            element
	 * @param parentNode
	 *            parentNode node
	 */
	public AVLNode(final T element, final AVLNode<T> parent) {
		this.element = element;
		this.leftNode = null;
		this.rightNode = null;
		this.parentNode = parent;
		this.balance = Balance.BALANCED;
	}

	/**
	 * Delete the node from the tree.
	 */
	public void delete() {
		if ((getParentNode() == null) && (getLeftNode() == null) && (getRightNode() == null)) {
			// this was the last node, the tree is now empty
			this.element = null;
		} else {
			AVLNode<T> node;
			AVLNode<T> child;
			boolean leftShrunk;
			if ((getLeftNode() == null) && (getRightNode() == null)) {
				node = this;
				this.element = null;
				leftShrunk = node == node.getParentNode().getLeftNode();
				child = null;
			} else {
				node = (getLeftNode() != null) ? getLeftNode().getLargest() : getRightNode().getSmallest();
				this.element = node.getElement();
				leftShrunk = node == node.getParentNode().getLeftNode();
				child = (node.getLeftNode() != null) ? node.getLeftNode() : node.getRightNode();
			}

			node = node.getParentNode();
			if (leftShrunk) {
				node.leftNode = child;
			} else {
				node.rightNode = child;
			}
			if (child != null) {
				child.parentNode = node;
			}

			while (leftShrunk ? node.rebalanceLeftShrunk() : node.rebalanceRightShrunk()) {
				if (node.getParentNode() == null) {
					return;
				}
				leftShrunk = node == node.getParentNode().getLeftNode();
				node = node.getParentNode();
			}
		}
	}

	/**
	 * Get the contained element.
	 * 
	 * @return element contained in the node
	 */
	public T getElement() {
		return element;
	}

	/**
	 * Get the node whose element is the largest one in the tree rooted at
	 * this node.
	 * 
	 * @return the tree node containing the largest element in the tree
	 *         rooted at this node or null if the tree is empty
	 * @see #getSmallest
	 */
	public AVLNode<T> getLargest() {
		AVLNode<T> node = this;
		while (node.getRightNode() != null) {
			node = node.getRightNode();
		}
		return node;
	}

	public AVLNode<T> getLeftNode() {
		return leftNode;
	}

	/**
	 * Get the node containing the next larger or equal element.
	 * 
	 * @return node containing the next larger or equal element (in which
	 *         case the node is guaranteed not to be empty) or null if there
	 *         is no larger or equal element in the tree
	 * @see #getPrevious
	 */
	public AVLNode<T> getNext() {
		if (getRightNode() != null) {
			final AVLNode<T> node = getRightNode().getSmallest();
			if (node != null) {
				return node;
			}
		}
		for (AVLNode<T> node = this; node.getParentNode() != null; node = node.getParentNode()) {
			if (node != node.getParentNode().getRightNode()) {
				return node.getParentNode();
			}
		}

		return null;
	}

	/**
	 * Get the parent node.
	 * 
	 * @return parent node.
	 */
	public AVLNode<T> getParentNode() {
		return parentNode;
	}

	/**
	 * Get the node containing the next smaller or equal element.
	 * 
	 * @return node containing the next smaller or equal element or null if
	 *         there is no smaller or equal element in the tree
	 * @see #getNext
	 */
	public AVLNode<T> getPrevious() {
		if (getLeftNode() != null) {
			final AVLNode<T> node = getLeftNode().getLargest();
			if (node != null) {
				return node;
			}
		}
		for (AVLNode<T> node = this; node.getParentNode() != null; node = node.getParentNode()) {
			if (node != node.getParentNode().getLeftNode()) {
				return node.getParentNode();
			}
		}

		return null;
	}

	public AVLNode<T> getRightNode() {
		return rightNode;
	}

	/**
	 * Get the node whose element is the smallest one in the tree rooted at
	 * this node.
	 * 
	 * @return the tree node containing the smallest element in the tree
	 *         rooted at this node or null if the tree is empty
	 * @see #getLargest
	 */
	public AVLNode<T> getSmallest() {
		AVLNode<T> node = this;
		while (node.getLeftNode() != null) {
			node = node.getLeftNode();
		}
		return node;
	}

	/**
	 * Insert an element in a sub-tree.
	 * 
	 * @param newElement
	 *            element to insert
	 * @return true if the parentNode tree should be re-Balance.BALANCED
	 */
	public boolean insert(final T newElement) {
		if (newElement.compareTo(getElement()) < 0) {
			// the inserted element is smaller than the node
			if (getLeftNode() == null) {
				this.leftNode = new AVLNode<T>(newElement, this);
				return rebalanceLeftGrown();
			}
			return getLeftNode().insert(newElement) ? rebalanceLeftGrown() : false;
		}

		// the inserted element is equal to or greater than the node
		if (getRightNode() == null) {
			this.rightNode = new AVLNode<T>(newElement, this);
			return rebalanceRightGrown();
		}
		
		return getRightNode().insert(newElement) ? rebalanceRightGrown() : false;
	}

	/**
	 * Re-balance the instance as leftNode sub-tree has grown.
	 * 
	 * @return true if the parentNode tree should be reSkew.BALANCED too
	 */
	private boolean rebalanceLeftGrown() {
		switch (this.balance) {
		case LEFT_HIGH:
			if (getLeftNode().balance == Balance.LEFT_HIGH) {
				rotateClockwise();
				this.balance = Balance.BALANCED;
				getRightNode().balance = Balance.BALANCED;
			} else {
				final Balance tmpBalance = getLeftNode().rightNode.balance;
				this.leftNode.rotateCounterClockwise();
				rotateClockwise();
				switch (tmpBalance) {
				case LEFT_HIGH:
					getLeftNode().balance = Balance.BALANCED;
					getRightNode().balance = Balance.RIGHT_HIGH;
					break;
				case RIGHT_HIGH:
					getLeftNode().balance = Balance.LEFT_HIGH;
					getRightNode().balance = Balance.BALANCED;
					break;
				default:
					getLeftNode().balance = Balance.BALANCED;
					getRightNode().balance = Balance.BALANCED;
				}
				this.balance = Balance.BALANCED;
			}
			return false;
		case RIGHT_HIGH:
			this.balance = Balance.BALANCED;
			return false;
		default:
			this.balance = Balance.LEFT_HIGH;
			return true;
		}
	}

	/**
	 * Re-balance the instance as leftNode sub-tree has shrunk.
	 * 
	 * @return true if the parentNode tree should be reSkew.BALANCED too
	 */
	private boolean rebalanceLeftShrunk() {
		switch (balance) {
		case LEFT_HIGH:
			this.balance = Balance.BALANCED;
			return true;
		case RIGHT_HIGH:
			if (getRightNode().balance == Balance.RIGHT_HIGH) {
				rotateCounterClockwise();
				this.balance = Balance.BALANCED;
				getLeftNode().balance = Balance.BALANCED;
				return true;
			} else if (getRightNode().balance == Balance.BALANCED) {
				rotateCounterClockwise();
				this.balance = Balance.LEFT_HIGH;
				getLeftNode().balance = Balance.RIGHT_HIGH;
				return false;
			} else {
				final Balance tmpBalance = getRightNode().getLeftNode().balance;
				getRightNode().rotateClockwise();
				rotateCounterClockwise();
				switch (tmpBalance) {
				case LEFT_HIGH:
					getLeftNode().balance = Balance.BALANCED;
					getRightNode().balance = Balance.RIGHT_HIGH;
					break;
				case RIGHT_HIGH:
					getLeftNode().balance = Balance.LEFT_HIGH;
					getRightNode().balance = Balance.BALANCED;
					break;
				default:
					getLeftNode().balance = Balance.BALANCED;
					getRightNode().balance = Balance.BALANCED;
				}
				this.balance = Balance.BALANCED;
				return true;
			}
		default:
			this.balance = Balance.RIGHT_HIGH;
			return false;
		}
	}

	/**
	 * Re-balance the instance as rightNode sub-tree has grown.
	 * 
	 * @return true if the parentNode tree should be reSkew.BALANCED too
	 */
	private boolean rebalanceRightGrown() {
		switch (balance) {
		case LEFT_HIGH:
			this.balance = Balance.BALANCED;
			return false;
		case RIGHT_HIGH:
			if (getRightNode().balance == Balance.RIGHT_HIGH) {
				rotateCounterClockwise();
				this.balance = Balance.BALANCED;
				getLeftNode().balance = Balance.BALANCED;
			} else {
				final Balance tmpBalance = getRightNode().getLeftNode().balance;
				getRightNode().rotateClockwise();
				rotateCounterClockwise();
				switch (tmpBalance) {
				case LEFT_HIGH:
					getLeftNode().balance = Balance.BALANCED;
					getRightNode().balance = Balance.RIGHT_HIGH;
					break;
				case RIGHT_HIGH:
					getLeftNode().balance = Balance.LEFT_HIGH;
					getRightNode().balance = Balance.BALANCED;
					break;
				default:
					getLeftNode().balance = Balance.BALANCED;
					getRightNode().balance = Balance.BALANCED;
				}
				this.balance = Balance.BALANCED;
			}
			return false;
		default:
			this.balance = Balance.RIGHT_HIGH;
			return true;
		}
	}

	/**
	 * Re-balance the instance as rightNode sub-tree has shrunk.
	 * 
	 * @return true if the parentNode tree should be reSkew.BALANCED too
	 */
	private boolean rebalanceRightShrunk() {
		switch (balance) {
		case RIGHT_HIGH:
			this.balance = Balance.BALANCED;
			return true;
		case LEFT_HIGH:
			if (getLeftNode().balance == Balance.LEFT_HIGH) {
				rotateClockwise();
				this.balance = Balance.BALANCED;
				getRightNode().balance = Balance.BALANCED;
				return true;
			} else if (getLeftNode().balance == Balance.BALANCED) {
				rotateClockwise();
				this.balance = Balance.RIGHT_HIGH;
				getRightNode().balance = Balance.LEFT_HIGH;
				return false;
			} else {
				final Balance tmpBalance = getLeftNode().getRightNode().balance;
				this.leftNode.rotateCounterClockwise();
				rotateClockwise();
				switch (tmpBalance) {
				case LEFT_HIGH:
					getLeftNode().balance = Balance.BALANCED;
					getRightNode().balance = Balance.RIGHT_HIGH;
					break;
				case RIGHT_HIGH:
					getLeftNode().balance = Balance.LEFT_HIGH;
					getRightNode().balance = Balance.BALANCED;
					break;
				default:
					getLeftNode().balance = Balance.BALANCED;
					getRightNode().balance = Balance.BALANCED;
				}
				this.balance = Balance.BALANCED;
				return true;
			}
		default:
			this.balance = Balance.LEFT_HIGH;
			return false;
		}
	}

	/**
	 * Perform a clockwise rotation rooted at the instance.
	 * <p>
	 * The balance factor are not updated by this method, they <em>must</em>
	 * be updated by the caller
	 * </p>
	 */
	private void rotateClockwise() {
		final T tmpElement = getElement();
		this.element = getLeftNode().getElement();
		getLeftNode().element = tmpElement;

		final AVLNode<T> tmpNode = getLeftNode();
		this.leftNode = tmpNode.getLeftNode();
		tmpNode.leftNode = tmpNode.getRightNode();
		tmpNode.rightNode = getRightNode();
		this.rightNode = tmpNode;

		if (getLeftNode() != null) {
			getLeftNode().parentNode = this;
		}
		if (getRightNode().getRightNode() != null) {
			getRightNode().getRightNode().parentNode = getRightNode();
		}
	}

	/**
	 * Perform a counter-clockwise rotation rooted at the instance.
	 * <p>
	 * The balance factor are not updated by this method, they <em>must</em>
	 * be updated by the caller
	 * </p>
	 */
	private void rotateCounterClockwise() {
		final T tmpElement = getElement();
		this.element = getRightNode().getElement();
		getRightNode().element = tmpElement;

		final AVLNode<T> tmpNode = getRightNode();
		this.rightNode = tmpNode.getRightNode();
		tmpNode.rightNode = tmpNode.getLeftNode();
		tmpNode.leftNode = getLeftNode();
		this.leftNode = tmpNode;

		if (getRightNode() != null) {
			getRightNode().parentNode = this;
		}
		if (getLeftNode().getLeftNode() != null) {
			getLeftNode().getLeftNode().parentNode = getLeftNode();
		}
	}

	/**
	 * Get the number of elements of the tree rooted at this node.
	 * 
	 * @return number of elements contained in the tree rooted at this node
	 */
	public int size() {
		return 1 + ((getLeftNode() == null) ? 0 : getLeftNode().size()) + ((getRightNode() == null) ? 0 : getRightNode().size());
	}

}