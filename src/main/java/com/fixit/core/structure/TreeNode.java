/**
 * 
 */
package com.fixit.core.structure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/12/30 14:07:54 GMT+2
 */
public class TreeNode<T> implements Iterable<TreeNode<T>> {

	private final T data;
	private final TreeNode<T> parent;
	private final List<TreeNode<T>> children;

	public boolean isRoot() {
		return parent == null;
	}

	public boolean isLeaf() {
		return children.size() == 0;
	}

	public TreeNode(T data) {
		this.data = data;
		this.parent = null;
		this.children = new LinkedList<TreeNode<T>>();
	}
	
	private TreeNode(T data, TreeNode<T> parent) {
		this.data = data;
		this.parent = parent;
		this.children = new LinkedList<TreeNode<T>>();
	}

	public TreeNode<T> addChild(T child) {
		TreeNode<T> childNode = new TreeNode<T>(child, this);
		this.children.add(childNode);
		return childNode;
	}

	public int getLevel() {
		if (this.isRoot())
			return 0;
		else
			return parent.getLevel() + 1;
	}

	public T getData() {
		return data;
	}

	public TreeNode<T> getParent() {
		return parent;
	}

	public List<TreeNode<T>> getChildren() {
		return children;
	}
	
	public TreeNode<T> getFirstChild() {
		if(!children.isEmpty()) {
			return children.get(0);
		}
		return null;
	}
	
	public TreeNode<T> getLastChild() {
		if(!children.isEmpty()) {
			return children.get(children.size() - 1);
		}
		return null;
	}
	
	public TreeNode<T> getRoot() {
		TreeNode<T> root = this;
		while(!root.isRoot()) {
			root = root.parent;
		}
		return root;
	}

	@Override
	public String toString() {
		return data != null ? data.toString() : "[data null]";
	}

	@Override
	public Iterator<TreeNode<T>> iterator() {
		TreeNodeIterator<T> iter = new TreeNodeIterator<>(this);
		return iter;
	}
}
