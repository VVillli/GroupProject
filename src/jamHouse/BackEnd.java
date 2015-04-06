package jamHouse;

import java.util.ArrayList;

public class BackEnd {
	private ArrayList<User> myUsers;
	private Encoder myCode;
	
	public BackEnd(){
		myUsers = new ArrayList<User>();
		myCode = new Encoder("githib.txt");
	}
	
	public ArrayList<String> getMessages(String username){
		for(User x : myUsers){
			if(x.getName().equalsIgnoreCase(username)){
				return x.getMessages();
			}
		}
		throw new NullPointerException("User not found");
	}
	
	public void addMessage(String username, String message){
		for(User n : myUsers){
			if(n.getName().equalsIgnoreCase(username)){
				n.addMessage(message);
				myCode.write(username + ": " + message);
				return;
			}
		}
		User man = new User(username);
		man.addMessage(message);
		myUsers.add(man);
		myCode.write(username + ": " + message);
		return;
	}
	
	public ArrayList<String> getUsers(){
		ArrayList<String> temp = new ArrayList<String>();
		for(User x : myUsers){
			temp.add(x.getName());
		}
		return temp;
	}
}
