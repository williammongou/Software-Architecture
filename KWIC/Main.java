import java.awt.Dimension;

import javax.swing.JFrame;
import view.KwicPanel;

public class Main {

	public static void main(String [] args){
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocation(400, 200);
		window.setPreferredSize(new Dimension(500,500));
		var panel = new KwicPanel(window);
		panel.init();
		window.pack();
		window.setVisible(true);
	}
}