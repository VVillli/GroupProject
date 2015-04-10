package jamHouse;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class FrontEnd extends JFrame{
	private BackEnd b = new BackEnd();
	private String currentUser = "New User";
	
	private JTextArea msgs; 
	
	
	public FrontEnd(){
		super();
		
		//Pre-Pack code
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Messager");
		
		//Adding Components
		
		this.setJMenuBar(new MenuBar(this));
		
		msgs = new JTextArea();
		JScrollPane scroll = new JScrollPane(msgs);
		JTextField newMessage = new JTextField();
		JButton addMessage = new JButton("Send Message");
		
		Box bottom = Box.createHorizontalBox();
		
		bottom.add(newMessage);
		bottom.add(addMessage);
		
		Box container = Box.createVerticalBox();
		
		container.add(scroll);
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
		
		//ActionListeners
		
		newMessage.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER){
					String s = newMessage.getText();
					if(!s.isEmpty()){
						b.addMessage(currentUser, s);
						newMessage.setText("");
					}
					update();
				}
			}

			public void keyReleased(KeyEvent arg0) {}

			public void keyTyped(KeyEvent arg0) {}
			
		});
		
		addMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!newMessage.getText().isEmpty()){
					b.addMessage(currentUser, newMessage.getText());
					newMessage.setText("");
				}
				
				update();
			}
		});
		
		//Packing
		
		this.pack();
		
		//Finishing Up
		
		this.setSize(new Dimension(400,400));
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

		this.setResizable(false);
		this.setVisible(true);
		
	}
	
	public void update(){
		msgs.setText('\n' + "        " + currentUser + ": \n");
		ArrayList<String> tempMsgs = b.getMessages(currentUser);
		for(int j = 0; j < tempMsgs.size(); j++){
			msgs.setText(msgs.getText() + '\t' + tempMsgs.get(j) + '\n');
		}
	}
	
	public void setUser(String user){
		currentUser = user;
	}
	
	public String[] getUsers(){
		String[] temp = new String[b.getUsers().size()];
		
		for(int i = 0; i < temp.length; i++){
			temp[i] = b.getUsers().get(i);
		}
		
		return temp;
	}
	
	public BackEnd getBack(){
		return b;
	}
}
