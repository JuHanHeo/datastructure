package list;

public class LinkedList<E> implements List<E> {

	private Node<E> head;
	private int size;

	public void add(E element) {
		Node<E> newNode = new Node<E>(element);

		if(head == null){
			head = newNode;
		}else{
			Node<E> x=head;
			while(x.next!=null){
				x=x.next;
			}
			x.next = newNode;
		}
		size++;
	}

	public void add(int index, E element) {
		if(index>size){
			throw new IndexOutOfBoundsException("에외발생");
		}
		Node<E> newNode = new Node<E>(element);
		if(head == null){
			head = newNode;
			size++;
		}else{

			if(index==0){
				newNode.next=head;
				head=newNode;
				size++;
			}else if(size== index){
				add(element);
			}else{
				Node<E> point = head;
				for(int i=0;i<index-1;i++){
					point=point.next;
				}
				newNode.next = point.next;
				point.next = newNode;
				size++;
			}
		}


	}

	public E get(int index) {
		Node<E> x = head;
		if(size<=index){
			throw new IndexOutOfBoundsException("에외발생");
		}
		for(int i=0;i<index;i++){
			x=x.next;
		}
		return x.data;
	}

	public E remove(int index) {
		if(size<=index){
			throw new IndexOutOfBoundsException("에외발생");
		}
		if(index == 0){
			if(head.next==null){
				head=null;
				size=0;
			}else{
				Node<E> tmp = head;
				head=head.next;
				tmp=null;
				size--;
			}
			
		}else{
			Node<E> tmp = head;
			for(int i=0;i<index-1;i++){
				tmp=tmp.next;
			}
			if(tmp.next.next==null){
				tmp.next=null;
				size--;
			}else{
				Node<E> link = tmp.next.next;
				tmp.next = null;
				tmp.next = link;
				size--;
			}
			
		}
		return null;
	}

	public void removeAll() {
		for(Node<E> x = head ; x.next!=null;){
			Node<E> next = x.next;
			x.data = null;
			x.next = null;

			x = next;
		}
		head = null;
		size=0;
	}

	public int size() {
		return size;
	}
	public void prt(){
		Node<E> point=head;
		while(true){
			System.out.print(point.data + " ");
			if(point.next==null){
				break;
			}
			point=point.next;
		}
		System.out.println();
		
	}

	private class Node<E>{
		private Node<E> next;
		private E data;

		private Node(E element){
			data = element;
			next = null;
		}
		private Node(E element, Node<E> next){
			this.data = element;
			this.next = next;
		}
	}

}
