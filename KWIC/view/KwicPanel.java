package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controller.KwicPanelListener;
import model.TextInput;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.awt.Container;
import java.awt.Dimension;
public class KwicPanel {
	
	private JFrame window;
	private Container cp;
	private TextInput textInput = new TextInput("");
	private ArrayList<TextInput> textInputList = new ArrayList<>();
	private JTextArea inputArea = new JTextArea();
	private JTextArea outputArea = new JTextArea();
	private KwicCanvas optionCanvas = new KwicCanvas(this);
	private JButton enterButton = new JButton("Enter");
	private JButton clearButton = new JButton("Clear");
	private JLabel titleLabel = new JLabel("Key Word Index Context");
	private boolean dictionaryUpdate = false;
	private KwicPanelListener listener;

	public KwicPanel(JFrame window){
		this.window = window;
	}
	public void init(){
		
		listener = new KwicPanelListener(this);
		cp = window.getContentPane();
		JPanel northPanel = new JPanel();
		northPanel.add(titleLabel);
		cp.add(BorderLayout.NORTH, northPanel);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(1,2));
		centerPanel.add(inputArea);
		centerPanel.add(outputArea);
		cp.add(BorderLayout.CENTER, centerPanel);

		JPanel southPanel = new JPanel();
		southPanel.add(enterButton);
		southPanel.add(clearButton);
		cp.add(BorderLayout.SOUTH, southPanel);


		//Action Listeners
		enterButton.addActionListener(listener);
		clearButton.addActionListener(listener);
		inputArea.addFocusListener(listener);

	}

	public JButton getEnterButton() {
		return enterButton;
	}

	public JButton getClearButton() {
		return clearButton;
	}

	public JTextArea getInputArea() {
		return inputArea;
	}

	public TextInput getTextInput() {
		return textInput;
	}
	
	public ArrayList<TextInput> getTextInputList() {
		return textInputList;
	}
	
	public void setTextInputList(ArrayList<TextInput> textInputList) {
		this.textInputList = textInputList;
	}

	public JTextArea getOutputArea() {
		return outputArea;
	}

	public Container getContainer() {
		return cp;
	}

	public boolean getDictionaryUpdate(){
		return dictionaryUpdate;
	}
	public void setDictionaryUpdate(boolean b) {
		this.dictionaryUpdate = b;
	}
}
