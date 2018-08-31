package ioStream;
import java.io.*;

public class FileDemo {
	public void showFileListFilter(String filePath) {
		File f = new File(filePath);
		File[] files = f.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith(".java");
			}
		});
		for (File fs : files)
			System.out.println(fs.getName());
	}

	public void showLevel(int level, File f) {
		for (int i = 0; i < level - 1; i++)
			System.out.print("|-----");
		System.out.print("|*****");
	}

	public void showFileList(String filePath, int level) {
		File f = new File(filePath);

		level++;
		System.out.println(f.getName());

		if (!f.exists()) {
			throw new RuntimeException("File doesn't exist!");
		} else if (!f.isDirectory()) {
			throw new RuntimeException("File isn't a directory!");
		} else {
			for (File subf : f.listFiles()) {
				if (subf.isDirectory()) {
					showLevel(level, subf);
					showFileList(filePath + "\\" + subf.getName(), level);
				} else {
					showLevel(level, subf);
					System.out.println(subf.getName());
				}
			}
		}
	}

	public void deleteFile(String filePath) {
		File f = new File(filePath);

		for (File subf : f.listFiles()) {
			if (subf.isDirectory()) {
				deleteFile(filePath + "\\" + subf.getName());
			} else {
				if (subf.delete())
					System.out.println(subf.getName() + "......... deleted");
				else
					System.out.println(subf.getName() + ".........Delete peration failure");
			}
		}
		if (f.delete())
			System.out.println(f.getName() + "......... deleted");
		else
			System.out.println(f.getName() + ".........Delete peration failure");

	}

	public static void main(String[] args) {
		String filePath = "C:\\Users\\toysoldier\\Documents\\Eclipse_Java_Workspace\\IOStream\\Collection";
		FileDemo fd = new FileDemo();

		// fd.showFileListFilter(filePath);
		fd.showFileList(filePath, 0);
		//fd.deleteFile(filePath);
	}
}
