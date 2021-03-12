package model;

import java.util.ArrayList;

public class TextInput {
	String text;
	ArrayList<String> dictionary = new ArrayList<>();
	public TextInput(String text){
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public ArrayList<String> getDictionary() {
		return dictionary;
	}

	public void setText(String text) {
		this.text = text;
	}
}