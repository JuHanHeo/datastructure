package list;

import java.util.Arrays;

public class DoubleLinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new DoubleLinkedList<Integer>();
		// add 연산
		list.add( 11 );
		list.add( 22 );
		list.add( 33 );
		list.add( 44 );
		list.add( 55 );

		// size 연산
		int count = list.size();
		System.out.println( "리스트 크기:" + list.size() );

		// get 연산 테스트
		for( int i= 0; i < count; i++ ) {
			System.out.println( i + "번째 항목: " + list.get( i ) );
		}

		// add(index, element) 테스트
		System.out.println( Arrays.toString( list.toArray() ) );		
		list.add( 0, 1 );
		System.out.println( Arrays.toString( list.toArray() ) );		
		list.add( 6, 2 );
		System.out.println( Arrays.toString( list.toArray() ) );		
		list.add( 4, -1 );
		System.out.println( Arrays.toString( list.toArray() ) );		
		list.add( 3, 4 );
		System.out.println( Arrays.toString( list.toArray() ) );	
		list.add( 9, 55 );
		System.out.println( Arrays.toString( list.toArray() ) );		
		list.add( 66 );
		System.out.println( Arrays.toString( list.toArray() ) );

		// remove( index ) 테스트
		System.out.println( "삭제 항목: " + list.remove( 0 )  );
		System.out.println( Arrays.toString( list.toArray() ) );
		System.out.println( "삭제 항목: " + list.remove( 1 )  );
		System.out.println( Arrays.toString( list.toArray() ) );
		System.out.println( "삭제 항목: " + list.remove( list.size() - 1  ) );
		System.out.println( Arrays.toString( list.toArray() ) );

		// removeAll 테스트
		list.removeAll();
		System.out.println( Arrays.toString( list.toArray() ) );

		// 예외 테스트
		try {
			list.get( 0 );
		} catch( IndexOutOfBoundsException e ) {
			System.out.println( "예외발생:" + e );
		}

	}

}
