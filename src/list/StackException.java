package list;

public class StackException extends Exception{
	public StackException() {
		super("Stack Exception Occurs");
	}
	
	public StackException(String msg){
		super(msg);
	}

}
