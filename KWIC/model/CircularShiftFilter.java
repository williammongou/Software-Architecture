package model;

public class CircularShiftFilter implements IFilter {
	
	private TextInput input;

	public CircularShiftFilter(TextInput input){
		this.input = input;
	}

	public void circularShift(){
		//...
		String text = input.getText();
		String output;
		String words = "";

		for(int i = 0; i < input.getText().length(); i++){
			if(input.getText().charAt(i) == ' ' && i > 0){
				text = input.getText().substring(i+1) + " "+ input.getText().substring(0,i);
				input.getDictionary().add(text);
			}
		}


		// for (int i = 0; i < text.length(); i++) {
		// 	output+=(text.charAt(i));
		// 	words = text.charAt(i).split(" ");
		// 	for (let j = 0; j < words.length - 1; j++) {
		// 	  text[i] = text[i].replace(words[j], "");
		// 	  text[i] = text[i] + " " + words[j];
		// 	  text[i] = text[i].trim();
		// 	  output.push(text[i]);
		// 	}
		// }
	}

	@Override
	public void filterAction(){
		circularShift();
	}

	public TextInput getTextInput() {
		return input;
	}
}