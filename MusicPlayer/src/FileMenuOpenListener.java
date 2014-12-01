// learned the JFileChooser stuff from https://docs.oracle.com/javase/tutorial/uiswing/components/filechooser.html
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class FileMenuOpenListener implements ActionListener{
	private final JFileChooser fc = new JFileChooser();
	private static File tempFile;
	private static File file1;
	private int returnVal;
	private JFrame gui;
	
	public FileMenuOpenListener(JFrame gui)
	{
		this.gui = gui;
	}
	public void actionPerformed(ActionEvent event)
	{
		//FileMenuOpenListener.setFile(new File("BH-ft.-Aloma-Steele-Hold-On.mp3"));
		FileMenuOpenListener.setFile(file1);
	    returnVal = fc.showOpenDialog(null);
	    
		
		if (returnVal == JFileChooser.APPROVE_OPTION)
		{
			tempFile = fc.getSelectedFile();
			
			if (tempFile.getName().endsWith(".mp3"))
			{
				file1 = fc.getSelectedFile();
				gui.setTitle("Music Player - " + file1.getName().substring(0,file1.getName().length()-4));
				Music.stopPlay();
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Only mp3 files can be played.","error",JOptionPane.ERROR_MESSAGE);
			}
		//	System.out.println(file1.getName());
		}
		else
		{
			JOptionPane.showMessageDialog(null,"You need to choose a file to play.","",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	public static void setFile(File file)
	{
		file1 = file;
	}
	public static File getFile()
	{
		return FileMenuOpenListener.file1;
	}
}
