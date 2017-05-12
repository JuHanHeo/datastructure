package Calc;

import list.StackException;

public class CalcMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputData in = new InputData();
		IntoPost itp = new IntoPost(in.getData());
		try {
			itp.changeFix();
			itp.CalStack();
		} catch (StackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
