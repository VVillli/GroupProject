package jamHouse;

import java.util.ArrayList;

public class User {
	private ArrayList<String> myMsgs = new ArrayList<String>();
	private String myName;
	
	public User(String name){
		myName = name;
	}
	
	public ArrayList<String> getMessages(){
		return myMsgs;
	}
	
	public String getName(){
		return myName;
	}
}
