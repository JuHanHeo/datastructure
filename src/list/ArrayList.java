package list;

public class ArrayList<E> implements List<E>{
	private static final int INIT_CAPACITY=10;
	private int size;
	private E[] data;
	
	@SuppressWarnings("unchecked")
	public ArrayList() {
		// TODO Auto-generated constructor stub
		size = 0;
		resize();
	}

	
	private void resize(){
		int capacity = (data == null)?INIT_CAPACITY:data.length*2;
		@SuppressWarnings("unchecked")
		E[] temp = (E[])new Object[capacity];	//공간복잡도 n
		
		for(int i=0;i<size;i++){	//시간복잡도 n
			temp[i] = data[i];
		}
		data=temp;
		System.out.println("리사이즈");
	}


	@Override
	public void add(E element) {
		// TODO Auto-generated method stub
		if(data.length==size){
			resize();
		}
		data[size] = element;
		size++;
		
	}


	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		if(index == size){
			throw new IndexOutOfBoundsException("Index:"+index+", size:"+size);
		}
		return data[index];
	}


	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		//기존의 공간을 지운 (메모리에서 없애버린다)
		for(int i = 0;i<size;i++){
			data[i] = null;
		}
		size = 0;	//처음 공간 부터 덮어씀(이것만 해도 상관없지만 공간 절약은 안좋음)
		
	}


	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}


	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>(){
			private int index = 0;

			@Override
			public boolean hasNext() {
				return index<size;
			}

			@Override
			public E next() {
				return data[index++];
			}
			
		};
	}


	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
