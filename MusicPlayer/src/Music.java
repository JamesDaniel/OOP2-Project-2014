//Music.java
//James McGarr
//http://stackoverflow.com/questions/5289851/stop-mute-playing-music-using-jlayer
//http://www.tutorialspoint.com/java/java_multithreading.htm
// reference for the 'to do' on next line http://stackoverflow.com/questions/9348547/how-to-listen-value-change-in-primitive-data-type-in-this-case-boolean
// to do: add ObserverPattern to see when music ends http://www.tutorialspoint.com/design_pattern/observer_pattern.htm
import javazoom.jl.player.Player;
import java.io.FileInputStream;
import java.io.*;
import java.awt.image.*;
import javax.swing.*;

public class Music extends Thread{
	private Thread t;
	private String threadName;
	private Player player;
	private static boolean stopPlay;
	private static File file1;
	JButton playPause;
	BufferedImage image1;
	public static boolean checkPlayCondition=false;
	public static int playDuration=0;
	private JLabel playTime;
	
	Music(String threadName, File file1, JButton playPause, BufferedImage image1, JLabel playTime)
	{
		this.threadName = threadName;
		this.stopPlay = false;
		this.file1 = file1;
		this.playPause = playPause;
		this.image1 = image1;
		this.playTime = playTime;
	}
	public void run()
	{
		try
		{
			FileInputStream fis = new FileInputStream(file1);
			player = new Player(fis);
			while (player.play(1))
			{
				Music.setPlayDuration(player.getPosition());
				if (stopPlay)
				{
					player.close(); // this is where the player is closed
				}
			}
			playPause.setIcon(new ImageIcon(image1));
			Music.setCheckPlayCondition(false);
			playTime.setText("00:00-00:00");
		}
		catch (Exception ex)
		{
			JOptionPane.showMessageDialog(null,"You gotta pick a song to play first.","Error",JOptionPane.ERROR_MESSAGE);
			playPause.setIcon(new ImageIcon(image1));
	        Music.setCheckPlayCondition(false);
	//		Music.checkPlayCondition = false;
		}
	}
	public void start()  // I got this method from http://www.tutorialspoint.com/java/java_multithreading.htm
	{
		if (t == null)
		{
			t = new Thread (this, threadName);
			t.start();
		}
	}
	public static void stopPlay(){
		stopPlay = true;
	}
	public static synchronized boolean getCheckPlayCondition()
	{
		return Music.checkPlayCondition;
	}
	public static synchronized void setCheckPlayCondition(boolean condition)
	{
		Music.checkPlayCondition = condition;
	}
	public static synchronized void setPlayDuration(int playDuration)
	{
		Music.playDuration = playDuration;
	}
	public static synchronized int getPlayDuration()
	{
		return Music.playDuration;
	}
}
