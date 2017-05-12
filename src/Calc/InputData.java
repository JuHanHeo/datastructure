package Calc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import list.ArrayList;

public class InputData {
	String inputStr;
	StringTokenizer tok;
	ArrayList<String> li;

	public InputData() {
		inputStr = null;
		tok = null;
		li = new ArrayList<String>();
	}

	public ArrayList<String> getData(){
		System.out.print("Input Data : ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			this.inputStr = br.readLine().replaceAll(" ", "");
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		tok = new StringTokenizer(inputStr, "()+-*/", true);


		while(tok.hasMoreTokens()){
			li.add(tok.nextToken());
		}
		
		return li;
	}

}
