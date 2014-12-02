//Gui.java
//James McGarr
// This class contains only the gui
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;

public class Gui extends JFrame{
	private JButton playPause;
	private JMenu file;
	private JMenu edit;
	private BufferedImage image1;
	private BufferedImage image2;
	private JLabel playTime;
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
		
		createFileMenu();
		createEditMenu();
		menuBar.add(file);
		menuBar.add(edit);
		
		image1 = scaleImage(39, 39, "button_blue_play.png");  //   http://findicons.com/icon/175990/button_blue_play
		image2 = scaleImage(39, 39, "button_blue_stop.png");  //   http://findicons.com/icon/176081/button_blue_stop
		                                                      //   http://findicons.com/icon/176085/button_blue_pause
		
		
		playPause = new JButton(new ImageIcon(image1));
		playPause.setPreferredSize(new Dimension(39,39));
		
		c1.add(playPause);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(472,39));
		panel.setBackground(Color.WHITE);
		c1.add(panel);
		
		playTime = new JLabel("00:00-00:00");
		playPause.addActionListener(new PlayPauseBtnListener(playPause,image1,image2,playTime));  // had to move this down here because I can't pass the JLabel by reference if it isn't created yet
		c1.add(playTime);
		
		addWindowListener(new GuiWindowListener());
	}
	public void createFileMenu(){
		file = new JMenu("File");
		JMenuItem item;
		item = new JMenuItem("Open");
		item.addActionListener(new FileMenuOpenListener((JFrame)this));
		file.add(item);
		
		item = new JMenuItem("Exit");
		item.addActionListener(new FileMenuExitListener());
		file.add(item);
	}
	public void createEditMenu(){
		edit = new JMenu("Edit");
		JMenuItem item;
		item = new JMenuItem("Next Song");
		item.addActionListener(new EditMenuNextSongListener());
		edit.add(item);
		
		item = new JMenuItem("Prev Song");
		item.addActionListener(new EditMenuPrevSongListener());
		edit.add(item);
	}
	public BufferedImage scaleImage(int WIDTH, int HEIGHT, String filename)  // this method code is from stackoverflow.com/questions/12475503/how-to-change-the-size-of-an-image
	{
    	BufferedImage bi = null;
    	try {
	        ImageIcon ii = new ImageIcon(filename);//path to image
        	bi = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        	Graphics2D g2d = (Graphics2D) bi.createGraphics();
        	g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY));
        	g2d.drawImage(ii.getImage(), 0, 0, WIDTH, HEIGHT, null);
    		} catch (Exception e) 
    			{
        			e.printStackTrace();
	        		return null;
    			}
    	return bi;
    }
}
