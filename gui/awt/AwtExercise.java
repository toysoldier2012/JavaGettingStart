package gui.awt;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class AwtExercise {
	Frame f = new Frame("AwtExercise");
	TextField tf1 = new TextField();
	Button b1 = new Button("Show");
	Button b2 = new Button("Close");
	Button b3 = new Button("Close");
	TextArea ta = new TextArea(20, 100);
	Dialog d = new Dialog(f, "Closing", true);
	Label l = new Label("You want to exit", Label.CENTER);

	AwtExercise() {
		init();
	}
	
	public void init() {
		/*
		 * Main Frame setting
		 */
		f.setBounds(300, 200, 800, 500);
		f.setLayout(new FlowLayout());
		f.setVisible(true);

		tf1.setColumns(10);
		f.add(tf1);

		f.add(b1);

		f.add(b2);

		ta.setEditable(false);
		f.add(ta);
		
		/*
		 * Closing Dialog setting
		 */
		d.setLayout(new FlowLayout());
		d.setBounds(400,300,200,100);
		
		l.setSize(200, 100);
		d.add(l);
		d.add(b3);
		
		Event();
		
	}
	
	/*
	 * Event
	 */
	public void Event() {
		/*
		 * Window listener
		 */
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

			public void windowActivated(WindowEvent e) {
				System.out.println("Window " + f.getTitle() + " actived");
			}

			public void windowOpened(WindowEvent e) {
				System.out.println("Window " + f.getName() + " opened");
			}
		});

		/*
		 * Button listener
		 */
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = tf1.getText();
				showFlieList(s, 0);
			}
		});

		b2.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				ta.setText("How dare u!");
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				d.setVisible(true);
			}
		});
		
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		/*
		 * TextField listener
		 */
		tf1.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
					showFlieList(tf1.getText(), 0);
			}
		});
		
		/*
		 * Dialog listener
		 */
		d.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				d.setVisible(false);
			}
		});
	}
	
	/*
	 * Show File List
	 */
	public void showLevel(int level) {
		for (int i = 0; i < level - 1; i++)
			ta.append("|-----");
		ta.append("|*****");
	}
	public void showFlieList(String filename, int level) {
		File f = new File(filename);
		if(!f.exists()) {
			ta.setText("Wrong file name!");
			return ;
		}
		File[] subFile = f.listFiles();
		
		ta.append(f.getName() +"\n");
		
		level++;
		for(File subFilename: subFile) {
			if(subFilename.isFile()) {
				showLevel(level);
				ta.append(subFilename.getName() +"\n");
			}
			if(subFilename.isDirectory()) {
				showLevel(level);
				showFlieList(filename +"\\"+ subFilename.getName(), level);
			}
		}
	}

	public static void main(String[] args) {
		new AwtExercise();
	}

}
