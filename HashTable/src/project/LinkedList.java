package project;

/**
 * The Class LinkedList.
 */
public class LinkedList 
{
	
	/** The first. */
	public Node first;
	
	/** The last. */
	public Node last;
	
	/**
	 * Instantiates a new linked list.
	 */
	public LinkedList()
	{
		first = null;
		last = null;
	}
	
	/**
	 * Checks if is empty.
	 *
	 * @return true, if is empty
	 */
	public boolean isEmpty()
	{
		return first == null;
	}
	
	/**
	 * Inserts the given country
	 *
	 * @param country the country
	 * @param population the population
	 * @param area the area
	 */
	public void insert(String country, long population, long area)
	{
		Node newNode = new Node(country,population,area);
		if(first == null)
		{
			first = newNode;
			last = newNode;
		}
		else
		{
			last.next = newNode;
			last = newNode;     
		}
	}
	
	/**
	 * Removes the country given
	 *
	 * @param country the country
	 * @return the node
	 */
	public Node remove(String country)
	{
		Node previous = null;
		Node current = first;
		
		while(current != null && !current.name.equals(country))
		{
			previous = current;
			current = current.next;
		}
		Node save = current;
		if(previous == null)
		{
			first = first.next;
		}
		else if(current == null)
		{
			return current;
		}
		else if(current.next == null)
		{
			last = previous;
			previous.next = null;
		}
		else
		{
			previous.next = current.next;
			current = null;
		}
		return save;
	}

	/**
	 * Display list.
	 */
	public void displayList()
	{
		boolean spot = false;
		Node current = first;
		while(current != null)
		{
			if(spot)
			{
				System.out.printf("%-6s","");
				current.printNode();
				current = current.next;
			}
			else
			{
				current.printNode();
				current = current.next;
				spot = true;
			}
		}
	}
	
	/**
	 * Find a country in the list
	 *
	 * @param country the country
	 * @return the node
	 */
	public Node find(String country)
	{
		Node current = first;
		while(current != null && !current.name.equals(country))
		{
			current = current.next;
		}
		return current;
	}
	
	/**
	 * Checks if a cell is collied or not
	 *
	 * @return true, if successful
	 */
	public boolean colliedCell()
	{
		if(first.next != null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}