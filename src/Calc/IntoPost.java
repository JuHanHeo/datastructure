package Calc;



import java.util.Arrays;

import list.ArrayList;
import list.List;
import list.StackException;
import stack.Stack;
import tree.LinkedTree;
import tree.LinkedTree.TreeNode;

public class IntoPost {
	ArrayList<String> li;
	Stack<String> opst;
	Stack<String> resultst;
	Stack<String> res;
	String tmp;
	Stack<TreeNode<String>> expTree;

	public IntoPost(ArrayList<String> li) {
		this.li = li;
		this.tmp = null;
		opst = new Stack<String>();
		resultst = new Stack<String>();
		res = new Stack<String>();
		expTree = new Stack<TreeNode<String>>();
	}
	
	public double evaluteExpressionTree(TreeNode<String> node){
		double lvalue=0;
		double rvalue=0;
		if(node.getLeft()!=null){
			lvalue = evaluteExpressionTree(node.getLeft());
		}
		if(node.getRight()!= null){
			rvalue = evaluteExpressionTree(node.getRight());
		}
		
		switch(node.getData()){
		case"+":
			return lvalue + rvalue;
		case"-":
			return lvalue - rvalue;
		case"*":
			return lvalue * rvalue;
		case"/":
			return lvalue / rvalue;
		default :  return Double.parseDouble(node.getData());
		}
	}

	public LinkedTree<String> makeExpTree(Stack<String> res){
		int cnt = res.size();
		for(int i=0;i<cnt;i++){
			try {
				TreeNode<String> node = new TreeNode<String>(res.pop2());
//				System.out.println(i+"=" + node.getData());
				if(node.getData().equals("+")||node.getData().equals("-")||node.getData().equals("*")||node.getData().equals("/")){	//연사자인경우
					
					node.setRight(expTree.pop());
					node.setLeft(expTree.pop());
//					System.out.println(node.getData() + node.getLeft().getData() + node.getRight().getData());
					
					if(i==cnt-1){
						LinkedTree<String> tree = new LinkedTree<>(node);
						List<String> list = new ArrayList<String>();
						tree.traversalPostorder(list);
//						System.out.println(Arrays.toString(list.toArray()));
						return tree;

					}else{
						expTree.add(node);
					}
					
				}else{	//피연사자인경우
					expTree.add(node);
				}
			} catch (StackException e) {
				e.printStackTrace();
			}


		}
		return null;

	}

	public int checkOp(String s) { //연산자 우선순위

		if (s.equals("+")) {
			return 1;
		} else if (s.equals("-")) {
			return 1;
		} else if (s.equals("*")) {
			return 2;
		} else if (s.equals("/")) {
			return 2;
		} else if (!s.equals("+") && !s.equals("-") && !s.equals("/") && !s.equals("*") && !s.equals("(")
				&& !s.equals(")")) { // 숫자인경우
			return 0;
		} else {
			return -1;
		}
	}

	public double CalDouble(double first, double second, String opr) {

		double num = 0;

		switch (opr) {
		case "+":
			num = first + second;
			break;
		case "-":
			num = first - second;
			break;
		case "*":
			num = first * second;
			break;
		case "/":
			num = first / second;
			break;
		default:
			break;

		}
		return num;
	}

	public Stack<String> changeFix() throws StackException {

		int lisize = li.size();
		for (int i = 0; i < lisize; i++) {
			tmp = li.remove(0);

			if (checkOp(tmp) == 0) { // 피연사자일 경우
				resultst.add(tmp);
			}

			else if (checkOp(tmp) != 0) { // 연사자일 경우

				if (opst.isEmpty() || tmp.equals("(")) { // opst이 비어 있을경우
					opst.add(tmp);
				} else if (!opst.isEmpty()) { // opst이 비어있지 않을경우

					if (tmp.equals(")")) {	//닫는괄호 만나면 스택에 여는괄호 만나때까지 팝팝
						while (true) {
							String optmp = opst.pop();
							if (optmp.equals("(")) {
								break;
							} else {
								resultst.add(optmp);
							}
						}
					}

					else if (checkOp(opst.get(opst.size()-1)) < checkOp(tmp) || opst.isEmpty()) {

						opst.add(tmp);
					} else if (checkOp(opst.get(opst.size()-1)) >= checkOp(tmp)) {

						while (true) {
							if (opst.isEmpty() || (checkOp(opst.get(opst.size()-1)) < checkOp(tmp) || opst.isEmpty())) {
								opst.add(tmp);
								break;

							} else if (checkOp(opst.get(opst.size()-1)) >= checkOp(tmp)) {
								resultst.push(opst.pop());

							}
						}
					}
				}
			}
			tmp = null;

		}
		while (!opst.isEmpty()) { //수식 끝나면 나머지  다 팝팝
			resultst.push(opst.pop());
		}


		return resultst;

	}

	public void CalStack() throws NumberFormatException, StackException {

		int size = resultst.size();
		String opr = null;
		double first = 0;
		double second = 0;
		double tmp = 0;

		System.out.println("PostFix -> "+Arrays.toString(resultst.toArray()));
		for (int i = 0; i < size; i++) {
			if (checkOp(resultst.get(i)) == 0) {
				res.add(resultst.get(i));
			} else {

				first = Double.parseDouble(res.pop());
				second = Double.parseDouble(res.pop());
				tmp = CalDouble(first, second, resultst.get(i));
				res.add(Double.toString(tmp));
				if (i == size - 1) {
					System.out.println("계산결과 :" +tmp);
				}

			}
		}
	}






}
