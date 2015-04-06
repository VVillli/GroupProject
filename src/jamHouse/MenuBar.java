package jamHouse;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MenuBar extends JMenuBar{
	JFrame f;
	
	public MenuBar(FrontEnd f){
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
		
		changeUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(f.getUsers().length > 0){
					String[] temp = f.getUsers();
					String blah = (String)JOptionPane.showInputDialog(f, "Choose User", "Change User", JOptionPane.QUESTION_MESSAGE, null, temp, temp[0]);
					f.setUser(blah);
				}
			}
		});
		
		addUser.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String x = JOptionPane.showInputDialog(f, "USER");
				f.setUser(x);
			}
		});
		
		this.add(file);
	}
}
