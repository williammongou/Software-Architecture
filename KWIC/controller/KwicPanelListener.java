package controller;

import java.awt.event.ActionListener;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import java.awt.BorderLayout;

import model.AlphabetizeFilter;
import model.CircularShiftFilter;
import model.InputFilter;
import model.TextInput;
import view.KwicCanvas;
import view.KwicPanel;

import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;

public class KwicPanelListener implements ActionListener, FocusListener{

	private KwicPanel panel;
	private KwicCanvas canvas;

	public KwicPanelListener(KwicPanel panel){
		this.panel = panel;
		this.canvas = new KwicCanvas(panel);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();

		if(button == panel.getEnterButton()){
			String text = panel.getInputArea().getText();

			InputFilter inFilter = new InputFilter(text, panel.getTextInputList());
			inFilter.filterAction();
			panel.setTextInputList(inFilter.getTextInputList());


			//System.out.println(panel.getTextInputList().size());
			for(int a = 0; a < panel.getTextInputList().size(); a++){
				TextInput textInput = panel.getTextInputList().get(a);

				CircularShiftFilter circFilter = new CircularShiftFilter(textInput);
				circFilter.filterAction();
				textInput = circFilter.getTextInput();
				

				AlphabetizeFilter alphaFilter = new AlphabetizeFilter(textInput);
				alphaFilter.filterAction();
				textInput = alphaFilter.getTextInput();

				for(int i = 0; i < textInput.getDictionary().size(); i++){
					panel.getOutputArea().append(textInput.getDictionary().get(i)+"\n");
				}
			}

			panel.setDictionaryUpdate(true);

		}
		else if(button == panel.getClearButton()){
			panel.getTextInputList().clear();
			panel.getOutputArea().setText("");
			panel.getInputArea().setText("");
		}

	}

	@Override
	public void focusGained(FocusEvent e) {
		if(panel.getDictionaryUpdate()){
			canvas.repaint();
			panel.getContainer().add(canvas);
		}

	}

	@Override
	public void focusLost(FocusEvent e) {
		panel.getContainer().remove(canvas);
	}

	
}
