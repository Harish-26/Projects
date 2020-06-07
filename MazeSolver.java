//This class will store the maze and solve it
import java.io.*;
import java.util.*;
public class MazeSolver implements Serializable
{
	//data
	private Stack<Direction> myStack;
	private boolean [][] isVisited;
	private int rows;
	private int columns;
	private Maze myMaze;

	//parameterized constructor
	public MazeSolver(int numRows, int numColumns)
	{
		myMaze = new Maze(numRows, numColumns);

		//build the maze
		myMaze.buildMaze(0);

		//set the animation delay to see the animation
		myMaze.setSolveAnimationDelay(1);

		//keep track of the cell
		myStack = new Stack<Direction>();

		//keep track of the cell, if it's been visited
		this.isVisited = new boolean[numRows][numColumns];
	}

		//method
		public void solve() throws Throwable
		{
			//keep track of the rows and columns
			int theCurrentRow = myMaze.getCurrentRow();
			int theCurrentColumn = myMaze.getCurrentCol();
			isVisited[theCurrentRow][theCurrentColumn] = true;

			//display the maze
			MazeDisplay mazeAnimation = new MazeDisplay(myMaze);

			//scanner for serialization
			Scanner kb = new Scanner(System.in);

			//ask the user if they want to save
			System.out.println("(ENTER 's' to save) OR (ENTER 'q' to quit)");

			do
			{
				/*String filename = kb.nextLine();


				if	(filename.equalsIgnoreCase("s")) //if the user enters "s", tell them to write the filename
				{
					String savedFile = kb.nextLine(); //enter the name of the file to be saved
					ObjectOutputStream newFile = new ObjectOutputStream(new FileOutputStream(savedFile));
					newFile.writeObject(this);
					newFile.close();
				}
				else if	(filename.equalsIgnoreCase("q")) //if the user enters "q", they quit the maze
				{
					System.out.println("Program ended without solving.");
					System.exit(1);
				}
				else
*/

				//set the current row and column as visited
				theCurrentRow = myMaze.getCurrentRow();
				theCurrentColumn = myMaze.getCurrentCol();
				isVisited[theCurrentRow][theCurrentColumn] = true;


				//if the cell is open downwards and the cell is not visited
				if	(myMaze.isOpen(Direction.DOWN) == true && isVisited[myMaze.getCurrentRow() + 1][myMaze.getCurrentCol()] == false)
				{

					myStack.push(Direction.DOWN);
					myMaze.move(Direction.DOWN);

				}

				//if the cell is open upwards and the cell is not visited
				else if	(myMaze.isOpen(Direction.UP) == true && isVisited[myMaze.getCurrentRow() - 1][myMaze.getCurrentCol()] == false)
				{
					myStack.push(Direction.UP);
					myMaze.move(Direction.UP);
				}

				//if the cell is open in the direction left and the cell is not visited
				else if	(myMaze.isOpen(Direction.LEFT) == true && isVisited[myMaze.getCurrentRow()][myMaze.getCurrentCol() - 1] == false)
				{
					myStack.push(Direction.LEFT);
					myMaze.move(Direction.LEFT);
				}

				//if the cell is open in the direction right and the cell is not visited
				else if	(myMaze.isOpen(Direction.RIGHT) == true && isVisited[myMaze.getCurrentRow()][myMaze.getCurrentCol() + 1] == false)
				{

					myStack.push(Direction.RIGHT);
					myMaze.move(Direction.RIGHT);
				}

				else
				{
					Direction anyDirection = myStack.pop();

					if	(anyDirection == Direction.UP) //if last direction was UP, then move DOWN
						myMaze.move(Direction.DOWN);

					else if	(anyDirection == Direction.DOWN) //if last direction was DOWN, then move UP
							myMaze.move(Direction.UP);

					else if	(anyDirection == Direction.LEFT) //if last direction was LEFT, then move RIGHT
							myMaze.move(Direction.RIGHT);

					else if	(anyDirection == Direction.RIGHT) //if last direction was RIGHT, then move LEFT
							myMaze.move(Direction.LEFT);
				}



			}while	(myMaze.goalReached() == false); //keep going until the maze is finished

			if	(myMaze.goalReached() == true)
				System.out.println("Maze is solved.");
		}
}




























