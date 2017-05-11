package list;


public class DoubleLinkedList<E> implements List<E> {
	private int size;
	private Node<E> head;
	private Node<E> tail;

	@Override
	public void add(E element) {
		final Node<E> newNode = new Node<E>(element);

		if(head==null){
			head=tail=newNode;
		} else{
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
			tail.next = null;
		}
		size++;
	}

	@Override
	public void add(int index, E element) {
		final Node<E> newNode = new Node<E>(element);
		if(head==null || index == size){
			add(element);
		}else{
			if(index == 0){
				newNode.next = head;
				head.prev = newNode;
				newNode.prev =null;
				head = newNode;
				size++;
			}else{
				Node<E> x = head;
				for(int i=0;i<index;i++){
					x=x.next;
				}
				x.prev.next = newNode;
				newNode.prev = x.prev;
				newNode.next = x;
				x.next.prev = newNode;
				size++;

			}
		}
	}

	@Override
	public E get(int index) {
		if(size<=index||index<0){
			throw new IndexOutOfBoundsException("에외발생");
		}
		Node<E> x = head;
		for(int i=0;i<index;i++){
			x=x.next;
		}
		return x.data;
	}

	@Override
	public E remove(int index) {
		Node<E> x = head;
		Node<E> y = tail;
		E del = null;
		if(index == 0){
			del = head.data;
			x.next.prev = null;
			head = x.next;
		} else if(index == size-1){
			del = tail.data;
			y.prev.next = null;
			tail = y.prev;
		} else{
			for(int i=0;i<index;i++){
				x=x.next;
			}
			del = x.data;
			x.prev.next = x.next;
			x.next.prev = x.prev;
			x = null;
		}
		size--;
		return del;
	}

	@Override
	public void removeAll() {
		Node<E> x = head;

		while(x!=null){
			Node<E> next = x.next;
			x.next = null;
			x.prev = null;
			x=next;
		}
		head=null;
		tail=null;
		size=0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	public Object[] toArray(){
		Object[] arr = new Object[size];
		if(tail == null){
			return arr;
		}
		int index=0;
		Node<E> x = head;

		while(true){
			arr[index++] = x.data;
			x=x.next;
			if(x==tail.next){	//다시 head로 돌아옴 (한바퀴돔)
				break;
			}
		}

		return arr;
	}

	@Override
	public Iterator<E> iterator() {
		return null;
	}

	private class Node<E>{
		private Node<E> next;
		private Node<E> prev;
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
