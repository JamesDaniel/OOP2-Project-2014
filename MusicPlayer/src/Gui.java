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
		playStopBtn.setBorderPainted(false);        //  http://stackoverflow.com/questions/1839074/howto-make-jbutton-with-simple-flat-style
		playStopBtn.setFocusPainted(false);        //   http://stackoverflow.com/questions/1839074/howto-make-jbutton-with-simple-flat-style
		playStopBtn.setContentAreaFilled(false);  //    http://stackoverflow.com/questions/1839074/howto-make-jbutton-with-simple-flat-style
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
	public void createFileMenu(){  // This code is from my lecturer John Walsh
		file = new JMenu("File");
		JMenuItem item;
		item = new JMenuItem("Open");
		item.addActionListener(new FileMenuOpenListener(manager));
		file.add(item);
		
		item = new JMenuItem("Exit");
		item.addActionListener(new FileMenuExitListener(manager));
		file.add(item);
	}
	public void createEditMenu(){  // This code is from my lecturer John Walsh
		edit = new JMenu("Edit");
		JMenuItem item;
		item = new JMenuItem("Next Song - NOT WORKING YET");
		item.addActionListener(new EditMenuNextSongListener(manager));
		edit.add(item);
		
		item = new JMenuItem("Prev Song - NOT WORKING YET");
		item.addActionListener(new EditMenuPrevSongListener(manager));
		edit.add(item);
	}
	public void readInImages(){    // learned some of this from --> stackoverflow.com/questions/12475503/how-to-change-the-size-of-an-image
	    try
	    {
	    	image1 = new ImageIcon("button_blue_play_copy.png");   //  http://findicons.com/icon/175990/button_blue_play
			image2 = new ImageIcon("button_blue_stop_copy.png");  //   http://findicons.com/icon/176081/button_blue_stop
	    }
	    catch (Exception ex)
	    {
	    	System.out.println("Failed to read in images");
	    }
	}
}
