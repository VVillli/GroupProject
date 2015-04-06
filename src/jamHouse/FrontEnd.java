package jamHouse;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FrontEnd extends JFrame{
	public FrontEnd(){
		super();
		
		//Pre-Pack code
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Messager");
		
		//Adding Components
		
		this.setJMenuBar(new MenuBar(this));
		
		JTextArea msgs = new JTextArea();
		JTextField newMessage = new JTextField();
		JButton addMessage = new JButton("Send Message");
		
		Box bottom = Box.createHorizontalBox();
		
		bottom.add(newMessage);
		bottom.add(addMessage);
		
		Box container = Box.createVerticalBox();
		
		container.add(msgs);
		container.add(bottom);
		
		this.add(container);
		
		//Modifying Components
		
		msgs.setEditable(false);
		//msgs.setBorder(BorderFactory.createTitledBorder("Messages"));
		msgs.setBackground(new Color(240,240,240,255));
		
		newMessage.setPreferredSize(new Dimension(250,30));
		newMessage.setMaximumSize(new Dimension(250,30));
		newMessage.setMinimumSize(new Dimension(250,30));
		
		addMessage.setPreferredSize(new Dimension(150,30));
		addMessage.setMaximumSize(new Dimension(150,30));
		addMessage.setMinimumSize(new Dimension(150,30));
		addMessage.setFocusPainted(false);
		
		//Packing
		
		this.pack();
		
		//Finishing Up
		
		this.setSize(new Dimension(400,400));
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

		this.setResizable(false);
		this.setVisible(true);
		
	}
}
