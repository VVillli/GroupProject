package jamHouse;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TreeMap;

public class Encoder {
	
	File file;


	public Encoder (String filename)
	{
		file= new File(filename);
		Writer writer= null;
		try{
		writer= new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(file.getName())),"utf-8"));
		writer.write("");
		}
		catch (Exception e)
		{
			
		}
		finally{
			try {writer.close();}catch(Exception ex){}
		}
		
	}
	private String encrypt(String o)
	{
		String s= "";
		for(int i=0;i<o.length()-1;i+=2)
		{
			String a= o.substring(i,i+1);
			String b= o.substring(i+1,i+2);
			s+=b;
			s+=a;
		}
		if(o.length()%2==1)
			s+=o.substring(o.length()-1,o.length());
		return s;
	}
	public void write(String plaintext)
	{
		String s= encrypt(plaintext);
		Writer writer= null;
		try{
			String content="";
			try{
			Scanner sc= new Scanner(file);
			content = sc.useDelimiter("\\Z").next();
			sc.close();
			}
			catch (Exception e)
			{
				
			}
			writer= new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(file.getName())),"utf-8"));
			writer.write(content+"\n"+ s);
		}
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		catch (NoSuchElementException e)
		{
			
		}
		catch (Exception e)
		{
			
		}
		finally{
			try {writer.close();}
			catch(Exception ex){}
		}
		
	}
	public ArrayList<String> read()
	{
		ArrayList<String> myList= new ArrayList<String>();
		try
		{
			Scanner sc= new Scanner(file);
			while(sc.hasNextLine()){
				myList.add(encrypt(sc.nextLine()));
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		return myList;
	}

}
