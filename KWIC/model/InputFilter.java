package model;

import java.util.ArrayList;

public class InputFilter implements IFilter{
	
	private ArrayList<TextInput> inputList = new ArrayList<>();
	private String input;

	public InputFilter(String input, ArrayList<TextInput> inputList){
		this.inputList = inputList;
		this.input = input;
	}

	public void inputAction(){
		
		String [] textLines = input.split("\n");
		for(int i = 0; i < textLines.length; i++){
			inputList.add(new TextInput(textLines[i]));
		}
	}

	@Override
	public void filterAction(){
		inputAction();
	}

	public ArrayList<TextInput> getTextInputList() {
		return inputList;
	}
}
