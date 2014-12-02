import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*; 

class GuiWindowListener extends WindowAdapter{
	private int answer;
	private Formatter x;
	private Scanner y;
	GuiWindowListener()
	{/*
		openFileToRead();
		FileMenuOpenListener.setFile(new File(readFile()));*/
	}
	public void  windowClosing(WindowEvent event)
	{
		answer = JOptionPane.showConfirmDialog(null,"Do you want to remember the last song you played?",
		                                            "",
		                                            JOptionPane.YES_NO_CANCEL_OPTION, 
		                                            JOptionPane.INFORMATION_MESSAGE);
		if (answer == JOptionPane.YES_OPTION)
		{
			if (FileMenuOpenListener.getFile() != null)
			{
				openFile();  // references below
				addRecords();  // references below
				closeFile(); // references below
			}
			System.exit(0);
			
		}
		else  if (answer == JOptionPane.NO_OPTION)
		{
			System.exit(0);
		}
		else
		{
			
		}
	}
	
	public void openFile()  // I got this Formatter code from    https://www.youtube.com/watch?v=Bws9aQuAcdg
	{
		try    
		{
			x = new Formatter("test.txt"); 
		}
		catch (Exception ex)
		{
			System.out.println("error in creating file. The file might already exist");
		}
	}
	public void addRecords()  // I got this Formatter code from the same place   https://www.youtube.com/watch?v=Bws9aQuAcdg
	{
		x.format("%s",FileMenuOpenListener.getFile().getPath());
	}
	public void closeFile()   // I got this Formatter code from the same place   https://www.youtube.com/watch?v=Bws9aQuAcdg
	{
		x.close();
	}
	public void openFileToRead()   //   https://www.youtube.com/watch?v=3RNYUKxAgmw
	{
		try
		{
			y = new Scanner(new File("test.txt"));
		}
		catch (Exception ex)
		{
			System.out.println("could not find file");
		}
	}
	public String readFile()
	{
		return y.next();
	}
}
