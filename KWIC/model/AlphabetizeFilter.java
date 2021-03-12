package model;

import java.util.Collections;

public class AlphabetizeFilter implements IFilter{
	
	private TextInput input;

	public AlphabetizeFilter(TextInput input){
		this.input = input;
	}

	public void alphabitize(){
		//...
		Collections.sort(input.getDictionary(), (s1,s2) ->{
			int value = 0;
			for(int i = 0; i<s1.length(); i++){
				value = (int)(s1.charAt(i)) - (int)(s2.charAt(i));
				if(value < 0) return -1;
				else if(value > 0) return 1;
			}
			return 0;
		});
	}

	@Override
	public void filterAction(){
		alphabitize();
	}

	public TextInput getTextInput() {
		return input;
	}

}
