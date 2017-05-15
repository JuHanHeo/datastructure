package Calc;

import list.StackException;

public class CalcMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputData in = new InputData();
		IntoPost itp = new IntoPost(in.getData());
		try {
			
			System.out.println(itp.evaluteExpressionTree(itp.makeExpTree(itp.changeFix()).getRoot()));		//수식트리를 이용한 계산
			
//			itp.changeFix();
//			itp.CalStack();
		} catch (StackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
