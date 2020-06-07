//This class is a driver for the MazeSolver, which will help the run the maze.
import java.util.*;
public class StartSolvingMaze
{
	public static void main(String[]args) throws Throwable
	{
		Scanner kb = new Scanner(System.in);

		//ask the user to enter number of rows
		System.out.println("Please enter number of rows: ");
		int numRows = kb.nextInt();

		//ask the user to enter number of columns
		System.out.println("Please enter number of columns ");
		int numColumns = kb.nextInt();

		//create a new instance of MazeSolver
		MazeSolver myMaze = new MazeSolver(numRows, numColumns);

		//tell it to solve
		myMaze.solve();
	}
}