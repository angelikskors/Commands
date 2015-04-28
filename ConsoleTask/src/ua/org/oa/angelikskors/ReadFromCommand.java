package ua.org.oa.angelikskors;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.Arrays;

public class ReadFromCommand {

	public static void main(String[] args) throws IOException {
		String name = args[0];
		String path = args[1];
		String command = args[2];

		File file = new File(path);
		if (command.equals("delete")) {
			if (checkFileExistence(path)) {
				file.delete();
				System.out.println(name + "deleted");
			} else {
				System.out.println("File doesn't exist");
			}
		} else if (command.equals("create")) {
			if (!checkFileExistence(path)) {
				createFile(args[1]);
				System.out.println(name + "created");
			} else {
				System.out.println("The file already exists");
			}

		} else if (command.equals("rename")) {
			if (checkFileExistence(path)) {

				System.out.println("renamed to " + rename(name, path));
			}
		}

	}

	public static String rename(String name, String path) {
		String newFileName = "terr.txt";
		if (path.contains(name)) {
			String newPathName = path.replaceAll(name, newFileName);
			File file = new File(path);
			try (FileInputStream fileCoping = new FileInputStream(path);
					FileOutputStream fole = new FileOutputStream(newPathName)) {// copying

				byte[] massive = new byte[1024];
				while (fileCoping.read(massive) != -1) {
					System.out.println("massive " + Arrays.toString(massive));
					fole.write(massive);
					fole.flush();
					fole.close();
					file.delete();

				}

			} catch (IOException e) {
				e.printStackTrace();
			}

			return newFileName;
		}
		return null;
	}

	public static void createFile(String string) throws IOException {
		File file = new File(string);
		file.createNewFile();

	}

	public static boolean checkFileExistence(String string) {
		File file = new File(string);
		return (file.exists());

	}

}
