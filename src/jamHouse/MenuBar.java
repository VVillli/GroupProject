package jamHouse;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar{
	JFrame f;
	
	public MenuBar(JFrame f){
		super();
		
		this.f = f;
		
		JMenu file = new JMenu("File");
		
		JMenuItem changeUser = new JMenuItem("Change User");
		JMenuItem addUser = new JMenuItem("Add User");
		JMenuItem close = new JMenuItem("Close");
		
		file.add(changeUser);
		file.add(addUser);
		file.addSeparator();
		file.add(close);
		
		this.add(file);
	}
}
