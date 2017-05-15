package recursion;

public class FibonacciTest {
	public static int countOfCall = 0;

	public static void main(String[] args) {
			System.out.print(50+":"+fibonacci(50)	+ ":" + countOfCall);
			
	}
	public static int fibonacci(int n){
		countOfCall++;
//		System.out.println(countOfCall);
		if(n==0){
			return 0;
		}
		if(n==1){
			return 1;
		}
		
		return fibonacci(n-1) + fibonacci(n-2);
	}

}
