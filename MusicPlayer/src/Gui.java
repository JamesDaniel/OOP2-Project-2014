//Gui.java
import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame{
	private JMenu file;
	private JMenu edit;
	MusicManager manager;
	private ImageIcon image1;
	private ImageIcon image2;
	public Gui()
	{
		setTitle("Music Player");
		setSize(610,100);
		setResizable(false);
		setLocation(300,200);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		Container c1 = getContentPane();
		c1.setLayout(new FlowLayout());
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		
		readInImages();
		JButton playStopBtn = new JButton(image1);
		playStopBtn.setPreferredSize(new Dimension(39,39));
		
	/*****************************************************
*    Title:   Howto make JButton with simple flat style? , line 38-40
*    Author: André Luiz Clinio
*    Site owner/sponsor:  http://stackoverflow.com/
*    Date:  Jan 21 '13 at 19:00
*    Code version:  
*    Availability:  http://stackoverflow.com/questions/1839074/howto-make-jbutton-with-simple-flat-style
*    Modified:  Code used (code used)
*****************************************************/
		playStopBtn.setBorderPainted(false);      
		playStopBtn.setFocusPainted(false);       
		playStopBtn.setContentAreaFilled(false);  
		c1.add(playStopBtn);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(472,39));
	//	panel.setBackground(Color.WHITE);
		c1.add(panel);
		
		JLabel playTime = new JLabel("00:00-00:00");
		c1.add(playTime);
		manager = new MusicManager(image1,image2,playStopBtn,playTime,this);
		
		createFileMenu();
		createEditMenu();
		menuBar.add(file);
		menuBar.add(edit);
		playStopBtn.addActionListener(new PlayStopBtnListener(manager));
		addWindowListener(new GuiWindowListener(manager));
	}
	/*****************************************************
*    Title:  JMenuBar , line 22-53
*    Author: John Walsh
*    Site owner/sponsor:  
*    Date: 07/12/2014 10:00:00
*    Code version:  1.0
*    Availability:  https://docs.oracle.com/javase/tutorial/essential/concurrency/runthread.html
*    Modified:  Code refactored (  )
*****************************************************/
	public void createFileMenu(){
		file = new JMenu("File");
		JMenuItem item;
		item = new JMenuItem("Open");
		item.addActionListener(new FileMenuOpenListener(manager));
		file.add(item);
		
		item = new JMenuItem("Exit");
		item.addActionListener(new FileMenuExitListener(manager));
		file.add(item);
	}
	public void createEditMenu(){  
		edit = new JMenu("Edit");
		JMenuItem item;
		item = new JMenuItem("Next Song - NOT WORKING YET");
		item.addActionListener(new EditMenuNextSongListener(manager));
		edit.add(item);
		
		item = new JMenuItem("Prev Song - NOT WORKING YET");
		item.addActionListener(new EditMenuPrevSongListener(manager));
		edit.add(item);
	}
	/*****************************************************
*    Title:  How to change the size of an image?, lines 110-121
*    Author: David Kroukamp
*    Site owner/sponsor:  http://stackoverflow.com/
*    Date: 18/09/2012 10:54:00
*    Code version:  
*    Availability:  stackoverflow.com/questions/12475503/how-to-change-the-size-of-an-image
*    Modified:  Code refactored (I used only ImageIcon class)
*****************************************************/
	/*****************************************************
*    Title:  Icon Pack Primo, lines 113-114
*    Author: Jack Cai
*    Site owner/sponsor:  http://findicons.com/
*    Date: 07/12/2014 10:00:00
*    Code version:  
*    Availability:  http://findicons.com/icon/175990/button_blue_play
*    Availability:  http://findicons.com/icon/176081/button_blue_stop
*    Modified:  Code refactored (I used only ImageIcon class)
*****************************************************/

	public void readInImages(){    
	    try
	    {
	    	image1 = new ImageIcon("button_blue_play_copy.png");  
			image2 = new ImageIcon("button_blue_stop_copy.png");  
	    }
	    catch (Exception ex)
	    {
	    	System.out.println("Failed to read in images");
	    }
	}
}
