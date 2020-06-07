//This program is a stack class that will implement a LIFO Data Structure
import java.io.*;
import java.util.*;
public class Stack<E> implements Serializable
{
	//data
	private ArrayList<E> contentsAL;

	//default constructor
	public Stack()
	{
		contentsAL = new ArrayList<E>();
	}

	//inserting the element at the end
	public void push(E elt)
	{
		contentsAL.add(0,elt);
	}

	//remove the element at position 0
	public E pop()
	{
		if	(contentsAL.isEmpty())
			throw new EmptyStackException();

		return contentsAL.remove(0);
	}

	//getting the firs element and don't remove it
	public E peek()
	{
		if	(contentsAL.isEmpty())
			throw new EmptyStackException();

		return contentsAL.get(0);
	}

	//returns the size of the stack
	public int size()
	{
		return contentsAL.size();
	}


	//asking the stack if its empty
	public boolean isEmpty()
	{
		if	(contentsAL.isEmpty())
			return true;

		else
			return false;

	}





















}
