//This class will serialize MazeSolver, read it and convert it to the existing MazeSolver
import java.io.*;
import java.util.*;
public class ResumeSolvingMaze
{
	public static void main(String [] args) throws Throwable
	{
		Scanner kb = new Scanner(System.in);

		//ask the person to enter the file
		System.out.println("Enter the saved file:");
		String filename2 = kb.nextLine();

		//read in the saved file
		ObjectInputStream savedFile = new ObjectInputStream(new FileInputStream(filename2));
		MazeSolver savedMaze = (MazeSolver)savedFile.readObject();

		savedFile.close();
		//after the file is read, continue solving it
		savedMaze.solve();

	}
}