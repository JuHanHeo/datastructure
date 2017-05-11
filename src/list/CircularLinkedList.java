package list;

public class CircularLinkedList<E> implements List<E>{
	private int size;
	private E data[];
	private Node<E> tail =null;
	private Node<E> pos = null;

	@Override
	public void add(E element) {
		final Node<E> newNode = new Node<E>(element);

		if(tail==null){
			tail = newNode.next = newNode;
		} else{
			newNode.next = tail.next; // head
			tail.next = newNode;
			tail = tail.next;
		}
		size++;
	}

	@Override
	public void add(int index, E element) {
		final Node<E> newNode = new Node<E>(element);
		if(tail==null){
			tail = newNode.next = newNode;
			size++;
		}else{
			if(index == size){ //맨끝에 넣는경우
				add(element);
			} else {
				Node<E> x = tail;
				for(int i=0;i<index;i++){
					x=x.next;
				}
				newNode.next = x.next;
				x.next = newNode;
				size++;
			}
		}

	}

	@Override
	public E get(int index) {
		
		if(size<=index){
			throw new IndexOutOfBoundsException("에외발생");
		}
		Node<E> x = tail.next;
		for(int i=0;i<index;i++){
			x=x.next;
		}
		return x.data;
	}

	@Override
	public E remove(int index) {
		Node<E> x = tail;

		for(int i=0;i<index;i++){
			x=x.next;
		}
		Node<E> del = x.next;
		x.next = del.next;
		del.next = null;
		if(index == size -1){
			tail=x;
		}
		size--;

		return del.data;
	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		Node<E> x = tail.next; //헤더로 이동

		while(x!=tail){
			Node<E> next = x.next;

			x.next = null;
			x=next;
		}

		tail.next = null;
		tail = null;
		size=0;

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	@Override
	public Object[] toArray(){
		Object[] arr = new Object[size];

		if(tail == null){
			return arr;
		}
		int index=0;
		Node<E> x = tail.next;

		while(true){
			arr[index++] = x.data;
			x=x.next;
			if(x==tail.next){	//다시 head로 돌아옴 (한바퀴돔)
				break;
			}
		}

		return arr;
	}
	public E next(){
		Node<E> show ;
		if(tail==null){
			return null;
		}
		if(pos==null){
			pos=tail;
		}
		show = pos.next;
		pos=pos.next;
		return show.data;

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




	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}




}
