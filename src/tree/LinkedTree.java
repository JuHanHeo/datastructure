package tree;

import list.List;

public class LinkedTree<E> {
	private TreeNode<E> root;
	
	public LinkedTree(E data){
		root = new TreeNode<E>(data);
	}
	public LinkedTree(TreeNode<E> node){
		this.root = node;
	}
	
	public TreeNode<E> getRoot(){
		return root;
	}
	
	public TreeNode<E> insertLeft(TreeNode<E> paraent, E data){
		final TreeNode<E> node = new TreeNode<E>(data);
		paraent.left = node;
		return node;
	}
	
	public TreeNode<E> insertRight(TreeNode<E> paraent, E data){
		final TreeNode<E> node = new TreeNode<E>(data);
		paraent.right = node;
		return node;
	}
	public void traversalPostorder(List<E> list){
		traversalPostorder(root, list);
	}
	public void traversalPostorder(TreeNode<E> node, List<E> list){
		if(node.left!=null){
			traversalPostorder(node.left,list);
		}
		if(node.right!=null){
			traversalPostorder(node.right,list);
		}
		list.add(node.data);
	}
	
	public static class TreeNode<E>{
		private E data;
		private TreeNode<E> left;
		private TreeNode<E> right;
		
		public TreeNode(E data){
			this.data = data;
			this.left = null;
			this.right = null;
		}

		public E getData() {
			return data;
		}

		public void setData(E data) {
			this.data = data;
		}

		public TreeNode<E> getLeft() {
			return left;
		}

		public void setLeft(TreeNode<E> left) {
			this.left = left;
		}

		public TreeNode<E> getRight() {
			return right;
		}

		public void setRight(TreeNode<E> right) {
			this.right = right;
		}
	}
}