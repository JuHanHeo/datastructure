package list;

public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(11);
		list.add(22);
		list.add(22);
		list.add(33);
		list.add(33);
		list.add(44);
		
		//iterator 반복자를 통한 리스트 순회
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()){
			int i = it.next();//auto unboxing
			System.out.println("   " +i);
		}
		
		System.out.println(list.size());

		System.out.println(list.get(2));
		
		list.add(11);
		list.add(22);
		list.add(22);
		list.add(33);
		list.add(33);
		list.add(44);
		
		System.out.println(list.size());

		System.out.println(list.get(2));
		
		list.removeAll();
		System.out.println(list.size());
		
		
		
		
		try {
			System.out.println(list.get(0));
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}

}
