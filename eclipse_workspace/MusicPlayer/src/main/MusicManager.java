package main;
//MusicManager.java
import javax.swing.*;
import java.io.*;
import javax.swing.filechooser.*;
import javax.sound.sampled.*;
import java.util.*;
import javazoom.spi.mpeg.sampled.file.MpegAudioFileReader;  
	/*****************************************************
*    Title:  MP3SPI 1.9.5 , line 7,17
*    Author: JLayer
*    Site owner/sponsor:  http://www.javazoom.net/
*    Date: Last Update : 11/2010
*    Code version:  1.9.5
*    Availability:  http://www.javazoom.net/mp3spi/sources.html
*    Modified:  Code used (this is where i got this library)
*****************************************************/
import javax.sound.sampled.spi.AudioFileReader;  
import org.tritonus.share.sampled.file.TAudioFileReader;     // from 
	/*****************************************************
*    Title:  tritonus/tritonus-utils.jar.zip( 94 k) , line 18
*    Author: tritonus
*    Site owner/sponsor:  http://www.java2s.com/
*    Date: Last Update : 
*    Code version:  
*    Availability:  http://www.java2s.com/Code/Jar/t/Downloadtritonusutilsjar.htm
*    Modified:  Code used (this is where i got this library)
*****************************************************/                                                           
                                                          

