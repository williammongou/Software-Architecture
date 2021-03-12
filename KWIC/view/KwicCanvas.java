package view;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class KwicCanvas extends JPanel {

	private KwicPanel panel;
	private ArrayList<String> dictionary = new ArrayList<>();

	public KwicCanvas(KwicPanel panel){
		this.panel = panel;
		setPreferredSize(new Dimension (100,100));
		setBackground(new Color(181,100,227));
		setLocation(500,400);
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.black);
		//g2.setFont()
		dictionary = panel.getTextInput().getDictionary();
		for(int i = 0; i < dictionary.size(); i++){
			g2.drawString(dictionary.get(i), 5, 5+(i*10));
		}

	}
}
