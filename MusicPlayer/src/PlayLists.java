//https://www.youtube.com/watch?v=Bws9aQuAcdg
//Java Programming Tutorial - 80 - Writing to Files

import java.io.*;
import java.lang.*;
import java.util.*;
 
public class PlayLists {
    	private Formatter x;
    	private MusicManager manager;
    	PlayLists(MusicManager manager)
    	{
    		this.manager = manager;
    		//System.out.println(manager.getFile().getPath());
    	}
    	public void openFile(){
    		try{
    			x = new Formatter("song.txt");
    		}
    		catch (Exception e)
    		{
    			System.out.println("Failed to write song file.");
    		}
    	}
    	public void addRecords(){
    		x.format("%s", manager.getFile().getPath());
    	}
    	public void closeFile(){
    		x.close();
    	}
    	public static File readFile(){
    		Scanner y = null;
    		try
    		{
    			y = new Scanner(new File("song.txt"));
    		}
    		catch (Exception ex){}
    		if (y.hasNext()){
    			return new File(y.next());
    		}
    		else
    			return null;
    	}
}