public class MusicManager {
	public boolean checkPlayCondition;
	private boolean fileExists;
	private ImageIcon image1;
	private ImageIcon image2;
	private JButton playStopBtn;
	private JLabel playTime;
	public File file;
	private Gui gui;
	public int playDuration;
	private PlayLists p1;
	public MusicManager(ImageIcon image1,ImageIcon image2,JButton playStopBtn, JLabel playTime, Gui gui)
	{
		checkPlayCondition = false;
		fileExists = false;
		this.image1 = image1;
		this.image2 = image2;
		this.playStopBtn = playStopBtn;
		this.playTime = playTime;
		this.gui = gui;
		this.file = PlayLists.readFile();
		if (file != null)
		{
			fileExists = true;
			this.setTitle("Music Player - " + getFile().
				                              getName().
				                              substring(0,getFile().getName().length()-4));
		}
		//System.out.println(getFile().getPath());
	}
	public void closeProgramAction()
	{
		System.out.println("manager.closeProgramAction() CALLED");
		int answer;
		if (fileExists)
		{
			answer = JOptionPane.showConfirmDialog(null,"Do you want to remember the last song you played?",
		    	                                        "",
		        	                                    JOptionPane.YES_NO_CANCEL_OPTION,
		            	                                JOptionPane.INFORMATION_MESSAGE);
			if (answer == JOptionPane.YES_OPTION)
			{
				// some code
				p1 = new PlayLists(this);
				p1.openFile();
				p1.addRecords();
				p1.closeFile();
				System.exit(0);
			}
			else if (answer == JOptionPane.NO_OPTION)
			{
				System.exit(0);
			}
			else
			{
				
			}
		}
		else
		{
			System.exit(0);
		}
	}
	public FileInputStream getFileInputStream(File file)
	{
		System.out.println("manager.getFileInputStream() CALLED");
		FileInputStream fis = null;
		try
		{
			fis = new FileInputStream(file);
		}
		catch (Exception ex)
		{
			System.out.println("no file selected");
		}
		return fis;
	}
	public boolean getCheckPlayCondition()
	{
	//	System.out.println("manager.getCheckPlayCondition() CALLED");
		return checkPlayCondition;
	}
	public void setCheckPlayCondition(boolean condition)
	{
		System.out.println("manager.setCheckPlayCondition() CALLED");
		checkPlayCondition = condition;
	}
	public void playMusic()
	{
		System.out.println("manager.playMusic() CALLED");
		try
		{
			Thread t1 = new Thread(new Music(this));  // this is where the music thread is instantiated
			t1.start();
			Thread t2 = new Thread(new PlayTimeLabel(this));
			t2.start();
			// I know I'm not ending the threads properly but I think its a bit too much to learn right now
		}
		catch (Exception ex)
		{
			
		}
	}
	public void startUpdateLabel()
	{
		// Never got around to starting the label thread (t2) here.
	}
	public void changeBtnImage(ImageIcon image)
	{
		System.out.println("manager.changeBtnImage() CALLED");
		playStopBtn.setIcon(image);
	}
	public ImageIcon getImage1()
	{
		System.out.println("manager.getImage1() CALLED");
		return image1;
	}
	public ImageIcon getImage2()
	{
		System.out.println("manager.getImage2() CALLED");
		return image2;
	}
	public void stopPlay()  // this method is kind of redundant because setCheckPlayCondition(false) will always be called with it. This is just to be explicite
	{
		System.out.println("manager.stopPlay() CALLED");
		setCheckPlayCondition(false);
	}
	public File getFile()
	{
		System.out.println("manager.getFile() CALLED");
		return file;
	}
	public void setFile(File file)
	{
		System.out.println("manager.setFile() CALLED");
		this.file = file;
		this.fileExists = true;
	}
	public void setTitle(String newTitle)
	{
		System.out.println("manager.setTitle() CALLED");
		gui.setTitle(newTitle);
	}
	public void openFile()
	{
		System.out.println("manager.openFile() CALLED");
		JFileChooser fc = new JFileChooser();
		fc.setFileFilter(new FileNameExtensionFilter("mp3 files", "mp3"));
		int answer =  fc.showOpenDialog(null);
		if (answer == JFileChooser.APPROVE_OPTION &&
			fc.getSelectedFile().getName().endsWith(".mp3"))
		{
			setFile(fc.getSelectedFile());
			setTitle("Music Player - " + getFile().
				                         getName().
				                         substring(0,getFile().getName().length()-4));
		    stopPlay(); // stopPlay() sets 'checkPlayCondition' to false. This is done here just to be explicite.
		    //checkPlayCondition = false;       this is not allowing the thread to sleep for some reason
		    
		    try   // this is not a perfect solution
		    {
		    	Thread.sleep(1000);
		    }
		    catch (Exception ex){}
		    // the thread classes intermittently check the 'checkPlayCondition' attribute to decide
		    // weather to continue executing. If they aren't given enough time to check that attribute
		    // before another song is played then they will execute at the same time.
		    
		    
		    
		    playMusic();
			startUpdateLabel();
			changeBtnImage(getImage2());
			setCheckPlayCondition(true);
			
			
		}
		else if (answer == JFileChooser.APPROVE_OPTION &&
			     !fc.getSelectedFile().getName().endsWith(".mp3"))
		{
			// to do WRITE CODE HERE
			System.out.println("You picked a file but it was not an mp3.");
		}
		else
		{
			
		}
	}
	public boolean getFileExists()
	{
		System.out.println("manager.getFileExists() CALLED");
		return fileExists;
	}
	public void setPlayTimeLabelText(String newText)
	{
	//	System.out.println("manager.setPlayTimeLabelText() CALLED");
		playTime.setText(newText);
	}
		/*****************************************************
*    Title:  Read out Time/Length/Duration of an Mp3 song in Java , line 240-246
*    Author: Mardo Del Cid
*    Site owner/sponsor:  stackoverflow.com
*    Date: Jan 12 '11 at 18:25
*    Code version:  
*    Availability:  http://stackoverflow.com/questions/3140992/read-out-time-length-duration-of-an-mp3-song-in-java
*    Modified:  Code refactored ()
*****************************************************/                                                           
	public Long getSongFileLength()
	{
		System.out.println("manager.getSongFileLength() CALLED");
		Long duration = null;
		try
		{
			AudioFileFormat baseFileFormat = new MpegAudioFileReader().getAudioFileFormat(file); 
			Map properties = baseFileFormat.properties();
      	duration = (Long) properties.get("duration");
      	return duration;
		}
		catch (Exception ex)
		{
			
		}
		// this system out is never being called because the duration is returned before this
		System.out.println("This is the duration: " + duration);
		return duration;
	}
}
