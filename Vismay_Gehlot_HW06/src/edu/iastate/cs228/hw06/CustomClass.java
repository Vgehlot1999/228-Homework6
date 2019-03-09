package edu.iastate.cs228.hw06;



/**
 * 
 * @author Vismay Gehlot
 * 
 * 
 * NOTE: 
 * 0. Put your Firstname and Lastname after above author tag.
 * 			Make sure that in both cases the first letter is uppercase
 *    and all others are lowercase.
 * 1. You are allowed to create and use your own private helper methods. 
 * 2. No additional data fields can be introduced.
 * 3. No custom classes of your own can be introduced or used.
 * 4. Import statements are not allowed.
 * 5. Fully qualified class names usage is not allowed.
 *    (Except for the methods that are provided already for you, which
 *    do not need to be implemented as part of this HW, i.e. needs to be
 *    used as it is.)
 * 6. You are allowed to reuse any part of the source codes of provided
 *    or shown under lecture notes.
 *    
 * All above 0 - 6 apply also to AList, LList, and LListWithTail.
 * 
 * 
 * 
 * REQUIREMENTS:
 *    All methods in this class need to be overridden in all of AList, 
 *    LList, and LListWithTail classes as per contract. You are allowed 
 *    to reuse already implemented methods in there while implementing
 *    these.
 * 
 * HINT:
 *    You are allowed to provide an implementation, i.e., body, of these
 *    methods here. In that case remove the abstract keyword. Otherwise,
 *    if you are providing implementation in specific classes then you 
 *    need to add @author tag in those classes with your name, and keep
 *    the abstract keyword in the signature of the methods below. In the
 *    former case, i.e., when you remove the abstract keywords here and
 *    provide the implementations here, no need to provided @author tag
 *    in classes AList, LList, and LListWithTail.
 *  
 */


public abstract class CustomClass<T> implements ListInterface<T>
{
	/**
	 * Adds a new entry to the beginning of this list.
	 * 
	 * 
	 */
	public void addFirst(T newEntry)
	{
		add(1, newEntry);
	}
	
	/**
	 * Adds a new entry to the end of this list.
	 * 
	 * 
	 */
	public void addLast(T newEntry)
	{
		add(newEntry);
	}
	
	/**
	 * Removes and returns the first entry in this list.
	 * If none, then throws java.util.NoSuchElementException.
	 * 
	 * 
	 */
	public T removeFirst()
	{
		if (isEmpty())
		{
			throw new java.util.NoSuchElementException();
		}
		return remove(1);
	}
	
	
	/**
	 * Removes and returns the last entry in this list.
	 * If none, then throws java.util.NoSuchElementException.
	 * 
	 * 
	 */
	public T removeLast()
	{
		if (isEmpty())
		{
			throw new java.util.NoSuchElementException();
		}
		else
		{
			return remove(getLength());
		}
	}
	
	/**
	 * Returns the first entry in this list.
	 * If none, then throws java.util.NoSuchElementException.
	 * 
	 * 
	 */
	public T getFirst() 
	{
		if (isEmpty())
		{
			throw new java.util.NoSuchElementException();
		}
		else
		{
			return getEntry(1);
		}
	}
	/**
	 * Returns the last entry in this list.
	 * If none, then throws java.util.NoSuchElementException.
	 * 
	 * 
	 */
	public T getLast()
	{
		if (isEmpty())
		{
			throw new java.util.NoSuchElementException();
		}
		else
		{
			return getEntry(getLength());
		}
	}
	
	
	/**
	 * Moves the first entry in this list to the end 
	 * of the list. If only single entry or
	 * the list is empty then does nothing.
	 * 
	 */
	public void moveToEnd()
	{
		if(getLength() > 1)
		{
			add(getEntry(1));
			remove(1);
		}
	}
	
	/**
	 * Removes the first occurrence of anEntry from
	 * the list. Returns true if successfully removes,
	 * otherwise, returns false.
	 * 
	 */
	public boolean remove(T anEntry)
	{
		for (int i = 1; i <= getLength(); i++)
		{
			if(getEntry(i).equals(anEntry))
			{
				remove(i);
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * Returns the position of the first occurrence of an 
	 * anEntry, if it exists in the list. If not returns -1. 
	 * 
	 */
	public int getPosition(T anEntry)
	{
		for (int i = 1; i <= getLength(); i++)
		{
			if(getEntry(i).equals(anEntry))
			{
				return i;
			}
		}
		return -1;
	}
	
	
}
