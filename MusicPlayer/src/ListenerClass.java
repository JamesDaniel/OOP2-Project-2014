//ListenerClass.java
//James McGarr
/*import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

public class ListenerClass extends WindowAdapter implements ActionListener{
	private static int checkPlayCondition=0;   // change this to boolean
	private String actionEventSource;
	public Object eventSource;
	private BufferedImage image1;
	private BufferedImage image2;
	
	public ListenerClass(String actionEventSource,Object eventSource)
	{
		this.actionEventSource = actionEventSource;
		this.eventSource = eventSource;
	}
	public ListenerClass(String actionEventSource,Object eventSource,BufferedImage image1,BufferedImage image2)
	{
		this.actionEventSource = actionEventSource;
		this.eventSource = eventSource;
		this.image1 = image1;
		this.image2 = image2;
	}
	
	public void actionPerformed(ActionEvent event)
	{
	//	System.out.println("hello listener");
		
		if (actionEventSource.equals("playPause"))
		{
			if (checkPlayCondition == 0)
			{*/
			/*	this.eventSource.
					setIcon(
						new ImageIcon(
							image2));*//*
		    	checkPlayCondition = 1;
			}
			else
			{
				checkPlayCondition = 0;
			}
		}
		
		
		
		
		
		if (actionEventSource.equals("FileMenuOpen"))
				System.out.println("open from the file menu");
		if (actionEventSource.equals("FileMenuExit"))
				System.out.println("exit from the program with the file menu");
		if (actionEventSource.equals("EditMenuNextSong"))
				System.out.println("go to the next song");
		if (actionEventSource.equals("EditMenuPrevSong"))
				System.out.println("go back to the previous song");
	}
}
*/