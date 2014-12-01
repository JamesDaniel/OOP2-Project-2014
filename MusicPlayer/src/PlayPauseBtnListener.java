import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.io.*;

public class PlayPauseBtnListener implements ActionListener{
	private static boolean checkPlayCondition=false;   // change this to boolean
	private static File file1;
	private JButton playPause;
	private BufferedImage image1;
	private BufferedImage image2;
	private File file;
	private JLabel playTime;
	
	public PlayPauseBtnListener(JButton playPause, BufferedImage image1, BufferedImage image2, JLabel playTime)
	{
		this.playPause = playPause;
		this.image1 = image1;
		this.image2 = image2;
		this.playTime = playTime;
	}
	
	public void actionPerformed(ActionEvent event)
	{
		if (!Music.getCheckPlayCondition())
		{
			Music m = new Music("music 1", FileMenuOpenListener.getFile(), playPause, image1, playTime);
			m.start();
			UpdateLabel ul = new UpdateLabel("label 1",playTime);
			ul.start();
			playPause.setIcon(new ImageIcon(image2));
			Music.setCheckPlayCondition(true);
		}
		else
		{
			Music.stopPlay();
			playPause.setIcon(new ImageIcon(image1));
			Music.setCheckPlayCondition(false);
		}
	}
}