package gui.awt;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Notepad {
	private Frame f;
	private MenuBar mb;
	private Menu m;
	private MenuItem load;
	private MenuItem save;
	private MenuItem saveAs;
	private MenuItem exit;
	private TextArea ta;
	private FileDialog loadFile;
	private FileDialog saveFile;
	private FileDialog saveAsFile;
	private Dialog warning;
	private Label warningText;
	private File file;
	private BufferedReader br;
	private BufferedWriter bw;
	private String fileDirPath;
	private String fileName;

	Notepad() {
		init();
	}

	private void init() {
		f = new Frame("Notepad");
		mb = new MenuBar();
		m = new Menu("File");
		load = new MenuItem("Open");
		save = new MenuItem("Save");
		saveAs = new MenuItem("Save As");
		exit = new MenuItem("Exit");
		ta = new TextArea();
		loadFile = new FileDialog(f, "Open File", FileDialog.LOAD);
		saveFile = new FileDialog(f, "Save File", FileDialog.SAVE);
		saveAsFile = new FileDialog(f, "Save As File", FileDialog.SAVE);
		warning = new Dialog(saveFile, "Warning");
		warningText = new Label();

		f.setBounds(500, 300, 800, 600);
		f.setVisible(true);

		f.setMenuBar(mb);
		f.add(ta);

		mb.add(m);
		m.add(load);
		m.add(save);
		m.add(saveAs);
		m.add(exit);

		warning.setSize(300, 200);

		Event();
	}

	private void Event() {
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadFile.setVisible(true);
				ta.setText("");
				fileDirPath = loadFile.getDirectory();
				fileName = loadFile.getFile();

				file = new File(fileDirPath + "\\" + fileName);
				try {
					br = new BufferedReader(new FileReader(file));

					String line;
					while (!((line = br.readLine()) == null)) {
						ta.append(line + "\r\n");
					}

					br.close();
				} catch (FileNotFoundException e1) {
					if (!(fileName == null))
						ta.setText("File doesn't exist");
					else
						ta.setText("Choose a file");
				} catch (IOException e1) {
					ta.setText(e1.getMessage());
				}

			}
		});

		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (file == null) {
					saveFile.setVisible(true);
					fileDirPath = saveFile.getDirectory();
					fileName = saveFile.getFile();
					if (fileDirPath == null || fileName == null)
						return;
					file = new File(fileDirPath, fileName);
				}

				try {
					bw = new BufferedWriter(new FileWriter(file));
					bw.write(ta.getText());
					bw.close();
				} catch (IOException e1) {
					warning.setVisible(true);
					warningText.setText(e1.getMessage());
				}

			}
		});

		saveAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveAsFile.setVisible(true);
				fileDirPath = saveAsFile.getDirectory();
				fileName = saveAsFile.getFile();
				if (fileDirPath == null || fileName == null)
					return;
				file = new File(fileDirPath, fileName);
				try {
					bw = new BufferedWriter(new FileWriter(file));
					bw.write(ta.getText());
					bw.close();
				} catch (IOException e1) {
					warning.setVisible(true);
					warningText.setText(e1.getMessage());
				}
			}
		});

		warning.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				warning.setVisible(false);
			}
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Notepad();
	}
}