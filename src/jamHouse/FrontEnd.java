package jamHouse;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class FrontEnd extends JFrame{
	public FrontEnd(){
		super();
		
		//Pre-Pack code
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Message");
		
		this.pack();
		
		//Finishing Up
		this.setSize(new Dimension(600,600));
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

		this.setResizable(false);
		this.setVisible(true);
		
	}
}
