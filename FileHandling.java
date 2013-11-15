package com.test.documentmanager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandling {

	private static String localRepoPath = "C:\\Users\\gsharma\\git\\jgit-box";
	private static List<Dir> dir = new ArrayList<Dir>();

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		File[] files = new File(localRepoPath).listFiles();

		dir = storeFiles(files, dir);
		System.out.println("=========================================");
		printDirContents(dir);

	}
	

	private static void printDirContents(List<Dir> localDir) {
		
		System.out.println("<ul>");
		
		for (Dir d : localDir) {
			
			System.out.println("<li>");
			
			System.out.println(d.getEntryName() + ": " + d.getEntryPath());			
			
			if(d.getDir().size() > 0) {
				printDirContents(d.getDir());
			}
			System.out.println("</li>");
		}
		
		System.out.println("</ul>");
	}


	public static List<Dir> storeFiles(File[] files, List<Dir> incomingDir)
			throws IOException {

		String fileName = "";
		String filePath = "";

		System.out.println("<ul>");

		for (File file : files) {

			fileName = file.getName();
			filePath = file.getAbsolutePath();
			filePath = filePath.replaceAll("(.*)jgit-box", "");

			if (!fileName.equals(".git") && !fileName.equals(".gitkeep")) {

				System.out.println("<li>");
				Dir d = new Dir(fileName, filePath);
				incomingDir.add(d);
				d.setDir(new ArrayList<Dir>());

				if (file.isDirectory()) {

					System.out.println(fileName + ": " + filePath);
					storeFiles(file.listFiles(), d.getDir()); // Calls same
																// method
					// again.
				} else {
					System.out.println(fileName + ": " + filePath);
				}

				System.out.println("</li>");
			}
		}
		System.out.println("</ul>");

		return incomingDir;
	}
}
